import java.util.Arrays;

public class AoC3A {
    //For both programs, the "slope" must be passed in as runtime arguments
    public static void main(String[] args){
        //Find how many trees (#) will be hit when traversing a given slope 3 to the right and 1 down starting from the top left down to the bottom right
        int index = 0;
        int row = 0;
        int trees = 0;
        boolean end = false;

        while(!end) {
            if(!(row > args.length - 1)) {
                if(args[row].charAt(index) == '#') {
                    trees++;
                }
                if (index + 3 >= args[row].length()){
                    index = index + 3 - 31;
                }
                else {
                    index += 3;
                }
                row++;
            }
            else {
                end = true;
            }
        }

        System.out.println("Number of trees on slope: " + trees);
    }
}
