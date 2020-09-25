import java.util.*;
import java.awt.*;

public class EF1 {

    private int agents;
    private int items;
    private HashMap<Integer, int[]> valuations = new HashMap<Integer, int[]>();
    // private HashMap<Integer, int[]> allocations = new HashMap<Integer, int[]>();
    private HashMap<Integer, String> allocations = new HashMap<Integer, String>();

    public EF1() {
        // get the number of agents
        System.out.println("Enter the number of agents below: ");
        Scanner scanAgents = new Scanner(System.in);
        int numAgents = scanAgents.nextInt();

        // get the number of items
        System.out.println("Enter the number of items below: ");
        Scanner scanItems = new Scanner(System.in);
        int numItems = scanItems.nextInt();

        // get the valuations for each agents and initialize them into the hashmap
        for (int agent = 0; agent < numAgents; agent++) {
            int[] values = new int[numItems];

            for (int item = 0; item < numItems; item++) {
                System.out.println("Enter the value agent " + Integer.toString(agent + 1) + " has for "
                        + Integer.toString(item + 1) + ":");
                Scanner valueScanner = new Scanner(System.in);
                int value = scanItems.nextInt();
                values[item] = value;
            }

            this.valuations.put(agent, values);
        }

        // initialize allocations hashmap
        for (int agent = 0; agent < numAgents; agent++) {
            // this.allocations.put(agent, new int[numItems]);
            this.allocations.put(agent, "");
        }

        // initialize number of agents and items
        this.agents = numAgents;
        this.items = numItems;
    }

    // EF1 algorithm implementation
    public void ef1Algorithm() {
        int MIN_VAL = Integer.MIN_VALUE;

        // duplicating the number of items to keep the original
        int numberOfItems = this.items;

        while (numberOfItems > 0) {
            for (int agent = 0; agent < this.agents; agent++) {
                // find the item with the largest value that is available
                int maxIdx = this.findLargestIndex(this.valuations.get(agent));
                numberOfItems -= 1;

                // remove the item for the agent valuations
                for (int subAgent = 0; subAgent < this.agents; subAgent++) {
                    this.valuations.get(subAgent)[maxIdx] = MIN_VAL;
                }

                // add this item to the allocations
                String origAlloc = this.allocations.get(agent);
                String newAlloc = origAlloc += Integer.toString(maxIdx + 1);
                this.allocations.put(agent, newAlloc);

                // check if there are no items. if so, just return.
                if (numberOfItems == 0) {
                    return;
                }
            }
        }

        return;
    }

    // algo helper function
    // find largest value
    private int findLargestIndex(int[] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }

        return max;
    }

    // getter functions
    public HashMap getAllocations() {
        // code this up
        for (Integer name : this.valuations.keySet()) {
            System.out.println(Integer.toString(name) + " : " + this.allocations.get(name));
        }

        return this.allocations;
    }

    public int getAgents() {
        return this.agents;
    }

    public int getItems() {
        return this.items;
    }

    public void getValuations() {

        for (Integer name : this.valuations.keySet()) {
            System.out.println(Integer.toString(name) + " : " + this.printArray(this.valuations.get(name)));
        }
    }

    // getValuations helper function
    private String printArray(int[] array) {
        String arrayString = "";

        for (int i = 0; i < array.length; i++) {
            arrayString += Integer.toString(array[i]) + " ";
        }

        return arrayString;
    }
}
