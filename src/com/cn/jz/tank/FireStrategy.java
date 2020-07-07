package com.cn.jz.tank;

import com.cn.jz.tank.Factory.AbstractStyleFactory;

public interface FireStrategy<T> {

    public void fire(T t, AbstractStyleFactory defaultFactory);
}
