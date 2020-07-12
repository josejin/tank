package com.cn.jz.tank;

import java.awt.*;

/**
 * 墙的实现
 */
public class Wall extends ModeObject {
    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.bulletL,x,y,null);
    }
}
