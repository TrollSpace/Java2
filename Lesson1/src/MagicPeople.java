/**
 * Created by Misha on 15.08.2018.
 */

public class MagicPeople extends People implements PeopleLife {
    String name;
    int weight;

    public MagicPeople(String name, int weight) {
        super(name, 10);
        this.name = super.getName();
        this.weight = 0;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void eat(int countEat) {
        weight += countEat;
    }

    @Override
    public String talk(String idea) {
        return idea;
    }

    @Override
    public boolean sleep() {
        if (weight > 0) {
            return true;
        } else return false;
    }
}
