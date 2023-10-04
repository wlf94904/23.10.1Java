package com.haha.homework;

/**
 * @author hhm
 * @version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        T t = new T();
        Thread thread1 = new Thread(t);

    }
}

//编写取款的线程
//1.因为这里涉及到多个线程共享资源，所以使用实现Runnable方式.
//2.每次取出1000块
class T implements Runnable{
    private int money=10000;

    @Override
    public void run() {
        while(true){
            //判断余额是否足够
            if(money<1000){
                System.out.println("余额不足");
                break;
            }

            money-=1000;
            System.out.println(Thread.currentThread().getName()+"取出了1000，当前余额为："+money);

            //休眠1秒，不然一下子全打出来了，看不到效果
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}