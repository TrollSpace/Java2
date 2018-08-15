/**
 * Created by Misha on 15.08.2018.
 */
public class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean go(int path) {
        if (path > 0) {
            return true;
        } else return false;
    }

    public void doSomething(String idea){
        if(!idea.isEmpty()){
            System.out.println(idea);
        }
        else{
            System.out.println("go to sleep");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
