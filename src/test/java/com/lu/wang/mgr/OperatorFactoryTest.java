package com.lu.wang.mgr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.lu.wang.data.operator.Operator;
import com.lu.wang.data.operator.OperatorClear;
import com.lu.wang.data.operator.OperatorDivide;
import com.lu.wang.data.operator.OperatorMinus;
import com.lu.wang.data.operator.OperatorMultiply;
import com.lu.wang.data.operator.OperatorNumber;
import com.lu.wang.data.operator.OperatorPlus;
import com.lu.wang.data.operator.OperatorSqrt;
import com.lu.wang.data.operator.OperatorUndo;

public class OperatorFactoryTest {
	@Test
	public void allValidOperator() {
		Operator operator;

		operator = OperatorFactory.getOperator("+", 2);
		assertTrue("OperatorPlus", operator instanceof OperatorPlus);
		assertEquals("Operator position", 2, operator.getPosition());

		operator = OperatorFactory.getOperator("-", 12);
		assertTrue("OperatorMinus", operator instanceof OperatorMinus);
		assertEquals("Operator position", 12, operator.getPosition());

		operator = OperatorFactory.getOperator("/", 5);
		assertTrue("OperatorDivide", operator instanceof OperatorDivide);
		assertEquals("Operator position", 5, operator.getPosition());

		operator = OperatorFactory.getOperator("*", 0);
		assertTrue("OperatorMultiply", operator instanceof OperatorMultiply);
		assertEquals("Operator position", 0, operator.getPosition());

		operator = OperatorFactory.getOperator("sqrt", 11);
		assertTrue("OperatorSqrt", operator instanceof OperatorSqrt);
		assertEquals("Operator position", 11, operator.getPosition());

		operator = OperatorFactory.getOperator("undo", 20);
		assertTrue("OperatorUndo", operator instanceof OperatorUndo);
		assertEquals("Operator position", 20, operator.getPosition());

		operator = OperatorFactory.getOperator("clear", 9);
		assertTrue("OperatorClear", operator instanceof OperatorClear);
		assertEquals("Operator position", 9, operator.getPosition());

		operator = OperatorFactory.getOperator("15", 22);
		assertTrue("OperatorNumber", operator instanceof OperatorNumber);
		assertEquals("Operator position", 22, operator.getPosition());
	}

	@Test
	public void inValidOperator() {
		Operator operator;

		operator = OperatorFactory.getOperator("test", 2);
		assertNull("Invalid operator, retun null", operator);
	}

}
