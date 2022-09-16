import java.util.ArrayList;
import java.util.Arrays;

public class AoC13A {

    public static void main(String[] args) {
        int time = Integer.parseInt(args[0]);
        int[] buses = getBuses(args[1].split(","));
        int smallestAboveTime = time * 2;
        int smallestAboveTimeID = 0;
        for (int i = 0; i < buses.length; i++) {
            int bus = buses[i];

            while(bus < time) {
                bus += buses[i];
            }

            if (smallestAboveTime > bus) {
                smallestAboveTime = bus;
                smallestAboveTimeID = buses[i];
            }
        }

        System.out.println("The ID of the bus is: " + smallestAboveTimeID + ".");
        System.out.println("It will run at: " + smallestAboveTime + ", which is a " + (smallestAboveTime - time) + " minutes wait.");
        System.out.println("The solution is: " + (smallestAboveTime - time) * smallestAboveTimeID);
    }

    public static int[] getBuses(String[] args) {
        ArrayList<Integer> buses = new ArrayList<>();

        for (int i = 1; i < args.length; i++) { if (!args[i].equals("x")) { buses.add(Integer.parseInt(args[i])); } }

        int[] bus = new int[buses.size()];

        for (int i = 0; i < bus.length; i++) { bus[i] = buses.get(i); }

        return bus;
    }
}
