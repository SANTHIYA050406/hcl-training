
package model;

public class UPIPayment extends Payment implements Refundable {
    private final String upiId;

    public UPIPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    public void processPayment() {
        System.out.println("UPI payment: Rs. " + amount
                + " from " + upiId);
    }

    @Override
    public void refund(double refundAmount) {
        if (!Double.isFinite(refundAmount)
                || refundAmount <= 0
                || refundAmount > amount) {
            throw new IllegalArgumentException("Invalid refund amount");
        }
        System.out.println("UPI refund processed: Rs. "
                + refundAmount);
    }
}