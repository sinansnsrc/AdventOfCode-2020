public class AoC1A {
    //For both programs, the numbers to be checked must be passed in as runtime arguments
    public static void main(String[] args) {
        //Find the two numbers in the given list of numbers that sum to 2020, then multiply the two values as the answer
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) { nums[i] = Integer.parseInt(args[i]); }

        int indexA = 0;
        int indexB = 0;
        boolean check = true;

        for (int a = 0; a < nums.length - 1; a++) {
            for (int b = a + 1; b < nums.length; b++) {
                if(check && (nums[a] + nums[b]) == 2020) {
                    indexA = a;
                    indexB = b;
                    check = false;
                }
            }
        }

        System.out.println("Value a: " + nums[indexA]);
        System.out.println("Value b: " + nums[indexB]);
        System.out.println("Sum: " + (nums[indexA] + nums[indexB]));
        System.out.println("Product: " + (nums[indexA] * nums[indexB]));
    }

}
