package com.github.cqljmeter.sampler;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.TypeEditor;

public abstract class AbstractCqlSamplerBeanInfo extends BeanInfoSupport {

	protected AbstractCqlSamplerBeanInfo(Class<? extends TestBean> beanClass) {
		super(beanClass);
		createPropertyGroup("cql", new String[] { "clusterId", "keySpace", "query" });

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
	}
}
