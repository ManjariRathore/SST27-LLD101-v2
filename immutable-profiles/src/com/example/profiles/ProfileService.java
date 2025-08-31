package com.example.profiles;

// Updated ProfileService to stop mutating after creation.
public class ProfileService {

    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    public UserProfile createFull(String id, String email, String ph, String name,
            String add, boolean OptIn, String twitter, String github) {
        return new UserProfile.Builder(id, email)
                .setPhone(ph)
                .setDisplayName(name)
                .setAddress(add)
                .setMarketingOptIn(OptIn)
                .setTwitter(twitter)
                .setGithub(github)
                .build();
    }
}
