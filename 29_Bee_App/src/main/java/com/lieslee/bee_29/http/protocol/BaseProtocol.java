package com.lieslee.bee_29.http.protocol;

import android.content.pm.PackageManager;
import android.os.Build;


import com.common.utils.MD5Util;
import com.lieslee.bee_29.R;
import com.lieslee.bee_29.application.BeeApplication;
import com.lieslee.bee_29.http.HttpConstants;
import com.lieslee.bee_29.utils.Util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by LiesLee on 16/10/13.
 */
public class BaseProtocol {

    /**
     * 带1的方法类型 SortedMap<String, String>
     * 不带1的      SortedMap<String, Object>
     * */



    public static String getParams(SortedMap<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            //if (null != v && !"".equals(v)) {
            if (null != v) {
                sb.append(k + "=" + v + "&");
            }
        }
        return sb.toString();
    }
    public static String getParams1(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            //if (null != v && !"".equals(v)) {
            if (null != v) {
                sb.append(k + "=" + v + "&");
            }
        }
        return sb.toString();
    }

    public static String createSign(String characterEncoding, SortedMap<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append(getParams(parameters));
        sb.append(HttpConstants.getSignKey());
        String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding);
        return sign;
    }

    public static String createSign(SortedMap<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append(getParams(parameters));
        sb.append(HttpConstants.getSignKey());
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8");
        return sign;
    }
    public static String createSign1(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append(getParams1(parameters));
        sb.append(HttpConstants.getSignKey());
        String sign = MD5Util.MD5Encode(sb.toString(), "utf-8");
        return sign;
    }

    public static SortedMap<String, Object> createPatams(Map<String, Object> parameters, String urlName){
        HashMap<String, Object> hashMap = new HashMap<>(parameters);
        try {
            hashMap.put("app_version", BeeApplication.getInstance().getPackageManager().getPackageInfo(BeeApplication.getInstance().getPackageName(),PackageManager.GET_META_DATA).versionName);
            hashMap.put("client_time",System.currentTimeMillis());
            hashMap.put("system_version",Build.VERSION.RELEASE);
            hashMap.put("device_id", Util.getDeviceId());
            hashMap.put("utm_medium", "android");
            hashMap.put("utm_source", "teeApp");


            if(!hashMap.containsKey("api_ver")){
                hashMap.put("api_ver", BeeApplication.getInstance().getResources().getString(R.string.api_ver));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        SortedMap<String, Object> map = new TreeMap<>(hashMap);
        map.put("api_sign", createSign(map));
        map.put("a", urlName);
        return map;
    }

    public static SortedMap<String, String> createPatams1(Map<String, String> parameters, String urlName){
        HashMap<String, String> hashMap = new HashMap<>(parameters);
        try {
            hashMap.put("app_version", ""+BeeApplication.getInstance().getPackageManager().getPackageInfo(BeeApplication.getInstance().getPackageName(),PackageManager.GET_META_DATA).versionName);
            hashMap.put("client_time",""+System.currentTimeMillis());
            hashMap.put("system_version",Build.VERSION.RELEASE);
            hashMap.put("device_id", Util.getDeviceId());
            hashMap.put("utm_medium", "android");
            hashMap.put("utm_source", "vmApp");

            if(!hashMap.containsKey("api_ver")){
                hashMap.put("api_ver", BeeApplication.getInstance().getResources().getString(R.string.api_ver));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        SortedMap<String, String> map = new TreeMap<>(hashMap);
        map.put("api_sign", createSign1(map));
        map.put("a", urlName);
        return map;
    }

    
}
