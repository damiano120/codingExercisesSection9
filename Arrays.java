import java.util.Scanner;
import java.util.Arrays;

    // Cwiczenia na tablicach - sortowanie liczb

public class Arrays {

    private static Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) {

        int[] tab1=getInteger(5);
        int[] sorted=sortIntegers(tab1);
        printArray(sorted);

    }

    public static int[] getInteger(int number){

        int[] array=new int[number];
        System.out.println("Wprowadź "+number+" liczb: ");
        for (int i=0; i<array.length; i++)
            array[i]= scanner.nextInt();
        return array;
    }

    public static void printArray(int[] array){

        for (int i=0; i<array.length; i++)
            System.out.print(array[i]+"  ");
    }

    public static int[] sortIntegers(int[] array){

//        int[] sortedTab=new int[array.length];
//        for (int i=0; i<array.length; i++)
//            sortedTab[i]=array[i];
//
//        LUB INNE ROZWIĄZANIE:

        int[] sortedTab= java.util.Arrays.copyOf(array, array.length);

        int temp;
        boolean trueFalse=true;

        while (trueFalse){
            trueFalse=false;
            for (int i=0; i<sortedTab.length-1; i++) {
                if (sortedTab[i] < sortedTab[i + 1]) {
                    temp = sortedTab[i];
                    sortedTab[i] = sortedTab[i + 1];
                    sortedTab[i + 1] = temp;
                    trueFalse = true;
                }
            }
        }

    return sortedTab;
    }
}
