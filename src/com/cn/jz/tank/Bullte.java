package com.cn.jz.tank;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullte {
    //坦克位子方向
    int x=200;
    int y=200;
    //方向枚举
    Dir dir ;
    //每次运行的步长
    private final int step = 5;

    private TankFrame tankFrame;
    /**
     * 子弹是否存活
     */
    private boolean isLove = true ;

    public Bullte(int x,int y,Dir dir,TankFrame tankFrame){
        this.x= x;
        this.y=y;
        this.dir =dir;
        this.tankFrame = tankFrame;
    }



    public void paint(Graphics g){
        if (!this.isLove){
            this.tankFrame.bullteList.remove(this);
        }
        System.out.println(" println Bullte paint....");
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,50,50);
        g.setColor(c);
        //子弹移动
        this.Moveing(dir);
    }
    //子弹移动
    public void Moveing( Dir dir ){
        switch (dir){
            case LEFT:
                x-=step; break;
            case RIGHT:
                x+=step;break;
            case UP:
                y-=step;break;
            case DOWN:
                y+=step;break;
            default:
        }

        //移除子弹
        if(x<0 || y<0 || x>tankFrame.getFrameWidth() || y > tankFrame.getFrameHeight()){
            this.isLove = false;
        }
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


}
