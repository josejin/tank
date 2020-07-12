package com.cn.jz.tank;

public interface Collider {
    /**
     * 位置碰撞
     * @return
     */
    public abstract boolean collideWith(ModeObject modeObject1,ModeObject modeObject2);
}
