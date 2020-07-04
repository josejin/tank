package com.cn.jz.tank;

import java.awt.*;
import java.util.List;

public class Explode {

    //坦克位子方向
    int x=200;
    int y=200;

    //每次运行的步长
    private  int step = 0;

    private TankFrame tankFrame;


    public Explode(int x,int y,TankFrame tankFrame){
        this.x= x;
        this.y=y;
        this.tankFrame = tankFrame;
      // new Thread(()->new Audio("audio/explode.wav").play()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/explode.wav").play();
            }
        }).start();
    }



    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++],x,y,null);
        if(step>=ResourceMgr.explodes.length){
            tankFrame.explodeList.remove(this);
        }
    }
}