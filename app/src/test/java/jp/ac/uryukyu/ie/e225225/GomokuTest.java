package jp.ac.uryukyu.ie.e225225;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GomokuTest {

    /**
     * 盤面の初期状態テスト
     */
    @Test
    void testInitialize() {
        Gomoku game = new Gomoku();
        char[][] board = game.getBoard();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                assertEquals('.', board[i][j]); // すべてのマスが初期状態 ('.') であることを確認
            }
        }
    }

    /**
     * 石を置く機能のテスト
     */
    @Test
    void testPlaceStone() {
        Gomoku game = new Gomoku();
        assertTrue(game.placeStone(7, 7)); // 正常に石を置けるか
        assertFalse(game.placeStone(7, 7)); // 同じ場所に置けないことを確認
    }
}
