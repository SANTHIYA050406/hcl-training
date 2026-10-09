
package app;

import model.*;
import service.PaymentService;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        Payment card = new CardPayment(1500, "1234567812345678");
        Payment upi = new UPIPayment(500, "santhiya@upi");
        Payment cash = new CashPayment(200);

        service.pay(card);
        service.pay(upi, "TXN-UPI-101");
        service.pay(cash);

        if (card instanceof Refundable) {
            ((Refundable) card).refund(300);
        }

        if (upi instanceof Refundable) {
            ((Refundable) upi).refund(100);
        }
    }
}