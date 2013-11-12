package com.github.cqljmeter.sampler;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TypeEditor;

public class CqlSamplerBeanInfo extends BeanInfoSupport {

	public CqlSamplerBeanInfo() {
		super(CqlSampler.class);
		createPropertyGroup("cql", new String[] { "contactPoint", "keySpace", "query" });

		PropertyDescriptor p = property("query", TypeEditor.TextAreaEditor);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "select * from Standard");
		p.setValue(TEXT_LANGUAGE, "sql");
		
		p = property("keySpace");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "stress");
		
		p = property("contactPoint");
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "127.0.0.1");
	}
}
