package com.lu.wang.mgr;

import java.math.BigDecimal;
import com.lu.wang.data.stack.Stack;
import com.lu.wang.data.stack.StackHistory;

public class StackMgr {
	/**
	 * Stack
	 */
	private Stack stack;
	/**
	 * Stack history
	 */
	private StackHistory history;

	/**
	 * Constructor.
	 */
	public StackMgr() {
		stack = new Stack();
		history = new StackHistory();
	}

	/**
	 * Return number of element in stack.
	 */
	public int size() {
		return stack.getList().size();
	}

	/**
	 * Return number of element in history.
	 */
	public int historySize() {
		return history.getHistory().size();
	}

	/**
	 * Remove the last element from stack.
	 * 
	 * @return Removed stack element.
	 */
	public BigDecimal removeLast() {
		return stack.getList().remove(stack.getList().size() - 1);
	}

	/**
	 * Add an element into current stack.
	 * 
	 * @param element
	 */
	public void add(BigDecimal element) {
		stack.getList().add(element);
	}


	/**
	 * Record current stack into history list.
	 */
	public void recordHistory() {
		if (stack.getList().isEmpty()) {
			return;
		}
		history.getHistory().add(stack.clone());
	}

	/**
	 * Remove all elements from stack.
	 */
	public void clear() {
		stack.getList().clear();
	}

	/**
	 * Assign last history stack to current stack and then remove it from history.
	 */
	public void removeLastHistory() {
		stack = history.getHistory().remove(history.getHistory().size() - 1);
	}

	/**
	 * @return the stack
	 */
	public Stack getStack() {
		return stack;
	}

	/**
	 * @param stack the stack to set
	 */
	public void setStack(Stack stack) {
		this.stack = stack;
	}

	/**
	 * @return the history
	 */
	public StackHistory getHistory() {
		return history;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(StackHistory history) {
		this.history = history;
	}
}
