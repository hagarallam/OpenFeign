package com.example.restconsume2.controller;
import com.example.restconsume2.OpenFeign.Payment;
import com.example.restconsume2.OpenFeign.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class PaymentController {

    private PaymentProxy paymentProxy;

    @Autowired
    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/processPayment")
    public Payment makePayment(@RequestBody Payment payment){
        return paymentProxy.makePaymentUsingRest(payment);
    }
}
