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
public class WeightUFUnion {
    int id[];
    int count;
    int sz[];

    public WeightUFUnion(int N) {
        id = new int[N];
        for (int i = 0;i < N;i++) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0;i < N;i++) sz[i] = 1;

        count = N;

        StdOut.println("init count = " + count);
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        int pRootID = find(p);
        int qRootID = find(q);

        if (pRootID == qRootID) return;

        if (sz[pRootID] < sz[qRootID]) {
            id[pRootID] = qRootID;
            sz[qRootID] += sz[pRootID];
        } else {
            id[qRootID] = pRootID;
            sz[pRootID] += sz[qRootID];
        }

        count--;
    }

    public int find(int p){
        int i = p;

        while(id[i] != i) i = id[i];

        return i;
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

        WeightUFUnion uf = new WeightUFUnion(N);

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
