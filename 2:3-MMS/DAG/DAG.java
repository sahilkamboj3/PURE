package DAG;

import java.util.*;
import java.awt.*;

public class DAG {
    private Node[] agentVertices;
    private int numAgents;
    private int numItems;

    public DAG(int numAgents, int numItems, int[][] agentValuations) {
        this.numAgents = numAgents;
        this.numItems = numItems;
        agentVertices = new Node[numAgents];

        for (int i = 0; i < numAgents; i++) {
            Node agent = new Node(i, numAgents, agentValuations[i]);
        }
    }

    // getter methods
    public int getNumAgents () {
        return this.numAgents;
    }

    public int getNumItems () {
        return this.numItems;
    }

    public Node[] getAgentVertices () {
        return this.agentVertices;
    }

}
