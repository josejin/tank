package com.cn.jz.tank.Factory;

import com.cn.jz.tank.Dir;
import com.cn.jz.tank.Factory.bullte.BullteBase;
import com.cn.jz.tank.Factory.explode.BaseExplode;
import com.cn.jz.tank.Factory.tank.BaseTank;
import com.cn.jz.tank.Group;
import com.cn.jz.tank.TankFrame;

/**
 * 类型皮肤工厂
 */
public abstract class AbstractStyleFactory {
    /**
     *   子弹类抽象工厂
     * @return
     */
    public abstract BullteBase createBullteStyle(int x, int y, Dir dir, TankFrame tankFrame, Group group);

    /**
     * 爆炸抽象方法
     * @return
     */
    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);

    /**
     * 坦克皮肤抽象方法
     * @return
     */
    public abstract BaseTank createTank(int x, int y, Dir dir, TankFrame tankFrame, Group group);
}
