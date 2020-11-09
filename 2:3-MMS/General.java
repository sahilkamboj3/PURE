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
}
