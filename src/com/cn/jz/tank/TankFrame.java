package com.cn.jz.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank tank =new Tank(200,200,Dir.DOWN,this);

    Bullte  bullte = new Bullte(50,50,Dir.DOWN);
  // Bullte bullte = tank.fire();

    private boolean isFire = false;

    private final int FrameWidth = 700,FrameHeight = 500;

    public TankFrame(){
        this.setResizable(false);
        this.setSize(FrameWidth,FrameHeight);
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
        System.out.println("update...");
       if (offScreenImage == null){
           offScreenImage = this.createImage(FrameWidth,FrameHeight);
       }
           Graphics offScreen = offScreenImage.getGraphics();
           Color color = offScreen.getColor();
           offScreen.setColor(Color.BLACK);
           offScreen.fillRect(0,0,FrameWidth,FrameHeight);
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
        tank.paint(g);
        System.out.println(" println isFire...." +isFire);
        bullte.paint(g);
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
            System.out.println(" println keyPressed....");
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
            System.out.println(" println keyReleased....");
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
                    tank.fire();
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

}
