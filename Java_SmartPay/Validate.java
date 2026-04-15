package Java_SmartPay;

public class Validate {
    public static boolean validateMeterReadings(double previousReading, double currentReading) {
        if (previousReading > currentReading) {
            System.err.println("❌ ERROR: Previous meter reading (" + previousReading + 
                             ") cannot be higher than current meter reading (" + currentReading + ")");
            return false;
        }
        if (previousReading == currentReading) {
            System.err.println("❌ ERROR: No units consumed. Readings are the same.");
            return false;
        }
        if (previousReading < 0 || currentReading < 0) {
            System.err.println("❌ ERROR: Meter readings cannot be negative.");
            return false;
        }
        return true;
    }
    public static boolean validateCustomerName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.err.println("❌ ERROR: Customer name cannot be empty.");
            return false;
        }
        return true;
    }
    public static boolean validateCustomerId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.err.println("❌ ERROR: Customer ID cannot be empty.");
            return false;
        }
        return true;
    }
    public static double parseDouble(String input) {
        try {
            double value = Double.parseDouble(input.trim());
            if (value < 0) {
                System.err.println("❌ ERROR: Value cannot be negative.");
                return -1;
            }
            return value;
        } catch (NumberFormatException e) {
            System.err.println("❌ ERROR: Invalid number format.");
            return -1;
        }
    }
}
