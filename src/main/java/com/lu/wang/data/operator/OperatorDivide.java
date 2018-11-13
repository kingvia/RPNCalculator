package com.lu.wang.data.operator;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorDivide extends Operator {
	private static final Logger log = LoggerFactory.getLogger(OperatorDivide.class);

	/**
	 * Key of divide operator
	 */
	public static final String KEY = "/";

	/**
	 * Constructor.
	 */
	public OperatorDivide() {
		super(KEY);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorDivide(int position) {
		this();
		setPosition(position);
	}

	@Override
	public String applyOperation(StackMgr stackMgr) {
		if (stackMgr.size() < 2) {
			log.error("Error when apply [" + this.toString() + "] on [" + stackMgr.getStack().toString() + "]");
			return OperatorMgr.getOperatorError(this);
		}
		stackMgr.recordHistory();

		BigDecimal b = stackMgr.removeLast();
		BigDecimal a = stackMgr.removeLast();
		BigDecimal result = a.divide(b);

		stackMgr.add(result);
		return null;
	}
}
