package com.example.profiles;

public class UserProfile {

    // Refactored UserProfile to immutable, all fields are private and final with no setters.
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    // private constructor to enforce object creation through Builder pattern
    private UserProfile(Builder Builder) {
        this.id = Builder.id;
        this.email = Builder.email;
        this.phone = Builder.phone;
        this.displayName = Builder.displayName;
        this.address = Builder.address;
        this.marketingOptIn = Builder.marketingOptIn;
        this.twitter = Builder.twitter;
        this.github = Builder.github;
    }

    // Builder static inner class
    public static class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn;
        private String twitter;
        private String github;

        // minimal constructor
        public Builder(String id, String email) {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);
            this.id = id;
            this.email = email;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setDisplayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setMarketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public Builder setTwitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public Builder setGithub(String github) {
            this.github = github;
            return this;
        }

        // Centralize validation in Builder.build() using Validation helpers.
        public UserProfile build() {
            Validation.requireNonBlank(id, "id");
            Validation.requireEmail(email);
            if (displayName != null && displayName.length() > 100) {
                displayName = displayName.substring(0, 100);
            }
            return new UserProfile(this);
        }
    }

    // getters
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAddress() {
        return address;
    }

    public boolean isMarketingOptIn() {
        return marketingOptIn;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getGithub() {
        return github;
    }
}
