package com.cn.jz.tank;

import test.ImagesTest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 坦克类
 */
public class Tank  extends ModeObject{
    //方向枚举
    Dir dir = Dir.DOWN;
    //每次运行的步长
    private final int step = 2 ;

    private boolean move = true;

    /*DefaultFireStrategy defaultFireStrategy = new DefaultFireStrategy();*/

    FourDirFireStrategy fourDirFireStrategy = new FourDirFireStrategy();

    FireStrategy fireStrategy=null;

    private int oldX,oldY;

    /**
     * 坦克是否存活
     */
    private boolean isLove = true ;

    Group group;

    //坦克的宽度
    public static int  TANK_WIDTH = ResourceMgr.tankD.getWidth();
    //坦克的高度
    public static int  TANK_HEIGTH = ResourceMgr.tankD.getHeight();

    Rectangle tankrect = null;

    GameMode gm = null;


    public Tank(int x,int y,Dir dir,GameMode gm,Group group){
        this.x= x;
        this.y=y;
        this.dir=dir;
        this.gm = gm;
        this.group = group;

        tankrect = new Rectangle(this.x,this.y,TANK_WIDTH,TANK_HEIGTH);
        try {
            if (this.group == Group.GOOD) {


            }else{
                String defultFire = ConfigMgr.getStringValue("defultFire");

                Class  defultFireClass = Class.forName(defultFire);
                fireStrategy = (FireStrategy) defultFireClass.newInstance();

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }



    public void paint(Graphics g){
       // System.out.println(" println paint....");
        if (!this.isLove){
            gm.getModeObjectList().remove(this);
        }

        switch (dir){
            case LEFT:
                g.drawImage(this.group==Group.BAD?ResourceMgr.badTankL:ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group==Group.BAD?ResourceMgr.badTankR:ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(this.group==Group.BAD?ResourceMgr.badTankU:ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group==Group.BAD?ResourceMgr.badTankD:ResourceMgr.tankD,x,y,null);
                break;
            default:
        }

        //如果弹起按钮坦克不移动
        if(!move){
           return;
        }
        //坦克移动
        this.Moveing(dir);


    }
    //坦克移动
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

        //更新
        tankrect.x =this.x;
        tankrect.y = this.y;
        oldX = this.x;
        oldY =this.y;
        //坦克射击
        if(Group.BAD.equals(this.group)){
            if(new Random().nextInt(10) > 8){
                this.fire();
            }
            //坦克随机移动方向
            if(new Random().nextInt(100) > 95){
                this.randomDir();
            }
        }

        //坦克移动超出边界处理
        this.movingBoundCheck();
    }

    /**
     * 坦克移动超出边界处理
     */
    private void movingBoundCheck(){
        if(this.x<2){
            this.x =2;
        }
        if(this.y<28){
            this.y =28;
        }
        if (this.x > TankFrame.frameWidth - TANK_WIDTH){
            this.x = TankFrame.frameWidth - TANK_WIDTH -2;
        }
        if (this.y > TankFrame.frameHeight - TANK_HEIGTH){
            this.y = TankFrame.frameHeight - TANK_HEIGTH -2;
        }


    }

    private void randomDir(){
      this.dir  = Dir.values()[new Random().nextInt(4)] ;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMove() {
        return move;
    }

    public void setMove(boolean move) {
        this.move = move;
    }

    /**
     * 坦克设计
     */
    public void fire(){
        if(Group.GOOD == this.group){
            fourDirFireStrategy.fire(this);
        }else {
            fireStrategy.fire(this);
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die(){
        this.isLove=false;
        gm.getModeObjectList().add(new Explode(this.x,this.y,gm));
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Rectangle getTankrect() {
        return tankrect;
    }

    public int getOldX() {
        return oldX;
    }

    public int getOldY() {
        return oldY;
    }
}
