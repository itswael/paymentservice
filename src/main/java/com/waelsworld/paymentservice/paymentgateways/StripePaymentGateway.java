package com.waelsworld.paymentservice.paymentgateways;

public class StripePaymentGateway implements PaymentGateway {
    @Override
    public String generatePaymentUrl() {
        return "https://stripe.com";
    }
}
