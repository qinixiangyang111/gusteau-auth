package net.xinhuamm.auth.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @program: gusteau-auth
 * @description: feign接口
 * @author: qinxiangyang
 * @create: 2020-06-08 17:46
 **/
@FeignClient(name = "auth")
public interface IAuthApiService {

}