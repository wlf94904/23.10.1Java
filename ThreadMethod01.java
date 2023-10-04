package com.haha.method_;

/**
 * @author hhm
 * @version 1.0
 */
public class ThreadMethod01 {
    public static void main(String[] args) throws InterruptedException {
        //测试相关的方法
        T t = new T();
        t.setName("老哈");
        t.setPriority(Thread.MIN_PRIORITY);//1
        t.start();//启动子线程

        //主线程打印5个hi，就中断子线程的休眠
        for(int i=0;i<5;i++){
            Thread.sleep(1000);
            System.out.println("hi "+i);
        }

        System.out.println(t.getName()+"的优先级是"+t.getPriority());

        t.interrupt();//当执行到这里时，就会中断t线程的休眠

    }
}

class T extends Thread{//自定义的线程类
    @Override
    public void run() {
        while(true) {
            for (int i = 0; i < 100; i++) {
                //Thread.currentThread().getName()获取当前线程的名称
                System.out.println(Thread.currentThread().getName() + "吃包子..." + i);
            }
            try {
                System.out.println(Thread.currentThread().getName() + "休眠中...");
                Thread.sleep(20000);//20s休眠时间
            } catch (InterruptedException e) {
                //当该线程执行到一个interrupt方法时，就会catch一个异常，可以加入自己的业务代码
                //InterruptedException是捕获到了一个中断异常
                System.out.println(Thread.currentThread().getName() + "被interr了");
            }
        }

    }
}
