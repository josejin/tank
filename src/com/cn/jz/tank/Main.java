package com.cn.jz.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final TankFrame a = new TankFrame();
        int enemyTankCount = Integer.valueOf(ConfigMgr.getStringValue("enemyTankCount"));
        //初始化地方坦克
        for(int i=0 ; i< enemyTankCount ;i++){
            a.enemyTankList.add(new Tank(100*i,100,Dir.DOWN,a,Group.BAD));
        }

        /**
         * 主线程每50ms刷新界面
         */
       while (true){
            Thread.sleep(50);
            //重新刷新界面,就多次使页面调用paint方法使坦克移动
            a.repaint();
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        int i=0;
                        while (i<10) {
                            Thread.sleep(50);

                            i++;
                        }
                    }catch (InterruptedException e){

                    }

                }
            }).start();*/

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
