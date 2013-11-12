package com.github.cqljmeter.sampler;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.exceptions.DriverException;

public class CqlSampler extends AbstractSampler implements TestBean {

	private static final Logger log = LoggingManager.getLoggerForClass();
	private static final long serialVersionUID = -996507992186021290L;

	private String query = "";
	private String keySpace = "";
	private String contactPoint = "";

	public SampleResult sample(Entry arg0) {
		log.debug("sampling cql: " + query);
		SampleResult result = new SampleResult();
		result.setDataType(SampleResult.TEXT);
		result.setContentType("text/plain");
		result.setSampleLabel(contactPoint + ":" + keySpace);
		result.setSamplerData(query);

		// Assume we will be successful
		result.setSuccessful(true);
		result.setResponseMessageOK();
		result.setResponseCodeOK();

		result.sampleStart();

		Cluster cluster = Cluster.builder().addContactPoint(getContactPoint()).build();
		Session session = null;
		try {
			try {
				session = cluster.connect(keySpace);
			} finally {
				result.latencyEnd();
			}
			result.setResponseMessage(session.execute(query).toString());
		} catch (DriverException ex) {
			result.setResponseCode("000");
			result.setResponseMessage(ex.toString());
			result.setResponseData(ex.getMessage().getBytes());
			result.setSuccessful(false);
		} catch (Exception ex) {
			result.setResponseMessage(ex.toString());
			result.setResponseCode("000");
			result.setResponseData(ex.getMessage().getBytes());
			result.setSuccessful(false);
		} finally {
			cluster.shutdown();
		}

		result.sampleEnd();
		return result;
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

	public String getContactPoint() {
		return contactPoint;
	}

	public void setContactPoint(String contactPoint) {
		this.contactPoint = contactPoint;
	}
}
