package chapter1_5.lx1_5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * UFQuick ADT
 *
 * <p>
 *     触点、连接、连通分量（分量）
 * </p>
 */
public class UFQuick {
    int id[];
    int count;

    public UFQuick(int N) {
        id = new int[N];
        for (int i = 0;i < N;i++) {
            id[i] = i;
        }
        count = N;

        StdOut.println("init count = " + count);
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID) return;

        for (int i = 0;i < id.length;i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public int find(int p){
        return id[p];
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String args[]) {
        // 读取连通数量

        /*
            读取整数对，如果连通，then 继续，else 归并二者的分量，打印连接
         */
        int N = StdIn.readInt();

        UFQuick uf = new UFQuick(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (uf.connected(p, q)) {
                continue;
            } else {
                uf.union(p, q);
                StdOut.println(p + "," + q);
            }
        }
        StdOut.println("commponent count : " + uf.count());
    }
}
