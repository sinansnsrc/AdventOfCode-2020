import java.util.Arrays;

public class AoC8B {
    //For both programs, the values provided must be pasted in the getValues() method below
    public static void main(String[] args) {
        //Change exactly one of the jmp to nop (and vice versa) to make the program fully execute without repeating, find the value of the accumulator at the end
        String[][] values = getValues();

        int count = -1;
        int lastChangedIndex = -1;

        for (int o = 0; o < values.length; o++) {
            values = getValues();

            for (int i = lastChangedIndex + 1; i < values.length; i++) {
                if(values[i][0].equals("jmp")) {
                    lastChangedIndex = i;
                    values[i][0] = "nop";
                    break;
                }
                else if(values[i][0].equals("nop")) {
                    lastChangedIndex = i;
                    values[i][0] = "jmp";
                    break;
                }
            }

            if (breakByEnd(values) != -1) {
                count = breakByEnd(values);
                break;
            }
            else {
                continue;
            }
        }

        System.out.println("The accumulator value is: " + count);
    }

    public static int breakByEnd(String[][] vals) {
        String[][] values = new String[vals.length][];

        for(int i = 0; i < vals.length; i++) {
            values[i] = vals[i].clone();
        }

        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                int index = i;
                if (values[i][0].equals("acc")) {
                    count += Integer.parseInt(values[i][1]);
                } else if (values[i][0].equals("jmp")) {
                    i += Integer.parseInt(values[i][1]) - 1;
                } else {
                    ;
                }
                values[index] = null;
            }
            else {
                return -1;
            }
        }
        return count;
    }

    public static String[] parseCmd(String cmd) {
        String[] parsedCommand = new String[2];
        parsedCommand[0] = cmd.substring(0,3);
        if (cmd.charAt(4) == '+') {
            parsedCommand[1] = cmd.substring(5);
        }
        else {
            parsedCommand[1] = cmd.substring(4);
        }
        return parsedCommand;
    }

    public static String[][] getValues(){
        String values = "";
        String[] unparsedValues = values.split("\n");
        String[][] parsedValues = new String[unparsedValues.length][];
        for (int i = 0; i < unparsedValues.length; i++) {
            parsedValues[i] = parseCmd(unparsedValues[i]);
        }
        return parsedValues;
    }
}
