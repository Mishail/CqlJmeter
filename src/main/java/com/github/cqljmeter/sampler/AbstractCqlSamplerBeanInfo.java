package com.github.cqljmeter.sampler;

/*
 * #%L
 * CqlJmeter
 * %%
 * Copyright (C) 2014 Mikhail Stepura
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */

import java.beans.PropertyDescriptor;

import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testbeans.gui.TypeEditor;

import com.datastax.driver.core.ConsistencyLevel;
import com.github.cqljmeter.config.CassandraClusterConfigBeanInfo;

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
		p.setValue(NOT_OTHER, Boolean.TRUE);
		p.setValue(TAGS, CassandraClusterConfigBeanInfo.toStrings(ConsistencyLevel.values()));
	}
}
