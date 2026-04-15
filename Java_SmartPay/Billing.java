package Java_SmartPay;

import java.time.LocalDateTime;

public class Billing {
    private String billId;
    private Users customer;
    private double unitsConsumed;
    private double baseAmount;
    private double taxAmount;
    private double totalAmount;
    private LocalDateTime billDate;
    private static final double SLAB_1_LIMIT = 100;
    private static final double SLAB_2_LIMIT = 300;
    private static final double SLAB_1_RATE = 1.00;    // 0-100 units
    private static final double SLAB_2_RATE = 2.00;    // 101-300 units
    private static final double SLAB_3_RATE = 5.00;    // 300+ units
    private static final double TAX_PERCENTAGE = 0.10; // 10% tax

    public Billing(String billId, Users customer) {
        this.billId = billId;
        this.customer = customer;
        this.unitsConsumed = customer.getUnitsConsumed();
        this.billDate = LocalDateTime.now();
        calculateBill();
    }
    private void calculateBill() {
        if (unitsConsumed <= SLAB_1_LIMIT) {
            this.baseAmount = unitsConsumed * SLAB_1_RATE;
        } else if (unitsConsumed <= SLAB_2_LIMIT) {
            double slab1Units = SLAB_1_LIMIT;
            double slab2Units = unitsConsumed - SLAB_1_LIMIT;
            this.baseAmount = (slab1Units * SLAB_1_RATE) + (slab2Units * SLAB_2_RATE);
        } else {
            double slab1Units = SLAB_1_LIMIT;
            double slab2Units = SLAB_2_LIMIT - SLAB_1_LIMIT;
            double slab3Units = unitsConsumed - SLAB_2_LIMIT;
            this.baseAmount = (slab1Units * SLAB_1_RATE) + (slab2Units * SLAB_2_RATE) + (slab3Units * SLAB_3_RATE);
        }
        this.taxAmount = baseAmount * TAX_PERCENTAGE;
        this.totalAmount = baseAmount + taxAmount;
    }
    public double calculateTotal() {
        return totalAmount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }
    public double getBaseAmount() {
        return baseAmount;
    }
    public String getBillId() {
        return billId;
    }
    public Users getCustomer() {
        return customer;
    }
    public double getUnitsConsumed() {
        return unitsConsumed;
    }
    public LocalDateTime getBillDate() {
        return billDate;
    }
    @Override
    public String toString() {
        return "Bill{" + "billId='" + billId + "', customer='" + customer.getCustomerName() + 
               "', units=" + unitsConsumed + ", total=$" + String.format("%.2f", totalAmount) + "}";
    }
}
