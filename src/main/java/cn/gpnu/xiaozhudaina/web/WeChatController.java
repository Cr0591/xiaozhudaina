package cn.gpnu.xiaozhudaina.web;

import cn.gpnu.xiaozhudaina.util.AuthUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/weChat")
public class WeChatController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response){
        String backUrl = "http://hanjie.free.idcfengye.com/weChat/callBack";
//        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
//                "appid=" + AuthUtil.APPID +
//                "&redirect_uri=" + URLEncoder.encode(backUrl) +
//                "&response_type=code" +
//                "&scope=snsapi_userinfo" +
//                "&state=STATE#wechat_redirect";
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+AuthUtil.APPID+"&redirect_uri="+URLEncoder.encode(backUrl)+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/callBack",method = RequestMethod.GET)
    public void callBack(HttpServletRequest request, HttpServletResponse response){
        String code = request.getParameter("code");
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?" +
                "appid=" + AuthUtil.APPID +
                "&secret=" + AuthUtil.APPSECRET +
                "&code=" + code +
                "&grant_type=authorization_code";
        try {
            JSONObject jsonObject = AuthUtil.doGetJson(url);
            String oppenId = jsonObject.getString("openid");
            String accessToken = jsonObject.getString("access_token");
            String infoUrl = "https://api.weixin.qq.com/sns/userinfo?" +
                    "access_token=" + accessToken +
                    "&openid=" + oppenId +
                    "&lang=zh_CN";
            JSONObject userInfo = AuthUtil.doGetJson(infoUrl);
            System.out.println(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
