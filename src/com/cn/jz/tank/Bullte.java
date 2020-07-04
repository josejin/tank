package com.cn.jz.tank;

import java.awt.*;

/**
 * 子弹类
 */
public class Bullte {
    //坦克位子方向
    int x=200;
    int y=200;
    //方向枚举
    Dir dir ;
    //每次运行的步长
    private final int step = 8;

    private TankFrame tankFrame;
    //子弹的宽度
    public static int  BULLE_WIDTH = ResourceMgr.bulletD.getWidth();
    //子弹的高度
    public static int  BULLE_HEIGTH = ResourceMgr.bulletD.getHeight();
    //敌我区分
    private Group group;
    /**
     * 子弹是否存活
     */
    private boolean isLove = true ;

    Rectangle bullteRect = null;

    public Bullte(int x,int y,Dir dir,TankFrame tankFrame,Group group){
        this.x= x;
        this.y=y;
        this.dir =dir;
        this.tankFrame = tankFrame;
        this.group = group;

        bullteRect = new Rectangle(this.x,this.y,this.BULLE_WIDTH,this.BULLE_HEIGTH);
    }



    public void paint(Graphics g){
        if (!this.isLove){
            this.tankFrame.bullteList.remove(this);
        }


        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            default:
        }

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

        bullteRect.x =this.x;
        bullteRect.y=this.y;
        //移除子弹
        if(x<0 || y<0 || x>tankFrame.getFrameWidth() || y > tankFrame.getFrameHeight()){
            this.isLove = false;
        }
    }

    public  void die(){
        this.isLove =false;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
    public void collideWith(Tank tank,Graphics g){
        if(this.group==tank.getGroup()){
            return;
        }
        //矩形
       // Rectangle bullteRect = new Rectangle(this.x,this.y,this.BULLE_WIDTH,this.BULLE_HEIGTH);
       // Rectangle tankrect = new Rectangle(tank.getX(),tank.getY(),tank.TANK_WIDTH,tank.TANK_HEIGTH);
        if(bullteRect.intersects(tank.tankrect)){
            tank.die();
            this.die();
        }

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
