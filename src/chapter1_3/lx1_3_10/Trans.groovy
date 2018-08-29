package chapter1_3.lx1_3_10

/**
 * 中序转后序
 */
class Trans {
    String midToEpilogue(String midStr) {
        String epilogue = null

        if (midStr == null) {
            return epilogue;
        }

        midStr = midStr + "#";

        Stack<Character> opsStack = new Stack<>();
        Stack<String> valeStack = new Stack<>();

        int i = 0;
        while (i < midStr.length()) {
            char ch = midStr.charAt(i);

            if (Character.isDigit(ch)) {
                valeStack.push("" + ch)

                i++;
            } else if (ch == '(') {
                int rightParenthesisIndex = getRightParenthesisIndex(midStr, i)

                if (rightParenthesisIndex == -1) {
                    return null;
                }

                final int leftParenthesisIndex = i;
                String subStringInParenthes = midStr.subSequence(leftParenthesisIndex + 1, rightParenthesisIndex);

                String subStringOfEpilogue = midToEpilogue(subStringInParenthes);

                // 入数字栈
                valeStack.push(subStringOfEpilogue);

                i = rightParenthesisIndex + 1;
            } else if (ch == '#') {
                String binaryEpilogue = binaryComputeEpilogue(valeStack, opsStack)

                valeStack.push(binaryEpilogue)

                if (valeStack.size() <= 1) {
                    i++  // 结束标志
                }
            } else { // 符号
                if (opsStack.isEmpty()) {
                    opsStack.push(ch)

                    i++;
                } else {
                    char topChar = opsStack.peek()
                    if (compare(ch, topChar) <= 0) {
                        String binaryEpilogue = binaryComputeEpilogue(valeStack, opsStack)

                        valeStack.push(binaryEpilogue)

                        opsStack.push(ch)

                        i++
                    } else {
                        opsStack.push(ch)

                        i++
                    }
                }
            }
        }

        if (!valeStack.isEmpty()) {
            epilogue = valeStack.pop()
        }

        return epilogue
    }

    /**
     * left < right return -1, left = right return 0, left > right return 1
     * @param left
     * @param right
     * @return
     */
    int compare(char left, char right) {
//        String level1 = "+-"
        String level2 = "*/"

        int leftLevel = level2.contains("" + left) ? 2 : 1;
        int rightLevel = level2.contains("" + right) ? 2 : 1;

        if (leftLevel < rightLevel) return -1
        if (leftLevel == rightLevel) return 0
        if (leftLevel > rightLevel) return 1
    }

    int getRightParenthesisIndex(String str, int leftParenthesisIndex) {
        int index = -1;

        Stack<Character> stack = new Stack<>()

        for (int i = leftParenthesisIndex; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {

                stack.push(ch)
            } else if (ch == ')') {
                if (!stack.isEmpty()) {

                    stack.pop()
                    if (stack.isEmpty()) {
                        index = i
                        break
                    }
                }
            }
        }

        return index;
    }

    String binaryComputeEpilogue(Stack<String> valeStack, Stack<Character> opsStack) {
        String right = valeStack.pop();
        String left = valeStack.pop();
        String op = opsStack.pop();

        return left + right + op;
    }
}
