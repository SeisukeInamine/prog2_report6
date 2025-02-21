package jp.ac.uryukyu.ie.e225225;

import java.util.Random;

/**
 * 五目並べのゲームロジックを管理するクラス
 */
public class Gomoku {
    private char[][] board;
    private char currentPlayer;
    private int mode;
    private static final int SIZE = 15;
    private Random random;

    public Gomoku(int mode) {
        this.board = new char[SIZE][SIZE];
        this.currentPlayer = 'o';
        this.mode = mode;
        this.random = new Random();
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public boolean placeStone(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE || board[row][col] != '.') {
            return false;
        }
        board[row][col] = currentPlayer;
        currentPlayer = (currentPlayer == 'o') ? 'x' : 'o';
        return true;
    }

    public void aiMove() {
        int row, col;
        do {
            row = random.nextInt(SIZE);
            col = random.nextInt(SIZE);
        } while (board[row][col] != '.');

        System.out.println("AIが " + row + " " + col + " に石を置きました。");
        placeStone(row, col);
    }

    public char checkWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] != '.' && (checkDirection(i, j, 1, 0) || 
                                           checkDirection(i, j, 0, 1) || 
                                           checkDirection(i, j, 1, 1) || 
                                           checkDirection(i, j, 1, -1))) {
                    return board[i][j];
                }
            }
        }
        return '.';
    }

    private boolean checkDirection(int row, int col, int dRow, int dCol) {
        char start = board[row][col];
        int count = 1;
        for (int i = 1; i < 5; i++) {
            int newRow = row + dRow * i;
            int newCol = col + dCol * i;
            if (newRow < 0 || newRow >= SIZE || newCol < 0 || newCol >= SIZE || board[newRow][newCol] != start) {
                return false;
            }
            count++;
        }
        return count == 5;
    }
}
