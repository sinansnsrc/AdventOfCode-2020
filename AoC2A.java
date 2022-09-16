import java.util.Arrays;

public class AoC2A {
    //For both programs, the values to be checked must be passed in as runtime arguments
    public static void main(String[] args) {
        //Verify passwords have the given letter in an amount within the given range, keep track of how many passwords follow this rule
        String[] range = new String[args.length / 3];
        String[] letter = new String[args.length / 3];
        String[] password = new String[args.length / 3];

        int count = 0;
        int total = 0;

        for(int i = 0; i < args.length; i++){
            if(i % 3 == 0) { range[i / 3] = args[i]; }
            else if (i % 3 == 1) { letter[i / 3] = args[i].substring(0, args[i].indexOf(":")); }
            else if (i % 3 == 2) { password[i / 3] = args[i]; }
        }

        for(int i = 0; i < password.length; i++) {
            for (int j = 0; j < password[i].length(); j++){
                if(password[i].substring(j,j + 1).equals(letter[i])) {
                    count++;
                }
            }
            if(count >= Integer.parseInt(range[i].substring(0,range[i].indexOf("-"))) && count <= Integer.parseInt(range[i].substring(range[i].indexOf("-") + 1))){
                total++;
            }
            count = 0;
        }

        System.out.println("Number of passwords provided: " + password.length);
        System.out.println("Total number of acceptable passwords: " + total);
    }
}
