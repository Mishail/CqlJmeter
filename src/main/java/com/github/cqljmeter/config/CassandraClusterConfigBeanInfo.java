package com.github.cqljmeter.config;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;

public class CassandraClusterConfigBeanInfo extends BeanInfoSupport {

	public CassandraClusterConfigBeanInfo() {
		super(CassandraClusterConfig.class);
		
		createPropertyGroup("cluster", new String[] { "clusterId", "contactPoint" });
		
		PropertyDescriptor p = property("clusterId");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "Cluster1");
		
		p = property("contactPoint");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "127.0.0.1");
	}

}
