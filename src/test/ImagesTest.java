package test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImagesTest {

    public static void main(String[] args) {
        try {
            //绝对路径读取文件
           // BufferedImage bff =ImageIO.read(new File("E:/git/tank/src/images/bulletR.gif"));
            //相对路径读取文件
           BufferedImage bff =ImageIO.read(ImagesTest.class.getClassLoader().getResource("images/bulletR.gif"));
            if (bff !=null){
                System.out.println("bff="+bff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void teskJunit(){

    }
}
