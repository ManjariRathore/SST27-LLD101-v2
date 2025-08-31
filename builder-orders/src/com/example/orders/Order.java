package com.example.orders;
import java.util.ArrayList;
import java.util.List;

//Made Order externally immutable (no setters, unmodifiable lines, defensive copy of lines).
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines = new ArrayList<>();
    private final Integer discountPercent; // 0..100 expected and enforced
    private final boolean expedited;
    private final String notes;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines.addAll(builder.lines);
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
    }

    public static class Builder {
        private String id;
        private String customerEmail;
        private List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail, List<OrderLine> lines) {
            this.id = id;
            this.customerEmail = customerEmail;
            this.lines.addAll(lines);
        }

        public Builder addLine(OrderLine line) {
            this.lines.add(line);
            return this;
        }

        public Builder setDiscountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder setExpedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder setNotes(String notes) {
            this.notes = notes;
            return this;
        }

        //Introduced Order.Builder with required id, customerEmail, and at least one line.
        //Validated email format, discount range 0-100, non-empty lines; centralize in build().
        public Order build() {
            PricingRules.isValidEmail(customerEmail);
            PricingRules.isValidDiscount(discountPercent);
            if (lines.isEmpty()) throw new IllegalArgumentException("Order does not contain any items");
            return new Order(this);
        }
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return new ArrayList<>(lines); } // deepcopy
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }
}
