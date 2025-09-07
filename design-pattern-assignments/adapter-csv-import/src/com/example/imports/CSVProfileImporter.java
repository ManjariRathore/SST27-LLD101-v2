package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CSVProfileImporter implements ProfileImporter {
  private final NaiveCsvReader reader;
  private final ProfileService service;

  public CSVProfileImporter(NaiveCsvReader reader, ProfileService service) {
    this.reader = reader;
    this.service = service;
  }

  public int importFrom(Path csvFile) {
    List<String[]> rows = reader.read(csvFile);
    int count = 0;
    if (rows.isEmpty())
      return 0;

    // assume first row is header and skip it
    for (int i = 1; i < rows.size(); i++) {
      String[] row = rows.get(i);

      if (row.length < 2) {
        System.out.println("Invalid row skipped: not enough columns");
        continue;
      }

      String id = row[0].trim();
      String email = row[1].trim();
      String displayName = row[2].trim();

      try {
        service.createProfile(id, email, displayName);
        count++;
      } catch (Exception e) {
        System.out.println("Invalid row skipped: " + e.getMessage());
      }
    }
    
    return count;
  }
}
