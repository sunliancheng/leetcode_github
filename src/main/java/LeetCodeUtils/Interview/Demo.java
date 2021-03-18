package LeetCodeUtils.Interview;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class Demo {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int idx = 0, max = 0;
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[n - i - 1] = arr[i];
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(ans[i]);
            if (i != n - 1) System.out.print(" ");
        }


    }


}
