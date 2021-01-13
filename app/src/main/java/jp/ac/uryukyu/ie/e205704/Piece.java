package jp.ac.uryukyu.ie.e205704;

import javax.swing.JButton; 

public class Piece extends JButton{ 

    static int[][] p = new int[10][10];
    public static final int OUT =-1;         //盤外 
    public static final int NULL = 0;              //コマが無いマス 
    public static final int BLACK = 1; 
    public static final int WHITE = 2; 

    static int turn = BLACK;
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
}

