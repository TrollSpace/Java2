import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Misha on 21.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        String[] arr = {"dog", "fish", "cat", "dog", "children", "book", "pencil", "table", "cat", "cat"};
        checkArray(arr);
    }


    public static void checkArray(String[] arr) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(arr));
        arrayList.sort(String::compareToIgnoreCase);
        String previousWord = null;
        int count = 0;
        ArrayList<String> answer = new ArrayList<>();

        for (String s : arrayList) {
            if (previousWord == null) {
                previousWord = s;
            }
            if (previousWord != s) {
                answer.add(previousWord + " count:" + count);
                previousWord = s;
                count = 0;
            }
            if (s == previousWord) {
                count++;
            }
        }
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
