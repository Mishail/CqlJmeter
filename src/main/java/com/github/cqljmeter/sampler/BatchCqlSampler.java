package com.github.cqljmeter.sampler;

import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import org.apache.commons.lang3.Validate;

import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.querybuilder.QueryBuilder;

public class BatchCqlSampler extends AbstractCqlSampler {

	private static final long serialVersionUID = 935766581618167876L;

	@Override
	protected Statement getStatement() {
		String[] statements = getQuery().split(";");
		Validate.validIndex(statements, 1, "Query contains only 1 statement: " + getQuery());
		List<Statement> result = newArrayList();
		for (String statement: statements) {
			result.add(new SimpleStatement(statement));
		}
		return QueryBuilder.batch(result.toArray(new Statement[0]));
	}

}
