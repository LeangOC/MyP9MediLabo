package com.p9oc.client.proxies;

import com.p9oc.client.beans.RiskBean;
import com.p9oc.client.security.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "risk-service", url = "http://localhost:8081")

public interface RiskProxy {
    @GetMapping("/api/risk/patient/{id}")
    RiskBean getRisk(@PathVariable("id") Integer id);
}
