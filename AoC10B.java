import java.util.ArrayList;
import java.util.Arrays;

public class AoC10B {
    //For both programs, the values must be provided as runtime arguments
    public static void main(String[] args) {
        //Find how many possible combinations of adapters there are to start from 0 and make it to the final outlet
        int[] values = getValues(args);
        Arrays.sort(values);

        ArrayList<int[]> splitValues = breakAtBreakPoints(values);

        long numOfPathways = 1;

        for (int[] i : splitValues) {
            numOfPathways *= findNumberOfPaths(i);
        }

        System.out.println("The number of pathways are: " + numOfPathways);
    }

    private static ArrayList<int[]> breakAtBreakPoints(int[] values) {
        ArrayList<int[]> breakPoints = new ArrayList<>();

        int prevValue = 0;
        int startIndex = 0;
        int endIndex = 0;

        for(int i : values) {
            if (i - prevValue == 3) {
                breakPoints.add(Arrays.copyOfRange(values, startIndex, endIndex));
                startIndex = endIndex;
                endIndex++;
            }
            else {
                endIndex++;
            }
            prevValue = i;
        }

        breakPoints.add(Arrays.copyOfRange(values, startIndex, endIndex));

        return breakPoints;
    }

    private static int findNumberOfPaths (int[] path) {
        switch(path.length) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 4;
            case 5:
                return 7;
        }
        return 1;
    }

    public static int[] getValues(String[] args) {
        int[] values = new int[args.length + 1];
        values[0] = 0;
        for (int i = 1; i < values.length; i++) {
            values[i] = Integer.parseInt(args[i-1]);
        }
        return values;
    }
}
