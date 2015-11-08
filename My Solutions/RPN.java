import java.util.Stack;

public class RPN {
	public int evalRPN(String[] tokens) {

		int len = tokens.length;
		int op1, op2;
		
		Stack<Integer> tokStack = new Stack<Integer>();
		
		for (int i = 0; i < len; i++) {
			switch (tokens[i]) {
			case "+":
				op2 = tokStack.pop();
				op1 = tokStack.pop();
				tokStack.push(op1+op2);
				break;
			case "-":
				op2 = tokStack.pop();
				op1 = tokStack.pop();
				tokStack.push(op1-op2);
				break;
			case "*":
				op2 = tokStack.pop();
				op1 = tokStack.pop();
				tokStack.push(op1*op2);
				break;
			case "/":
				op2 = tokStack.pop();
				op1 = tokStack.pop();
				tokStack.push(op1/op2);
				break;
			default:
				tokStack.push(Integer.parseInt(tokens[i]));
				break;
			}
		}
		return tokStack.pop();
	}
}