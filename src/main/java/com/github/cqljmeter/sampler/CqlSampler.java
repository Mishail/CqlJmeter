package com.github.cqljmeter.sampler;

import org.apache.commons.lang3.Validate;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.github.cqljmeter.config.ClusterHolder;

public class CqlSampler extends AbstractSampler implements TestBean {

	private static final Logger log = LoggingManager.getLoggerForClass();
	private static final long serialVersionUID = -996507992186021290L;

	private String query = "";
	private String keySpace = "";
	private String clusterId = "";

	public SampleResult sample(Entry arg0) {
		log.debug("sampling cql: " + query);
		SampleResult result = new SampleResult();
		result.setDataType(SampleResult.TEXT);
		result.setContentType("text/plain");
		result.setSampleLabel(getName());
		result.setSamplerData(query);

		// Assume we will be successful
		result.setSuccessful(true);
		result.setResponseMessageOK();
		result.setResponseCodeOK();

		result.sampleStart();
		try {
			ResultSet data = getSession(keySpace).execute(query);
			result.setResponseData(data.toString().getBytes());
			result.setResponseMessage(data.toString());
		} catch (Exception ex) {
			result.setResponseMessage(ex.toString());
			result.setResponseData(ex.getMessage().getBytes());
			result.setSuccessful(false);
		} 
		result.sampleEnd();
		return result;
	}

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
}
