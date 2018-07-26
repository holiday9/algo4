package chapter1_3

class Exeirence1_3_4 {
    def checkBracketExpression(String str) {
        if (str == null) {
            return false;
        }

        def s = new FixedCapacityStackOfChar(100)

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (isLeftBracket(ch)) {

                s.push(ch);

            } else {

                if (s.isEmpty()) {

                    return false
                } else {

                    char topCh = s.pop();
                    if (!isMatch(topCh, ch)) return false;
                }
            }
        }

        return s.isEmpty();
    }

    def isMatch(char leftBracket, char rightBracket) {
        switch (leftBracket) {
            case '{':
                if ('}' == rightBracket) return true;
                break;
            case '[':
                if (']' == rightBracket) return true;
            case '(':
                if (')' == rightBracket) return true;
            default:
                return false;
        }
    }

    def isLeftBracket(char ch) {
        switch (ch) {
            case '{':
            case '[':
            case '(':
                return true;
            default:
                return false;
        }
    }

    static void main(String []args) {
        if (args.length <= 0) {
            println "参数为空";
            return
        };
        String bracketExpression = args[0];

        def exeirence1_3_4 = new Exeirence1_3_4();
        println exeirence1_3_4.checkBracketExpression(bracketExpression);
    }
}


