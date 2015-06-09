package com.sangeethlabs.antlr.expr;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class TestExprParser {

	private Evaluator evalutar = new Evaluator();
	
	@Test
	public void testAddition() throws IOException {
		String expression = "100+20";
		Assert.assertEquals(120, evalutar.eval(expression));
	}
	
	@Test
	public void testSubtraction() throws IOException {
		String expression = "100-20";
		Assert.assertEquals(80, evalutar.eval(expression));
	}

	@Test
	public void testLongExpression() throws IOException {
		String expression = "100+20-60";
		Assert.assertEquals(60, evalutar.eval(expression));
	}

}
