package exercise;

public class AdapterLDAP implements Employee  {
  EmployeeLDAP ELDAP;
  @Override
  public String getId() {
    return ELDAP.get("uid");
  }

  @Override
  public String getFirstName() {
    
    return ELDAP.get("givenName");
  }

  @Override
  public String getLastName() {
    return ELDAP.get("sn");
  }

  @Override
  public String getEmail() {
    return ELDAP.get("mail");
  }
  
}
