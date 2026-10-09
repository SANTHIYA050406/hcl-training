
package service;

import model.Payment;

public class PaymentService {

    public void pay(Payment payment) {
        payment.processPayment();
    }

    public void pay(Payment payment, String reference) {
        System.out.println("Reference: " + reference);
        payment.processPayment();
    }
}