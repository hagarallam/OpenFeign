package com.example.restconsume2.OpenFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

//@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {
//    @PostMapping("/makePayment")
//    Payment makePayment(@RequestHeader String requestId, @RequestBody Payment payment);
    Payment makePaymentUsingRest(Payment payment);
}
