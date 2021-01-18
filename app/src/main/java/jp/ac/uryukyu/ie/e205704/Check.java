package jp.ac.uryukyu.ie.e205704;

import java.awt.Color; 

public class Check {
    static boolean check = true;
    static boolean bb = false;
    static boolean ww = false;
    Check(){}

    public static void PieceChecker(int i,int j,int sx,int sy){
        int mx = sx+i;
        int my = sy+j;
        while(true){    
            if(Piece.p[mx][my] <= 0)return;
            if(Piece.p[mx][my] == Piece.turn){
                while(mx != sx || my != sy){
                    Piece.p[mx][my] = Piece.turn;
                    mx -= i;
                    my -= j;
                }
                return;
            }
            mx += i;
            my += j;
        }
    }
    public static boolean notChecker(int sx ,int sy , int turn){
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0)) {
                    int cnt = 0;
                    int mx = sx + i;
                    int my = sy + j;
                    while (true) {

                        if (Piece.p[mx][my] <= 0) {
                            break;
                        }
                        if (Piece.p[mx][my] == turn && Piece.p[sx][sy] == Piece.NULL) {
                            if (cnt > 0) {
                                return true;
                            }
                            break;
                        }
                        mx += i;
                        my += j;
                        cnt += 1;
                    }
                }
            }
        }
        return false;
    }

    public static boolean finChecker(){
        int nullCnt = 0;
        int blackCnt = 0;
        int whiteCnt = 0;
        for(int x=1; x<=8; x++){
            for(int y=1;y<=8;y++){
                if(Piece.p[x][y] == Piece.NULL){
                    if(notChecker(x, y, Piece.BLACK) || notChecker(x,y,Piece.WHITE)){
                        return false;
                    }
                    else{
                        nullCnt++;
                    }
                }
                else if(Piece.p[x][y] == Piece.BLACK){
                    blackCnt++;
                }
                else if(Piece.p[x][y] == Piece.WHITE){
                    whiteCnt++;
                }
            }
        }
        if(blackCnt == 0 || whiteCnt == 0 || nullCnt == 0){
            result(blackCnt,whiteCnt);
            return true;
        }
        result(blackCnt,whiteCnt);
        return true;
    }

    public static void result(int b,int w){
        String bString = String.valueOf(b);
        String wString = String.valueOf(w);
        if(b > w){
            Board.header("黒の勝ち 　黒 : "+bString+"  白 : "+wString,Color.BLACK,Color.WHITE);
        }
        else if(b < w){
            Board.header("白の勝ち 　黒 : "+bString+"  白 : "+wString,Color.WHITE,Color.BLACK);
        }
        else{
            if(Piece.turn == Piece.BLACK){
                Board.header("引き分け",Color.BLACK,Color.WHITE);
            }
            else{
                Board.header("引き分け",Color.WHITE,Color.BLACK);
            }
        }
    }

    public static boolean passChecker(int turn){
        int nullCnt = 0;
        for(int x=1; x<=8; x++){
            for(int y=1;y<=8;y++){
                if(Piece.p[x][y] == Piece.NULL){
                    if(notChecker(x,y,turn)){
                        nullCnt++;
                    }
                }

            }
        }
        if(nullCnt > 0){
            return false;
        }
        return true;
    }

    public static void turnCheck(){
        if(Piece.turn == Piece.BLACK){
            Board.header("黒の番です",Color.BLACK,Color.WHITE);
        }
        else{
            Board.header("白の番です",Color.WHITE,Color.BLACK);
        }
    }
}
