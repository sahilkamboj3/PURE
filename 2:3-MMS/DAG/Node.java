package DAG;

import java.util.*;
import java.awt.*;
import org.apache.commons.lang3.ArrayUtils;

public class Node {
    private int id;

    private int[] itemAllocs;
    private int[] curItems;
    private int totalValue;

    private Node[] nodesEnvied;
    private Node[] nodesThatEnvy;

    public Node(int id, int numAgents, int[] itemVals) {
        this.id = id;
        this.itemVals = itemVals;
        this.curItems = new int[itemVals.length];
        this.nodesEnvied = new Node[numAgents];
        this.nodesThatEnvy = new Node[numAgents];
        this.totalValue = 0;
    }

    public void addNodesEnvied(Node agent) {
        this.nodesEnvied = ArrayUtils.add(this.nodesEnvied, agent);
    }

    public void addNodesThatEnvy(Node agent) {
        this.nodesThatEnvy = ArrayUtils.add(this.nodesThatEnvy, agent);
    }

    public void removeNodesEnvied(Node agent) {
        Node[] newArr = new Node[this.nodesEnvied.length];

        for (int i = 0; i < this.nodesEnvied.length; i++) {
            if (this.nodesEnvied[i].equals(agent)) {
                continue;
            }

            newArr[i] = this.nodesEnvied[i];
        }

        this.nodesEnvied = newArr;
    }

    public void removeNodesThatEnvy(Node agent) {
        Node[] newArr = new Node[this.nodesThatEnvy.length];

        for (int i = 0; i < this.nodesThatEnvy.length; i++) {
            if (this.nodesThatEnvy[i].equals(agent)) {
                continue;
            }

            newArr[i] = this.nodesThatEnvy[i];
        }

        this.nodesThatEnvy = newArr;
    }

    public void addItem(int item) {
        this.curItems = ArrayUtils.add(this.curItems, item);
        this.totalValue = findItemValues();
    }

    private int findItemValues() {
        int sum = 0;

        for (int i = 0; i < curItems.length; i++) {
            sum += itemAllocs[i - 1];
        }

        return sum;
    }

    public boolean isSink() {
        if (this.nodesEnvied.length == 0) {
            return true;
        }
        return false;
    }

    public boolean isSource() {
        if (this.nodesThatEnvy.length == 0) {
            return true;
        }
        return false;
    }

    public int evaluate(int[] items) {
        int sum = 0;

        for (int i = 0; i < items.length; i++) {
            sum += this.itemAllocs[items[i]];
        }

        return sum;
    }

    // override .equals() method
    @Override
    public boolean equals(Node agent) {
        int id = agent.getId();

        if (id == this.id) {
            return true;
        }

        return false;
    }

    // getter methods
    public int getId() {
        return this.id;
    }

    public int getTotalValue() {
        return this.totalValue;
    }

    public int[] getCurItems() {
        return this.curItems;
    }

    public int[] getItemAllocs() {
        return this.itemAllocs;
    }

    public Node[] getNodesEnvied() {
        return this.nodesEnvied;
    }

    public Node[] getNodesThatEnvy() {
        return this.nodesThatEnvy;
    }

    // setter methods
    public int[] setItemAllocs(int[] itemAllocs) {
        this.itemAllocs = itemAllocs;
        return itemAllocs;
    }

    public Node[] setNodesEnvied(Node[] newNodes) {
        this.nodesEnvied = newNodes;
        return newNodes;
    }

    public Node[] setNodesThatEnvy(Node[] newNodes) {
        this.nodesThatEnvy = newNodes;
        return newNodes;
    }
}
