package com.lu.wang.mgr;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.data.operator.Operator;
import com.lu.wang.data.operator.OperatorClear;
import com.lu.wang.data.operator.OperatorDivide;
import com.lu.wang.data.operator.OperatorMinus;
import com.lu.wang.data.operator.OperatorMultiply;
import com.lu.wang.data.operator.OperatorNumber;
import com.lu.wang.data.operator.OperatorPlus;
import com.lu.wang.data.operator.OperatorSqrt;
import com.lu.wang.data.operator.OperatorUndo;

public class OperatorFactory {
	private static final Logger log = LoggerFactory.getLogger(OperatorFactory.class);

	/**
	 * Return operator object.
	 * 
	 * @param key      Key of the operator
	 * @param position Position of the operator
	 * @return Operator object
	 */
	public static Operator getOperator(String key, int position) {
		switch (key) {
		case OperatorPlus.KEY:
			return new OperatorPlus(position);
		case OperatorMinus.KEY:
			return new OperatorMinus(position);
		case OperatorDivide.KEY:
			return new OperatorDivide(position);
		case OperatorMultiply.KEY:
			return new OperatorMultiply(position);
		case OperatorSqrt.KEY:
			return new OperatorSqrt(position);
		case OperatorClear.KEY:
			return new OperatorClear(position);
		case OperatorUndo.KEY:
			return new OperatorUndo(position);
		default:
			try {
				BigDecimal number = new BigDecimal(key);
				return new OperatorNumber(number, position);
			} catch (NumberFormatException exc) {
				log.error("Invalid operator [" + key + "]");
				return null;
			}
		}
	}
}
