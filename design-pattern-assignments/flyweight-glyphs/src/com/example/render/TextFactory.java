package com.example.render;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextFactory {
    private final Map<String, TextStyle> cache = new ConcurrentHashMap<>();

    public TextStyle getStyle(String font, int size, boolean bold) {
        String key = font+"|" + size +"|"+ (bold ? "B" : "N");
        return cache.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }
}
