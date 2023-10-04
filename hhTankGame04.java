package com.haha.tankgame4;

import javax.swing.*;

/**
 * @author hhm
 * @version 1.0
 */
public class hhTankGame04 extends JFrame {
    //定义MyPanel
    MyPanel mp=null;
    public static void main(String[] args) {
        hhTankGame04 hhTankGame01 = new hhTankGame04();

    }

    //构造器
    public hhTankGame04(){
        mp=new MyPanel();
        //将mp放入到Thread，并启动
        Thread thread = new Thread(mp);
        thread.start();

        this.add(mp);//游戏的绘图区域
        this.addKeyListener(mp);//让JFrame监听mp的键盘事件
        this.setSize(1200,950);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
}
