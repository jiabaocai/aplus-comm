package com.ald.news.user.client;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author lianweiyue
 * @DATE 2018/1/18
 * 用来调用应用news-content的接口
 */
@FeignClient("news-xxx")
public interface ContentService {

//    @RequestMapping(value = "/content/user/news",method = RequestMethod.POST)
//    BaseResponse<List<ContentDo>> getUserNewsList(@RequestParam("newsId") List<Long> newsId);
}
