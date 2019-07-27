package net.xdclass.xdvideo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : dk
 * @date : 2019/7/27 16:52
 * @description :微信配置类
 */

@Configuration
@PropertySource(value="classpath:application.properties")
public class WeChatConfig {

    /**
     * appId  及密钥
     */
    @Value("${wxpay.appid}")
    private String appId;

    @Value("${wxpay.appsecret}")
    private String appsecret;

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppsecret() {
        return appsecret;
    }
}
