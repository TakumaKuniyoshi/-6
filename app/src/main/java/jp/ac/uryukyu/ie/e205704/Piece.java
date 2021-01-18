package jp.ac.uryukyu.ie.e205704;

import javax.swing.JButton; 

/**
 * 盤外、何も置かれてない、置かれたコマの色を判断する変数を設定
 */
public class Piece extends JButton{ 

    private static final long serialVersionUID = 1L;
    static int[][] p = new int[10][10];
    static final int OUT =-1;         //盤外 
    static final int NULL = 0;        //コマが無いマス 
    public static final int BLACK = 1; 
    public static final int WHITE = 2; 

    static int turn = BLACK;

    /**
     * 判断する変数の設置。
     */
    public void pieceSetting(){ 
         
        for(int i=0; i<100; i++) 
        { 
            int x = i%10; 
            int y = i/10; 
             
            if(x==0 || x== 9 || y==0 || y==9) 
            { 
                p[x][y] = OUT; 
            } 
            else 
            { 
                p[x][y] = NULL; 
            } 
        } 
         
        p[4][4] = BLACK; 
        p[5][5] = BLACK; 
        p[4][5] = WHITE; 
        p[5][4] = WHITE;         // 初期配置 
         
    } 
    
    /**
     * コマが置けた時に実行される
     * @param sx　コマの位置(縦軸)
     * @param sy　コマの位置(横軸)
     */
    public static void doRev(int sx, int sy){ 
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(!(i==0 && j==0)){
                    Check.PieceChecker(i,j,sx,sy);
                }
            }
        }
    }
}

