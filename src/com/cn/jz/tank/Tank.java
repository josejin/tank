package com.cn.jz.tank;

import test.ImagesTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 坦克类
 */
public class Tank {
    //坦克位子方向
    int x=200;
    int y=200;
    //方向枚举
    Dir dir = Dir.DOWN;
    //每次运行的步长
    private final int step = 2 ;

    private boolean move = false;

    private TankFrame tankFrame;




    public Tank(int x,int y,Dir dir,TankFrame tankFrame){
        this.x= x;
        this.y=y;
        this.dir=dir;
        this.tankFrame = tankFrame;
    }



    public void paint(Graphics g){
        System.out.println(" println paint....");
        /*Color color = g.getColor();
        g.setColor(Color.green);
        g.fillRect(x,y,50,50);
        g.setColor(color);*/
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            default:
        }

        //如果弹起按钮坦克不移动
        if(!move){
           return;
        }
        //坦克移动
        this.Moveing(dir);

    }
    //坦克移动
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
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    /**
     * 坦克设计
     */
    public void fire(){
        tankFrame.bullteList.add(new Bullte(this.x,this.y,this.dir,this.tankFrame));
    }
}
