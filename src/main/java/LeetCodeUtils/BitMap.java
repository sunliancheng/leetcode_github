package LeetCodeUtils;

import org.junit.Test;

public class BitMap {

    int size = 0;
    int[] masks = null;

    public void init(int size) {
        this.size = size;
        masks = new int[]{size / 32};
    }

    public boolean get(int idx) {
        if (idx >= size) {
            throw new IllegalArgumentException("out of the original size!");
        }
        int[] location = getLocation(idx);
        int tem = (1 << location[1]) & masks[location[0]];
        return tem == 0 ? false : true;
    }

    public boolean set(int idx, boolean res) {
        if (idx >= size) {
            throw new IllegalArgumentException("out of the original size!");
        }
        int tem = res == true ? 1 : 0;
        int[] location = getLocation(idx);
        if (res) {
            masks[location[0]] |= tem << location[1];
        } else {
            masks[location[0]] &= tem << location[1];
        }
        return get(idx);
    }

    public int[] getLocation(int idx) {
        int i = idx / 32;
        int j = idx % 32;
        return new int[]{i, j};
    }

    @Test
    public void test() {
        init(32);
        System.out.println(get(21));
        System.out.println(set(21, true));
        System.out.println(get(21));
        System.out.println(set(21, false));
        System.out.println(get(21));
    }

    public static void main(String[] args) {
        System.out.println();
    }

}
