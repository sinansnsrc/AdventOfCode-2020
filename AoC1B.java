public class AoC1B {
    //For both programs, the numbers to be checked must be passed in as runtime arguments
    public static void main(String[] args) {
        //Find the three numbers in the given list of numbers that sum to 2020, then multiply the three values as the answer
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) { nums[i] = Integer.parseInt(args[i]); }

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        boolean check = true;

        for(int a = 0; a < nums.length - 2; a++) {
            for(int b = a + 1; b < nums.length - 1; b++) {
                for(int c = b + 1; c < nums.length; c++) {
                    if(check && (nums[a] + nums[b] + nums[c]) == 2020) {
                        indexA = a;
                        indexB = b;
                        indexC = c;
                        check = false;
                    }
                }
            }
        }

        System.out.println("Value a: " + nums[indexA]);
        System.out.println("Value b: " + nums[indexB]);
        System.out.println("Value c: " + nums[indexC]);
        System.out.println("Sum: " + (nums[indexA] + nums[indexB] + nums[indexC]));
        System.out.println("Product: " + (nums[indexA] * nums[indexB] * nums[indexC]));
    }

}
