package com.cn.jz.tank;

import test.ImagesTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage tankR ,tankD, tankL,tankU;
    static {
        try {
            tankR = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankR.gif"));
            tankD = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankD.gif"));
            tankL = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankL.gif"));
            tankU = ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/tankU.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
