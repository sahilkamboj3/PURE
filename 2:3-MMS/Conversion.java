import java.util.*;
import java.awt.*;
import java.lang.reflect.Array;

public class Conversion {

	private HashMap<Integer, HashSet<Integer>> initAllocations;
	private HashMap<Integer, HashSet<Integer>> sortedAllocations = new HashMap<Integer, HashSet<Integer>>();
	private String initMMS;

	public Conversion(String initMMS, HashMap<Integer, HashSet<Integer>> initAllocations) {
		this.initMMS = initMMS;
		this.initAllocations = initAllocations;

		for (Integer key : this.initAllocations.keySet()) {
			int[] curArr = hashSetToArray(this.initAllocations.get(key));
			// selectSort(curArr);
			// Arrays.sort(curArr);

			HashSet<Integer> sortedHashSet = new HashSet<Integer>();

			for (int i = 0; i < curArr.length; i++)
				sortedHashSet.add(curArr[i]);

			this.sortedAllocations.put(key, sortedHashSet);
		}

	}

	// sort array
	public void selectSort(int[] arr) {
		Arrays.sort(arr);
		// int num = arr[0];
		// arr[0] = arr[1];
		// arr[1] = num;
		// for (int i = 0; i < arr.length - 1; i++) {
		// System.out.print(arr[i] + ", ");
		// int minIdx = i;

		// for (int j = i + 1; j < arr.length; j++) {
		// if (arr[j] < arr[minIdx]) {
		// minIdx = j;
		// }
		// }

		// int curNum = arr[i];
		// int smallestNum = arr[minIdx];
		// System.out.print(i + ": " + curNum + " " + minIdx + ": " + smallestNum + ",
		// ");

		// arr[i] = smallestNum;
		// arr[minIdx] = curNum;
		// }
		// System.out.println("\n");
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
