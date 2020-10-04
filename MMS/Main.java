import java.util.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        MMS mmsAlgo = new MMS();
        System.out.println("______________Initial Valuations______________");
        mmsAlgo.printValuations();
        System.out.println();
        mmsAlgo.MMSAlgo();
        System.out.println("______________Final Valuations______________");
        mmsAlgo.printValuations();
        System.out.println();
        System.out.println("______________Allocations______________");
        mmsAlgo.returnAllocations();

    }
}
