import java.util.Arrays;
import java.util.Scanner;

    // Cwiczenia na tablicach - znajdowanie najmniejszej liczby

public class MinimumElement {

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Ile liczb chcesz wprowadzić: ");
        int count=scanner.nextInt();
        int[] array=readIntegers(count);
        int min=findMin(array);
        System.out.println("Min element: "+min);

    }

    public static int [] readIntegers(int count){
        int[] array=new int[count];
        System.out.println("Enter "+count+" integer: ");
        for (int i=0; i<count; i++)
            array[i]=scanner.nextInt();
        return array;
    }

    public static int findMin(int[] array) {
//        int[] sorted = Arrays.copyOf(array, array.length);
//        int temp;
//        boolean trueFalse = true;
//
//        while (trueFalse)
//            for (int i = 0; i < array.length - 1; i++) {
//                trueFalse = false;
//                if (sorted[i] > sorted[i + 1]) {
//                    temp = sorted[i];
//                    sorted[i] = sorted[i + 1];
//                    sorted[i + 1] = temp;
//                    trueFalse = true;
//                }
//            }
//        return sorted[0];

        int min=Integer.MAX_VALUE;

        for (int i=0; i<array.length; i++){
            int value=array[i];
            if (value<min)
                min=value;
        }
    return min;
    }
}
