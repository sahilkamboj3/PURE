import java.util.*;
import java.awt.*;

public class Conversion {

	private HashMap<Integer, HashSet<Integer>> initAllocations;
	private HashMap<Integer, HashSet<Integer>> sortedAllocations = new HashMap<Integer, HashSet<Integer>>();
	private String initMMS;

	public Conversion(String initMMS, HashMap<Integer, HashSet<Integer>> initAllocations) {
		this.initMMS = initMMS;
		this.initAllocations = initAllocations;

		for (Integer key : this.initAllocations.keySet()) {
			int[] curArr = hashSetToArray(this.initAllocations.get(key));
			selectSort(curArr);

			HashSet<Integer> sortedHashSet = new HashSet<Integer>();

			for (int i = 0; i < curArr.length; i++)
				sortedHashSet.add(curArr[i]);

			this.sortedAllocations.put(key, sortedHashSet);
		}

	}

	// sort array
	public void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int j = i + 1;
			int min = i;

			while (j < arr.length) {
				if (arr[j] < arr[min])
					min = j;
				j += 1;
			}
			int cur = arr[min];
			arr[min] = arr[i];
			arr[i] = cur;
		}
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
	public HashMap<Integer, HashSet<Integer>> getSortedAllocations() {
		return this.sortedAllocations;
	}

	public String returnInitMMS() {
		return this.initMMS;
	}
}
