package com.ald.aplus.thirdparty.service.impl;

import com.ald.aplus.thirdparty.service.YopClientService;
import com.ald.aplus.thirdparty.utils.YopClient;
import com.ald.news.core.base.BaseResponse;
import com.ald.news.core.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description:
 * @author: Mr.cai
 * @create: 2019-01-04 11:21
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@Service("yopClientService")
public class YopClientServiceImpl extends BaseService implements YopClientService {
    @Override
    public BaseResponse yopApi(Map<String, Object> params, String urlType) {
        try {
            YopClient yopClient = new YopClient();
            String uri = YopClient.getUrl(urlType);
            Map<String, Object> yopresponsemap = yopClient.yeepayYOP(params, uri);
            return BaseResponse.newSuccessInstance(yopresponsemap);
        } catch (Exception e) {
            return BaseResponse.newFailInstance(401);
        }
    }

    @Override
    public BaseResponse yopFile(Map<String, String> params, String path) {
        try {
            YopClient yopClient = new YopClient();
            //获取对账文件
            String filePath = yopClient.yosFile(params, path);
            return BaseResponse.newSuccessInstance(filePath);
        } catch (Exception e) {
            return BaseResponse.newFailInstance(401);
        }

    }


}


 
