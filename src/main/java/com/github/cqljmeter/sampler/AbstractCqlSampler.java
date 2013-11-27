package com.github.cqljmeter.sampler;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.Statement;
import com.github.cqljmeter.config.ClusterHolder;

public abstract class AbstractCqlSampler extends AbstractSampler implements TestBean {
	private static final long serialVersionUID = -996507992186021290L;
	private static final Logger log = LoggingManager.getLoggerForClass();

	private String query = "";
	private String keySpace = "";
	private String clusterId = "";
	private String consistency = null;

	public SampleResult sample(Entry arg0) {
		SampleResult result = new SampleResult();
		result.setDataType(SampleResult.TEXT);
		result.setContentType("text/plain");
		result.setSampleLabel(getName());
		result.setSamplerData(query);

		// Assume we will be successful
		result.setSuccessful(true);
		result.setResponseMessageOK();
		result.setResponseCodeOK();

		Statement statement = configure(getStatement());
		result.sampleStart();
		try {
			ResultSet data = getSession(keySpace).execute(statement);
			result.setResponseData(data.toString().getBytes());
			result.setResponseMessage(data.toString());
		} catch (Exception ex) {
			log.error(String.format("Error executing CQL statement [%s]", getQuery()), ex);
			result.setResponseMessage(ex.toString());
			result.setResponseData(ex.getMessage().getBytes());
			result.setSuccessful(false);
		} 
		result.sampleEnd();
		return result;
	}

	private Statement configure(Statement statement) {
		if (StringUtils.isNotBlank(consistency)) {
			statement.setConsistencyLevel(ConsistencyLevel.valueOf(consistency));
		}
		return statement;
	}

	protected abstract Statement getStatement();

	private Session getSession(String input) {
		ClusterHolder holder = (ClusterHolder) getThreadContext().getVariables().getObject(getClusterId());
		Validate.notNull(holder, "Can't obtain a session. Did you forget to add C* Cluster Configuration Element?");
		return holder.getSesssion(input);
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getKeySpace() {
		return keySpace;
	}

	public void setKeySpace(String keySpace) {
		this.keySpace = keySpace;
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public String getConsistency() {
		return consistency;
	}

	public void setConsistency(String consistency) {
		this.consistency = consistency;
	}
}
