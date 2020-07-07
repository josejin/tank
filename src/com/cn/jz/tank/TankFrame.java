package com.cn.jz.tank;

import com.cn.jz.tank.Factory.AbstractStyleFactory;
import com.cn.jz.tank.Factory.DefaultFactory;
import com.cn.jz.tank.Factory.bullte.BullteBase;
import com.cn.jz.tank.Factory.tank.BaseTank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 战场类型
 */
public class TankFrame extends Frame {

    AbstractStyleFactory defaultFactory =  new DefaultFactory();

    BaseTank tank =defaultFactory.createTank(200,200,Dir.DOWN,this,Group.GOOD);

    //Bullte  bullte = new Bullte(50,50,Dir.DOWN);
    //子弹类型
   public List<BullteBase> bullteList = new ArrayList<>();

    //敌军坦克类
   public List<BaseTank> enemyTankList = new ArrayList<>();

    //爆炸List
   public List<Explode> explodeList =new ArrayList<>();


    public boolean isFire = false;

    public final int frameWidth = 1000,frameHeight = 800;




    public TankFrame(){
        this.setResizable(false);
        this.setSize(frameWidth,frameHeight);
        this.setVisible(true);
        this.setTitle("坦克大战");
        //监听键盘小心
        this.addKeyListener(new MyKeyListener());
        //监听窗口关闭
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //定义图片
    Image offScreenImage = null;
    /**
     *  该方法是调用repaint后调用拦截，执行完UPDATE方法就继续执行paint方法
     * @param g
     */
    @Override
    public void update(Graphics g) {

       if (offScreenImage == null){
           offScreenImage = this.createImage(frameWidth,frameHeight);
       }
           Graphics offScreen = offScreenImage.getGraphics();
           Color color = offScreen.getColor();
           offScreen.setColor(Color.BLACK);
           offScreen.fillRect(0,0,frameWidth,frameHeight);
           offScreen.setColor(color);
           paint(offScreen);
           g.drawImage(offScreenImage,0,0,null);

    }

    /**
     * 每次移动方向
     * @param g
     */
    @Override
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
            for(BaseTank tank : enemyTankList){
                for (BullteBase bullte :bullteList){
                    bullte.collideWith(tank,g);
                }
            }
        }

    }

    /**
     * 处理键盘事件类
     */
    class  MyKeyListener extends KeyAdapter{

        boolean vl = false;
        boolean vf = false;
        boolean vu = false;
        boolean vk = false;
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }

        /**
         * 键盘按下方法会被调用
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
          //  System.out.println(" println keyPressed....");
            int key =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    vl=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    vf=true;
                    break;
                case KeyEvent.VK_UP:
                    vu=true;
                    break;
                case KeyEvent.VK_DOWN:
                    vk=true;
                    break;
                case KeyEvent.VK_CONTROL:
                    isFire = false;
                    break;
                default:
            }
            this.setMainTankDir();
        }

        /**
         * 键盘抬起方法会被调用
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
           // System.out.println(" println keyReleased....");
            int key =e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    vl=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    vf=false;
                    break;
                case KeyEvent.VK_UP:
                    vu=false;
                    break;
                case KeyEvent.VK_DOWN:
                    vk=false;
                    break;
                case KeyEvent.VK_CONTROL:
                    isFire = true;
                    tank.fire(defaultFactory);
                    break;
                default:
            }
            this.setMainTankDir();
        }
        //键盘触发改变方向
        public  void setMainTankDir(){
            if (!vl||!vf||!vu||!vk){
                tank.setMove(false);
            }

            if (vl){
                tank.setMove(true);
                tank.setDir(Dir.LEFT);
            }
            if (vf){
                tank.setMove(true);
                tank.setDir(Dir.RIGHT);
            }
            if (vu){
                tank.setMove(true);
                tank.setDir(Dir.UP);
            }
            if (vk){
                tank.setMove(true);
                tank.setDir(Dir.DOWN);
            }
        }
    }


    public int getFrameWidth() {
        return frameWidth;
    }

    public int getFrameHeight() {
        return frameHeight;
    }



}
