package com.haha.syn;

/**
 * @author hhm
 * @version 1.0
 * 使用多线程，模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {
        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里我们会出现超卖
//        sellTicket01.start();//启动售票线程
//        sellTicket02.start();//启动售票线程
////        sellTicket03.start();//启动售票线程
//
//        System.out.println("===使用实现接口的方式来售票===");
//        SellTicket02 sellTicket02 = new SellTicket02();

//        new Thread(sellTicket02).start();//第1个线程-窗口
//        new Thread(sellTicket02).start();//第2个线程-窗口
//        new Thread(sellTicket02).start();//第3个线程-窗口

        //测试
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();//第1个线程-窗口
        new Thread(sellTicket03).start();//第2个线程-窗口
        new Thread(sellTicket03).start();//第3个线程-窗口


    }
}

//实现接口方式,使用同步方法Synchronized实现线程同步
class SellTicket03 extends Thread{

    private  int tickNum=100;//让多个线程共享tickNum
    private boolean loop=true;//控制run方法的变量
    Object object=new Object();

    //同步方法（静态的）锁为当前类本身
    //1.public synchronized static void m1(){}锁是加在SellTicket03.class
    //2.如果在静态方法中，实现一个同步代码块
    /*
     public void m2(){
        synchronized (SellTicket03.class){
            System.out.println("m2");
        }
     */
    public synchronized static void m1(){

    }
    public void m2(){
        synchronized (SellTicket03.class){
            System.out.println("m2");
        }

    }
    //1. public synchronized void sell(){}就是一个同步方法
    //2.这时锁在this对象
    //3.也可以在代码块上写synchronized，同步代码块,互斥锁还是在this对象
    public /*synchronized*/ void sell(){//同步方法，在同一时刻，只能有一个线程来执行r方sell方法
        synchronized (/*this*/object) {
            if (tickNum <= 0) {
                System.out.println("售罄");
                loop = false;
                return;
            }

            //休眠50毫秒,模拟人按键盘嘛
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票"
                    + "剩余票数=" + (--tickNum));
        }
    }
    @Override
    public  void run() {
        while(loop){
            sell();//sell方法是一个同步方法
        }
    }
}



//使用Thread方式
//new SellTicket01().start()
//new SellTicket01().start()

class SellTicket01 extends Thread{

    private static int tickNum=100;//让多个线程共享tickNum

//    public void m1(){
//        synchronized (this){
//            System.out.println("hello");
//        }
//    }
    @Override
    public void run() {
        while(true){
            if(tickNum<=0){
                System.out.println("售罄");
                break;
            }

            //休眠50毫秒,模拟人按键盘嘛
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("窗口"+Thread.currentThread().getName()+"售出一张票"
            +"剩余票数="+(--tickNum));
        }
    }
}

