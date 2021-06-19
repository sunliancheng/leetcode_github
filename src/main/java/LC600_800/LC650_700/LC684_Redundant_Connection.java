//package LC600_800.LC650_700;
//
//import org.junit.Test;
//
//public class LC684_Redundant_Connection {
//
//    @Test
//    public void test() {
//        System.out.println(findRedundantConnection(new int[][]{{1, 2}, {3, 4}, {2, 3}, {1, 4}, {1, 5}}));
//    }
//
//    public int[] findRedundantConnection(int[][] edges) {
//        int n = edges.length;
//        UF uf = new UF(n + 1);
//        for (int[] edge : edges) {
//
//        }
//    }
//
//}
//
//class UF {
//
//    private int[] id;
//
//    public UF(int n) {
//        id = new int[n];
//        for (int i = 0; i < n; ++i) id[i] = i;
//    }
//
//    int find(int p) {
//        while (p != id[p]) p = id[p];
//        return p;
//    }
//
//    public void connect(int p, int q) {
//        id[find(p)] = find(q);
//    }
//
//    public boolean isConnected(int p, int q) {
//        return find(p) == find(q);
//    }
//}
