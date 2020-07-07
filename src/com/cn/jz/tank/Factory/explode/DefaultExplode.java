package com.cn.jz.tank.Factory.explode;

import com.cn.jz.tank.Audio;
import com.cn.jz.tank.Explode;
import com.cn.jz.tank.Factory.AbstractStyleFactory;
import com.cn.jz.tank.Factory.DefaultFactory;
import com.cn.jz.tank.ResourceMgr;
import com.cn.jz.tank.TankFrame;

import java.awt.*;

public class DefaultExplode extends BaseExplode {

    //坦克位子方向
    int x = 200;
    int y = 200;

    //每次运行的步长
    public int step = 0;

    private TankFrame tankFrame;


    public DefaultExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        // new Thread(()->new Audio("audio/explode.wav").play()).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Audio("audio/explode.wav").play();
            }
        }).start();
    }


    public void paint(Graphics g) {

        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            tankFrame.explodeList.remove(this);
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
