import java.util.Arrays;

public class AoC11A {
    //For both programs, the values must be provided as runtime arguments
    public static void main (String[] args) {
        //Find how many seats are occupied after following the given rules of cellular automata
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
        else if (seat.equals("#") && adjacentOccupiedSeats >= 4) {
            return "L";
        }
        else {
            return seat;
        }
    }

    public static int occupiedAdjacentSeats(int row, int column, String[] all) {
        int occupied = 0;

        if (column > 0) {
            if(all[row].charAt(column - 1) == '#') {
                occupied++;
            }
            if (row > 0) {
                if(all[row - 1].charAt(column - 1) == '#') {
                    occupied++;
                }
            }
            if (row < all.length - 1) {
                if(all[row + 1].charAt(column - 1) == '#') {
                    occupied++;
                }
            }
        }

        if (column < all[0].length() - 1) {
            if(all[row].charAt(column + 1) == '#') {
                occupied++;
            }
            if (row > 0) {
                if(all[row - 1].charAt(column + 1) == '#') {
                    occupied++;
                }
            }
            if (row < all.length - 1) {
                if(all[row + 1].charAt(column + 1) == '#') {
                    occupied++;
                }
            }
        }

        if (row > 0) {
            if(all[row - 1].charAt(column) == '#') {
                occupied++;
            }
        }

        if (row < all.length - 1) {
            if(all[row + 1].charAt(column) == '#') {
                occupied++;
            }
        }

        return occupied;
    }
}
