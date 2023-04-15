package com.shengfq.concurrent.tools;

import java.util.concurrent.*;

/**
 * 另一种形式的栅栏是Exchanger，它是一种两方(Two-Party)栅栏，各方在栅栏位置上交还数据。
 * */
public class MethBooth {
    private Exchanger<Object> exchanger;

    public MethBooth(Exchanger<Object> exchanger) {
        this.exchanger = exchanger;
    }

    private class DrugDealer implements Runnable {
        private String infiniteDrug;
        private int money;

        public DrugDealer(String infiniteDrug, int money) {
            this.infiniteDrug = infiniteDrug;
            this.money = money;
        }

        @Override
        public void run() {
            Object object;
            System.out.println("DrugDealer: Walking to rendezvous");
            try {
                for (; ; ) {
                    TimeUnit.SECONDS.sleep(5);
                    object = exchanger.exchange(infiniteDrug);
                    if (object != null && "NARC".equals(object.toString())) {
                        System.out.println("DrugDealer:COPS! Running away......");
                        Thread.currentThread().interrupt();
                    } else {
                        Integer drugMoney = (Integer) object;
                        System.out.println("DrugDealer: Getting $" + drugMoney);
                        money += drugMoney;
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("DrugDealer: I'm gone, collecting money $" + money + " in total.");
                e.printStackTrace();
            }
        }
    }

    private class DrugUser implements Runnable {
        private int money;

        public DrugUser(int money) {
            this.money = money;
        }

        @Override
        public void run() {
            System.out.println("DrugUser: Driving to rendezvous");
            Object object;
            try {
                while (money > 0) {
                    TimeUnit.SECONDS.sleep(5);
                    object = exchanger.exchange(5);
                    money -= 5;
                    System.out.println("DrugUser: Giving $5, getting " + object + ", left " + money);
                }
                object = exchanger.exchange("NARC");
                System.out.println("DrugUser: Giving NARC, getting " + object);
                object = exchanger.exchange(100, 3, TimeUnit.SECONDS);
                System.out.println("DrugUser: Giving $100, getting " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
                System.out.println("DrugUser: DrugDealer is gone...");
            }
        }
    }

    public void drugDealing() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Thread(new DrugDealer("BLUE CHERRY", 0)));
        executorService.submit(new Thread(new DrugUser(10)));
        executorService.shutdown();
    }

    public static void main(String[] args) {
        MethBooth methBooth = new MethBooth(new Exchanger<Object>());
        methBooth.drugDealing();
    }
}
