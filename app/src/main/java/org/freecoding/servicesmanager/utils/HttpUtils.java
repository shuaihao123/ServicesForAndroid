package org.freecoding.servicesmanager.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * Created by Wowser on 2016/4/28.
 */
public class HttpUtils {
    private static final String BASE_URL = "http://139.196.230.64:8080/ouyang/";
    //private static final String BASE_URL2 = "http://139.196.230.64:8080/ouyang2/";
    private static final String BASE_URL2 = "http://10.0.2.2:8080/ouyang2/";

    /**
     * 登录
     *
     * @param loginId
     * @param password
     * @param callback
     */

    public static void login(String loginId, String password, StringCallback callback) {
        String url = BASE_URL2 + "member/login.do?loginId=" + loginId + "&password=" + password;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 注册
     *
     * @param loginId
     * @param password
     * @param callback
     */
    public static void register(String loginId, String password, StringCallback callback) {
        String url = BASE_URL2 + "member/register.do?loginId=" + loginId + "&password=" + password;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }

    /**
     * 客户保存家政服务
     *
     * @param servicetype
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param address
     * @param phone
     * @param remark
     * @param age
     * @param jiguan
     * @param state
     * @param callback
     */
    public static void saveServiceItemJiaZheng(int servicetype, String serviceDate, String serviceTime, String serviceItem, String remark, String name, String address, String phone, String age, String jiguan,int state, StringCallback callback) {
        String url = BASE_URL2 + "member/orderJiaZheng.do?type=" + servicetype + "&phoneNo=" + phone + "&serviceDate=" + serviceDate + "&serviceTime=" + serviceTime + "&serviceItem=" + serviceItem + "&remark=" + remark + "&address=" + address + "&customerName=" + name + "&age=" + age + "&jiguan=" + jiguan + "&state="+state;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }
    /**
     * 查询家政订单列表
     *
    /**
     * @param phoneNo
     * @param type
     * @param callback
     */
    public static void getOrderJiaZhengByTypeAndPhone(String phoneNo, int type, StringCallback callback) {
            String url = BASE_URL2 + "member/getOrderJiaZhengByTypeAndPhone.do?phoneNo="+phoneNo+"&type="+type;

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
        String url = BASE_URL2 + "member/orderJiaZheng.do?phoneNo=" + phoneNo + "&type=" + type + "&serviceItem=" + serviceItem;
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }
    /**
     * 取消家政订单
     *
     * @param callback
     */
    public static void cancelOrderJiaZheng(String phoneNo,String orderNos,int state,StringCallback callback) {
        String url = BASE_URL2 + "member/cancelOrderJiaZheng.do?phoneNo="+phoneNo+"&orderNos="+orderNos+"&state="+state;
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
        String url = BASE_URL2 + "member/getAllJiazhengItem.do";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);

    }

    /**
     * 保存护理服务
     *
     * @param type
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param address
     * @param phone
     * @param bz
     * @param state
     * @param callback
     */

    public static void saveServiceItemHuLi(int type, String serviceDate, String serviceTime, String serviceItem, String bz, String name, String address, String phone,int state, StringCallback callback) {
        String url = BASE_URL2 + "member/orderHuLi.do?phoneNo=" + phone + "&type=" + type + "&serviceDate=" + serviceDate + "&serviceTime=" + serviceTime + "&serviceItem=" + serviceItem + "&remark=" + bz + "&customerName=" + name + "&address=" + address + "&state="+state;
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
        String url = BASE_URL2 + "member/getMemberOrderHuLiByNo.do?phoneNo=" + phoneNo + "&orderNo=" + orderNo;
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
        String url = BASE_URL2 + "member/orderHuLi.do?phoneNo=" + phoneNo + "&type=" + type + "&serviceDate=" + serviceDate + "&serviceTime=" + serviceTime + "&serviceItem=" + serviceItem + "&remark=" + remark;
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
        String url = BASE_URL2 + "member/getAllHuLiItem.do";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }


    /**
     * 保存医疗服务
     *
     * @param type
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param bz
     * @param address
     * @param phone
     * @param callback
     */


    /**
     * 保存医疗服务
     *
     * @param type
     * @param serviceDate
     * @param serviceTime
     * @param serviceItem
     * @param name
     * @param bz
     * @param address
     * @param phone
     * @param callback
     */

    public static void saveServiceItemYiLiao(int type, String serviceDate, String serviceTime, String serviceItem,String bz, String name, String address, String phone, StringCallback callback) {
        String url = BASE_URL2 + "member/orderYiLiao.do?phoneNo="+phone+"&type="+type+"&serviceDate="+serviceDate+"&serviceTime="+serviceTime+"&serviceItem="+serviceItem+"&remark="+bz+"&customerName="+name+"&address="+address+"&state=1";
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
        String url = BASE_URL2 + "member/getAllYiLiaoItem.do";
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(callback);
    }


}
