package jp.ac.uryukyu.ie.e205704;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CheckTest {
    /**
     * Warriarの攻撃力を検証。
     * 検証手順
     *  (1) Board,Pieceを設定。
     *  (2) 白のコマが置かれていたところに黒を置く。
     *  (3) 全部黒になっているはずなのでfinChecker()がtrueを返すことを期待。
     */
    @Test
    void finCheckerTest() {
        Board demoBoard = new Board();
        Piece demoPiece = new Piece();
        
        demoPiece.pieceSetting();
        demoPiece.p[4][5] = Piece.BLACK;
        demoPiece.p[5][4] = Piece.BLACK;
        demoBoard.putPiece();
        assertEquals(Check.finChecker(),true); 
    }
}