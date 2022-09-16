import java.util.ArrayList;

public class AoC5B {
    //For both programs, the data to be checked must be passed in as runtime arguments
    public static void main(String[] args) {
        //Find the unoccupied seat id out of the seat ids found in the last program
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (int i = 0; i < args.length; i++){
            String rowStr = args[i].substring(0,7);
            String columnStr = args[i].substring(7);

            int row = findRow(rowStr);
            int column = findColumn(columnStr);
            int seatID = (row * 8) + column;

            ids.add(seatID);
        }
        ids.sort(Integer::compareTo); //Puts the list in increasing order
        int lastID = ids.get(0);
        for (int i : ids) {
            if (i - lastID == 2) {
                System.out.println("The unoccupied seat id is: " + (i - 1));
            }
            else { lastID = i; }
        }
    }

    public static int findRow(String args){
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int j = 0; j < 128; j++) { row.add(j); }

        for (int i = 0; i < args.length(); i++){
            int remove = row.size() / 2;
            if (args.charAt(i) == 'F'){
                row.subList(remove, row.size()).clear();
            }
            else if (args.charAt(i) == 'B'){
                row.subList(0, remove).clear();
            }
        }
        return row.get(0);
    }

    public static int findColumn(String args){
        ArrayList<Integer> row = new ArrayList<Integer>();
        for (int j = 0; j < 8; j++) { row.add(j); }

        for (int i = 0; i < args.length(); i++){
            int remove = row.size() / 2;
            if (args.charAt(i) == 'L'){
                row.subList(remove, row.size()).clear();
            }
            else if (args.charAt(i) == 'R'){
                row.subList(0, remove).clear();
            }
        }
        return row.get(0);
    }
}
