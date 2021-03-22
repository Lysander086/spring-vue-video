package com.example.business.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "github-client",
        url = "https://api.github.com",
        configuration = GitHubExampleConfig.class,
        fallback = GitHubClient.DefaultFallback.class)
public interface GitHubClient {
    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);

    /**
     * 容错处理类，当调用失败时，简单返回空字符串
     */
    @Component
    public class DefaultFallback implements GitHubClient {
        @Override
        public String searchRepo(@RequestParam("q") String queryStr) {
            return "";
        }
    }
}