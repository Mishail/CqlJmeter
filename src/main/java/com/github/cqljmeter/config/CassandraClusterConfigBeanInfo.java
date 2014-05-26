package com.github.cqljmeter.config;

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
