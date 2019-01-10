package com.ald.xxlJob.client.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

/**
 * @program: xxl-job
 * @Version 1.0.0
 * @description:
 * @author: Mr.cai
 * @create: 2019-01-10 11:10
 * @CopyRight 本内容仅限于北境内部传阅，禁止外泄以及用于其他的商业目的
 **/
@JobHandler(value = "testJobHand")
@Component
public class TestJobHandler extends IJobHandler {
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.println("执行running" + param);
        SUCCESS.setMsg("执行成功");
        return SUCCESS;
    }

}


 
