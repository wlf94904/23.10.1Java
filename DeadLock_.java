package com.haha.syn;

/**
 * @author hhm
 * @version 1.0
 * 模拟线程死锁
 */
public class DeadLock_ {
    public static void main(String[] args) {
        //模拟死锁现象
        DeadLockDemo A = new DeadLockDemo(true);
        A.setName("A线程");
        DeadLockDemo B = new DeadLockDemo(false);
        B.setName("B线程");
        A.start();
        B.start();
    }
}

class DeadLockDemo extends Thread{
    static Object o1=new Object();//保证多线程共享一个对象，所以用static
    static Object o2=new Object();
    boolean flag;

    public DeadLockDemo(boolean flag){//构造器

        this.flag=flag;
    }

    public void run(){

        //业务逻辑的分析
        //1.如果flag为true，线程A就会先持有/得到o1对象锁，然后尝试去获取o2对象锁
        //2.如果线程A得不到o2对象锁，就会Blocked
        //3.如果flag为False,线程B就会先持有/得到o2对象锁，然后尝试去获取o1对象锁
        //4.如果线程B得不到o1对象锁，就会Blocked
        if(flag){
            synchronized (o1){//对象互斥锁，下面就是同步代码
                System.out.println(Thread.currentThread().getName()+"   进入1");
                synchronized (o2){//这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName()+"   进入2");

                }
            }
        }else{
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"    进入3");
                synchronized (o1){//这里获得li对象的监视权
                    System.out.println(Thread.currentThread().getName()+"   进入4");

                }
            }
        }
    }

}