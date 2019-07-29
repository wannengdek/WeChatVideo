package net.xdclass.xdvideo.controller;

import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.domain.JsonData;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author : dk
 * @date : 2019/7/29 15:22
 * @description :
 */
@Controller
@RequestMapping("/api/v1/wechat")
public class WechatController {

    @Autowired
    private WeChatConfig weChatConfig;
    /**
     * 拼装微信扫一扫登录url
     * @return
     */
    @RequestMapping("login_url")
    @ResponseBody
    public JsonData loginUrl(@RequestParam (value = "access_page",required =true)
                                         String accessPage) throws UnsupportedEncodingException {
        String redirectUrl = weChatConfig.getOpenRedirectUrl();
        //获取重定向地址
        String callbackUrl = URLEncoder.encode(redirectUrl,"GBK");

        String grcodeUrl = String.format(WeChatConfig.getOpenQrcodeUrl(),
                weChatConfig.getAppId(),
                callbackUrl,
                accessPage);


        return JsonData.buildError(grcodeUrl);
    }
}
