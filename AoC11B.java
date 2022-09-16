import java.util.Arrays;

public class AoC11B {
    //For both programs, the values must be provided as runtime arguments
    public static void main(String[] args) {
        //Find how many seats are occupied after following the (different) given rules of cellular automata
        String[] values = args;
        String[] previousValues = new String[values.length];
        int occupiedSeats = 0;

        while (!Arrays.equals(previousValues, values)) {
            previousValues = values;
            values = checkSeatingSystem(previousValues);
        }

        for (String i : values) {
            for (int j = 0; j < i.length(); j++) {
                if(i.charAt(j) == '#') {
                    occupiedSeats++;
                }
            }
        }

        System.out.println("Number of occupied seats: " + occupiedSeats);
    }

    public static String[] checkSeatingSystem(String[] values) {
        String[] parallelValues = Arrays.copyOf(values, values.length);
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length(); j++) {
                parallelValues[i] = parallelValues[i].substring(0,j) + replaceByRules(i, j, values) + parallelValues[i].substring(j + 1);
            }
        }
        return parallelValues;
    }

    public static String replaceByRules(int row, int column, String[] all) {
        String seat = all[row].substring(column,column + 1);

        int adjacentOccupiedSeats = occupiedAdjacentSeats(row, column, all);

        if (seat.equals(".")) {
            return ".";
        }
        else if (seat.equals("L") && adjacentOccupiedSeats == 0) {
            return "#";
        }
        else if (seat.equals("#") && adjacentOccupiedSeats >= 5) {
            return "L";
        }
        else {
            return seat;
        }
    }

    public static int occupiedAdjacentSeats(int row, int column, String[] all) {
        int occupied = 0;
        int offset = 1;

        while (column - offset >= 0) {
            if(all[row].charAt(column - offset) == '#') {
                occupied++;
                break;
            }
            else if (all[row].charAt(column - offset) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (column + offset < all[0].length()) {
            if(all[row].charAt(column + offset) == '#') {
                occupied++;
                break;
            }
            else if (all[row].charAt(column + offset) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (row - offset >= 0) {
            if(all[row - offset].charAt(column) == '#') {
                occupied++;
                break;
            }
            else if (all[row - offset].charAt(column) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (row + offset < all.length) {
            if(all[row + offset].charAt(column) == '#') {
                occupied++;
                break;
            }
            else if (all[row + offset].charAt(column) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (row - offset >= 0 && column - offset >= 0) {
            if(all[row - offset].charAt(column - offset) == '#') {
                occupied++;
                break;
            }
            else if (all[row - offset].charAt(column - offset) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (row - offset >= 0 && column + offset < all[0].length()) {
            if(all[row - offset].charAt(column + offset) == '#') {
                occupied++;
                break;
            }
            else if (all[row - offset].charAt(column + offset) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (row + offset < all.length && column - offset >= 0) {
            if(all[row + offset].charAt(column - offset) == '#') {
                occupied++;
                break;
            }
            else if (all[row + offset].charAt(column - offset) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        while (row + offset < all.length && column + offset < all[0].length()) {
            if(all[row + offset].charAt(column + offset) == '#') {
                occupied++;
                break;
            }
            else if (all[row + offset].charAt(column + offset) == 'L') {
                break;
            }
            else {
                offset++;
            }
        }
        offset = 1;

        return occupied;
    }
}
