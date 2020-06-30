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
    //子弹图片
    public static BufferedImage bulletR ,bulletD, bulletL,bulletU;
    //爆炸图片
    public static BufferedImage[] explodes = new BufferedImage[16];
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


           /* bulletR = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletR.gif"));
            bulletD = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletD.gif"));
            bulletL = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletL.gif"));
            bulletU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletU.gif"));*/
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
