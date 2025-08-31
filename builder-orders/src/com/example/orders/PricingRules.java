package com.example.orders;

public final class PricingRules {
    private PricingRules() {
    }

    public static void isValidEmail(String email) {
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("Invalid email -_- ");
    }

    public static void isValidDiscount(Integer d) {
        if (d != null && (d < 0 || d > 100))
            throw new IllegalArgumentException("Discount must be between 0 and 100, Stupid!");
    }
}
