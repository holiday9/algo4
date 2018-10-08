package chapter1_5.lx1_5_1;

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
public class UFQuick1_5_1 {
    int id[];
    int count;
    long accessCount = 0;

    public UFQuick1_5_1(int N) {
        id = new int[N];
        for (int i = 0;i < N;i++) {
            id[i] = i;
        }
        count = N;
    }

    public int count() {
        return count;
    }

    public void union(int p, int q) {
        accessCount = 0;

        int pID = find(p);
        int qID = find(q);

        if (pID == qID) {
            printId(p, q);
            printlnAccessCount(p, q);
            return;
        }

        for (int i = 0;i < id.length;i++) {
            if (id[i] == pID) {
                id[i] = qID;

                accessCount++;
            }
        }
        count--;

        StdOut.println("--------------------" + p + "," + q + "------------------");
        printId(p, q);
        printlnAccessCount(p, q);
    }

    private void printlnAccessCount(int p, int q) {
        StdOut.println("\naccess count = " + accessCount + "");
    }

    private void printId(int p, int q) {
        StdOut.print("id content:");

        for (int idTemp : id) {
            StdOut.print(idTemp + ",");
        }
    }

    public int find(int p){
        accessCount++;

        return id[p];
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public static void main(String args[]) {
        try {
            FileInputStream input = new FileInputStream("/Users/yuan/IdeaProjects/Algo4/src/chapter1_5/lx1_5/tinydata.txt");
            System.setIn(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // 读取连通数量

        /*
            读取整数对，如果连通，then 继续，else 归并二者的分量，打印连接
         */
        int N = StdIn.readInt();

        UFQuick1_5_1 uf = new UFQuick1_5_1(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (uf.connected(p, q)) {
                continue;
            } else {
                uf.union(p, q);
            }
        }
    }
}
