package chapter1_3.lx1_3_10

import edu.princeton.cs.algs4.StdIn
import org.junit.Assert

/**
 * 表达式中序转逆序
 */
class Exercise1_3_10 {

    static void main(String[] args) {
//        while (!StdIn.isEmpty()) {

        Assert.assertEquals("12+", new Trans().midToEpilogue("1+2"))
        Assert.assertEquals("123*+", new Trans().midToEpilogue("1+2*3"))
        Assert.assertEquals("12*3+", new Trans().midToEpilogue("1*2+3"))
        Assert.assertEquals("123+*", new Trans().midToEpilogue("1*(2+3)"))

//        }
    }
}
