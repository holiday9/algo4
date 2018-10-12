package chapter1_5.lx1_5_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * UFQuick ADT
 *
 * <p>
 *     触点、连接、连通分量（分量）
 * </p>
 */
public class LX1_5_3 {
    int id[];
    int count;
    int sz[];

    int accessCount;

    public LX1_5_3(int N) {
        id = new int[N];
        for (int i = 0;i < N;i++) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0;i < N;i++) sz[i] = 1;

        count = N;
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

            accessCount++;
        } else {
            id[qRootID] = pRootID;
            sz[pRootID] += sz[qRootID];

            accessCount++;
        }

        count--;
    }

    public int find(int p){
        int i = p;

        while(id[i] != i) {
            i = id[i];

            accessCount += 2;
        }

        accessCount++;

        return i;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public void printlnContent() {
        for (int element : id) {
            StdOut.print(element + ",");
        }
        StdOut.println();
    }

    public void resetStatics() {
        accessCount = 0;
    }

    public static void main(String args[]) {
        // 读取连通数量
        try {
            FileInputStream input =
                    new FileInputStream("/Users/yuan/algs4/algs4-data/tinyUF.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*
            读取整数对，如果连通，then 继续，else 归并二者的分量，打印连接
         */
        int N = StdIn.readInt();

        LX1_5_3 uf = new LX1_5_3(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            StdOut.println("-----------" + p + "," + q + "------------------");

            uf.resetStatics();

            if (uf.connected(p, q)) {

                StdOut.println("access count:" + uf.accessCount);
                uf.printlnContent();
                continue;
            } else {
                uf.union(p, q);

                StdOut.println("access count:" + uf.accessCount);
                uf.printlnContent();
            }

        }

        System.out.println("commponet count = " + uf.count());
    }
}
