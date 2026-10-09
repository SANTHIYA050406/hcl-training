
package model;

public class cd C:\Users\Lenovo\IdeaProjects\java1
git status
git add DailyTasks/day05/payment-hierarchy
git commit -m "Add Day 05 payment hierarchy"
git push origin masterUPIPayment extends Payment implements Refundable {
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