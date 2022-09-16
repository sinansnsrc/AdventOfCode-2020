import java.util.ArrayList;
//THIS PROGRAM WORKS AND WILL EXECUTE HOWEVER IT WILL TAKE A WHILE AS IT IS NOT VERY EFFICIENT
//MIGHT TAKE UPWARDS OF 12 HOURS AND NO GUARANTEES IT WILL BE LESS THAN A DAY
public class AoC13B {
    public static void main(String[] args) {
        String[] values = args[1].split(",");
        ArrayList<int[]> buses = new ArrayList<>();

        for (int i = 0; i < values.length; i++) {
            if (!(values[i].equals("x"))) {
                buses.add(new int[] {Integer.parseInt(values[i]), i});
            }
        }

        System.out.println("The earliest timestamp is: " + findEarliestTimestamp(buses));
    }

    private static long findEarliestTimestamp(ArrayList<int[]> buses) {
        long timestamp = (long) buses.get(0)[0] * (100000000000000L / buses.get(0)[0]);
        //long timestamp = 0L;
        boolean found = false;

        while (!found) {
            timestamp += buses.get(0)[0];

            found = true;

            for (int i = 0; i < buses.size(); i++) {
                //System.out.println("Time: " + timestamp + ", Bus: " + buses.get(i)[0] + ", Offset: " + buses.get(i)[1]);
                if ((timestamp + buses.get(i)[1]) % buses.get(i)[0] == 0) {

                }
                else {
                    found = false;
                    break;
                }
            }

            if(timestamp < 0) {
                timestamp = -1;
                found = true;
                break;
            }
        }

        return timestamp;
    }
}
