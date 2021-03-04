package LC200_400.LC300_350;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LC341_Flatten_Nested_List_Iterator {
}

class NestedIterator implements Iterator<Integer> {

    private List<Integer> result = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        for (NestedInteger tem : nestedList)
            handle(tem);
    }

    int idx = 0;

    @Override
    public Integer next() {
        if (idx < result.size())
            return result.get(idx++);
        return -1;
    }

    @Override
    public boolean hasNext() {
        return idx < result.size();
    }

    public void handle(NestedInteger var) {
        if (var.isInteger())
            result.add(var.getInteger());
        else {
            List<NestedInteger> list = var.getList();
            for (NestedInteger tem : list)
                handle(tem);
        }
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}