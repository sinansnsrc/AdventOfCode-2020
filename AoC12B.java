import java.util.Arrays;

public class AoC12B {
    public static void main(String[] args) {
        String[] values = args;

        int[] shipAndWaypointLocation = {0,0,10,1};

        for (String i : values) {
            shipAndWaypointLocation = runInstructions(i, shipAndWaypointLocation);
        }

        System.out.println("The ship is at (" + shipAndWaypointLocation[0] + "," + shipAndWaypointLocation[1] + ").");
        System.out.println("The waypoint is at (" + shipAndWaypointLocation[2] + "," + shipAndWaypointLocation[3] + ").");
        System.out.println("The manhattan distance is " + (Math.abs(shipAndWaypointLocation[0]) + Math.abs(shipAndWaypointLocation[1])));
    }

    public static int[] runInstructions(String instruction, int[] shipAndWaypoint) {
        char action = instruction.charAt(0);
        int actionValue = Integer.parseInt(instruction.substring(1));

        if (action == 'L' || action == 'R') {
            int[] newHeading = {0,0};
            switch (action) {
                case 'L':
                    if (actionValue == 90) {
                        newHeading[0] = -1 * (shipAndWaypoint[3] - shipAndWaypoint[1]);
                        newHeading[1] = (shipAndWaypoint[2] - shipAndWaypoint[0]);
                    }
                    else if (actionValue == 180) {
                        newHeading[1] = -1 * (shipAndWaypoint[3] - shipAndWaypoint[1]);
                        newHeading[0] = -1 * (shipAndWaypoint[2] - shipAndWaypoint[0]);
                    }
                    else if (actionValue == 270) {
                        newHeading[0] = (shipAndWaypoint[3] - shipAndWaypoint[1]);
                        newHeading[1] = -1 * (shipAndWaypoint[2] - shipAndWaypoint[0]);
                    }
                    break;
                case 'R':
                    if (actionValue == 90) {
                        newHeading[0] = (shipAndWaypoint[3] - shipAndWaypoint[1]);
                        newHeading[1] = -1 * (shipAndWaypoint[2] - shipAndWaypoint[0]);
                    }
                    else if (actionValue == 180) {
                        newHeading[1] = -1 * (shipAndWaypoint[3] - shipAndWaypoint[1]);
                        newHeading[0] = -1 * (shipAndWaypoint[2] - shipAndWaypoint[0]);
                    }
                    else if (actionValue == 270) {
                        newHeading[0] = -1 * (shipAndWaypoint[3] - shipAndWaypoint[1]);
                        newHeading[1] = (shipAndWaypoint[2] - shipAndWaypoint[0]);
                    }
                    shipAndWaypoint[2] = shipAndWaypoint[0] + newHeading[0];
                    shipAndWaypoint[3] = shipAndWaypoint[1] + newHeading[1];
                    break;
            }
            shipAndWaypoint[2] = shipAndWaypoint[0] + newHeading[0];
            shipAndWaypoint[3] = shipAndWaypoint[1] + newHeading[1];
        }
        else if (action == 'F') {
            int[] waypointDistance = {shipAndWaypoint[2] - shipAndWaypoint[0], shipAndWaypoint[3] - shipAndWaypoint[1]};
            for (int i = 0; i < actionValue; i++) {
                shipAndWaypoint[0] = shipAndWaypoint[2];
                shipAndWaypoint[1] = shipAndWaypoint[3];
                shipAndWaypoint[2] += waypointDistance[0];
                shipAndWaypoint[3] += waypointDistance[1];
            }
        }
        else {
            switch(action) {
                case 'N':
                    shipAndWaypoint[3] += actionValue;
                    break;
                case 'S':
                    shipAndWaypoint[3] -= actionValue;
                    break;
                case 'E':
                    shipAndWaypoint[2] += actionValue;
                    break;
                case 'W':
                    shipAndWaypoint[2] -= actionValue;
                    break;
            }
        }

        return shipAndWaypoint;
    }
}
