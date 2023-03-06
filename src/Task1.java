import java.util.HashMap;
import java.util.Map;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class Task1 {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> phone_book= new HashMap<>();
        Map<String, Integer> ID_1= new HashMap<>();
        ID_1.put("основной", 12345);
        ID_1.put("рабочий", 12346);
        ID_1.put("домашний", 12347);
        ID_1.put("другой", 12348);
        phone_book.put("Иванов Иван", ID_1);

        Map<String, Integer> ID_2= new HashMap<>();
        ID_2.put("домашний", 22345);
        ID_2.put("рабочий", 22346);
        phone_book.put("Петров Петр", ID_2);

        Map<String, Integer> ID_3= new HashMap<>();
        ID_3.put("основной", 32345);
        ID_3.put("рабочий", 32346);
        phone_book.put("Сидоров Сергей", ID_3);

        System.out.println(phone_book.get("Иванов Иван").get("другой"));
        System.out.println(phone_book.get("Петров Петр").get("рабочий"));
        System.out.println(phone_book.get("Сидоров Сергей").get("основной"));
    }
}