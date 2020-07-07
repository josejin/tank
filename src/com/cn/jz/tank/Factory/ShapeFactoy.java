package com.cn.jz.tank.Factory;

import com.cn.jz.tank.Dir;
import com.cn.jz.tank.Factory.bullte.BullteBase;
import com.cn.jz.tank.Factory.bullte.ShapeBullte;
import com.cn.jz.tank.Factory.explode.BaseExplode;
import com.cn.jz.tank.Factory.explode.ShapeExplode;
import com.cn.jz.tank.Factory.tank.BaseTank;
import com.cn.jz.tank.Factory.tank.ShapeTank;
import com.cn.jz.tank.Group;
import com.cn.jz.tank.TankFrame;

public class ShapeFactoy extends AbstractStyleFactory{
    @Override
    public BullteBase createBullteStyle(int x, int y, Dir dir, TankFrame tankFrame, Group group) {
        return new ShapeBullte(x, y, dir, tankFrame, group);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new ShapeExplode(x, y, tankFrame);
    }


    @Override
    public BaseTank createTank(int x, int y, Dir dir, TankFrame tankFrame, Group group){
        return new ShapeTank( x,  y,  dir,  tankFrame,  group);
    }
}
