package com.zknu.shop.common.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * hgx
 *  2017/7/15.
 *  用于判断积分是否达到晋级水平
 */
public class JfUtil {
    /**
     * 传入积分 返回会员级别
     * @param jifen
     * @return
     */
    public static String getLevel(int jifen){
        Properties pros = new Properties();
        String value = "";
        String  key=null;
        try {
            pros.load(new InputStreamReader(JfUtil.class.getResourceAsStream("/user.properties"), "GBK"));
            //根据传入的积分 判断为什么用户
            if(0<=jifen&&jifen<=200)
            {
                key="1";
            }else if (200<jifen&&jifen<=500){
                key="2";
            }else if (500<jifen&&jifen<=900){
                key="3";
            }else if (900<jifen&&jifen<=1500){
                key="4";
            }else if (1500<jifen){
                key="5";
            }
            value = pros.get(key).toString();
        } catch (IOException e) {
        }
        return value;

    }

    /**
     * 传入级别名称 返回折扣值
     *
     * @param level
     * @return
     */
    public static String getDiscount(String level){
        Properties pros = new Properties();
        String value = "";
        try {
            pros.load(new InputStreamReader(JfUtil.class.getResourceAsStream("/user.properties"), "GBK"));
            //根据传入的积分 判断为什么用户
            value = pros.get(level).toString();
        } catch (IOException e) {
        }
        return value;

    }
    /**
     *  返回100元能借几本书
     *
     * @return
     */
    public static int getYjCount(){
        Properties pros = new Properties();
        String value = "";
        try {
            pros.load(new InputStreamReader(JfUtil.class.getResourceAsStream("/user.properties"), "GBK"));
            value = pros.get("100").toString();
            System.out.print(value);
        } catch (IOException e) {
        }
        return Integer.parseInt(value);
    }
    /**
     *  每位老师能推荐几本书
     *
     * @return
     */
    public static int getRecommend(){
        Properties pros = new Properties();
        String value = "";
        try {
            pros.load(new InputStreamReader(JfUtil.class.getResourceAsStream("/user.properties"), "GBK"));
            value = pros.get("recommend").toString();
        } catch (IOException e) {
        }
        return Integer.parseInt(value);
    }
    /**
     *  每本书可以借多长时间
     *
     * @return
     */
    public static int getBorrowDate(){
        Properties pros = new Properties();
        String value = "";
        try {
            pros.load(new InputStreamReader(JfUtil.class.getResourceAsStream("/user.properties"), "GBK"));
            value = pros.get("jieshu").toString();
        } catch (IOException e) {
        }
        return Integer.parseInt(value);
    }
}
