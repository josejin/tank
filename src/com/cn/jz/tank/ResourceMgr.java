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
    static {
        try {
            tankR = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankR.gif"));
            tankD = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankD.gif"));
            tankL = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankL.gif"));
            tankU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankU.gif"));

            bulletR = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletR.gif"));
            bulletD = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletD.gif"));
            bulletL = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletL.gif"));
            bulletU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletU.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
