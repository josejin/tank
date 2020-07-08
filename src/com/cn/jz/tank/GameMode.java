package com.cn.jz.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameMode {
    //子弹类型
    java.util.List<Bullte> bullteList = null;

    //敌军坦克类
    java.util.List<Tank> enemyTankList = null;

    //爆炸List
    List<Explode> explodeList =null;

    int enemyTankCount =  Integer.valueOf(ConfigEnum.PRO.getStringValue("enemyTankCount"));

    //初始化地方坦克
    Tank tank = null;

    public GameMode(){
        enemyTankList = new ArrayList<>();
        bullteList = new ArrayList<>();
        explodeList =new ArrayList<>();
        tank =new Tank(200,200,Dir.DOWN,this,Group.GOOD);
        for(int i=0 ; i< enemyTankCount ;i++){
            enemyTankList.add(new Tank(100*i,100,Dir.DOWN,this,Group.BAD));
        }
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的个数："+ bullteList.size(),10,100);
        g.setColor(color);
        g.setColor(Color.WHITE);
        g.drawString("敌方坦克的个数："+ enemyTankList.size(),10,200);
        g.setColor(color);

        tank.paint(g);


        for (int i=0; i< bullteList.size(); i++ ){
            bullteList.get(i).paint(g);
        }

        for (int i=0; i< enemyTankList.size(); i++ ){
            enemyTankList.get(i).paint(g);
        }
        for (int i=0; i< explodeList.size(); i++ ){
            explodeList.get(i).paint(g);
        }


        //子弹与坦克相撞
        if(enemyTankList!= null&&enemyTankList.size()>0 && bullteList != null&&bullteList.size()>0){
            for(Tank tank : enemyTankList){
                for (Bullte bullte :bullteList){
                    bullte.collideWith(tank,g);
                }
            }
        }

    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
}
