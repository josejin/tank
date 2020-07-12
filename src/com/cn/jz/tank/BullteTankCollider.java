package com.cn.jz.tank;

public class BullteTankCollider implements Collider{


    @Override
    public boolean collideWith(ModeObject modeObject1, ModeObject modeObject2) {
        if (modeObject1 instanceof  Bullte && modeObject2 instanceof Tank){
             Bullte dbullte = (Bullte) modeObject1;
             Tank dtank= (Tank) modeObject2;
             dbullte.collideWith(dtank);
             return true;

        }else if(modeObject1 instanceof Tank  && modeObject2 instanceof Bullte){
            return this.collideWith(modeObject2,modeObject1);
        }
        return false;
    }
}
