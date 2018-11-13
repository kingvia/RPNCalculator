package com.lu.wang.data.operator;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorSqrt extends Operator {
	private static final Logger log = LoggerFactory.getLogger(OperatorSqrt.class);
	/**
	 * Key of square root operator
	 */
	public static final String KEY = "sqrt";

	/**
	 * Constructor.
	 */
	public OperatorSqrt() {
		super(KEY);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorSqrt(int position) {
		this();
		setPosition(position);
	}

	@Override
	public String applyOperation(StackMgr stackMgr) {
		if (stackMgr.size() < 1) {
			log.error("Error when apply [" + this.toString() + "] on [" + stackMgr.getStack().toString() + "]");
			return OperatorMgr.getOperatorError(this);
		}
		stackMgr.recordHistory();

		BigDecimal a = stackMgr.removeLast();
		BigDecimal result = new BigDecimal(Math.sqrt(a.doubleValue()));

		stackMgr.add(result);
		return null;
	}
}
