import java.util.*;
import java.awt.*;
import java.lang.reflect.Array;

public class Conversion {

	private HashMap<Integer, HashSet<Integer>> initAllocations;
	private int[][] sortedAllocations;
	private String initMMS;
	private int numAgents;
	private int numItems;

	public Conversion(String initMMS, HashMap<Integer, HashSet<Integer>> initAllocations, int numItems, int numAgents) {
		this.initMMS = initMMS;
		this.initAllocations = initAllocations;
		this.numAgents = numAgents;
		this.numItems = numItems;
		this.sortedAllocations = new int[this.numAgents][this.numItems];

		for (Integer key : this.initAllocations.keySet()) {
			int[] curArr = hashSetToArray(this.initAllocations.get(key));
			sortArr(curArr);
			this.sortedAllocations[key] = curArr;
		}

	}

	// sort array
	public void sortArr(int[] arr) {
		Arrays.sort(arr);
	}

	// convert HashSet to array
	public int[] hashSetToArray(HashSet<Integer> hashSet) {
		Iterator<Integer> it = hashSet.iterator();
		int[] arr = new int[hashSet.size()];
		int idx = 0;

		while (it.hasNext()) {
			arr[idx] = it.next();
			idx += 1;
		}

		return arr;
	}

	// getter methods
	public int[][] getSortedAllocations() {
		return this.sortedAllocations;
	}

	public String returnInitMMS() {
		return this.initMMS;
	}
}
