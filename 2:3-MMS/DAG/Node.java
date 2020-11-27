package DAG;

import java.util.*;
import java.awt.*;
import org.apache.commons.lang3.ArrayUtils;

public class Node {
    private int id;

    private int[] itemAllocs;
    private int[] curItems;
    private int itemsValue;

    private Node[] nodesEnvied;
    private Node[] nodesThatEnvy;

    public Node(int id, int numAgents, int[] itemVals) {
        this.id = id;
        this.itemVals = itemVals;
        this.curItems = new int[itemVals.length];
        this.nodesEnvied = new Node[numAgents];
        this.nodesThatEnvy = new Node[numAgents];
        this.itemsValue = 0;
    }

    public void addNodesEnvied (Node agent) {
        this.nodesEnvied = ArrayUtils.add(this.nodesEnvied, agent);
    }

    public void addNodesThatEnvy (Node agent) {
        this.nodesThatEnvy = ArrayUtils.add(this.nodesThatEnvy, agent);
    }

    public void removeNodesEnvied (Node agent) {
        Node[] newArr = new Node[this.nodesEnvied.length];

        for (int i = 0; i < this.nodesEnvied.length; i++) {
            if (this.nodesEnvied[i].equals(agent)) {
                continue;
            }

            newArr[i] = this.nodesEnvied[i];
        }

        this.nodesEnvied = newArr;
    }

    public void removeNodesThatEnvy (Node agent) {
        Node[] newArr = new Node[this.nodesThatEnvy.length];

        for (int i = 0; i < this.nodesThatEnvy.length; i++) {
            if (this.nodesThatEnvy[i].equals(agent)) {
                continue;
            }

            newArr[i] = this.nodesThatEnvy[i];
        }

        this.nodesThatEnvy = newArr;
    }

    public void addItem (int item) {
        this.curItems = ArrayUtils.add(this.curItems, item);
        this.itemsValue = findItemValues();
    }

    private int findItemValues() {
        int sum = 0;

        for (int i = 0; i < curItems.length; i++) {
            sum += itemAllocs[i - 1];
        }

        return sum;
    }

    // override .equals() method
    @Override
    public boolean equals(Node agent) {
        int id = agent.getAgentNum();
        
        if (id == this.id) {
            return true;
        }

        return false;
    }

    // getter methods
    public int getAgentNum() {
       return this.agent; 
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
    public int[] setCurItems(int[] curItems) {
       this.curItems = curItems;
       return curItems;
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
