package chapter1_1.stddraw;

import edu.princeton.cs.algs4.StdDraw;

public class StdDrawDemo {
    private void drawFunc() {
        int N = 100;
        StdDraw.setScale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(.01);
        for (int i = 0; i <= N; i++) {
            StdDraw.point(i, 1);
            StdDraw.point(i, i * i);
            StdDraw.point(i, i * Math.log(i));
        }
    }
    
    public static void main(String[] args) {
        new StdDrawDemo().drawFunc();
    }
}
