/**
 * Created by Misha on 16.08.2018.
 */
public class Children extends People {
    int size;

    public Children(String name, int age) {
        super(name, age);
        this.size = 5;
    }

    public boolean isEmpty() {
        if (size > 0) {
            size--;
            return false;
        }
        return true;
    }

}
