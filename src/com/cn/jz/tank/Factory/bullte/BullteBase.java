package com.cn.jz.tank.Factory.bullte;

import com.cn.jz.tank.Factory.tank.BaseTank;
import com.cn.jz.tank.ResourceMgr;


import java.awt.*;

public abstract class BullteBase {
    //子弹的宽度
    public static int  BULLE_WIDTH = ResourceMgr.bulletD.getWidth();
    //子弹的高度
    public static int  BULLE_HEIGTH = ResourceMgr.bulletD.getHeight();

    public abstract void collideWith(BaseTank tank, Graphics g);

    public abstract  void die();

    public abstract void paint(Graphics g);
}
