package HomeWork_L2_3

import java.util.HashMap;

public class CollectionTask {


    public static void main(String[] args) {
        String[] words = {
                "Первое",
                "Второе",
                "Третье",
                "Android",
                "Django",
                "Java",
                "Android",
                "JavaScript",
                "LaTeX",
                "Android",
                "Linux",
                "Java",
                "Java",
                "Mac",
                "MySQL",
                "PHP",
                "PostgreSQL",
                "Python"};
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word: words) {
            Integer res = hm.get(word);
            hm.put(word, res == null ? 1 : res + 1);
        }
        System.out.println(hm);

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+79241112232");
        phoneBook.add("Иванов", "+79241112233");
        phoneBook.add("Петров", "+79241112234");
        phoneBook.add("Сидоров", "+79241112235");

        phoneBook.info();

        System.out.println(" У Иванова номера: " + phoneBook.get("Иванов"));
    }

}
