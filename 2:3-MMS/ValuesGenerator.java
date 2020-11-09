import java.util.*;
import java.awt.*;

public class ValuesGenerator {
    private int numAgents;
    private int numItems;
    private int minVal;
    private int maxVal;
    private HashMap<Integer, HashSet<Integer>> agentValues = new HashMap<Integer, HashSet<Integer>>();
    private Random rand;

    public ValuesGenerator(int numAgents, int numItems, int minVal, int maxVal) {
        this.numAgents = numAgents;
        this.numItems = numItems;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.rand = new Random();

        for (int agent = 0; agent < this.numAgents; agent++) {
            HashSet<Integer> vals = generateData(this.numItems);
            this.agentValues.put(agent, vals);
        }
    }

    public ValuesGenerator(int numAgents, int numItems, int maxVal) {
        this.numAgents = numAgents;
        this.numItems = numItems;
        this.maxVal = maxVal;
        this.minVal = 0;
        this.rand = new Random();

        for (int agent = 0; agent < this.numAgents; agent++) {
            HashSet<Integer> vals = generateData(this.numItems);
            this.agentValues.put(agent, vals);
        }
    }

    public HashSet<Integer> generateData(int numItems) {
        HashSet<Integer> values = new HashSet<Integer>();

        for (int item = 0; item < this.numItems; item++) {
            int num = rand.nextInt((this.maxVal + 1 - this.minVal) + this.minVal);
            while (values.contains(num)) {
                num = rand.nextInt((this.maxVal + 1 - this.minVal) + this.minVal);
            }

            values.add(num);
        }

        return values;
    }

    // getter methods

    public HashMap<Integer, HashSet<Integer>> getAgentValues() {
        return this.agentValues;
    }
}
