package com.dingxianginc.ctu.test;

import com.alibaba.fastjson.JSON;
import com.dingxianginc.ctucommon.client.CtuClient;
import com.dingxianginc.ctucommon.client.model.CtuRequest;
import com.dingxianginc.ctucommon.client.model.CtuResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @FileName: SaasCtuTest
 * @Description: 调用决策引擎的demo
 * @Author: guangya.zhao
 * @Date: 2019/10/17 17:36
 */
public class SaasCtuTest {
    public static void main(String[] args) {
        //设置url, appKey, appSecret
        CtuClient ctuClient = new CtuClient("http://dxhz4811.dingxiang-inc.com:7009/ctu/event.do",
                "15cd33f28ce1e4db96f6d143bf089377", "3879d10b0ed87167585c4164866938b6",
                60000, 60000, 240000);

        Map<String, Object> data = new HashMap<>();
        //业务请求数据
        data.put("user_name", "张某某");
        data.put("idcard", "320688199005051485");
//        data.put("phone_number", "13012345678");

        //创建一个请求数据实例
        CtuRequest request = new CtuRequest();
        //设置产品编码
        request.setAppCode("prdt_test");
        //设置事件编码
        request.setEventCode("test_event");
        //设置该次风控请求的业务数据
        request.setData(data);
        //设置请求标记
        request.setFlag("activity_" + System.currentTimeMillis());

        //向风控引擎发送请求，获取引擎返回的结果
        CtuResponse response = null;
        try {
            response = ctuClient.checkRisk(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(JSON.toJSONString(response));
    }
}
