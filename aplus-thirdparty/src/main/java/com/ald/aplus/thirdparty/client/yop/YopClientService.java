package com.ald.aplus.thirdparty.client.yop;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description: 易宝三方调用接口
 * @author: Mr.cai
 * @create: 2019-01-03 11:51
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@FeignClient(url = "${yop.url}", name = "yopurl")
public interface YopClientService {

    @RequestMapping(value = "/rest/v1.0/balance/transfer_send", method = RequestMethod.GET)
    String getdis();

}


 
