package txt_files;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    File file = new File(args[0]);
    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.println("1-Vypsat uložené kontakty, 2-Přidat kontakt, 3-Odebrat kontakt, 4-Ukončit program");
      System.out.print("Zadej akci, kterou chceš provést: ");
      int akce = input.nextInt();
      switch (akce) {
        case 1 -> AddressBook.PrintSavedContacts(file);
        case 2 -> AddressBook.AddContact(file);
        case 3 -> AddressBook.RemoveContact(file);
        case 4 -> System.exit(0);
        default -> System.out.println("Neplatná akce.");
      }
    }
  }
}
