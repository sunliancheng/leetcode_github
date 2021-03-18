package LeetCodeUtils.Interview;

import sun.reflect.annotation.ExceptionProxy;

import java.util.Scanner;

public class Fir {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[n - i - 1] = sc.nextInt();
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i]);
            if (i != n - 1) System.out.print(" ");
        }
    }
}
