package com.github.cqljmeter.sampler;

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.TypeEditor;

public class CqlSamplerBeanInfo extends BeanInfoSupport {

	public CqlSamplerBeanInfo() {
		super(CqlSampler.class);
		createPropertyGroup("cql", new String[] { "query", "queryTimeout" });
		
		PropertyDescriptor p = property("queryTimeout"); // $NON-NLS-1$
        p.setValue(NOT_UNDEFINED, Boolean.TRUE);
        p.setValue(DEFAULT, "");
		
		 p = property("query", TypeEditor.TextAreaEditor);
		p.setValue(NOT_UNDEFINED, Boolean.TRUE);
		p.setValue(DEFAULT, "test");
		p.setValue(TEXT_LANGUAGE, "sql");
	}
}
