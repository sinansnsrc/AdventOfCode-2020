import java.util.Arrays;

public class AoC4A {
    //For this program, the values must be pasted as a string in the getValues() method
    public static void main(String[] args) {
        //Find how many passports are valid in the given list of passports and verify based on which data headers they have
        String[] values = getValues().split("\n\n");

        int passports = 0;

        for(int i = 0; i < values.length; i++){
            if(values[i].indexOf("byr") != -1 && values[i].indexOf("iyr") != -1 && values[i].indexOf("eyr") != -1 && values[i].indexOf("hgt") != -1 && values[i].indexOf("hcl") != -1 && values[i].indexOf("ecl") != -1 && values[i].indexOf("pid") != -1) {
                passports++;
            }
        }
        System.out.println("Number of acceptable passports: " + passports);
    }

    public static String getValues() {
        //Replace the return String with the values to be used
        String values = "";
        return values;
    }

}
