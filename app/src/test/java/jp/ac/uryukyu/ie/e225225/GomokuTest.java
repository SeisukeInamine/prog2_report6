package jp.ac.uryukyu.ie.e225225;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Gomokuクラスの単体テスト
 */
public class GomokuTest {

    @Test
    public void testCheckWinHorizontal() {
        Gomoku game = new Gomoku(1);
        game.placeStone(0, 0);
        game.placeStone(1, 0);
        game.placeStone(0, 1);
        game.placeStone(1, 1);
        game.placeStone(0, 2);
        game.placeStone(1, 2);
        game.placeStone(0, 3);
        game.placeStone(1, 3);
        game.placeStone(0, 4);
        assertEquals('o', game.checkWin());
    }

    @Test
    public void testCheckWinVertical() {
        Gomoku game = new Gomoku(1);
        game.placeStone(0, 0);
        game.placeStone(0, 1);
        game.placeStone(1, 0);
        game.placeStone(1, 1);
        game.placeStone(2, 0);
        game.placeStone(2, 1);
        game.placeStone(3, 0);
        game.placeStone(3, 1);
        game.placeStone(4, 0);
        assertEquals('o', game.checkWin());
    }

    @Test
    public void testCheckWinDiagonalRight() {
        Gomoku game = new Gomoku(1);
        game.placeStone(0, 0);
        game.placeStone(1, 0);
        game.placeStone(1, 1);
        game.placeStone(2, 0);
        game.placeStone(2, 2);
        game.placeStone(3, 0);
        game.placeStone(3, 3);
        game.placeStone(4, 0);
        game.placeStone(4, 4);
        assertEquals('o', game.checkWin());
    }

    @Test
    public void testNoWin() {
        Gomoku game = new Gomoku(1);
        game.placeStone(0, 0);
        game.placeStone(0, 1);
        game.placeStone(1, 0);
        game.placeStone(1, 1);
        game.placeStone(2, 0);
        assertEquals('.', game.checkWin());
    }
}
