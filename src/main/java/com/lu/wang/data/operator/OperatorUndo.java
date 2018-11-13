package com.lu.wang.data.operator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorUndo extends Operator {
	private static final Logger log = LoggerFactory.getLogger(OperatorSqrt.class);

	/**
	 * Key of undo operator
	 */
	public static final String KEY = "undo";

	/**
	 * Constructor.
	 */
	public OperatorUndo() {
		super(KEY);
	}

	/**
	 * Constructor.
	 *
	 * @param position The Operator's position
	 */
	public OperatorUndo(int position) {
		this();
		setPosition(position);
	}

	@Override
	public String applyOperation(StackMgr stackMgr) {
		if (stackMgr.getHistory().getHistory().size() <= 0) {
			log.error("Error when apply [" + this.toString() + "] when stack history size is ["
					+ stackMgr.getHistory().getHistory().size() + "]");
			return OperatorMgr.getOperatorError(this);
		}
		stackMgr.removeLastHistory();
		return null;
	}
}
