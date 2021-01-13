package jp.ac.uryukyu.ie.e205704;

import javax.swing.JButton; 

public class Piece extends JButton{ 

    static int[][] p = new int[10][10];
    public static final int OUT =-1;         //盤外 
    public static final int NULL = 0;              //コマが無いマス 
    public static final int BLACK = 1; 
    public static final int WHITE = 2; 

    static int turn = BLACK;
}
