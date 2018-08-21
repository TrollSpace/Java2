import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Misha on 21.08.2018.
 */
public class PhoneBook {
    private static HashMap<Integer, String> phoneBook = new HashMap<>();

    public static void add(String name, Integer number) {
        phoneBook.put(number, name);
    }

    public static void get(String name) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry entry : phoneBook.entrySet()) {
            if (name.equals((String) (entry.getValue()))) {
                answer.add((Integer) entry.getKey());
            }
        }
        System.out.println(name + " phone:");
        if (!answer.isEmpty()) {
            for (Integer i : answer) {
                System.out.println(i);
            }
        } else System.out.println("none");
    }
}
