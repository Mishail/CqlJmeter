package com.github.cqljmeter.sampler;

import org.apache.commons.lang3.Validate;

import com.datastax.driver.core.BatchStatement;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;

public class BatchCqlSampler extends AbstractCqlSampler {

	private static final long serialVersionUID = 935766581618167876L;

	@Override
	protected Statement getStatement() {
		String[] statements = getQuery().split(";");
		Validate.validIndex(statements, 1, "Query contains only 1 statement: " + getQuery());
		BatchStatement result = new BatchStatement();
		for (String statement: statements) {
			result.add(new SimpleStatement(statement));
		}
		return result;
	}

}
