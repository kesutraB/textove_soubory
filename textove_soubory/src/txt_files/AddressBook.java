package txt_files;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class AddressBook {

  static List<Contact> contacts = new ArrayList<>();

  public static void AddContact(File f) throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.println("ID-Jméno-Příjmení-Email-Telefon");
    String person = input.next();
    String[] contact = person.split("-");
    boolean duplicateId = false;
    for (Contact p : contacts) {
      if (p.ID.equals(contact[0])) {
        duplicateId = true;
        break;
      }
    }
    if (duplicateId) System.out.println("Nelze přidat kontakt se stejným ID!\n");
    else {
      contacts.add(new Contact(contact[0], contact[1], contact[2], contact[3], contact[4]));
      SaveContacts(f);
      System.out.println("Kontakt byl přidán.\n");
    }
  }

  public static void RemoveContact(File f) throws IOException {
    Scanner input = new Scanner(System.in);
    System.out.print("Zadej ID kontaktu, který chceš odebrat: ");
    String idToBeRemoved = input.next();
    contacts = contacts.stream().filter((p)->!p.ID.equals(idToBeRemoved)).collect(Collectors.toList());
    SaveContacts(f);
    System.out.println("Kontakt byl odebrán.\n");
  }

  public static void SaveContacts(File f) throws IOException {
    FileWriter fileWriter = new FileWriter(f, false);
    for (Contact p : contacts) {
      fileWriter.write(p.toString() + "\n");
    }
    fileWriter.close();
  }

  public static void PrintSavedContacts(File f) throws FileNotFoundException {
    if (f.exists()) {
      Scanner fileReader = new Scanner(f);
      while (fileReader.hasNextLine()) {
        System.out.println(fileReader.nextLine());
      }
      System.out.println();
    }
    else System.out.println("Žádné kontakty k výpisu.\n");
  }

  public static void LoadSavedContacts(File f) throws FileNotFoundException {
    Scanner fileReader = new Scanner(f);
    while (fileReader.hasNextLine()) {
      contacts.add(new Contact(fileReader.nextLine()));
    }
  }
}
