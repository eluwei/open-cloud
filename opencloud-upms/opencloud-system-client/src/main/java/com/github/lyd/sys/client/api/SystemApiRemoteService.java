package com.github.lyd.sys.client.api;

import com.github.lyd.common.model.PageList;
import com.github.lyd.common.model.ResultBody;
import com.github.lyd.sys.client.entity.SystemApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface SystemApiRemoteService {
    /**
     * 获取Api资源列表
     *
     * @return
     */
    @PostMapping("/apis")
    ResultBody<PageList<SystemApi>> apis(
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit,
            @RequestParam(name = "keyword", required = false) String keyword
    );


    /**
     * 获取Api资源
     *
     * @param apiId apiId
     * @return 应用信息
     */
    @GetMapping("/apis/{apiId}")
    ResultBody<SystemApi> getApi(@PathVariable("apiId") Long apiId);

    /**
     * 添加Api资源
     *
     * @param apiCode     Api编码
     * @param apiName     Api名称
     * @param serviceId   服务ID
     * @param url         请求路径
     * @param enabled     是否启用
     * @param priority    优先级越小越靠前
     * @param apiDesc 描述
     * @return
     */
    @PostMapping("/apis/add")
    ResultBody<Boolean> addApi(
            @RequestParam(value = "apiCode") String apiCode,
            @RequestParam(value = "apiName") String apiName,
            @RequestParam(value = "serviceId") String serviceId,
            @RequestParam(value = "url", required = false, defaultValue = "") String url,
            @RequestParam(value = "enabled", defaultValue = "true") Boolean enabled,
            @RequestParam(value = "priority", required = false, defaultValue = "0") Integer priority,
            @RequestParam(value = "apiDesc", required = false, defaultValue = "") String apiDesc
    );

    /**
     * 编辑Api资源
     *
     * @param apiId       ApiID
     * @param apiCode     Api编码
     * @param apiName     Api名称
     * @param serviceId   服务ID
     * @param url         请求路径
     * @param enabled     是否启用
     * @param priority    优先级越小越靠前
     * @param apiDesc 描述
     * @return
     */
    @PostMapping("/apis/update")
    ResultBody<Boolean> updateApi(
            @RequestParam("apiId") Long apiId,
            @RequestParam(value = "apiCode") String apiCode,
            @RequestParam(value = "apiName") String apiName,
            @RequestParam(value = "serviceId") String serviceId,
            @RequestParam(value = "url", required = false, defaultValue = "") String url,
            @RequestParam(value = "enabled", defaultValue = "true") Boolean enabled,
            @RequestParam(value = "priority", required = false, defaultValue = "0") Integer priority,
            @RequestParam(value = "apiDesc", required = false, defaultValue = "") String apiDesc
    );

    /**
     * 禁用Api资源
     *
     * @param apiId ApiID
     * @return
     */
    @PostMapping("/apis/disable")
    ResultBody<Boolean> disableApi(
            @RequestParam("apiId") Long apiId
    );

    /**
     * 启用Api资源
     *
     * @param apiId ApiID
     * @return
     */
    @PostMapping("/apis/enable")
    ResultBody<Boolean> enableApi(
            @RequestParam("apiId") Long apiId
    );

    /**
     * 移除Api
     *
     * @param apiId ApiID
     * @return
     */
    @PostMapping("/apis/remove")
    ResultBody<Boolean> removeApi(
            @RequestParam("apiId") Long apiId
    );
}
