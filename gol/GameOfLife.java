package gol;

import java.util.Arrays;

public class GameOfLife implements Board {

    // Integers: 0 or 1 for alive or dea
    private int[][] board;

    public GameOfLife(int x, int y)
    {
        // Construct a 2d array of the given x and y size.
        board = new int[x][y];
    }

    // Set values on the board
    public void set(int x, int y, int[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                board[i + x][j + y] = data[i][j];
            }
        }
    }

    // Run the simulation for a number of turns
    public void run(int turns) {
        // call step the number of times requested
        for (int i = 0; i < turns; i++) {
            step();
        }
    }

    // Step the simulation forward one turn.
    public void step()
    {
        print();
        // Update the game board, store a 1 if the cell is alive and a 0 otherwise.

        int[][] next = new int[board.length][board[0].length];

        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {

                int alive = board[x][y];
                int neighbors = countNeighbors(x, y);

                if (alive == 1) {
                    // Rules for live cells:
                    // Any live cell with 2 or 3 neighbors lives; otherwise dies.
                    if (neighbors == 2 || neighbors == 3)
                        next[x][y] = 1;
                    else
                        next[x][y] = 0;
                } else {
                    // Rules for dead cells:
                    // Any dead cell with exactly 3 neighbors becomes alive.
                    if (neighbors == 3)
                        next[x][y] = 1;
                    else
                        next[x][y] = 0;
                }
            }
        }

        board = next;
    }


    public int countNeighbors(int x, int y) {
        int count = 0;
        // count the number of neighbors the cell has
        // use the get(x,y) method to read the board state you need.

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {

                if (dx == 0 && dy == 0)
                    continue; // skip the cell itself

                count += get(x + dx, y + dy);
            }
        }

        return count;
    }

    // Get a value from the board with "wrap around"
    // Locations outside the board will loop back into the board.
    // Ex: -1 will read board.length-1
    public int get(int x, int y) {
        int xLimit = board.length;
        int yLimit = board[0].length;
        return board[(x + xLimit) % xLimit][(y + yLimit) % yLimit];
    }

    // Test helper to get the whole board state
    public int[][] get()
    {
        return board;
    }

    // Test helper to print the current state
    public void print(){
        // Print the header
        System.out.print("\n ");
        for (int y = 0; y < board[0].length; y++) {
            System.out.print(y%10 + " ");
        }

        for (int x = 0; x < board.length; x++) {
            System.out.print("\n" + x%10);
            for (int y=0; y<board[x].length; y++)
            {
                if (board[x][y] == 1)
                {
                    System.out.print("⬛");
                }
                else
                {
                    System.out.print("⬜");
                }
            }
        }
        System.out.println();
    }
}
