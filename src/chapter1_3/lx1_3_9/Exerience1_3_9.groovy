package chapter1_3.lx1_3_9

import edu.princeton.cs.algs4.StdIn

class Exerience1_3_9 {

    static void main(String[] args) {
        String expressionMissLeftParenthesis = StdIn.readString();

        String expression = new AutoCompleteExpression().autoComplete(expressionMissLeftParenthesis);

        printf "补全后的表达式:" + expression;

    }
}
