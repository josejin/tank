package com.cn.jz.tank.Factory.tank;

import com.cn.jz.tank.Dir;
import com.cn.jz.tank.Factory.AbstractStyleFactory;
import com.cn.jz.tank.Group;
import com.cn.jz.tank.ResourceMgr;
import com.cn.jz.tank.TankFrame;

import java.awt.*;

public abstract class BaseTank {

    //坦克的宽度
    public static int  TANK_WIDTH = ResourceMgr.tankD.getWidth();
    //坦克的高度
    public static int  TANK_HEIGTH = ResourceMgr.tankD.getHeight();

    public abstract int getX();

    public abstract int getY();

    public abstract TankFrame getTankFrame();

    public abstract Group getGroup();

    public abstract void paint(Graphics g);

    public abstract void fire(AbstractStyleFactory defaultFactory);

    public abstract void setMove(boolean move);

    public abstract void setDir(Dir dir);

    public abstract void die();

    public abstract Rectangle getTankrect();

    public abstract Dir getDir();
}
