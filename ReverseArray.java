import java.util.Arrays;

    // Cwiczenia na tablicach - odwracanie tablicy

public class ReverseArray {

    public static void main(String[] args) {

        int[] array={1,2,3,4,5};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array){

        int value=array.length-1;
        for (int i=0; i<array.length/2; i++){
            int temp=array[i];
            array[i]=array[value-i];
            array[value-i]=temp;

        }
    }
}
