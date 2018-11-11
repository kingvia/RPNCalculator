package com.lu.wang.data.operator;

import java.math.BigDecimal;
import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorSqrt extends Operator {
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
			return OperatorMgr.getOperatorError(this);
		}
		stackMgr.recordHistory();

		BigDecimal a = stackMgr.removeLast();
		BigDecimal result = new BigDecimal(Math.sqrt(a.doubleValue()));

		stackMgr.add(result);
		return null;
	}
}
