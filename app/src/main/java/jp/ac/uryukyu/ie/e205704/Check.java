package jp.ac.uryukyu.ie.e205704;

public class Check {
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
}
