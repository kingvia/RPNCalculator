package com.lu.wang.data.operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.mgr.StackMgr;

public class OperatorClear extends Operator {
	private static final Logger log = LoggerFactory.getLogger(OperatorClear.class);

	/**
	 * Key of clear operator
	 */
	public static final String KEY = "clear";

	/**
	 * Constructor.
	 */
	public OperatorClear() {
		super(KEY);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorClear(int position) {
		this();
		setPosition(position);
	}

	@Override
	public String applyOperation(StackMgr stackMgr) {
		stackMgr.recordHistory();
		stackMgr.clear();
		return null;
	}
}
