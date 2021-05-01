package bsu.comp152;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            ArrayList<String> lines = new ArrayList<>();


            File myFile = new File("Numbers.txt");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            int[] numbers = new int[lines.size()];

            for (int i = 0; i < lines.size(); i++) {
                numbers[i] = Integer.parseInt(lines.get(i));
            }
            System.out.println("Median : " + (findMedian(selectionSort(numbers))));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);

        }
    }
    public static int[] selectionSort (int [] array){
        int startScan, index, minIndex, minValue;

        for (startScan = 0; startScan < (array.length - 1); startScan ++){
            minIndex = startScan;
            minValue = array[startScan];
            for (index = startScan + 1; index < array.length; index++){
                if (array[index] < minValue){
                    minValue = array[index];
                    minIndex = index;
                }
            }
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }

        System.out.println("Array : " + (Arrays.toString(array)));
        return array;
    }

    public static int findMedian(int [] array){
        int median;
        if (array.length % 2 == 1){
            median = array[(array.length / 2)];
        }
        else {
            median = (((array[(array.length - 1)/ 2])) + (array[(array.length / 2)])) / 2;
        }
        return median;
    }

}
