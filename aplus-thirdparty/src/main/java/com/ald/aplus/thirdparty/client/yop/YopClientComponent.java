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


    /**
     * 代付代发对账文件
     *
     * @param params
     * @return
     */
    @GetMapping(value = "/rest/v1.0/balance/api_file")
    @ResponseBody
    BaseResponse apiFile(@RequestParam Map<String, String> params) {
        return yopClientService.yopFile(params, "/");
    }


    /**
     * 鉴权绑卡确认
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/auth/confirm")
    @ResponseBody
    BaseResponse paperorderAythConfirm(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "authbindcardreqUri");
    }

    /**
     * 统一鉴权绑卡请求
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/unified/auth/request")
    @ResponseBody
    BaseResponse paperorderUnifiedAuthRequest(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "authbindcardreqUri");
    }

    /**
     * 鉴权绑卡重发
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/auth/resend")
    @ResponseBody
    BaseResponse paperorderAuthResend(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "authbindcardresendUri");
    }

    /**
     * 鉴权列表查询
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/auth/bindcard/list")
    @ResponseBody
    BaseResponse paperorderAuthBindcatdList(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "authListqueryUri");
    }

    /**
     * 鉴权记录查询
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/auth/query")
    @ResponseBody
    BaseResponse paperorderAuthQuery(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "authrecordqueryUri");
    }

    /**
     * bin查询
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/temppay/bankcardrecord")
    @ResponseBody
    BaseResponse paperTemppayBankcardrecord(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "bankcardqueryUri");
    }


    /**
     * 批量扣款查询
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/api/pay/batchtempcard/query")
    @ResponseBody
    BaseResponse paperorderApiPayBatchtempcatdQuery(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "batchpayqueryUri");
    }

    /**
     * 批量扣款的url
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/api/pay/batchtempcard/order")
    @ResponseBody
    BaseResponse paperApiPayBatchtempcardOrder(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "batchpayUri");
    }

    /**
     * 绑卡支付确认
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/pay/confirm")
    @ResponseBody
    BaseResponse paperorderPayConfirm(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "bindcardconfirmUri");
    }

    /**
     * 绑卡支付重发
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/pay/resend")
    @ResponseBody
    BaseResponse paperorderPayResend(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "bindcardpayresendUri");
    }

    /**
     * 绑卡支付查询
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/api/pay/query")
    @ResponseBody
    BaseResponse paperorderApiPayQuery(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "bindcardpayqueryUri");
    }

    /**
     * 首次支付查询
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/firstpayorder/query")
    @ResponseBody
    BaseResponse paperorderFirstpayorderQuery(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "firstpayqueryUri");
    }

    /**
     * 首次支付短验确认
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/firstpayorder/confirm")
    @ResponseBody
    BaseResponse paperorderFirstPayorderConfirm(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "firstpaysmsconfUri");
    }

    /**
     * 首次支付短验重发
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/firstpayorder/resend")
    @ResponseBody
    BaseResponse paperorderFirstpayorderResend(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "firstpaysmsresendUri");
    }

    /**
     * 对账
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/api/accountcheck")
    @ResponseBody
    BaseResponse paperorderApiAccountcheck(@RequestParam Map<String, String> params) {
        String requestUri = null;
        String authfileUri ="authfileUri";
        String payfileUri = "payfileUri";
        String refundfileUri = "refundfileUri";
        String splitfileUri = "splitfileUri";
        String orderType = String.valueOf(params.get("orderType"));
        //针对选择的文件类型不同对应不同的地址
        if (orderType.equals("pay")) {
            requestUri = payfileUri;
        } else if (orderType.equals("refund")) {
            requestUri = refundfileUri;
        } else if (orderType.equals("divide")) {
            requestUri = splitfileUri;
        } else if (orderType.equals("authentic")) {
            requestUri = authfileUri;
        }
        return yopClientService.yopPayApi(params, requestUri);
    }

    /**
     * 鉴权绑卡确认
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/auth/confirm")
    @ResponseBody
    BaseResponse paperorderAuthConfirm(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "authbindcardconfirmUri");
    }

    /**
     * 统一绑卡支付请求
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/unified/pay")
    @ResponseBody
    BaseResponse paperorderUnifiedPay(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "unibindcardpayUri");
    }


    /**
     * 统一首次支付请求
     *
     * @param params
     * @throws IOException
     */
    @PostMapping(value = "/rest/v1.0/paperorder/unified/firstpay")
    @ResponseBody
    BaseResponse paperorderUnifiedFirstpay(@RequestParam Map<String, String> params) {
        return yopClientService.yopPayApi(params, "unionfirstpayUri");
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

        params.put("customerNumber","11111111111");
        TransferSendRequest c = EntityUtils.mapToEntity(params, TransferSendRequest.class);
        System.out.println(c);

//        String uri = YopClient.getUrl("paymentURI");
//        Map<String, String> yopresponsemap = yopClient.yeepayYOP(params, uri);


//		request.setAttribute("yopresponsemap",yopresponsemap==null?"系统异常":yopresponsemap);
//		RequestDispatcher view	= request.getRequestDispatcher("/jsp/11paymentResponse.jsp");
//		view.forward(request, response);


    }


}


 
