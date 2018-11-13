package com.lu.wang;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RPNCalculatorAppTest {
	RPNCalculatorApp app;

	@Before
	public void setUp() throws Exception {
		app = new RPNCalculatorApp();
	}

	@Test
	public void number() {
		app.calculate("5 2");
		assertEquals("buid stack 5 2", "stack: 5 2", app.getStackMgr().getStack().toString());
	}

	@Test
	public void plus() {
		app.calculate("5 2 +");
		assertEquals("5+2=", "stack: 7", app.getStackMgr().getStack().toString());
	}

	@Test
	public void minus() {
		app.calculate("5 2 -");
		assertEquals("5-2=", "stack: 3", app.getStackMgr().getStack().toString());
	}

	@Test
	public void divide() {
		app.calculate("5 2 /");
		assertEquals("5/2=", "stack: 2.5", app.getStackMgr().getStack().toString());
	}

	@Test
	public void multiply() {
		app.calculate("5 2 *");
		assertEquals("5*2=", "stack: 10", app.getStackMgr().getStack().toString());
	}

	@Test
	public void sqrt() {
		app.calculate("9 sqrt");
		assertEquals("Square root of 9=", "stack: 3", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example2() {
		app.calculate("2 sqrt");
		assertEquals("[2 sqrt]=", "stack: 1.4142135623", app.getStackMgr().getStack().toString());

		app.calculate("clear 9 sqrt");
		assertEquals("[clear 9 sqrt]=", "stack: 3", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example3() {
		app.calculate("5 2 -");
		assertEquals("[5 2 -]=", "stack: 3", app.getStackMgr().getStack().toString());

		app.calculate("3 - ");
		assertEquals("[3 - ]=", "stack: 0", app.getStackMgr().getStack().toString());

		app.calculate("clear");
		assertEquals("[clear]=", "stack:", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example4() {
		app.calculate("5 4 3 2");
		assertEquals("[5 4 3 2]=", "stack: 5 4 3 2", app.getStackMgr().getStack().toString());

		app.calculate("undo undo *");
		assertEquals("[undo undo *]=", "stack: 20", app.getStackMgr().getStack().toString());

		app.calculate("5 *");
		assertEquals("[5 *]=", "stack: 100", app.getStackMgr().getStack().toString());

		app.calculate("undo undo");
		assertEquals("[undo undo]=", "stack: 20", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example5() {
		app.calculate("7 12 2 /");
		assertEquals("[7 12 2 /]=", "stack: 7 6", app.getStackMgr().getStack().toString());

		app.calculate("*");
		assertEquals("[*]=", "stack: 42", app.getStackMgr().getStack().toString());

		app.calculate("4 /");
		assertEquals("[4 /]=", "stack: 10.5", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example6() {
		app.calculate("1 2 3 4 5");
		assertEquals("[1 2 3 4 5]=", "stack: 1 2 3 4 5", app.getStackMgr().getStack().toString());

		app.calculate("*");
		assertEquals("[*]=", "stack: 1 2 3 20", app.getStackMgr().getStack().toString());

		app.calculate("clear 3 4 -");
		assertEquals("[clear 3 4 -]=", "stack: -1", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example7() {
		app.calculate("1 2 3 4 5");
		assertEquals("[1 2 3 4 5]=", "stack: 1 2 3 4 5", app.getStackMgr().getStack().toString());

		app.calculate("* * * *");
		assertEquals("[* * * *]=", "stack: 120", app.getStackMgr().getStack().toString());
	}

	@Test
	public void example8() {
		String result;
		result = app.calculate("1 2 3 * 5 + * * 6 5");
		assertEquals("[1 2 3 * 5 + * * 6 5]", "stack: 11", app.getStackMgr().getStack().toString());
		assertEquals("Error message:", "operator * (position: 15): insufficient parameters", result);
	}

}
