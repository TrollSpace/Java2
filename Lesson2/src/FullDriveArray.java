import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Misha on 19.08.2018.
 */
public class FullDriveArray {
    private String[][] arr;
    private int size;


    public FullDriveArray(int size) {
        this.size = size;
        this.arr = new String[size][size];
    }

    public void initArray() {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = sc.nextLine();
            }
        }
    }

    public void display() throws MyArraySizeException {
        if (arr.length != 4) throw new MyArraySizeException("Not supported size array = " + arr.length);
        for (int i = 0; i < arr.length; i++) {
            for (String s : arr[i]) {
                System.out.println(s);
            }

        }
    }

    public void printSumElements() throws MyArrayDataException {
        int sum = 0;
        int x = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Pattern p = Pattern.compile("\\D");
                Matcher m = p.matcher(arr[i][j]);
                if (m.find())
                    throw new MyArrayDataException("Array in [" + i + "],[" + j + "] has not parsing line." + arr[i][j]);
                x = Integer.parseInt(arr[i][j]);
                sum += x;
            }

        }
        System.out.println(sum);
    }
}
