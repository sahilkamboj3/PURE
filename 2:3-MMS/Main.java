import java.util.*;
import java.awt.*;

// import DAG.Test;

public class Main {

	public static void main(String[] args) {
		// Test test = new Test();

		Util utilFuncs = new Util();

		int numAgents = 5;
		int numItems = 5;
		int minVal = 0;
		int maxVal = 100;

		AllocGenerator gen = new AllocGenerator(numAgents, numItems, minVal, maxVal);
		HashMap<Integer, HashSet<Integer>> vals = gen.getAgentValues();

		Sorting sort = new Sorting("1/2", vals, numItems, numAgents);
		int[][] sortedVals = sort.getSortedAllocations();

		System.out.println("Original Allocations");
		utilFuncs.printHashMap(vals);

		System.out.println();

		System.out.println("Sorted Allocations");
		utilFuncs.printNestedArray(sortedVals);
	}

}
