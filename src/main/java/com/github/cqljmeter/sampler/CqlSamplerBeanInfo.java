package com.github.cqljmeter.sampler;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.TypeEditor;

public class CqlSamplerBeanInfo extends BeanInfoSupport {
	protected CqlSamplerBeanInfo(Class<? extends TestBean> arg0) {
		super(arg0);
		createPropertyGroup("cql", new String[] { "query" });

		PropertyDescriptor p = property("query", TypeEditor.TextAreaEditor);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "");
		p.setValue(TEXT_LANGUAGE, "sql");
	}

	public CqlSamplerBeanInfo() {
		super(CqlSampler.class);
	}
}
