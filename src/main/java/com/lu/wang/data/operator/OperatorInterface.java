package com.lu.wang.data.operator;

import com.lu.wang.mgr.StackMgr;

interface OperatorInterface {
	/**
	 * Return the error message when apply the operation. NULL if operation successfully applied.
	 * 
	 * @param stackMgr Stack manager
	 * @return The error message when apply the operation. NULL if operation successfully applied.
	 */
	public abstract String applyOperation(StackMgr stackMgr);
}
