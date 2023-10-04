package com.haha.tankgame4;

import java.util.Vector;

/**
 * @author hhm
 * @version 1.0
 * 敌人的坦克
 */
@SuppressWarnings({"all"})
public class EnemyTank extends Tank implements Runnable{
    //在敌人坦克类，使用Vector保存多个Shot
    Vector<Shot> shots=new Vector<>();
    boolean isLive=true;
    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while(true){

            //判断如果shots size()=0了
            //创建一颗子弹，放入到shots集合中，并启动
            if(isLive&&shots.size()<1){

                Shot s=null;

                //判断坦克的方向，创建对应的子弹
                switch (getDirect()){
                    case 0:
                        s=new Shot(getX()+20,getY(),0);
                        break;
                    case 1:
                        s=new Shot(getX()+60,getY()+20,1);
                        break;

                    case 2:
                        s=new Shot(getX()+20,getY()+60,2);
                        break;
                    case 3://向左
                        s=new Shot(getX(),getY()+20,3);
                        break;
                }
                shots.add(s);
                //启动
                new Thread(s).start();


            }
            //根据坦克的方向来继续移动
            switch (getDirect()){
                case 0://向上
                    //让坦克保持一个方向走30步
                    for(int i=0;i<30;i++) {
                        if(getY()>0) {
                            moveUp();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1://向右
                    //让坦克保持一个方向走30步
                    for(int i=0;i<30;i++) {
                        if(getX()+60<1000) {
                            moveRight();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2://向下
                    //让坦克保持一个方向走30步
                    for(int i=0;i<30;i++) {
                        if(getY()+60<750) {
                            moveDown();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3://向左
                    //让坦克保持一个方向走30步
                    for(int i=0;i<30;i++) {
                        if(getX()>0) {
                            moveLeft();
                        }
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

            }



            //然后随机的改变坦克方向,0-3的整数
            setDirect((int)(Math.random()*4));//[0,4)
            //写并发程序，一定要考虑清楚，该线程什么时候结束
            if(!isLive){
                break;//退出线程
            }

        }
    }
}
