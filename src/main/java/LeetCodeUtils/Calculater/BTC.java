package LeetCodeUtils.Calculater;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     *
     * @param capital
     * @param interestEveryInstallment 0.2 represents 20%
     * @param numberOfPeriods
     * @return
     */
    public static double calCompoundInterest(double capital, double interestEveryInstallment, int numberOfPeriods) {
        double pow = Math.pow(1 + interestEveryInstallment, numberOfPeriods);
        return capital * pow;
    }

    public void comparision(double capital, double interestWholePeriod, List<Double> interests) {
        double v = calCompoundInterestByData(capital, interests);
        double v2 = capital * (1 + interestWholePeriod);
        System.out.println("复利： " + v + " 单利： " + v2);
    }

    public static double calCompoundInterestByData(double capital, List<Double> interests) {
        capital = 1000d;
        for (int i = 0; i < interests.size(); ++i) { capital = calCompoundInterest(capital, interests.get(i), 1); }
        return capital;
    }

    @Test
    public void test() {
        ArrayList<Double> interests = new ArrayList<>();
        comparision(1000d, 3.03, interests);
        System.out.println(57824 / 9002);
    }
}
