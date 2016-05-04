package org.freecoding.servicesmanager.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Wowser on 2016/4/28.
 */
public class HttpUtils {
    private static final String BASE_URL = "http://139.196.230.64:8080/ouyang/";

    /**
     * 登录
     *  @param loginId
     * @param password
     * @param callback
     */
    public static void login(String loginId, String password, StringCallback callback) {
        String url = BASE_URL + "member.do?method=login&loginId=" + loginId + "&password=" + password;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 注册
     *  @param loginId
     * @param password
     * @param callback
     */
    public static void register(String loginId, String password, StringCallback callback) {
        String url = BASE_URL + "member.do?method=register&loginId=" + loginId + "&password=" + password;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 客户保存家政服务
     *
     * @param serviceId
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param address
     * @param phone
     * @param callback
     */
    public static void saveServiceItemJiaZheng(int serviceId, String serviceTime, String serviceItem, String name, String address, String phone, StringCallback callback) {
        String url = BASE_URL + "jiazhengitem.do?method=saveServiceItemJiaZheng&serviceId=" + serviceId + "&serviceTime=" + serviceTime + "&serviceItem=" + serviceItem + "&name=" + name + "&address=" + address + "&phone=" + phone;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 查询家政订单
     *
     * @param phoneNo
     * @param orderNo
     * @param callback
     */
        public static void getMemberOrderByNo(String phoneNo, String orderNo, StringCallback callback) {
        String url = BASE_URL + "member.do?method=getMemberOrderByNo&phoneNo=" + phoneNo + "&orderNo=" + orderNo;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 生成家政订单
     *
     * @param phoneNo
     * @param type
     * @param serviceItem
     * @param callback
     */
    public static void orderJiaZheng(String phoneNo, int type, String serviceItem, StringCallback callback) {
        String url = BASE_URL + "member.do?method=orderJiaZheng&phoneNo=" + phoneNo + "&type=" + type + "&serviceItem=" + serviceItem;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 家政菜单
     *
     * @param callback
     */
    public static void getAllJiazhengItem(StringCallback callback) {
        String url = BASE_URL + "jiazhengitem.do?method=getAllJiazhengItem";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 保存护理服务
     *
     * @param serviceId
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param address
     * @param phone
     * @param callback
     */
    public static void saveServiceItemHuLi(int serviceId, String serviceDate, String serviceTime, String serviceItem, String name, String address, String phone, StringCallback callback) {
        String url = BASE_URL + "huliitem.do?method=saveServiceItemHuLi&serviceId=" + serviceId + "&serviceDate=" + serviceDate + "&serviceTime=" + serviceTime + "&serviceItem=" + serviceItem + "&name=" + name + "&address=" + address + "&phone=" + phone;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 查询护理订单
     *
     * @param phoneNo
     * @param orderNo
     * @param callback
     */
    public static void getMemberOrderHuLiByNo(String phoneNo, String orderNo, StringCallback callback) {
        String url = BASE_URL + "member.do?method=getMemberOrderHuLiByNo&phoneNo=" + phoneNo + "&orderNo=" + orderNo;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 生成护理订单
     *
     * @param phoneNo
     * @param type
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param remark
     * @param callback
     */
    public static void orderHuLi(String phoneNo, int type, String serviceDate, String serviceTime, String serviceItem, String remark, StringCallback callback) {
        String url = BASE_URL + "member.do?method=orderHuLi&phoneNo=" + phoneNo + "&type=" + type + "&serviceDate=" + serviceDate + "&serviceTime=" + serviceTime + "&serviceItem=" + serviceItem + "&remark=" + remark;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 护理菜单
     *
     * @param callback
     */
    public static void getAllHuLiItem(StringCallback callback) {
        String url = BASE_URL + "huliitem.do?method=getAllHuLiItem";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }
    /**
     * 保存医疗服务
     *
     * @param serviceId
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param address
     * @param phone
     * @param callback
     */
    public static void saveServiceItemYiLiao(int serviceId, String serviceDate, String serviceTime, String serviceItem, String name, String address, String phone, StringCallback callback) {
        String url = BASE_URL + "yiliaoitem.do?method=saveServiceItemYiLiao&serviceId="+serviceId+"&serviceDate="+serviceDate+"&serviceTime="+serviceTime+"&serviceItem="+serviceItem+"&name="+name+"&address="+address+"&phone="+"phone";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 菜单医疗
     *
     * @param callback
     */
    public static void getAllYiLiaoItem(StringCallback callback) {
        String url = BASE_URL + "yiliaotem.do?method=getAllYiLiaoItem";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }
}
