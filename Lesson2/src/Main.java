/**
 * Created by Misha on 19.08.2018.
 */
public class Main {
    public static void main(String[] args) {
        FullDriveArray gogo = new FullDriveArray(2);
        gogo.initArray();
        try {
            gogo.display();
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        try {
            gogo.printSumElements();
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());

        }

        FullDriveArray go = new FullDriveArray(4);
        go.initArray();
        try {
            go.display();
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        }
        try {
            go.printSumElements();
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }
}
