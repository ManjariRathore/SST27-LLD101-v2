package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class AppSettings implements Serializable {
    private final Properties props = new Properties();

    // private constructor that handles reflection attacks and prevents creating multiple instances
    private AppSettings() {
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("trying to create second instance using reflection, illegal move");
        }
    }

    //inner class design pattern
    private static class Holder{
        static final AppSettings INSTANCE = new AppSettings();
    }
    public static AppSettings getInstance() {
        return Holder.INSTANCE;
    }

    //using readResolve to preserve singleton property during deserialization and returning the same instance
    protected Object readResolve() {
        return getInstance();
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
