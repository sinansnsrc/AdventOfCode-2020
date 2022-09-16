import java.util.Arrays;

public class AoC2B {
    //For both programs, the values to be checked must be passed in as runtime arguments
    public static void main(String[] args) {
        //Verify passwords have the given letter exclusively at one of the two indexes provided, keep track of how many passwords follow this rule
        String[] index = new String[args.length / 3];
        String[] letter = new String[args.length / 3];
        String[] password = new String[args.length / 3];

        for(int i = 0; i < args.length; i++){
            if(i % 3 == 0) { index[i / 3] = args[i]; }
            else if (i % 3 == 1) { letter[i / 3] = args[i].substring(0, args[i].indexOf(":")); }
            else if (i % 3 == 2) { password[i / 3] = args[i]; }
        }

        int total = 0;
        int firstIndex = 0;
        int secondIndex = 0;

        for(int i = 0; i < password.length; i++) {
            firstIndex = Integer.parseInt(index[i].substring(0, index[i].indexOf("-")));
            secondIndex = Integer.parseInt(index[i].substring(index[i].indexOf("-") + 1));
            if(password[i].substring(firstIndex - 1, firstIndex).equals(letter[i]) ^ password[i].substring(secondIndex - 1, secondIndex).equals(letter[i])) {
                total++;
            }
        }

        System.out.println("Number of passwords provided: " + password.length);
        System.out.println("Total number of acceptable passwords: " + total);
    }
}
