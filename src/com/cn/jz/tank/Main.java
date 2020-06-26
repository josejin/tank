package com.cn.jz.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame a = new TankFrame();
        /**
         * 主线程每50ms刷新界面
         */
       while (true){
            Thread.sleep(50);
            //重新刷新界面,就多次使页面调用paint方法使坦克移动
            a.repaint();
        }

        //子线程

      /*  Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a.repaint();
                }

            }
        });
        t.start();*/

    }
}
