package com.lu.wang.data.operator;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.mgr.StackMgr;

public class OperatorNumber extends Operator {
	private static final Logger log = LoggerFactory.getLogger(OperatorNumber.class);

	/**
	 * Number
	 */
	private BigDecimal number;

	/**
	 * Constructor.
	 */
	public OperatorNumber(BigDecimal number, int position) {
		setKey(number.toString());
		setNumber(number);
		setPosition(position);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorNumber(int position) {
		setPosition(position);
	}

	@Override
	public String applyOperation(StackMgr stackMgr) {
		stackMgr.recordHistory();
		stackMgr.add(getNumber());
		return null;
	}

	/**
	 * @return the number
	 */
	public BigDecimal getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
}
