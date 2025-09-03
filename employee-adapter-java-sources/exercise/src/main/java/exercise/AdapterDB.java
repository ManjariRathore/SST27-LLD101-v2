package exercise;

public class AdapterDB implements Employee {
  EmployeeDB EDB ;

  @Override
  public String getId() {
    return String.valueOf(EDB.getId());
  }

  @Override
  public String getFirstName() {
    return EDB.getFirstName();
  }

  @Override
  public String getLastName() {
    return EDB.getSurname();
  }

  @Override
  public String getEmail() {
    return EDB.getEmailAddress();
  }
  
}
