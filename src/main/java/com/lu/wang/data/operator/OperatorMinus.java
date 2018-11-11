package com.lu.wang.data.operator;

import java.math.BigDecimal;

import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorMinus extends Operator {
	/**
	 * Key of minus operator
	 */
	public static final String KEY = "-";

	/**
	 * Constructor.
	 */
	public OperatorMinus() {
		super(KEY);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorMinus(int position) {
		this();
		setPosition(position);
	}

	@Override
	public String applyOperation(StackMgr stackMgr) {
		if (stackMgr.size() < 2) {
			return OperatorMgr.getOperatorError(this);
		}
		stackMgr.recordHistory();

		BigDecimal b = stackMgr.removeLast();
		BigDecimal a = stackMgr.removeLast();
		BigDecimal result = a.subtract(b);

		stackMgr.add(result);
		return null;
	}
}
