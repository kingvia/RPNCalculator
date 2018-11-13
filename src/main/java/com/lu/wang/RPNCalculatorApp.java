package com.lu.wang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lu.wang.data.operator.Operator;
import com.lu.wang.mgr.OperatorMgr;
import com.lu.wang.mgr.StackMgr;

public class RPNCalculatorApp {
	private static final Logger log = LoggerFactory.getLogger(RPNCalculatorApp.class);

	private static final String COMMAND_ERROR = "invalid input";

	/**
	 * Operator manager
	 */
	private OperatorMgr operatorMgr;

	/**
	 * Stack manager
	 */
	private StackMgr stackMgr;

	/**
	 * Constructor
	 */
	public RPNCalculatorApp() {
		operatorMgr = new OperatorMgr();
		stackMgr = new StackMgr();
	}

	/**
	 * Run RPN Calculator application.
	 */
	public void run() {
		BufferedReader br;
		String s;
		String error = null;
		while (true) {
			try {
				// Read user input
				br = new BufferedReader(new InputStreamReader(System.in));
				s = br.readLine();
				log.info("Start user command [" + s + "]");

				error = calculate(s.toLowerCase());
				if (error != null) {
					System.out.println(error);
				}

				log.info("Finish user command [" + s + "] => [" + stackMgr.getStack().toString() + "]");

				System.out.println(stackMgr.getStack().toString());
			} catch (IOException e) {
				System.out.println(COMMAND_ERROR);
			}
		}
	}

	/**
	 * Calculate the stack based on specified command. Error message if invalid
	 * command specified. Otherwise null.
	 * 
	 * @param command
	 * @return Error message if invalid command specified. Otherwise null.
	 */
	public String calculate(String command) {

		String error = operatorMgr.initFromCommand(command);
		if (error != null) {
			return error;
		}
		for (Operator o : operatorMgr.getOperatorList()) {
			error = o.applyOperation(stackMgr);
			if (error != null) {
				return error;
			}
			// Successful, log the stack.
			log.debug("After process [" + o.toString() + "] => [" + stackMgr.getStack().toString() + "]");
		}
		return null;
	}

	/**
	 * @return the operatorMgr
	 */
	public OperatorMgr getOperatorMgr() {
		return operatorMgr;
	}

	/**
	 * @param operatorMgr the operatorMgr to set
	 */
	public void setOperatorMgr(OperatorMgr operatorMgr) {
		this.operatorMgr = operatorMgr;
	}

	/**
	 * @return the stackMgr
	 */
	public StackMgr getStackMgr() {
		return stackMgr;
	}

	/**
	 * @param stackMgr the stackMgr to set
	 */
	public void setStackMgr(StackMgr stackMgr) {
		this.stackMgr = stackMgr;
	}

	/**
	 * Main method for the application
	 */
	public static void main(String[] args) {
		log.info("Application started ...");

		RPNCalculatorApp app = new RPNCalculatorApp();
		app.run();

		log.info("Application stopped ...");
	}
}
