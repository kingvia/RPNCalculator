package com.lu.wang.mgr;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class OperatorMgrTest {
	/**
	 * Test with all operator
	 */
	@Test
	public void allOperator() {
		OperatorMgr mgr = new OperatorMgr();

		String result = mgr.initFromCommand("5 2 + - * / sqrt undo clear");
		assertEquals("Valid command, return null", null, result);

		int i = 0;
		assertEquals("Operator " + i, "5", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "2", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "+", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "-", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "*", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "/", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "sqrt", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "undo", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "clear", mgr.getOperatorList().get(i).getKey());
	}

	/**
	 * Test with duplicate operator
	 */
	@Test
	public void duplicateOperator() {
		OperatorMgr mgr = new OperatorMgr();

		String result = mgr.initFromCommand("2 2 2 2 clear clear clear clear undo undo undo undo + + + +");
		assertEquals("Valid command, return null", null, result);

		int i = 0;
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "2", mgr.getOperatorList().get(i).getKey());
			i++;
		}
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "clear", mgr.getOperatorList().get(i).getKey());
			i++;
		}
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "undo", mgr.getOperatorList().get(i).getKey());
			i++;
		}
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "+", mgr.getOperatorList().get(i).getKey());
			i++;
		}
	}

	/**
	 * Test with wrong input
	 */
	@Test
	public void invalidCommand() {
		OperatorMgr mgr = new OperatorMgr();

		String result = mgr.initFromCommand("2 test");
		assertNotNull("invalid command, return error message", result);
	}

	/**
	 * Test with double spaces
	 */
	@Test
	public void doubleSpaces() {
		OperatorMgr mgr = new OperatorMgr();

		String result = mgr.initFromCommand("  5  2  +     -  *  /    sqrt    undo  clear ");
		assertEquals("Valid command, return null", null, result);

		int i = 0;
		assertEquals("Operator " + i, "5", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "2", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "+", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "-", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "*", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "/", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "sqrt", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "undo", mgr.getOperatorList().get(i).getKey());
		i++;
		assertEquals("Operator " + i, "clear", mgr.getOperatorList().get(i).getKey());
	}
}
