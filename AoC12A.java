import java.util.Arrays;

public class AoC12A {
    public static void main(String[] args) {
        String[] values = args;
        int[] shipLocation = {0,0,0};

        for (String i : values) {
            shipLocation = runInstructions(i, shipLocation);
        }

        System.out.println("The ship is at (" + shipLocation[0] + "," + shipLocation[1] + ").");
        System.out.println("The manhattan distance is " + (Math.abs(shipLocation[0]) + Math.abs(shipLocation[1])));
    }

    public static int[] runInstructions(String instruction, int[] shipLocation) {
        char action = instruction.charAt(0);
        int actionValue = Integer.parseInt(instruction.substring(1));
        int heading = shipLocation[2];

        if (action == 'L' || action == 'R') {
            switch (action) {
                case 'L':
                    heading += actionValue;
                    while (heading >= 360) {
                        heading -= 360;
                    }
                    break;
                case 'R':
                    heading -= actionValue;
                    while (heading < 0) {
                        heading += 360;
                    }
                    break;
            }

            shipLocation[2] = heading;
        }
        else if (action == 'F') {
            switch(heading) {
                case 0:
                    shipLocation[0] += actionValue;
                    break;
                case 90:
                    shipLocation[1] += actionValue;
                    break;
                case 180:
                    shipLocation[0] -= actionValue;
                    break;
                case 270:
                    shipLocation[1] -= actionValue;
                    break;
            }
        }
        else {
            switch(action) {
                case 'N':
                    shipLocation[1] += actionValue;
                    break;
                case 'S':
                    shipLocation[1] -= actionValue;
                    break;
                case 'E':
                    shipLocation[0] += actionValue;
                    break;
                case 'W':
                    shipLocation[0] -= actionValue;
                    break;
            }
        }
        return shipLocation;
    }

}
