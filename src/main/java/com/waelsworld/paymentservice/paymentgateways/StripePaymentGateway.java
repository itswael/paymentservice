package com.waelsworld.paymentservice.paymentgateways;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.waelsworld.paymentservice.dtos.InitiatePaymentRequestDto;
import lombok.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGateway {
    @Override
    public String generatePaymentUrl(InitiatePaymentRequestDto requestDto) throws StripeException {
        // apikey should be stored in a secure location or environment variable
        Stripe.apiKey = "sk_test_51QeglV2fGiVOBftsUNayU386Q02C3VGBhYqOIgCPAmrJYxegukn7zfTMCletOfEZeZj0wmbnqG6TSo6nZBtwpFyK00QHkBQBns";
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl("http://localhost:4242/success")
                        .setCancelUrl("http://localhost:4242/cancel")
                        .addLineItem(
                                SessionCreateParams.LineItem.builder()
                                        .setQuantity(requestDto.getQuantity())
                                        .setPriceData(
                                                SessionCreateParams.LineItem.PriceData.builder()
                                                        .setCurrency(requestDto.getCurrency())
                                                        .setUnitAmount(requestDto.getUnitAmount())
                                                        .setProductData(
                                                                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                        .setName(requestDto.getName())
                                                                        .build())
                                                        .build())
                                        .build())
                        .build();

        Session session = Session.create(params);
        //response.redirect(session.getUrl(), 303);

        return session.getUrl();
    }
}
