package com.example.orders;

public final class PricingRules {
    private PricingRules() {}
    public static Boolean isValidEmail(String email) { return email != null && email.contains("@"); }
    public static Boolean isValidDiscount(Integer d) { return d == null || (d >= 0 && d <= 100); }
}