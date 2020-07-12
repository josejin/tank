package com.cn.jz.tank;

import java.util.LinkedList;
import java.util.List;

public class ColliderChain implements Collider {
    private List<Collider> list = new LinkedList<>();

    @Override
    public boolean collideWith(ModeObject modeObject1, ModeObject modeObject2) {
        for(Collider collider : list){
           if (collider.collideWith(modeObject1,modeObject2)){
               return true;
           }
        }
        return false;
    }
    public void deleteCollider(Collider collider){
        list.remove(collider);
    }
    public void addCollider(Collider collider){
        list.add(collider);
    }

    public ColliderChain(){
        list.add(new BullteTankCollider());
        list.add(new TankTankCollider());

    }
}
