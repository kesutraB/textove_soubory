package txt_files;

public class Contact {
  protected String ID;
  protected String FirstName;
  protected String LastName;
  protected String Email;
  protected String PhoneNumber;

  public Contact(String id, String firstName, String lastName, String email, String phoneNumber) {
    this.ID = id;
    this.FirstName = firstName;
    this.LastName = lastName;
    this.Email = email;
    this.PhoneNumber = phoneNumber;
  }

  public Contact(String line) {
    String[] contact = line.split("-");
    this.ID = contact[0];
    this.FirstName = contact[1];
    this.LastName = contact[2];
    this.Email = contact[3];
    this.PhoneNumber = contact[4];
  }

  public String toString() {
    return this.ID + "-" + this.FirstName + "-" + this.LastName + "-" + this.Email + "-" + this.PhoneNumber;
  }
}

