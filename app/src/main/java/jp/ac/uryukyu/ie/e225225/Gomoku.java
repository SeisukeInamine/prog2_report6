package jp.ac.uryukyu.ie.e225225;

/**
 * 五目並べの基本実装
 * 盤面の初期化、手番管理、石を置く処理、勝利判定を行う。
 */
public class Gomoku {
    private char[][] board;
    private boolean turn; // true: 'o', false: 'x'
    private static final int SIZE = 15;

    /**
     * コンストラクタ：盤面を初期化
     */
    public Gomoku() {
        initialize();
    }

    /**
     * 盤面の初期化
     */
    public void initialize() {
        board = new char[SIZE][SIZE];
        turn = true;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '.'; // 空白を示す
            }
        }
    }

    /**
     * 盤面の表示
     */
    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 石を置く
     * @param x 横座標
     * @param y 縦座標
     * @return 成功すればtrue、失敗すればfalse
     */
    public boolean placeStone(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE || board[x][y] != '.') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        board[x][y] = turn ? 'o' : 'x';
        turn = !turn;
        return true;
    }

    /**
     * 5つ並んでいるかをチェックする
     * @return 'o' が勝利: 'o', 'x' が勝利: 'x', まだ勝敗が決まっていない: '.'
     */
    public char checkWin() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                char player = board[i][j];

                // 横方向
                if (j <= SIZE - 5 &&
                        board[i][j + 1] == player &&
                        board[i][j + 2] == player &&
                        board[i][j + 3] == player &&
                        board[i][j + 4] == player) {
                    return player;
                }

                // 縦方向
                if (i <= SIZE - 5 &&
                        board[i + 1][j] == player &&
                        board[i + 2][j] == player &&
                        board[i + 3][j] == player &&
                        board[i + 4][j] == player) {
                    return player;
                }

                // 右下斜め
                if (i <= SIZE - 5 && j <= SIZE - 5 &&
                        board[i + 1][j + 1] == player &&
                        board[i + 2][j + 2] == player &&
                        board[i + 3][j + 3] == player &&
                        board[i + 4][j + 4] == player) {
                    return player;
                }

                // 左下斜め
                if (i <= SIZE - 5 && j >= 4 &&
                        board[i + 1][j - 1] == player &&
                        board[i + 2][j - 2] == player &&
                        board[i + 3][j - 3] == player &&
                        board[i + 4][j - 4] == player) {
                    return player;
                }
            }
        }
        return '.'; // 勝者なし
    }
}
