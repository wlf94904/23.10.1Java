package com.haha.method_;

/**
 * @author hhm
 * @version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();

        for(int i=0;i<=20;i++){
            Thread.sleep(1000);
            System.out.println("主线程(小弟）吃了  "+i+"  个包子...");
            if(i==5){
                System.out.println("主线程（小弟）让子线程（老大）先吃");
                //join线程插队
//                t2.join();//这里相当于让t2线程先执行完毕

                Thread.yield();//礼让，不一定成功
                System.out.println("线程（老大）让主线程小弟继续吃。。。");
            }
        }

    }
}

class T2 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<=20;i++){
            try {
                Thread.sleep(1000);//休眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程（老大）吃了"+i+"个包子");
        }
    }
}