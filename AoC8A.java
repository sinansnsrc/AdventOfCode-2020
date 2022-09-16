import java.util.Arrays;

public class AoC8A {
    //For both programs, the values provided must be pasted in the getValues() method below
    public static void main(String[] args) {
        //Find the value of the accumulator right before any piece of instruction is ran for the second time
        String[][] values = getValues();

        int count = 0;

        for (int i = 0; i < values.length; i++) {
            if (values[i] != null){
                int index = i;
                if (values[i][0].equals("acc")) {
                    count += Integer.parseInt(values[i][1]);
                }
                else if (values[i][0].equals("jmp")) {
                    i += Integer.parseInt(values[i][1]) - 1;
                }
                else {
                    ;
                }
                values[index] = null;
            }
            else {
                break;
            }
        }
        System.out.println("The accumulator value is: " + count);
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
