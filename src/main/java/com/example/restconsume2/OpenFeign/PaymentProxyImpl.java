package com.example.restconsume2.OpenFeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Component
public class PaymentProxyImpl implements PaymentProxy{

    private RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String URL;

    public PaymentProxyImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Payment makePaymentUsingRest(Payment payment) {
        String fullUrl = URL+"/makePayment";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());
        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment,httpHeaders);
        ResponseEntity<Payment> responseEntity =
        restTemplate.exchange(fullUrl, HttpMethod.POST,httpEntity,Payment.class);
        return responseEntity.getBody();
    }
}
