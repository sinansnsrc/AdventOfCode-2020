import java.util.ArrayList;
import java.util.Arrays;

public class AoC14A {

    public static void main(String[] args) {
        String[][] values = new String[args.length / 3][];
        long[] memoryValues = new long[100000];

        for(int i = 0, j = 0; i < args.length; i++) {
            if(i % 3 == 0) {
                values[j] = new String[2];
                values[j][0] = args[i];
            }
            else if(i % 3 == 2) {
                values[j][1] = args[i];
                j++;
            }
        }

        String memory = "000000000000000000000000000000000000";
        String mask = "";
        String value = "";

        long sum = 0L;

        for(String[] i : values) {
            if(i[0].equals("mask")) {
                mask = i[1];
            }
            else {
                value = i[1];
                memory = writeValue(value, mask, memory);
                memoryValues[Integer.parseInt(i[0].substring(i[0].indexOf("[") + 1,i[0].indexOf("]")))] = Long.parseLong(memory,2);
            }
        }

        for(Long i : memoryValues) {
            sum += i;
        }

        System.out.println("The sum of all values left in memory after the program terminates is: " + sum);

    }

    public static String writeValue(String value, String mask, String memory) {
        value = Integer.toBinaryString(Integer.parseInt(value));

        while(value.length() != mask.length()) {
            value = "0" + value;
        }

        for(int i = 0; i < mask.length(); i++) {
            if(mask.charAt(i) == 'X') {
                memory = memory.substring(0, i) + value.charAt(i) + memory.substring(i + 1);
            }
            else {
                memory = memory.substring(0, i) + mask.charAt(i) + memory.substring(i + 1);
            }
        }

        return memory;
    }

}
