package com.hz.authority.management.sys.aspect;

import com.hz.authority.management.sys.constant.ResultCode;
import com.hz.authority.management.sys.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 李号东
 * @Description 权限不足处理类 返回403
 * @Date 00:31 2019-03-17
 * @Param
 * @return
 **/
@Slf4j
@Component("RestAuthenticationAccessDeniedHandler")
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException {
        StringBuilder msg = new StringBuilder("请求: ").append(httpServletRequest.getRequestURI()).append(" 权限不足，无法访问系统资源.");
        log.info(msg.toString());
        ResultUtil.writeJavaScript(httpServletResponse, ResultCode.REQ_REJECT, msg.toString());
    }
}