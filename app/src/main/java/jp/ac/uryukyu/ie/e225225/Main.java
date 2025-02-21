package jp.ac.uryukyu.ie.e225225;

public class Main {
    public static void main(String[] args) {
        Gomoku game = new Gomoku();
        game.printBoard(); // 初期盤面の表示

        // いくつか石を置いてみる
        game.placeStone(7, 7);
        game.placeStone(7, 8);
        game.placeStone(8, 8);
        game.placeStone(6, 6);

        // 石を置いた後の盤面を表示
        game.printBoard();
    }
}
