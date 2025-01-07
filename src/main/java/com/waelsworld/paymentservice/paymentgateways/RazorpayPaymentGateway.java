package com.waelsworld.paymentservice.paymentgateways;

import com.waelsworld.paymentservice.dtos.InitiatePaymentRequestDto;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String generatePaymentUrl(InitiatePaymentRequestDto paymentRequestDto) {
        return "https://razorpay.com";
    }
}
