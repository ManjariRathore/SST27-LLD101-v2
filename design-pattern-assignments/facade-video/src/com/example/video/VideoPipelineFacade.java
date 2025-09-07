package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
  private final Decoder dec = new Decoder();
  private final FilterEngine fe = new FilterEngine();
  private final Encoder enc = new Encoder();
  private final SharpenAdapter sharpen = new SharpenAdapter();

  public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {

    Frame[] frames = dec.decode(src);
    
    if (gray) frames = fe.grayscale(frames);
    if (scale != null) frames = fe.scale(frames, scale);
    if (sharpenStrength != null) sharpen.sharpen(frames, sharpenStrength);

    return enc.encode(frames, out);
  }

}
