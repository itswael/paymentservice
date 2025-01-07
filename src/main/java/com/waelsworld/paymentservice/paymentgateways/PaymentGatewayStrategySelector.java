package com.waelsworld.paymentservice.paymentgateways;

public class PaymentGatewayStrategySelector {
    private final RazorpayPaymentGateway razorpayPaymentGateway;
    private final StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayStrategySelector(RazorpayPaymentGateway razorpayPaymentGateway,
                                          StripePaymentGateway stripePaymentGateway) {
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGateway getPaymentGateway(String paymentGateway) {
        // there can be various parameters to select the payment gateway
        // like number of successful transactions, amount of transaction, etc.
        // for now, we are just using a string
        if (paymentGateway.equals("razorpay")) {
            return razorpayPaymentGateway;
        } else if (paymentGateway.equals("stripe")) {
            return stripePaymentGateway;
        } else {
            throw new IllegalArgumentException("Invalid payment gateway");
        }
    }
}
