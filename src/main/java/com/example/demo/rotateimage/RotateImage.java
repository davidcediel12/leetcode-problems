package com.example.demo.rotateimage;

public class RotateImage {


    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();

        rotateImage.rotate(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        });
    }

    public void rotate(int[][] matrix) {

        int size = matrix.length;

        int up = 0;
        int down = size - 1;

        while (up < down) {

            int[] temp = matrix[up];

            matrix[up] = matrix[down];
            matrix[down] = temp;

            up++;
            down--;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) { // Iterate just in the upper triangle of the matrix

                System.out.printf("Swapping [%d,%d] (%d) and [%d, %d] (%d)%n", i, j, matrix[i][j], j, i, matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;


            }
        }
    }

    static class InefficientSolution {
        public void rotate(int[][] matrix) {

            int moves = 0;

            int i = 0;
            int j = 0;
            int tempNumber = matrix[0][0];
            int actualNumber;
            int rounds = -1;
            int size = matrix.length;

            while (moves < size - 1) {

                actualNumber = matrix[i][j];
                matrix[i][j] = tempNumber;
                tempNumber = actualNumber;

                if (i == moves && j == moves) {

                    rounds++;

                    if (rounds >= size - (2 * moves) - 1) {
                        rounds = 0;
                        moves++;

                        if (moves > size / 2) {
                            return;
                        }
                        i++;
                        j++;
                    }

                    tempNumber = matrix[i][j];
                }


                Direction direction = calculateDirection(i, j, size, moves);

                System.out.println("Direction: " + direction + " i: " + i + " j: " + j);

                switch (direction) {
                    case UP -> i--;
                    case DOWN -> i++;
                    case RIGHT -> j++;
                    case LEFT -> j--;
                }
            }
        }


        private Direction calculateDirection(int i, int j, int size, int offset) {

            int limit = size - offset - 1;

            if (i == offset && j < limit) {
                return Direction.RIGHT;
            }

            if (j == limit && i < limit) {
                return Direction.DOWN;
            }

            if (i == limit && j > offset) {
                return Direction.LEFT;
            }

            if (i > offset && j == offset) {
                return Direction.UP;
            }

            return Direction.NONE;
        }


        enum Direction {
            RIGHT, DOWN, LEFT, UP, NONE
        }
    }
}
