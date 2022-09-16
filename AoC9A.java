import java.util.ArrayList;
import java.util.Arrays;

public class AoC9A {
    //For both programs, the values to be checked must be provided as runtime arguments
    public static void main(String[] args) {
        //Find the first number in the given list that isn't the sum of two of the last 25 numbers
        long[] values = getValues(args);
        ArrayList<Long> previousValues = new ArrayList<>();

        int index = 0;
        while (index < 25) {
            previousValues.add(values[index]);
            index++;
        }

        boolean viable = true;
        while(viable) {
            viable = isViable(previousValues, values[index]);
            if (viable) {
                previousValues.remove(0);
                previousValues.add(values[index]);
            }
            else {
                System.out.println("The non-viable value is: " + values[index]);
            }
            index++;
        }
    }

    public static boolean isViable(ArrayList<Long> values, long num) {
        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < values.size(); j++) {
                if (values.get(i) + values.get(j) == num && values.get(i) != values.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static long[] getValues(String[] args) {
        long[] values = new long[args.length];

        for(int i = 0; i < values.length; i++) {
            values[i] = Long.parseLong(args[i]);
        }

        return values;
    }
}
