import java.util.ArrayList;

public class AoC9B {
    //For both programs, the values to be checked must be provided as runtime arguments
    public static void main(String[] args) {
        //Find a contigious set of numbers in the given values that add up to the previously found invalid number, then add the maximum and minimum values in this contigious set together
        long[] values = getValues(args);
        long invalidNumber = 138879426;

        ArrayList<Long> set = findContiguousSet(values, invalidNumber);
        long min = set.get(0);
        long max = set.get(0);
        for (long i : set) {
            if (i < min) { min = i; }
            if (i > max) { max = i; }
        }

        System.out.println("The encryption weakness in the number set is: " + (max + min));
    }

    public static ArrayList<Long> findContiguousSet(long[] values, long num) {
        boolean notFound = true;
        boolean greater = false;
        int index = 0;
        int offset = 0;
        long sum = 0;
        ArrayList<Long> set = new ArrayList<>();

        while (notFound) {
            set.add(values[index + offset]);
            sum = 0;
            for (int i = 0; i < set.size(); i++) {
                sum += set.get(i);
            }
            if (sum == num && set.size() > 2) {
                notFound = false;
            }
            else if (sum > num) {
                set.clear();
                index++;
                offset = 0;
                sum = 0;
            }
            else if (sum < num) {
                offset++;
            }
        }
        return set;
    }

    public static long[] getValues(String[] args) {
        long[] values = new long[args.length];

        for(int i = 0; i < values.length; i++) {
            values[i] = Long.parseLong(args[i]);
        }

        return values;
    }
}
