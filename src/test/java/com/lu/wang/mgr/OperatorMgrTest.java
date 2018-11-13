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
		assertEquals("Operator " + i + " position", 1, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "2", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 3, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "+", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 5, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "-", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 7, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "*", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 9, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "/", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 11, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "sqrt", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 13, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "undo", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 18, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "clear", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 23, mgr.getOperatorList().get(i).getPosition());
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
			assertEquals("Operator " + i + " position", i + 1 + j, mgr.getOperatorList().get(i).getPosition());
			i++;
		}
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "clear", mgr.getOperatorList().get(i).getKey());
			assertEquals("Operator " + i + " position", i + 5 + j * 5, mgr.getOperatorList().get(i).getPosition());
			i++;
		}
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "undo", mgr.getOperatorList().get(i).getKey());
			assertEquals("Operator " + i + " position", i + 25 + j * 4, mgr.getOperatorList().get(i).getPosition());
			i++;
		}
		for (int j = 0; j < 4; j++) {
			assertEquals("Operator " + i, "+", mgr.getOperatorList().get(i).getKey());
			assertEquals("Operator " + i + " position", i + 41 + j, mgr.getOperatorList().get(i).getPosition());
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
		assertEquals("Operator " + i + " position", 3, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "2", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 6, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "+", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 9, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "-", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 15, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "*", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 18, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "/", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 21, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "sqrt", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 26, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "undo", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 34, mgr.getOperatorList().get(i).getPosition());
		i++;
		assertEquals("Operator " + i, "clear", mgr.getOperatorList().get(i).getKey());
		assertEquals("Operator " + i + " position", 40, mgr.getOperatorList().get(i).getPosition());
	}
}
