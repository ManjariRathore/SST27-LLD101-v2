package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class ReportBundleFacade {
  private final JsonWriter writer = new JsonWriter();
  private final Zipper zipper = new Zipper();
  private final AuditLog log = new AuditLog();

  public Path generateReportBundle(Map<String, Object> data, Path outDir, String baseFileName) {
    try {
      // Write JSON file
      Path json = writer.write(data, outDir, baseFileName);
      // Create ZIP of the JSON file
      Path zip = zipper.zip(json, outDir.resolve(baseFileName + ".zip"));
      // Audit the export
      log.log("exported " + zip);
      // Return path to the ZIP file
      return zip;
    } catch (Exception e) {
      throw new RuntimeException("Failed to generate report bundle", e);
    }
    
  }
}
