package com.cn.jz.tank;

import test.ImagesTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 图片缓存类型，启动时加载到内存
 */
public class ResourceMgr {
    //坦克图片
    public static BufferedImage tankR ,tankD, tankL,tankU;
    //地方坦克图片
    public static BufferedImage badTankR ,badTankD, badTankL,badTankU;
    //子弹图片
    public static BufferedImage bulletR ,bulletD, bulletL,bulletU;
    //子弹图片
    public static BufferedImage bullet1R ,bullet1D, bullet1L,bullet1U;
    //爆炸图片
    public static BufferedImage[] explodes = new BufferedImage[16];
    //爆炸图片2
    public static BufferedImage[] explode2s = new BufferedImage[11];
    static {
        try {
           /* tankR = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankR.gif"));
            tankD = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankD.gif"));
            tankL = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankL.gif"));
            tankU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankU.gif"));*/
            tankU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/GoodTank2.png"));
            tankR = ImageUtil.rotateImage(tankU,90);
            tankD = ImageUtil.rotateImage(tankU,180);
            tankL = ImageUtil.rotateImage(tankU,-90);

            badTankU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/BadTank1.png"));
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankL = ImageUtil.rotateImage(badTankU,-90);

            bullet1R = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletR.gif"));
            bullet1D = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletD.gif"));
            bullet1L = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletL.gif"));
            bullet1U = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletU.gif"));

            bulletU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletU.png"));
            bulletR = ImageUtil.rotateImage(bulletU,90);
            bulletD = ImageUtil.rotateImage(bulletU,180);
            bulletL = ImageUtil.rotateImage(bulletU,-90);


            explodes[0] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e1.gif"));
            explodes[1] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e2.gif"));
            explodes[2] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e3.gif"));
            explodes[3] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e4.gif"));
            explodes[4] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e5.gif"));
            explodes[5] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e6.gif"));
            explodes[6] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e7.gif"));
            explodes[7] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e8.gif"));
            explodes[8] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e9.gif"));
            explodes[9] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e10.gif"));
            explodes[10] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e11.gif"));
            explodes[11] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e12.gif"));
            explodes[12] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e13.gif"));
            explodes[13] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e14.gif"));
            explodes[14] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e15.gif"));
            explodes[15] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/e16.gif"));

            explode2s[0] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/0.gif"));
            explode2s[1] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/1.gif"));
            explode2s[2] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/2.gif"));
            explode2s[3] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/3.gif"));
            explode2s[4] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/4.gif"));
            explode2s[5] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/5.gif"));
            explode2s[6] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/6.gif"));
            explode2s[7] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/7.gif"));
            explode2s[8] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/8.gif"));
            explode2s[9] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/9.gif"));
            explode2s[10] = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/10.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
