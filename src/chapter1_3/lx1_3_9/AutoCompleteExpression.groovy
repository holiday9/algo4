package chapter1_3.lx1_3_9

class AutoCompleteExpression {
    String autoComplete(String expressionMissLeftParenthesis) {
        if (expressionMissLeftParenthesis == null || expressionMissLeftParenthesis == "") {
            return null;
        }

        Stack<Character> ops = new Stack();
        Stack<String> vals = new Stack();

        for (int i = 0;i < expressionMissLeftParenthesis.length();i++) {
            char ch = expressionMissLeftParenthesis.charAt(i);

            // if ch is value, then push to vals stack
            // if ch is (, then ignore
            // if ch is + - * /, then push to ops stack
            // if ch is ), then pop two value and pop a op and make a string with (), then push the result to vals
            if (Character.isDigit(ch)) {
                vals.push("" + ch);
            } else if (ch == '(') {
                // ignore
            }
            else if (ch == '+') ops.push(ch);
            else if (ch == '-') ops.push(ch);
            else if (ch == '*') ops.push(ch);
            else if (ch == '/') ops.push(ch);
            else if (ch == ')') {
                String right = vals.pop();
                String left = vals.pop();
                String op = ops.pop();

                String result = "(" + left + op + right + ")";

                vals.push(result);
            }
        }

        return vals.pop();
    }
}
