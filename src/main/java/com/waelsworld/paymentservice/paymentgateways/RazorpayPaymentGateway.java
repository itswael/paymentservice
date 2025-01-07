package com.waelsworld.paymentservice.paymentgateways;

public class RazorpayPaymentGateway implements PaymentGateway {
    @Override
    public String generatePaymentUrl() {
        return "https://razorpay.com";
    }
}
