package LC1000_1200.LC1100_1150;

import LeetCodeUtils.MyGraph;

import java.util.ArrayList;
import java.util.*;

public class LC1192_Critical_Connections_In_A_Network {


    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, GNode1192> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new GNode1192(i));
        }
        for (List<Integer> list : connections) {
            map.get(list.get(0)).neis.add(list.get(1));
            map.get(list.get(1)).neis.add(list.get(0));
        }
        LinkedList<GNode1192> list = new LinkedList();
        for (int i : map.keySet()) {
            if (map.get(i).neis.size() == 1) {
                list.addLast(map.get(i));
            }
        }
        while (list.size() > 0) {
            int size = list.size();
            while (size-- > 0) {
                GNode1192 node = list.removeFirst();
                for (int i : node.neis) {
                    GNode1192 nei = map.get(i);
                    for (int j = 0; j < nei.neis.size(); ++j) {
                        if (nei.neis.get(j) == node.val) {
                            nei.neis.remove(j);
                            break;
                        }
                    }
                    if (nei.neis.size() == 1) {
                        list.addLast(nei);
                    }
                    List<Integer> tem = new ArrayList<>();
                    tem.add(i); tem.add(node.val);
                    result.add(tem);
                }
            }
        }
        return result;
    }

    class GNode1192 {
        List<Integer> neis = null;
        int val = 0;
        public GNode1192 (int val) {
            neis = new ArrayList<>();
            this.val = val;
        }
    }

}


