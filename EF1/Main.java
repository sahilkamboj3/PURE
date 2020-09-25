import java.util.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		EF1 ef1Algo = new EF1();
		System.out.println("Original Valuations:");
		ef1Algo.getValuations();
		ef1Algo.ef1Algorithm();
		System.out.println("EF1 Allocations:");
		ef1Algo.getAllocations();
	}

}
