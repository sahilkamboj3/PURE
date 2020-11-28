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
            agent[i] = agent;
        }
    }

    public void addItem(int itemNum) {
        Node source = findSource();
        source.add(itemNum);

        boolean isAcyclic = isAcyclic();

        if (isAcyclic) {
            // Node[] tempNodesThatEnvy =
            // for (int i = 0; i < this.agentVertices.length; i++) {
            // if (source.getId() == this.agentVertices[i].getId()) {
            // continue;
            // }

            // if (isEnvy(source.getCurItems(), other)) {

            // }
            // }
        }
    }

    public boolean isAcyclic() {
        for (int i = 0; i < this.agentVertices.length; i++) {
            for (int j = i + 1; j < this.agentVertices.length; j++) {
                Node[] agentINodes = this.agentVertices[i].getNodesEnvied();
                Node[] agentJNodes = this.agentVertices[j].getNodesEnvied();

                if (agentINodes.indexOf(this.agentVertices[j]) > -1
                        && agentJNodes.indexOf(this.agentVertices[i]) > -1) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEnvy(int[] items, Node other) {
        if (other.getTotalValue() < other.evaluate(items)) {
            return true;
        }
        return false;
    }

    private Node findSource() {
        Node source = null;

        for (int i = 0; i < agentVertices.length; i++) {
            if (agentVertices[i].isSource()) {
                source = agentVertices[i];
                return source;
            }
        }

        return null;
    }

    // getter methods
    public int getNumAgents() {
        return this.numAgents;
    }

    public int getNumItems() {
        return this.numItems;
    }

    public Node[] getAgentVertices() {
        return this.agentVertices;
    }

}
