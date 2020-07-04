package com.cn.jz.tank;

import java.io.IOException;
import java.util.Properties;

public class ConfigMgr {
    private ConfigMgr(){
    }
   private static volatile  Properties pro = null;
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



 /* static {
      try {
          pro.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config"));
      } catch (IOException e) {
          e.printStackTrace();
      }
  }*/

    /**
     * 获取配置文件返回参数
     * @param key
     * @return
     */
  public static String  getStringValue(String key){
      init();
      return  pro.getProperty(key);
  }

    /**
     * 获取配置文件信息，返回Object 对象
     * @param key
     * @return
     */
  public static Object getStringObj(String key){
      init();
      return  pro.get(key);
  }
}
