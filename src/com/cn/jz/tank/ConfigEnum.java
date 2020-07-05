package com.cn.jz.tank;

import java.io.IOException;
import java.util.Properties;

public enum ConfigEnum {
    PRO;

    private Properties  pro = null;
    ConfigEnum(){

        try {
            pro = new Properties();
            pro.load(ConfigMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public  Properties  getConfigMgr(){
        return  pro;
    }

    public  String  getStringValue(String key){
        // init();
        return  pro.getProperty(key);
    }
}
