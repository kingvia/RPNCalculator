package com.lu.wang.data.operator;

public abstract class Operator implements OperatorInterface {
	/**
	 * key
	 */
	protected String key;

	/**
	 * Position
	 */
	protected int position;

	/**
	 * Constructor.
	 */
	public Operator() {
	}

	/**
	 * Constructor.
	 *
	 * @param operator The Operator's key
	 */
	public Operator(String key) {
		this.setKey(key);
	}

	/**
	 * Constructor.
	 *
	 * @param operator The Operator's key
	 */
	public Operator(String key, int position) {
		this.setKey(key);
		this.setPosition(position);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Returns a string that represents the current object.
	 * 
	 * @return A string that represents the current object.
	 */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Operator: key=");
		sb.append(getKey());
		sb.append(" position=");
		sb.append(getPosition());
		return sb.toString();
	}
}
