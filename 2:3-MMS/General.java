import java.util.*;
import java.awt.*;

public class General {
    public General() {
    }

    public void printHashMap(HashMap<Integer, HashSet<Integer>> hM) {
        for (Integer key : hM.keySet()) {
            System.out.println("Agent " + Integer.toString(key + 1) + ": " + hM.get(key));
        }
    }

    public void printNestedArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            System.out.print("Agent " + row + ": [");
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col]);

                if (col < arr[0].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            System.out.println();
        }
    }
}
