public class AoC6A {
    //For both programs, the values must be pasted as a string in the getValues() method
    public static void main(String[] args){
        //Find how many questions were answered yes, where each letter represents a question, without counting duplicate yeses to the same question
        String[] values = getValues().split("\n\n");
        for(int i = 0; i < values.length; i++) { values[i] = values[i].replace("\n", ""); }

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        int total = 0;

        for(String i : values) {
            for (int j = 0; j < alphabet.length() ; j++) {
                if(i.indexOf(alphabet.substring(j, j+1)) != -1){
                    total++;
                }
            }
        }

        System.out.println("Total number of distinct yeses: " + total);
    }

    public static String getValues(){
        String values = "";
        return values;
    }

}
