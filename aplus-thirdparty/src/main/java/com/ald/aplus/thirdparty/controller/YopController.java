package com.ald.aplus.thirdparty.controller;

import com.ald.aplus.thirdparty.service.YopClientService;
import com.ald.news.core.base.BaseController;
import com.ald.news.core.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description: 易宝控制层
 * @author: Mr.cai
 * @create: 2019-01-03 12:06
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@Api(tags = "易宝接口", value = "易宝接口")
@RestController
@RequestMapping("/v1/api")
public class YopController extends BaseController {
    @Resource
    private YopClientService yopClientService;


    @ApiOperation(value = "代付单笔出款接口", notes = "代付单笔出款接口")
    @ResponseBody
    @PostMapping(value = "/transfer_send")
    public BaseResponse getTransferSend(@RequestParam Map<String, Object> params) {
        return yopClientService.yopApi(params,"paymentURI");
    }

}


 
