package com.ald.aplus.thirdparty.client.yop;

import com.ald.aplus.thirdparty.service.YopClientService;
import com.ald.aplus.thirdparty.utils.YopClient;
import com.ald.news.core.base.BaseController;
import com.ald.news.core.base.BaseResponse;
import com.ald.news.domain.thirdparty.TransferSendRequest;
import com.ald.news.utils.java.EntityUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: aplus
 * @Version 1.0.0
 * @description: 易宝三方调用接口
 * @author: Mr.cai
 * @create: 2019-01-03 11:51
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@RestController
@Api
public class YopClientComponent extends BaseController {
    @Resource
    private YopClientService yopClientService;

    /**
     * 代付代发出款接口
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/rest/v1.0/balance/transfer_send")
    @ResponseBody
    BaseResponse transfer_send(@RequestParam Map<String, Object> params) {

        return yopClientService.yopApi(params, "paymentURI");
    }

    /**
     * 代付代发批量出款接口
     *
     * @param params
     * @return
     */
    @PostMapping(value = "/rest/v1.0/balance/transfer_batch_send")
    @ResponseBody
    BaseResponse transfer_batch_send(@RequestParam Map<String, Object> params) {
        return yopClientService.yopApi(params, "batchsendURI");
    }

    /**
     * 代付代发查询接口
     *
     * @param params
     * @return
     */
    @GetMapping(value = "/rest/v1.0/balance/transfer_query")
    @ResponseBody
    BaseResponse transfer_query(@RequestParam Map<String, Object> params) {
        return yopClientService.yopApi(params, "paymentqueryURI");
    }

    /**
     * 代付代发账户余额查询接口
     *
     * @param params
     * @return
     */
    @GetMapping(value = "/rest/v1.0/balance/query_customer_amount")
    @ResponseBody
    BaseResponse query_customer_amount(@RequestParam Map<String, Object> params) {
        return yopClientService.yopApi(params, "customeramountQueryURI");
    }

    public static void main(String[] args) throws IOException {
        YopClient yopClient = new YopClient();
        Map<String, Object> params = new HashMap<>();

        params.put("customerNumber", "121232131232131");
        params.put("groupNumber", "1");
        params.put("batchNo", "121232131232131");
        params.put("orderId", "1");
        params.put("amount", "1");
        params.put("product", "1");
        params.put("urgency", "1");
        params.put("accountName", "1");
        params.put("accountNumber", "1");
        params.put("bankCode", "1");
        params.put("bankName", "1");
        params.put("bankBranchName", "1");
        params.put("provinceCode", "1");
        params.put("cityCode", "1");
        params.put("feeType", "1");
        params.put("desc", "1");
        params.put("leaveWord", "1");
        params.put("abstractInfo", "1");
        TransferSendRequest c = EntityUtils.mapToEntity(params, TransferSendRequest.class);
        System.out.println(c);
//        String uri = YopClient.getUrl("paymentURI");
//        Map<String, Object> yopresponsemap = yopClient.yeepayYOP(params, uri);


//		request.setAttribute("yopresponsemap",yopresponsemap==null?"系统异常":yopresponsemap);
//		RequestDispatcher view	= request.getRequestDispatcher("/jsp/11paymentResponse.jsp");
//		view.forward(request, response);


    }


}


 
