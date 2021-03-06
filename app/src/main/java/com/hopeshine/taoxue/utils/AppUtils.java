package com.hopeshine.taoxue.utils;

import com.hopeshine.taoxue.app.BaseApplication;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


/**
 * Created by CC on 2016/6/5.
 */

public class AppUtils {
    public static void showToast(String msg) {
        UtilToast.showText(msg);
    }

    public static void showToast(int resId) {
        UtilToast.showText(BaseApplication.get().getString(resId));
    }

    public static byte[] getFileToByte(File file) {
        byte[] by = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                bytestream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            by = bytestream.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return by;
    }

    public static String getNullTxt(String str){
        if ("null".equals(str)||"".equals(str)){
            return "0";
        }else{
            return str;
        }
    }

}
