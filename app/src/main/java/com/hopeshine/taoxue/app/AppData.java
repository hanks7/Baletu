package com.hopeshine.taoxue.app;

import android.os.Environment;

import java.util.ArrayList;

/**
 * Created by hanks7 on 2017/4/1.
 */

public class AppData {

    /**
     * 是否上线
     */
    public final static Boolean IS_TEST = true;
    /**
     * 是否关闭打印日志
     */
    public final static Boolean IS_LOG = true;
    /**
     * 轮播图图片
     *
     */
    public  static ArrayList<String> textUrlList() {

        ArrayList<String> list = new ArrayList<>();

        list.add("https://i3.mifile.cn/a4/xmad_14964017903819_apNQP.jpg");

        list.add("https://i3.mifile.cn/a4/xmad_14965733100139_wcKQo.jpg");

        list.add("https://i3.mifile.cn/a4/xmad_14962268945869_klEsv.jpg");

        list.add("https://i3.mifile.cn/a4/xmad_14952089770715_otDpj.jpg");


        return list;

    }
    /**
     *
     */
    public final static String APP_INDEX = "taoxue";
    /**
     *测试图片
     */
    public final static String TEST_PIC_URL = "https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png";
    /**
     * apk安装名称
     */
    public final static String apkName = APP_INDEX+".apk";
    /**
     * 下载路径
     */
    public static String apkURL = "";
    /**
     * imageload缓存路径
     * 可读写的缓存路径
     * /storage/emulated/0/ebookcar/
     */
    public static String PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + APP_INDEX + "/";
    public static String FILE_PATH = PATH + "file/";



}
