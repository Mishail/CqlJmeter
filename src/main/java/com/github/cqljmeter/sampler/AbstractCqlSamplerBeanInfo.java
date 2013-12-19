package com.github.cqljmeter.sampler;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.TypeEditor;

import com.datastax.driver.core.ConsistencyLevel;

public abstract class AbstractCqlSamplerBeanInfo extends BeanInfoSupport {

	protected AbstractCqlSamplerBeanInfo(Class<? extends TestBean> beanClass) {
		super(beanClass);
		createPropertyGroup("cql", new String[] { "clusterId", "keySpace", "consistency", "query" });

		PropertyDescriptor p = property("query", TypeEditor.TextAreaEditor);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "select * from Standard");
		p.setValue(TEXT_LANGUAGE, "sql");
		
		p = property("keySpace");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "stress");
		
		p = property("clusterId");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "Cluster1");
		
		p = property("consistency");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, ConsistencyLevel.ONE.toString());
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
