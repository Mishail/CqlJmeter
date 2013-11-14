package com.github.cqljmeter.sampler;

import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

public class CqlSampler extends AbstractCqlSampler {
	private static final long serialVersionUID = 5256197785592415550L;

	@Override
	protected Statement getStatement() {
		return new SimpleStatement(getQuery());
	}
}
