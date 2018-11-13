package com.lu.wang.data.stack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Stack {
	private static final int MAX_DECIMAL = 10;
	/**
	 * List
	 */
	private List<BigDecimal> list;

	/**
	 * Constructor
	 */
	public Stack() {
		list = new ArrayList<BigDecimal>();
	}

	/**
	 * @return the list
	 */
	public List<BigDecimal> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<BigDecimal> list) {
		this.list = list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Stack clone() {
		Stack object = new Stack();
		for (BigDecimal number : getList()) {
			object.getList().add(number);
		}
		return object;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("stack: ");
		for (BigDecimal stack : getList()) {
			if (stack.scale() > MAX_DECIMAL) {
				sb.append(stack.setScale(MAX_DECIMAL, RoundingMode.FLOOR));
			} else {
				sb.append(stack.toString());
			}
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}
