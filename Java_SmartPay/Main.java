package Java_SmartPay;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private static SmartPay smartPay;
    private static Scanner scanner;

    public static void main(String[] args) {
        smartPay = new SmartPay();
        scanner = new Scanner(System.in);

        displayWelcomeBanner();
        while (true) {
            displayMainMenu();
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("EXIT")) {
                exitApplication();
                break;
            }

            switch (choice) {
                case "1":
                    generateNewBill();
                    break;
                case "2":
                    viewAllBills();
                    break;
                case "3":
                    searchBillsByCustomer();
                    break;
                case "4":
                    displayStatistics();
                    break;
                default:
                    System.out.println("⚠️  Invalid choice! Please try again.\n");
            }
        }
    }
    private static void displayWelcomeBanner() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("     ╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("     ║                                                               ║");
        System.out.println("     ║          💰 SMARTPAY - UTILITY BILL GENERATOR 💰              ║");
        System.out.println("     ║                                                               ║");
        System.out.println("     ║   Progressive Billing System for Electricity & Water          ║");
        System.out.println("     ║                                                               ║");
        System.out.println("     ╚═══════════════════════════════════════════════════════════════╝");
        System.out.println("=".repeat(80) + "\n");
    }
    private static void displayMainMenu() {
        System.out.println("📋 MAIN MENU");
        System.out.println("─".repeat(40));
        System.out.println("1. Generate New Bill");
        System.out.println("2. View All Bills");
        System.out.println("3. Search Bills by Customer");
        System.out.println("4. View Statistics");
        System.out.println("EXIT. Exit Application");
        System.out.println("─".repeat(40));
        System.out.print("Enter your choice: ");
    }
    private static void generateNewBill() {
        System.out.println("\n📝 GENERATE NEW BILL");
        System.out.println("─".repeat(40));

        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine().trim();

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("Enter Previous Meter Reading: ");
        String prevReadingStr = scanner.nextLine().trim();
        double previousReading = Validate.parseDouble(prevReadingStr);
        if (previousReading == -1) {
            System.out.println();
            return;
        }

        System.out.print("Enter Current Meter Reading: ");
        String currReadingStr = scanner.nextLine().trim();
        double currentReading = Validate.parseDouble(currReadingStr);
        if (currentReading == -1) {
            System.out.println();
            return;
        }

        Billing bill = smartPay.createBill(customerId, customerName, previousReading, currentReading);
        if (bill != null) {
            displayReceipt(bill);
        }
        System.out.println();
    }
    private static void displayReceipt(Billing bill) {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("  ✓ DIGITAL RECEIPT - SmartPay Utility Billing System");
        System.out.println("═".repeat(60));
        System.out.println("Bill ID: " + bill.getBillId());
        System.out.println("Bill Date: " + bill.getBillDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("─".repeat(60));
        System.out.println("Customer Information:");
        System.out.println("  Name: " + bill.getCustomer().getCustomerName());
        System.out.println("  ID: " + bill.getCustomer().getCustomerId());
        System.out.println("─".repeat(60));
        System.out.println("Meter Reading:");
        System.out.printf("  Previous Reading: %.2f units%n", bill.getCustomer().getPreviousMeterReading());
        System.out.printf("  Current Reading:  %.2f units%n", bill.getCustomer().getCurrentMeterReading());
        System.out.printf("  Units Consumed:   %.2f units%n", bill.getUnitsConsumed());
        System.out.println("─".repeat(60));
        System.out.println("Billing Breakdown (Progressive Tax Slabs):");
        System.out.println("  • Slab 1 (0-100 units):    $1.00 per unit");
        System.out.println("  • Slab 2 (101-300 units):  $2.00 per unit");
        System.out.println("  • Slab 3 (300+ units):     $5.00 per unit");
        System.out.println("─".repeat(60));
        System.out.printf("Base Amount (before tax): $%.2f%n", bill.getBaseAmount());
        System.out.printf("Tax Amount (10%%):          $%.2f%n", bill.getTaxAmount());
        System.out.println("═".repeat(60));
        System.out.printf("TOTAL AMOUNT DUE:           $%.2f%n", bill.calculateTotal());
        System.out.println("═".repeat(60) + "\n");
    }
    private static void viewAllBills() {
        System.out.println();
        smartPay.displayAllBillsSummary();
    }
    private static void searchBillsByCustomer() {
        System.out.println("\n🔍 SEARCH BILLS BY CUSTOMER");
        System.out.println("─".repeat(40));
        System.out.print("Enter Customer Name to search: ");
        String customerName = scanner.nextLine().trim();

        java.util.List<Billing> bills = smartPay.getBillsByCustomer(customerName);

        if (bills.isEmpty()) {
            System.out.println("⚠️  No bills found for customer: " + customerName);
        } else {
            System.out.println("\n📋 Bills for " + customerName + ":");
            System.out.println("─".repeat(60));
            System.out.printf("%-15s %-12s %-12s %-12s%n", "Bill ID", "Units", "Amount", "Date");
            System.out.println("-".repeat(60));

            double totalAmount = 0;
            for (Billing bill : bills) {
                System.out.printf("%-15s %-12.2f $%-11.2f %s%n",
                        bill.getBillId(),
                        bill.getUnitsConsumed(),
                        bill.calculateTotal(),
                        bill.getBillDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                totalAmount += bill.calculateTotal();
            }
            System.out.println("-".repeat(60));
            System.out.printf("Total Bills: %d | Total Amount: $%.2f%n", bills.size(), totalAmount);
            System.out.println("─".repeat(60));
        }
        System.out.println();
    }
    private static void displayStatistics() {
        System.out.println("\n" + "═".repeat(60));
        System.out.println("  📊 SYSTEM STATISTICS");
        System.out.println("═".repeat(60));

        int totalBills = smartPay.getTotalBillsCount();
        if (totalBills == 0) {
            System.out.println("⚠️  No bills generated yet.");
        } else {
            double totalRevenue = smartPay.getTotalRevenue();
            double averageBill = smartPay.getAverageBillAmount();
            double totalUnits = smartPay.getTotalUnitsConsumed();

            System.out.printf("Total Bills Generated:  %d%n", totalBills);
            System.out.printf("Total Revenue:          $%.2f%n", totalRevenue);
            System.out.printf("Average Bill Amount:    $%.2f%n", averageBill);
            System.out.printf("Total Units Consumed:   %.2f units%n", totalUnits);
        }
        System.out.println("═".repeat(60) + "\n");
    }
    private static void exitApplication() {
        System.out.println("\n👋 Thank you for using SmartPay! Goodbye!");
        System.out.println("═".repeat(60));
        scanner.close();
    }
}
