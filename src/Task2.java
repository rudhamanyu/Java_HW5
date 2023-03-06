import java.util.*;

//Пусть дан список сотрудников:
// Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин,
// Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина,
// Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
public class Task2 {
    public static void main(String[] args) {
        String str_staff = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, " +
                "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, " +
                "Мария Федорова, Марина Светлова, Мария Савина,Мария Рыкова, Марина Лугова, " +
                "Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";

        String[] list_staff = str_staff.split(", ");
        Map<String, Integer> map = nameRepeats(list_staff);
        System.out.println();
        System.out.println("Сортировка с помощью TreeMap, по убыванию количества повторов имени в списке:");
        sortListStaff(map);
    }

    public static Map<String, Integer> nameRepeats(String[] arr) {
        Map<String, Integer> hashMap = new HashMap<>();
        Integer count = 1;
        for (String worker : arr) {
            String[] name = worker.split(" ");
            if (!hashMap.containsKey(name[0]))
                hashMap.put(name[0], count);
            else hashMap.put(name[0], hashMap.get(name[0]) + 1);
        }
        for (Map.Entry entry: hashMap.entrySet()) {
            if((Integer)entry.getValue()> 1)  // Вывод повторяющихся имен
                System.out.printf("Имя %s встречается в списке - %d раза\n", entry.getKey(),entry.getValue());
        }
        return hashMap;
    }

    public static void sortListStaff(Map<String, Integer> hashMap) {
        Map<Integer, List<String>> treeMap = new TreeMap<>(new Comparator<Integer>() { // Comparator- Анонимный класс для сравнения объектов
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2,o1);              // Сортировка по убыванию колличества повторов
            }
        });
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!treeMap.containsKey(entry.getValue())) {
                List<String> lst = new ArrayList<>();
                lst.add((String) entry.getKey());
                treeMap.put((Integer) entry.getValue(), lst);
            } else {
                List<String> lst = treeMap.get(entry.getValue());
                lst.add((String) entry.getKey());
            }
        }
        System.out.println(treeMap);
    }
}


