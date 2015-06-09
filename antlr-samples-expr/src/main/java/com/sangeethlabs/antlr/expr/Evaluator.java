package com.sangeethlabs.antlr.expr;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.sangeethlabs.antlr.expr.ExprParser.AddContext;
import com.sangeethlabs.antlr.expr.ExprParser.IntContext;
import com.sangeethlabs.antlr.expr.ExprParser.SubtractContext;

public class Evaluator {
	public int eval(String expression) throws IOException {
		ByteArrayInputStream in = new ByteArrayInputStream(expression.getBytes());
		
		ANTLRInputStream input = new ANTLRInputStream(in);
		ExprLexer lexer = new ExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ExprParser parser = new ExprParser(tokens);
		ParseTree tree = parser.expr();
		EvalVisitor visitor = new EvalVisitor();
		return visitor.visit(tree);
	}
	
	private class EvalVisitor extends ExprBaseVisitor<Integer> {

		@Override
		public Integer visitAdd(AddContext ctx) {
			return visit(ctx.expr(0)) + visit(ctx.expr(1));
		}

		@Override
		public Integer visitSubtract(SubtractContext ctx) {
			return visit(ctx.expr(0)) - visit(ctx.expr(1));
		}

		@Override
		public Integer visitInt(IntContext ctx) {
			return Integer.valueOf(ctx.INT().getText());
		}
	}
}
