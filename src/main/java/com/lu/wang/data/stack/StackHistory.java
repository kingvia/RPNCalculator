package com.lu.wang.data.stack;

import java.util.ArrayList;
import java.util.List;

public class StackHistory {
	/**
	 * History
	 */
	private List<Stack> history;

	/**
	 * Constructor
	 */
	public StackHistory() {
		setHistory(new ArrayList<Stack>());
	}

	/**
	 * @return the history
	 */
	public List<Stack> getHistory() {
		return history;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(List<Stack> history) {
		this.history = history;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Stack History: ");
		for (Stack stack : getHistory()) {
			sb.append(stack.toString());
		}
		return sb.toString();
	}
}
