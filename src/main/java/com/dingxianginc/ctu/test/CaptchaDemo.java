/*
 * Copyright: 2017 dingxiang-inc.com Inc. All rights reserved.
 */

package com.dingxianginc.ctu.test;


import com.dingxianginc.ctucommon.client.CaptchaClient;
import com.dingxianginc.ctucommon.client.model.CaptchaResponse;

/**
 * @FileName: CaptchaDemo.java
 * @Description: 业务后台校验验证码token demo
 * @Author: dx
 * @Date: 2020/6/2 10:43
 */
public class CaptchaDemo {

    public static void main(String[] args) throws Exception{
        String hehe  = "hehe";
        String appId = "appId";
        String appSecret = "appSecret";
        String token = "前端传入的验证码token";
        CaptchaClient captchaClient = new CaptchaClient(appId,appSecret);
        captchaClient.setCaptchaUrl("http://10.1.2.43:7776/api/tokenVerify");
        //私有化部署的场景下需要设置服务url
        CaptchaResponse response = captchaClient.verifyToken(token);
        //CaptchaResponse response = captchaClient.verifyToken(token, ip);
        //针对一些token冒用的情况，业务方可以采集客户端ip随token一起提交到验证码服务，验证码服务除了判断token的合法性还会校验提交业务参数的客户端ip和验证码颁发token的客户端ip是否一致
        System.out.println(response.getCaptchaStatus());
        //确保验证状态是SERVER_SUCCESS，SDK中有容错机制，在网络出现异常的情况会返回通过
        //System.out.println(response.getIp());
        // 验证码服务采集到的客户端ip
        if (response.getResult()) {
            /**token验证通过，继续其他流程**/
        } else {
            /**token验证失败，业务系统可以直接阻断该次请求或者继续弹验证码**/
        }
        System.out.println("分支的使用");


    }


}
