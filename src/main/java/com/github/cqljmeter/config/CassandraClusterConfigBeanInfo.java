package com.github.cqljmeter.config;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TypeEditor;

public class CassandraClusterConfigBeanInfo extends BeanInfoSupport {

	public CassandraClusterConfigBeanInfo() {
		super(CassandraClusterConfig.class);
		
		createPropertyGroup("cluster", new String[] { "clusterId", "contactPoint", "user", "password"});
		
		PropertyDescriptor p = property("clusterId");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "Cluster1");
		
		
		p = property("contactPoint");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "127.0.0.1");
		
		p = property("user");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "");
		
		p = property("password", TypeEditor.PasswordEditor);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "");
	}


}
