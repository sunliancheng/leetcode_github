package LC600_800.LC650_700;

import java.util.*;

public class LC690_Employee_Importance {

    Map<Integer, Employee> emap;
    public int getImportance(List<Employee> employees, int queryid) {
        emap = new HashMap();
        for (Employee e: employees) emap.put(e.id, e);
        return dfs(queryid);
    }
    public int dfs(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates)
            ans += dfs(subid);
        return ans;
    }

}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
