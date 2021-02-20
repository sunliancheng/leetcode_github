package LeetCodeUtils.Calculater;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class BTC {


    private static double ownnPrice;

    private static double trasactionRate;

    private static double currentPrice;

    private static double ownBTC;

    public static double calculateDifference() {
        return (currentPrice - ownnPrice) * (1 - trasactionRate);
    }

    public static double calculateSellPrice() {
        return (ownnPrice) / (1 - trasactionRate);
    }

    public static void main(String[] args) throws Exception {
        ownnPrice = 55680;
        ownBTC = 0.001721;
        trasactionRate = 0.004;

        new Thread(() -> {
            compare();
        }).start();

        new CountDownLatch(1).await();

    }

    public static void compare()  {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            double current = doGet();
            if (calculateSellPrice() < current) {
                System.out.println("it's time to sell now and current price is: " + current);
            }
        }
    }

    public static double doGet() {
        JSONObject result = Http.getHttpResponseJson("https://api.coincap.io/v2/rates/bitcoin", new HashMap<>());
        JSONObject bitcoin = (JSONObject) result.get("data");
        System.out.println("bitcoin: " + bitcoin.get("id") + " price: " + bitcoin.get("rateUsd").toString().substring(0, 10) + " USD");
        return Double.valueOf(bitcoin.get("rateUsd").toString().substring(0, 10));
    }
}
