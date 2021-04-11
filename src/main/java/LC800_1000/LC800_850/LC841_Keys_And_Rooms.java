package LC800_1000.LC800_850;

import java.util.*;

public class LC841_Keys_And_Rooms {

    int count = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        count = rooms.size() - 1;
        dfs(rooms, 0, new HashMap<>());
        return count == 0 ? true : false;
    }

    public void dfs(List<List<Integer>> rooms, int roomNum, Map<Integer, Boolean> map) {
        if (count == 0 || map.getOrDefault(roomNum, false)) return;
        if (roomNum != 0 && !map.containsKey(roomNum)) {
            map.put(roomNum, true);
            count--;
        }
        for (int room : rooms.get(roomNum)) {
            dfs(rooms, room, map);
        }
    }


}
