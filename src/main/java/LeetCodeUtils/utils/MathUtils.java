package LeetCodeUtils.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class MathUtils {

    private static Long product = 7140229933l;

    Set<Integer> primeSet = new HashSet<>();

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * 使用了 埃拉托斯特尼筛法
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        int count = n - 1;
        for (int i = 2; i <= n; ++i) {
            if (prime[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    if (prime[j]) {
                        prime[j] = false;
                        --count;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 使用了 埃拉托斯特尼筛法
     * @param n
     * @return
     */
    public void storePrimes(int start, int end) {
        for (int i = start; i <= end; ++i) {
            boolean flag = true;
            for (int j = 2; j <= i / 2 + 1; ++j) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                primeSet.add(i);
            }
        }
    }

    /**
     * 传统的暴力法
     * @param n
     * @return
     */
    public static int countPrimesByOriginalWay(int n) {
        int count = 2;
        for (int i = 2; i <= n; ++i) {
            boolean flag = true;
            for (int j = 2; j <= i / 2 + 1; ++j) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) ++count;
        }
        return --count;
    }

    /**
     * 传统的暴力法
     * @param n
     * @return
     */
    public boolean isPrime(int n) {
        if (n == 2) return true;
        if (n == 1) return false;
        boolean flag = true;
        for (int j = 2; j <= n / 2 + 1; ++j) {
            if (n % j == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    @Test
    public void test() {
//        double huilv = 6.56d;
//        double fee = 0.002d;
//        double targetWantPrice = 20000d - 1046.71d - 677.71d;
//        double pricePerCoin = 0.505d;
//
//        // num * pricePerCoin * (1 - fee) * huilv = targetWantPrice
//
//        double num = (targetWantPrice / huilv / (1 - fee) / pricePerCoin);
//
//        //System.out.println(num);
//
//        String s = "dfs";
//
//        List<Integer> list = new ArrayList<>();
//
//
//        double ben = 2000d;
//        double tar = ben * Math.pow(1.005d, 365 * 2);
//        System.out.println(tar);
//        System.out.println(tar / ben);
//        //Arrays.stream(new int[]{2,3,4}).sum();
        storePrimes(2, 10);

        System.out.println(primeSet);
    }

    @Test
    public void test2() {

        for (int i = 2; i < Integer.MAX_VALUE / 2; ++i) {
            if (isPrime(i)) {
                Long tem = (product / i);
                if (tem * i == product) {
                    System.out.println(i);
                }
            }

        }
        //System.out.println(isPrime(2));
    }
}
