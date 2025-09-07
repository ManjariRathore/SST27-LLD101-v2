package com.example.video;

public class SharpenAdapter {
  
  private final LegacySharpen legacy = new LegacySharpen();

  public void sharpen(Frame[] frames, int strength) {
    //doubtful about "handle"
    int handleValue = frames.length * (frames.length > 0 ? frames[0].w : 1);
    String handle = "HANDLE:" + handleValue;
    legacy.applySharpen(handle, strength);
    System.out.println("Sharpen applied via adapter");
  }
}
