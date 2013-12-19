package com.github.cqljmeter.config;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TypeEditor;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.QueryOptions;

public class CassandraClusterConfigBeanInfo extends BeanInfoSupport {

	public CassandraClusterConfigBeanInfo() {
		super(CassandraClusterConfig.class);
		
		createPropertyGroup("cluster", new String[] { "clusterId", "contactPoint", "user", "password", "consistency" });
		
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
		
		p = property("consistency");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, QueryOptions.DEFAULT_CONSISTENCY_LEVEL.toString());
		p.setValue(NOT_OTHER, Boolean.TRUE);
		p.setValue(TAGS, toStrings(ConsistencyLevel.values()));
	}

	public static String[] toStrings(ConsistencyLevel[] input) {
		String[] result = new String[input.length];
		for (int i=0; i < input.length; i++) {
			result[i] = input[i].toString();
		}
		return result;
	}

}
