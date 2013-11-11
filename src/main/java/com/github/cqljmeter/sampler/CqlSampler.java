package com.github.cqljmeter.sampler;

import java.util.concurrent.TimeUnit;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

public class CqlSampler extends AbstractSampler implements TestBean {

	private static final Logger log = LoggingManager.getLoggerForClass();
	private static final long serialVersionUID = -996507992186021290L;
	
	private String query = "";
	private String queryTimeout = "";

	public CqlSampler(){}
	
	public SampleResult sample(Entry arg0) {
		log.warn("sampling cql: " + query);
		SampleResult result = new SampleResult();
        result.setSampleLabel("test label");
        result.setSamplerData("test data");
        result.setDataType(SampleResult.TEXT);
        result.setContentType("text/plain");
        
        // Assume we will be successful
        result.setSuccessful(true);
        result.setResponseMessageOK();
        result.setResponseCodeOK();


        result.sampleStart();
        
        try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public String getQueryTimeout() {
		return queryTimeout;
	}

	public void setQueryTimeout(String queryTimeout) {
		this.queryTimeout = queryTimeout;
	}

}
