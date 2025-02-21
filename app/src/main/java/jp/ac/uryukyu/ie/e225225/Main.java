package jp.ac.uryukyu.ie.e225225;

import java.util.Scanner;

/**
 * 五目並べのゲームを実行するメインクラス
 */
public class Main {
    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            game.printBoard();
            System.out.print("Enter row and column (e.g., 3 4): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (game.placeStone(x, y)) {
                char winner = game.checkWin();
                if (winner != '.') {
                    game.printBoard();
                    System.out.println("Player " + winner + " wins!");
                    running = false;
                }
            }
        }
        scanner.close();
    }
}
