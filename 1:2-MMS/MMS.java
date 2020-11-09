import java.util.*;
import java.awt.*;

public class MMS {
    public int numAgents;
    public int numItems;
    public int[][] valuations;
    public HashMap<Integer, String> allocations = new HashMap<Integer, String>();
    public final int MIN_VAL = Integer.MIN_VALUE;
    public int[] itemsLeft;

    public MMS() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Number of agents: ");
        this.numAgents = scan.nextInt();

        System.out.print("Number of items: ");
        this.numItems = scan.nextInt();

        this.valuations = new int[this.numAgents][this.numItems];

        for (int i = 0; i < this.numAgents; i++) {
            int[] agentVals = new int[this.numItems];
            for (int j = 0; j < this.numItems; j++) {
                System.out.print(
                        "Value of Item " + Integer.toString(j + 1) + " for Agent " + Integer.toString(i + 1) + ": ");
                agentVals[j] = scan.nextInt();
            }
            this.valuations[i] = agentVals;
        }

        for (int i = 0; i < this.numAgents; i++) {
            this.allocations.put(i, "");
        }

        this.itemsLeft = new int[this.numItems];
        for (int i = 0; i < this.numItems; i++) {
            this.itemsLeft[i] = i;
        }
    }

    public void MMSAlgo() {
        boolean allocated = true;
        int round = 1;

        // step 2
        while (allocated) {
            double[] averages = getAverages(); // step 1

            System.out.println("______________Averages " + Integer.toString(round) + "______________");
            round += 1;
            printAverages(averages);
            boolean allocatedRound = false;

            for (int agent = 0; agent < this.valuations.length; agent++) {
                int curAgent = agent;
                if (Arrays.stream(this.valuations[agent]).anyMatch(i -> i >= averages[curAgent] / 2)) {
                    allocatedRound = true;
                    giveItem(agent);
                    agent = this.valuations.length;
                }
            }
            if (this.numAgents == 0) {
                allocated = false;
            } else {
                allocated = allocatedRound;
            }
        }

        // step 3
        if (this.numItems > 0 && this.numAgents == 0) {
            String remainingItems = "";
            for (int i = 0; i < this.itemsLeft.length; i++) {
                if (this.itemsLeft[i] > MIN_VAL) {
                    remainingItems += Integer.toString(i + 1);
                }
            }
            String oldAlloc = this.allocations.get(0);
            String newAlloc = oldAlloc + remainingItems;
            this.allocations.replace(0, newAlloc);
        }

        while (this.numItems > 0 && this.numAgents > 0) {
            for (int i = 0; i < this.valuations.length; i++) {
                if (Arrays.stream(this.valuations[i]).anyMatch(val -> val > MIN_VAL)) {
                    giveItem(i);
                }
                if (this.numItems == 0) {
                    break;
                }
            }
        }
    }

    public void giveItem(int agent) {
        // find the max valued item
        int maxIdx = 0;
        for (int i = 0; i < this.valuations[agent].length; i++) {
            if (this.valuations[agent][i] > this.valuations[agent][maxIdx]) {
                maxIdx = i;
            }
        }

        // give item to this agent in the allocation
        String oldAlloc = this.allocations.get(agent);
        String newAlloc = oldAlloc + Integer.toString(maxIdx + 1);
        this.allocations.replace(agent, newAlloc);

        // remove the item for everyone's list
        for (int j = 0; j < this.valuations.length; j++) {
            this.valuations[j][maxIdx] = MIN_VAL;
        }

        // reduce the number of agents and items and essentially remove the agent
        for (int j = 0; j < this.valuations[agent].length; j++) {
            this.valuations[agent][j] = MIN_VAL;
        }
        this.numItems -= 1;
        this.numAgents -= 1;
        this.itemsLeft[maxIdx] = MIN_VAL;
    }

    // step 1
    public double[] getAverages() {
        double[] averages = new double[this.valuations.length];

        for (int i = 0; i < this.valuations.length; i++) {
            double sum = 0.0;
            int[] curAgentVals = this.valuations[i];
            for (int j = 0; j < curAgentVals.length; j++) {
                if (curAgentVals[j] > MIN_VAL) {
                    sum += curAgentVals[j];
                }
            }
            averages[i] = sum / this.numAgents;
        }

        return averages;
    }

    private void printAverages(double[] averages) {
        System.out.print("Averages: ");
        for (int i = 0; i < averages.length; i++) {
            System.out.print(averages[i] + " ");
        }
        System.out.println();
    }

    public void printValuations() {
        for (int agent = 0; agent < this.valuations.length; agent++) {
            System.out.print("Agent " + Integer.toString(agent + 1) + ": ");
            for (int item = 0; item < this.valuations[agent].length; item++) {
                System.out.print(this.valuations[agent][item] + " ");
            }
            System.out.println();
        }
        return;
    }

    public void returnAllocations() {
        for (Integer agent : this.allocations.keySet()) {
            System.out.println("Agent " + Integer.toString(agent + 1) + ": " + this.allocations.get(agent));
        }
        return;
    }
}
