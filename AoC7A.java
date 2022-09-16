import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayList;
public class AoC7A {
    //For this program, the values must be pasted as a string in the getValues() method
    public static void main(String[] args){
        //Find how many unique bags can eventually hold a shiny gold bag
        String[][] bags = getValues();
        ArrayList<String> uniqueBags = getUniqueBags(bags);

        System.out.println("Number of bags that can hold the shiny gold bag are: " + findBagsThatCanHold("shiny gold", bags, uniqueBags));
    }

    public static int findBagsThatCanHold(String bagColor, String[][] allBags, ArrayList uniqueBags) {
        ArrayList<String> bagsToCheck = new ArrayList<String>();

        for (int i = 0; i < allBags.length; i++) {
            if (allBags[i].length != 0) {
                for (int j = 1; j < allBags[i].length; j++) {
                    if (allBags[i][j].equals(bagColor)){
                        bagsToCheck.add(allBags[i][0]);
                    }
                }
            }
        }

        int numOfBags = 0;
        int numOfBagsToCheck = bagsToCheck.size();

        for (int i = 0; i < numOfBagsToCheck; i++) {
            String bag = bagsToCheck.get(i);
            if(uniqueBags.contains(bag)) {
                numOfBags++;
                uniqueBags.remove(bag);

                numOfBags += findBagsThatCanHold(bag, allBags, uniqueBags);
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

    public static ArrayList getUniqueBags(String[][] bags){
        ArrayList<String> uniqueBags = new ArrayList<String>();
        for (int i = 0; i < bags.length; i++) {
            if (bags[i] != null) {
                for (int j = 0; j < bags[i].length; j += 2) {
                    if (uniqueBags.indexOf(bags[i][j]) == -1) {
                        uniqueBags.add(bags[i][j]);
                    }
                }
            }
        }
        return uniqueBags;
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

