import java.util.ArrayList;
import java.util.Arrays;

public class AoC7B {
    //For this program, the values must be pasted as a string in the getValues() method
    public static void main(String[] args){
        //Find out how many bags a shiny gold bag can hold
        String[][] bags = getValues();

        System.out.println("Number of bags that can hold the shiny gold bag are: " + findBagsThatCanHold("shiny gold", bags));
    }

    public static int findBagsThatCanHold(String bagColor, String[][] allBags) {
        ArrayList<String> bagsToCheck = new ArrayList<String>();
        int numOfBags = 0;

        for (int i = 0; i < allBags.length; i++) {
            if (allBags[i].length != 0) {
                if (allBags[i][0].equals(bagColor)){
                    for (int j = 1; j < allBags[i].length; j++)
                    {
                        if (j % 2 == 1) {
                            numOfBags += Integer.parseInt(allBags[i][j]);
                        }
                        if (j % 2 == 0) {
                            numOfBags += Integer.parseInt(allBags[i][j - 1]) * findBagsThatCanHold(allBags[i][j], allBags);
                        }
                    }
                }
            }
        }

        return numOfBags;
    }

    public static String[] sortCurrentLine(String bags){
        if (bags.indexOf(" no ") != -1) {
            String[] a = new String[0];
            return a;
        }
        else {
            ArrayList<String> values = new ArrayList<String>();
            values.add(bags.substring(0, bags.indexOf("contain") - 1));
            bags = bags.substring(bags.indexOf("contain") + 8);
            while(bags.length() > 0){
                values.add(bags.substring(0, 1));
                bags = bags.substring(2);
                if (bags.indexOf(",") != -1) {
                    values.add(bags.substring(0, bags.indexOf(",")));
                    bags = bags.substring(bags.indexOf(",") + 2);
                }
                else {
                    values.add(bags);
                    bags = "";
                }
            }

            String[] returnValues = new String[values.size()];

            for (int i = 0; i < values.size(); i++){
                returnValues[i] = values.get(i);
            }
            return returnValues;
        }

    }

    public static String[][] getValues(){
        //Replace the return String with the values to be used
        String values = "";

        String[] unsortedValues = values.replace("bags", "").replace("bag","").replace("  ", " ").replace(" .", "").replace(" ,", ",").split("\n");
        String[][] bags = new String[unsortedValues.length][];

        for (int i = 0; i < unsortedValues.length; i++) {
            bags[i] = sortCurrentLine(unsortedValues[i]);
        }
        return bags;
    }

}
