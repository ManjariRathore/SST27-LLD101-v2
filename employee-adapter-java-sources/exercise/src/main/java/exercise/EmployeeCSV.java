package exercise;

import java.util.Objects;

public final class EmployeeCSV {
  
  private final String csvRow;
  private final String[] tokens;

  public EmployeeCSV(String csvRow) {
    this.csvRow = Objects.requireNonNull(csvRow);
    this.tokens = csvRow.split("\\s*,\\s*");
  }
  public String getCsvRow() { return csvRow; }
  public String[] tokens() { return tokens; }
}
