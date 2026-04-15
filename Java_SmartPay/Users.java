package Java_SmartPay;

public class Users {
    private String customerId;
    private String customerName;
    private double previousMeterReading;
    private double currentMeterReading;

    public Users(String customerId, String customerName, double previousMeterReading, double currentMeterReading) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.previousMeterReading = previousMeterReading;
        this.currentMeterReading = currentMeterReading;
    }
    public String getCustomerId() {
        return customerId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getPreviousMeterReading() {
        return previousMeterReading;
    }
    public double getCurrentMeterReading() {
        return currentMeterReading;
    }
    public double getUnitsConsumed() {
        return currentMeterReading - previousMeterReading;
    }
    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + customerName + 
               ", Previous: " + previousMeterReading + ", Current: " + currentMeterReading;
    }
}
