package com.cn.jz.tank;

import java.awt.*;
import java.util.List;

public class Explode extends ModeObject{

    //每次运行的步长
    private  int step = 0;

    private GameMode gm;


    public Explode(int x,int y,GameMode gm){
        this.x= x;
        this.y=y;
        this.gm = gm;
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
            gm.getModeObjectList().remove(this);
        }
    }
}
