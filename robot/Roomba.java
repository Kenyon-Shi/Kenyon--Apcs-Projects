package robot;
import kareltherobot.*;

public class Roomba implements Directions {
    public static void main(String[] args) {
        String worldName = "robot/finalTestWorld2024.wld";
        World.readWorld(worldName);
        World.setVisible(true);
        World.setDelay(0);

        RoombaCleaner cleaner = new RoombaCleaner(26, 101, East, infinity);
        cleaner.cleanRoom();
        cleaner.report();
    }
}

class RoombaCleaner extends Robot {
    private int area = 0;
    private int piles = 0;
    private int totalBeepers = 0;
    private int largestPile = 0;
    private int largestPileStreet = 0;
    private int largestPileAvenue = 0;
    private int moves=0;

    public RoombaCleaner(int street, int avenue, Direction dir, int beepers) {
        super(street, avenue, dir, beepers);
    }

    public void cleanRoom() {
        // Always start facing east
        while (!facingEast()) {
            turnLeft();
        }

        boolean running = true;
        while (running) {
            area++;
            int pileSize = 0;

            // Pick up pile
            while (nextToABeeper()) {
                pickBeeper();
                pileSize++;
                totalBeepers++;
            }

            if (pileSize > 0) {
                piles++;
                if (pileSize > largestPile) {
                    largestPile = pileSize;
                    largestPileStreet = street();
                    largestPileAvenue = avenue();
                }
            }

            // Move or zig-zag
            if (frontIsClear()) {
                move();
            } else {
                if (facingEast()) {
                    turnLeft();
                    if (frontIsClear()) {
                        move();
                        turnLeft();
                    } else running = false;
                } else if (facingWest()) {
                    turnRight();
                    if (frontIsClear()) {
                        move();
                        turnRight();
                    } else running = false;
                }
            }
        }
        moves=area;
    }
    
    public void report() {
        
        double avgPile = (piles > 0) ? (double) totalBeepers / piles : 0.0;
        double percentDirty = (area > 0) ? (piles * 100.0 / area) : 0.0;

        System.out.println("=== Roomba Cleaning Report ===");
        System.out.println("Area of room: " + area);
        System.out.println("number of moves:" + area);
        System.out.println("Number of piles: " + piles);
        System.out.println("Total beepers: " + totalBeepers);
        System.out.println("Largest pile: " + largestPile +
                " at (" + largestPileAvenue + ", " + largestPileStreet + ")");
        System.out.printf("Average pile size: %.2f%n", avgPile);
        System.out.printf("Percent dirty: %.1f%%%n", percentDirty);
        System.out.println("==============================");
    }

    private void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }
}

