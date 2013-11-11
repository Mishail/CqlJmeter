package com.github.cqljmeter.sampler;

import java.util.concurrent.TimeUnit;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

public class CqlSampler extends AbstractSampler implements TestBean {
	@Override
	public boolean applies(ConfigTestElement configElement) {
        String guiClass = configElement.getProperty(TestElement.GUI_CLASS).getStringValue();
        log.warn(guiClass);
        return "org.apache.jmeter.config.gui.SimpleConfigGui".equalsIgnoreCase(guiClass);
	}

	private static final Logger log = LoggingManager.getLoggerForClass();
	private static final long serialVersionUID = -996507992186021290L;
	
	private String query = "";

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

}
