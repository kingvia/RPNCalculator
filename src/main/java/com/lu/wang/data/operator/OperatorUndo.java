package com.lu.wang.data.operator;

import java.util.List;

import com.lu.wang.data.stack.Stack;
import com.lu.wang.data.stack.StackHistory;
import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class OperatorUndo extends Operator {
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
			return OperatorMgr.getOperatorError(this);
		}
		stackMgr.removeLastHistory();
		return null;
	}
}
