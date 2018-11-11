package com.lu.wang.mgr;

import java.util.ArrayList;
import java.util.List;

import com.lu.wang.data.operator.Operator;

public class OperatorMgr {

	private static final String OPERATOR_ERROR = "operator %s (position: %d): insufficient parameters";

	private static final String COMMAND_ERROR = "invalid input";
	/**
	 * Operator list
	 */
	private List<Operator> operatorList;

	/**
	 * Constructor.
	 */
	public OperatorMgr() {
	}

	/**
	 * Initialize operator list from user command
	 * 
	 * @param command User command
	 */
	public String initFromCommand(String command) {
		operatorList = new ArrayList<Operator>();
		String[] keys = command.split(" ");
		int lastIndex = 0;
		for (String key : keys) {
			// double space, skip
			if (key.isEmpty()) {
				continue;
			}
			lastIndex = command.indexOf(key, lastIndex + 1);
			Operator operator = OperatorFactory.getOperator(key, lastIndex + key.length());
			if (operator != null) {
				operatorList.add(operator);
			} else {
				return COMMAND_ERROR;
			}
		}
		return null;
	}

	/**
	 * 
	 * Get the error message for the given operator.
	 * 
	 * @param operator
	 * @return Return the error message for the given operator.
	 */
	public static String getOperatorError(Operator operator) {
		return String.format(OPERATOR_ERROR, operator.getKey(), operator.getPosition());
	}

	/**
	 * @return the operatorList
	 */
	public List<Operator> getOperatorList() {
		return operatorList;
	}

	/**
	 * @param operatorList the operatorList to set
	 */
	public void setOperatorList(List<Operator> operatorList) {
		this.operatorList = operatorList;
	}
}
