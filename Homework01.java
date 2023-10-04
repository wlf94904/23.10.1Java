package com.haha.homework;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @author hhm
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);//一定要注意，把a线程对象传给b
        a.start();
        b.start();

    }
}

//创建A线程类
class A extends Thread{
    private boolean loop=true;
    @Override
    public void run() {
        //输出1-100数字
        while(loop){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a线程退出");
        //休眠

    }

    public void setLoop(boolean loop) {//可以修改loop变量
        this.loop = loop;
    }
}

//直到第二个线程从键盘读取了“Q”命令
class B extends Thread{
    private A a;
    private Scanner scanner=new Scanner(System.in);

    public B(A a) {//构造器中，直接传入A类对象
        this.a = a;
    }//构造器中，直接传入A类对象

    @Override
    public void run() {
        while(true) {
            //接收到用户的输入
            System.out.println("请输入你的指令(Q表示退出)：");
            //获取字符
            char key = scanner.next().toUpperCase().charAt(0);
            if(key=='Q'){
                //以通知的方式结束a线程
                a.setLoop(false);
                System.out.println("b线程已退出。");
                break;
            }
        }

    }
}
