package Java_SmartPay;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SmartPay {
    private List<Billing> bills;
    private int billCounter = 1000;

    public SmartPay() {
        this.bills = new ArrayList<>();
    }
    public Billing createBill(String customerId, String customerName, double previousReading, double currentReading) {
        if (!Validate.validateCustomerId(customerId)) return null;
        if (!Validate.validateCustomerName(customerName)) return null;
        if (!Validate.validateMeterReadings(previousReading, currentReading)) return null;
        Users customer = new Users(customerId, customerName, previousReading, currentReading);
        String billId = "BILL-" + (++billCounter);
        Billing bill = new Billing(billId, customer);
        bills.add(bill);
        return bill;
    }
    public List<Billing> getAllBills() {
        return new ArrayList<>(bills);
    }
    public List<Billing> getBillsByCustomer(String customerName) {
        List<Billing> result = new ArrayList<>();
        for (Billing bill : bills) {
            if (bill.getCustomer().getCustomerName().equalsIgnoreCase(customerName)) {
                result.add(bill);
            }
        }
        return result;
    }
    public double getTotalRevenue() {
        double total = 0;
        for (Billing bill : bills) {
            total += bill.calculateTotal();
        }
        return total;
    }
    public double getAverageBillAmount() {
        if (bills.isEmpty()) {
            return 0;
        }
        return getTotalRevenue() / bills.size();
    }
    public double getTotalUnitsConsumed() {
        double total = 0;
        for (Billing bill : bills) {
            total += bill.getUnitsConsumed();
        }
        return total;
    }
    public int getTotalBillsCount() {
        return bills.size();
    }
    public void displayAllBillsSummary() {
        if (bills.isEmpty()) {
            System.out.println("📋 No bills generated yet.\n");
            return;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("📊 ALL BILLS SUMMARY");
        System.out.println("=".repeat(80));
        System.out.printf("%-15s %-20s %-12s %-12s %-12s%n", "Bill ID", "Customer Name", "Units", "Amount", "Date");
        System.out.println("-".repeat(80));

        for (Billing bill : bills) {
            System.out.printf("%-15s %-20s %-12.2f $%-11.2f %s%n",
                    bill.getBillId(),
                    bill.getCustomer().getCustomerName(),
                    bill.getUnitsConsumed(),
                    bill.calculateTotal(),
                    bill.getBillDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        }
        System.out.println("=".repeat(80));
        System.out.printf("Total Bills: %d | Total Revenue: $%.2f | Average Bill: $%.2f | Total Units: %.2f%n",
                getTotalBillsCount(), getTotalRevenue(), getAverageBillAmount(), getTotalUnitsConsumed());
        System.out.println("=".repeat(80) + "\n");
    }
}
