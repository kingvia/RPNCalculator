package com.lu.wang.data.operator;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorMultiply extends Operator {
	private static final Logger log = LoggerFactory.getLogger(OperatorMultiply.class);
	/**
	 * Key of multiply operator
	 */
	public static final String KEY = "*";

	/**
	 * Constructor.
	 */
	public OperatorMultiply() {
		super(KEY);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorMultiply(int position) {
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
		BigDecimal result = a.multiply(b);

		stackMgr.add(result);
		return null;
	}
}
