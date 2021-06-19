package Acwing.Sort;

public class BinarySearch {

    public boolean check(int m) {
        return true;
    }

    public int bSearch1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) r = mid; // 如果找出来的 mid 点符合要求，那么 所求值就在左边
            else l = mid + 1;
        }
        return l;
    }

    public int bSearch2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1; // r = mid - 1; 的时候，如果 mid = l + r >> 1; mid = l （ l = r - 1）; 区间[l,r] 便成区间[mid,r];还是 [l,r]。所以死循环
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

}
