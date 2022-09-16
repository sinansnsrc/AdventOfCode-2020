import java.util.Arrays;

public class AoC3B {
    //For both programs, the "slope" must be passed in as runtime arguments
    public static void main(String[] args){
        //Find how many trees (#) will be hit when traversing a given slope 5 different ways from the top left down to the bottom right and multiply the number of trees hit on each slope together
        int index = 0;
        int row = 0;
        int indexIncrease = 0;
        int rowIncrease = 0;
        int trees = 0;
        long total = 1; //As an int, the result produces overflow as the integer cannot store the final answer. Long must be used.
        boolean end = false;

        for (int i = 0; i < 5; i++){
            switch(i){
                case 0:
                    indexIncrease = 1;
                    rowIncrease = 1;
                    break;
                case 1:
                    indexIncrease = 3;
                    rowIncrease = 1;
                    break;
                case 2:
                    indexIncrease = 5;
                    rowIncrease = 1;
                    break;
                case 3:
                    indexIncrease = 7;
                    rowIncrease = 1;
                    break;
                case 4:
                    indexIncrease = 1;
                    rowIncrease = 2;
                    break;
            }

            end = false;

            while(!end) {
                if(!(row > args.length - 1)) {
                    if(args[row].charAt(index) == '#') {
                        trees++;
                    }
                    if (index + indexIncrease >= args[row].length()){
                        index = index + indexIncrease - 31;
                    }
                    else {
                        index += indexIncrease;
                    }
                    row += rowIncrease;
                }
                else {
                    end = true;
                }
            }

            total *= trees;
            trees = 0;
            index = 0;
            row = 0;
        }

        System.out.println("Product of number of trees: " + total);
    }
}
