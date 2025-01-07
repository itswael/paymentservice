package com.waelsworld.paymentservice.paymentgateways;

import com.stripe.exception.StripeException;
import com.waelsworld.paymentservice.dtos.InitiatePaymentRequestDto;

public interface PaymentGateway {
    String generatePaymentUrl(InitiatePaymentRequestDto paymentRequestDto) throws StripeException;
}
