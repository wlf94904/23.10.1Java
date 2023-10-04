package com.haha.tankgame3;

import javax.swing.*;

/**
 * @author hhm
 * @version 1.0
 */
public class hhTankGame03 extends JFrame {
    //定义MyPanel
    MyPanel mp=null;
    public static void main(String[] args) {
        hhTankGame03 hhTankGame01 = new hhTankGame03();

    }

    //构造器
    public hhTankGame03(){
        mp=new MyPanel();
        //将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);//游戏的绘图区域
        this.addKeyListener(mp);//让JFrame监听mp的键盘事件
        this.setSize(1000,750);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
