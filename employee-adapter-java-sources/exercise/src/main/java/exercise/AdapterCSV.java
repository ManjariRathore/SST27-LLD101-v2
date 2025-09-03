package exercise;

public class AdapterCSV implements Employee {
  EmployeeCSV ECSV;
  @Override
  public String getId() {
    return ECSV.tokens()[0];
  }
  
  @Override
  public String getFirstName() {
    return ECSV.tokens()[1];
  }

  @Override
  public String getLastName() {
    return ECSV.tokens()[2];
  }

  @Override
  public String getEmail() {
    return ECSV.tokens()[3];
  }
  
}
