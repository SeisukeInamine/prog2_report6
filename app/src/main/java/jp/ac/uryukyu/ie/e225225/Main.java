package jp.ac.uryukyu.ie.e225225;

import java.util.Scanner;

/**
 * 五目並べのメインクラス
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("五目並べを開始します。");
        System.out.println("1:vs player");
        System.out.println("2:vs AI");
        System.out.print("モードを選択してください (1 or 2): ");
        int mode = scanner.nextInt();
        Gomoku game = new Gomoku(mode);

        while (true) {
            game.printBoard();
            System.out.print("行と列を入力してください (例: 3 4): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!game.placeStone(row, col)) {
                System.out.println("無効な手です。もう一度入力してください。");
                continue;
            }

            if (game.checkWin() != '.') {
                game.printBoard();
                System.out.println("Player " + game.checkWin() + " wins!");
                break;
            }

            if (mode == 2) {
                game.aiMove();
                if (game.checkWin() != '.') {
                    game.printBoard();
                    System.out.println("Player " + game.checkWin() + " wins!");
                    break;
                }
            }
        }

        System.out.print("もう一度遊びますか？ (y/n): ");
        char retry = scanner.next().charAt(0);
        if (retry == 'y' || retry == 'Y') {
            main(null); // 再帰的にゲームをリスタート
        } else {
            System.out.println("ゲームを終了します。");
        }
        scanner.close();
    }
}
