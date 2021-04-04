package LC600_800.LC650_700;

public class LC685_Redundant_Connection2 {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int conflict = 0, cycle = 0;
        int parent[] = new int[edges.length + 1];
        UnionFind uf = new UnionFind(edges.length + 1);
        for (int i = 0; i < edges.length; ++i) {
            if (parent[edges[i][1]] != 0) conflict = i;
            else {
                parent[edges[i][1]] = edges[i][0];
                int sourceRoot = uf.find(edges[i][0]), targetRoot = uf.find(edges[i][1]);
                if (sourceRoot == targetRoot) cycle = 1;
                else uf.union(sourceRoot, targetRoot);
            }
        }

        if (cycle == 0) return edges[conflict];
        else if (conflict == 0) return edges[cycle];
        else return new int[] {parent[edges[conflict][1]], edges[conflict][1]};

    }


}

class UnionFind {
    int root[];
    int height[];

    public UnionFind(int n) {
        root = new int[n];
        height = new int[n];
        for (int i = 0; i < n; ++i) root[i] = i;
    }

    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (height[rootX] < height[rootY]) root[rootX] = rootY;
        else if (height[rootY] < height[rootX]) root[rootY] = rootX;
        else {
            root[rootX] = rootY;
            height[rootY]++;
        }
    }

    public int find (int x) {
        return root[x] == x ? x : find(root[x]);
    }
}