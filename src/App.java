import java.util.Random;

public class App {
    private Random random = new Random();
    private int[][] chessBoard = new int[8][8];

    public App() {
        this.generateRooks();
        this.checkForRooksInDanger(chessBoard);
    }

    private void generateRooks() {
        for (int i = 0; i < 6; i++) {
            int positionX = random.nextInt(0, chessBoard.length);
            int positionY = random.nextInt(0, chessBoard.length);

            if (chessBoard[positionX][positionY] == 1) {
                i--;
                continue;
            }
            chessBoard[positionX][positionY] = 1;
        }
    }

    public void checkForRooksInDanger(int[][] array) {
        for (int[] ints : array) {
            System.out.print("| ");
            for (int anInt : ints) {
                System.out.print(anInt + " | ");
            }
            System.out.println();
        }
        System.out.println();

        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                for (int k = j + 1; k < cols; k++) {
                    if (array[i][j] != 0 && array[i][k] != 0) {
                        System.out.println("Rooks in range of each other at: (" + i + ", " + j + ") and (" + i + ", " + k + ")!");

                    }
                }
            }
        }

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows - 1; i++) {
                for (int k = i + 1; k < rows; k++) {
                    if (array[i][j] != 0 && array[k][j] != 0) {
                        System.out.println("Rooks in range of each other at: (" + i + ", " + j + ") and (" + k + ", " + j + ")!");

                    }
                }
            }
        }
    }
}