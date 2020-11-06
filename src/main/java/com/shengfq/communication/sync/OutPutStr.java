package com.shengfq.communication.sync;

public class OutPutStr {

    /**
     * synchronized 这把锁是锁住this当前对象,不同的线程访问同一个对象的方法是要获取锁排队的
     * */
    public static synchronized void out(String str) {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
            System.out.println();
    }

    public static void main(String[] args) {
        //

        new Thread(new Runnable() {

            @Override
            public void run() {
                //
                while (true) {
                    try{
                    Thread.sleep(100);
                }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    OutPutStr.out("111111111111");
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                //
                while (true) {
                    try{
                        Thread.sleep(100);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                    OutPutStr.out("222222222222");
                }
            }
        }).start();
    }
}