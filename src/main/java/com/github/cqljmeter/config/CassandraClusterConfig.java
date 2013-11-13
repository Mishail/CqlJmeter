package com.github.cqljmeter.config;

import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jorphan.logging.LoggingManager;
import org.apache.log.Logger;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraClusterConfig extends ConfigTestElement  implements TestStateListener, TestBean {

	private static final Logger log = LoggingManager.getLoggerForClass();
	private static final long serialVersionUID = -3927956370607660166L;
	
	private String clusterId = "";
	
	private String contactPoint = "";

	@Override
	public void testEnded() {
		((ClusterHolder)getThreadContext().getVariables().getObject(getClusterId())).shutdown();
	}

	@Override
	public void testEnded(String arg0) {
		testEnded();
	}

	@Override
	public void testStarted() {
		log.debug("Creating cluster: " + clusterId);
		Cluster cluster = Cluster.builder().withClusterName(clusterId).addContactPoint(contactPoint).build();
		getThreadContext().getVariables().putObject(getClusterId(), new ClusterHolder(cluster));
	}

	@Override
	public void testStarted(String arg0) {
		testStarted();
	}

	public String getClusterId() {
		return clusterId;
	}

	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	public static Session getSession(String clusterId, String keySpace) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContactPoint() {
		return contactPoint;
	}

	public void setContactPoint(String contactPoint) {
		this.contactPoint = contactPoint;
	}
	
}
