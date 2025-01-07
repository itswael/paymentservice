package com.waelsworld.paymentservice.controllers;

import com.stripe.exception.StripeException;
import com.waelsworld.paymentservice.dtos.InitiatePaymentRequestDto;
import com.waelsworld.paymentservice.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public ResponseEntity<String> initiatePayment(@RequestBody InitiatePaymentRequestDto request) {
        try {
            return ResponseEntity.ok(paymentService.initiatePayment(request));
        } catch (StripeException e) {
            //PaymentserviceApplication.logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
