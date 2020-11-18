import java.util.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		General genFuncs = new General();

		int numAgents = 5;
		int numItems = 5;
		int minVal = 0;
		int maxVal = 100;

		ValuesGenerator gen = new ValuesGenerator(numAgents, numItems, minVal, maxVal);
		HashMap<Integer, HashSet<Integer>> vals = gen.getAgentValues();

		Conversion conv = new Conversion("1/2", vals, numItems, numAgents);
		int[][] sortedVals = conv.getSortedAllocations();

		System.out.println("Original Allocations");
		genFuncs.printHashMap(vals);

		System.out.println();

		System.out.println("Sorted Allocations");
		genFuncs.printNestedArray(sortedVals);
	}

}
