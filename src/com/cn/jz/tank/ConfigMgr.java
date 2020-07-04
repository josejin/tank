package com.cn.jz.tank;

import java.io.IOException;
import java.util.Properties;

public class ConfigMgr {
    private ConfigMgr(){
    }
    //饿汉式加载。
 /*  private static volatile  Properties pro =  new Properties();

    static {
        try {
            pro.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    //懒汉式
   /* private static volatile  Properties pro =  null;

    private static void init(){
        try {
            pro = new Properties();
            pro.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

  //双重锁实现单例
  private static volatile  Properties pro =  null;
  private static void init(){
       if (pro==null){
           synchronized (ConfigMgr.class){
               if (pro==null){
                   try {
                       pro = new Properties();
                       pro.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config"));
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
           }
       }
    }


    public static Properties  getConfigMgr(){
         init();
        return  pro;
    }


    /**
     * 获取配置文件返回参数
     * @param key
     * @return
     */
  public static String  getStringValue(String key){
     // init();
      return  pro.getProperty(key);
  }

    /**
     * 获取配置文件信息，返回Object 对象
     * @param key
     * @return
     */
  public static Object getStringObj(String key){
     // init();
      return  pro.get(key);
  }


    public static void main(String[] args) {
        new Thread(()->{
            while(true){

                try {
                    System.out.println(ConfigMgr.getConfigMgr().hashCode());
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            while(true){
                try {
                    System.out.println(ConfigMgr.getConfigMgr().hashCode());
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
