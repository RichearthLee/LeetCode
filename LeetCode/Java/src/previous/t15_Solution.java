package previous;

import java.util.Stack;
/*
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 */

public class t15_Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("%")) {
				int b = st.pop();
				int a = st.pop();
				st.push(operation(a, b, tokens[i]));
			} else {
				st.push(Integer.parseInt(tokens[i]));
			}

			/*
			 * if(tokens[i].matches("[0-9]{1,}")) {
			 * 
			 * }
			 */
		}
		return st.pop();
	}

	public int operation(int a, int b, String op) {
		switch (op) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "*":
			return a * b;
		case "/":
			return a / b;
		default:
			return 0;
		}
	}

}
