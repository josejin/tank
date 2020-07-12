package com.cn.jz.tank;

public class TankTankCollider implements Collider {
    @Override
    public boolean collideWith(ModeObject modeObject1, ModeObject modeObject2) {
        if (modeObject1 instanceof Tank && modeObject2 instanceof Tank) {
            Tank tankA = (Tank) modeObject1;
            Tank tankB = (Tank) modeObject2;

            if ((tankA).tankrect.intersects((tankB).getTankrect())) {
                tankA.setX(tankA.getOldX());
                tankA.setY(tankA.getOldY());
               /* tankB.setX(tankB.getOldX());
                tankB.setY(tankB.getOldY());*/
                return true;
            }
        }
        return false;
    }
}
