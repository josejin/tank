package com.cn.jz.tank;

import com.cn.jz.tank.Factory.AbstractStyleFactory;
import com.cn.jz.tank.Factory.bullte.BullteBase;
import com.cn.jz.tank.Factory.tank.BaseTank;

public class DefaultFireStrategy implements FireStrategy<BaseTank> {
    @Override
    public void fire(BaseTank tank,AbstractStyleFactory defaultFactory) {
        int bullteX=  tank.getX() + BaseTank.TANK_WIDTH/2 - BullteBase.BULLE_WIDTH/2;
        int BullteY= tank.getY() + BaseTank.TANK_HEIGTH/2 - BullteBase.BULLE_HEIGTH/2;
        defaultFactory.createBullteStyle(bullteX,BullteY,tank.getDir(),tank.getTankFrame(),tank.getGroup());
    }
}
