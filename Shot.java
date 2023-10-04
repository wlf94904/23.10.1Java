package com.haha.tankgame4;

/**
 * @author hhm
 * @version 1.0
 * 射击子弹
 */
public class Shot implements Runnable{
    int x;//子弹x坐标
    int y;//子弹y坐标
    int direct=0;//子弹的方向
    int speed=2;//子弹的速度
    boolean isLive=true;//子弹是否还存活
    //构造器
    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {//射击
        while(true){
            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //根据方向改变x，y坐标
            switch (direct){
                case 0://向上
                    y-=speed;
                    break;
                case 1://向右
                    x+=speed;
                    break;
                case 2://向下,x,y的坐标与平时数学题中的y坐标相反
                    y+=speed;
                    break;
                case 3://向左
                    x-=speed;
                    break;
            }
            //测试，输出x，y坐标
            System.out.println("子弹x="+x+"  y="+y);
            //当子弹移动到面板的边界时，就应该销毁（把启动的子弹的线程销毁）
            //当子弹碰到敌人坦克时，也应该销毁线程
            if(!(x>=0&&x<=1000&&y>=0&&y<=750&&isLive)){
                System.out.println("子弹线程退出...");
                isLive=false;
                break;
            }
        }

    }
}
