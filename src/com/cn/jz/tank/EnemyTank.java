package com.cn.jz.tank;

import java.awt.*;
import java.util.List;

public class EnemyTank {

    //坦克位子方向
    int x=200;
    int y=200;
    //方向枚举
    Dir dir ;
    //每次运行的步长
    private final int step = 2;

    private TankFrame tankFrame;
    /**
     * 子弹是否存活
     */
    private boolean isLove = true ;

    public EnemyTank(int x,int y,Dir dir,TankFrame tankFrame){
        this.x= x;
        this.y=y;
        this.dir =dir;
        this.tankFrame = tankFrame;
    }



    public void paint(Graphics g){
        if (!this.isLove){
            this.tankFrame.getEnemyTankList().remove(this);
        }
        System.out.println(" println EnemyTank paint....");
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,50,50);
        g.setColor(c);
        //子弹移动
        this.Moveing(dir);
    }
    //子弹移动
    public void Moveing( Dir dir ){
        switch (dir){
            case LEFT:
                x-=step; break;
            case RIGHT:
                x+=step;break;
            case UP:
                y-=step;break;
            case DOWN:
                y+=step;break;
            default:
        }
        if (tankFrame.enemyTankList!= null&&tankFrame.enemyTankList.size()>0 && tankFrame.bullteList != null&&tankFrame.bullteList.size()>0){
            //移动改变方向
            for(EnemyTank enemyTank : tankFrame.enemyTankList){
                for (Bullte bullte :tankFrame.bullteList){
                    if(enemyTank.x == bullte.x || enemyTank.y==bullte.y){
                        this.isLove = false;
                    }
                }
            }

        }

/*
        if(x<0 || y<0 || x>tankFrame.getFrameWidth() || y > tankFrame.getFrameHeight()){
            this.isLove = false;
        }*/
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
