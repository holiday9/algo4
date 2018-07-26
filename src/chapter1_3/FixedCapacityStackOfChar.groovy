package chapter1_3

class FixedCapacityStackOfChar {
    private char[] a;
    private int N;

    FixedCapacityStackOfChar(int cap) {
        a = new char[cap];
    }

    void push(char item) {
        a[N++] = item;
    }

    char pop() {
        return a[--N];
    }

    boolean isEmpty() {
        return N == 0;
    }

    boolean isFull() {
        return N == a.length;
    }

    int size() {
        return N;
    }
}
