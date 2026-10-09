
package model;

public class CardPayment extends Payment implements Refundable {
    private final String cardNumber;

    public CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    public void processPayment() {
        System.out.println("Card payment: Rs. " + amount
                + " using card ending "
                + cardNumber.substring(cardNumber.length() - 4));
    }

    @Override
    public void refund(double refundAmount) {
        validateRefund(refundAmount);
        System.out.println("Card refund processed: Rs. "
                + refundAmount);
    }

    private void validateRefund(double refundAmount) {
        if (!Double.isFinite(refundAmount)
                || refundAmount <= 0
                || refundAmount > amount) {
            throw new IllegalArgumentException("Invalid refund amount");
        }
    }
}