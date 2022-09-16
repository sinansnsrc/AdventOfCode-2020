import java.util.Arrays;

public class AoC10A {
    //For both programs, the values must be provided as runtime arguments
    public static void main(String[] args) {
        //Find the number of 3 jolt differences times the number of 1 jolt differences between adapters starting from 0 to the final outlet
        int[] values = getValues(args);
        Arrays.sort(values);

        int numOf1Jolt = 0;
        int numOf3Jolt = 0;
        int prevValue = 0;

        for (int i : values) {
            if (i - prevValue == 1) {
                numOf1Jolt++;
            }
            else if (i - prevValue == 3) {
                numOf3Jolt++;
            }
            prevValue = i;
        }

        numOf3Jolt++;

        System.out.println("Number of 3 jolt differences multiplied by number of 1 jolt differences is: " + (numOf1Jolt * numOf3Jolt));

    }

    public static int[] getValues(String[] args) {
        int[] values = new int[args.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(args[i]);
        }
        return values;
    }
}