import bridges.base.Color;
import bridges.base.ElementVisualizer;
import bridges.connect.Bridges;
import bridges.base.Array1D;
import bridges.base.Element;

import java.lang.reflect.Array;

public class AnneSzarek {
    public static void main(String[] args) throws Exception {

        /* Initialize a Bridges connection with your credentials */
        /* TODO: plug your own BRIDGES credentials */
        Bridges bridges = new Bridges(0, "szarek", "1509239090489");

        /* Set an assignment title */
        bridges.setTitle("Array Example");

        /* Set up the array dimensions, allocate an Array of Elements */
        /* TODO: Make an array of size 10 - DONE */
        int arraySize = 10;
        Array1D<Integer> arr = new Array1D<Integer> (arraySize);

        /* Populate the array with integers */
        /* TODO: Make the array store square numbers - DONE*/
        for (int i = 0; i < arraySize; i++) {

            int temp = i * i;
            arr.getElement(i).setValue(temp);

            int r = 63;
            int g = 191;
            int b = 191;
            int a = 1;
            /* set the value as a Label */
            arr.getElement(i).setLabel(String.valueOf(temp));
            arr.getElement(i).setColor("blue");
        }

        /* Tell BRIDGES which data structure to visualize */
        bridges.setDataStructure(arr);

        /* Visualize the Array */
        bridges.visualize();
    }
}