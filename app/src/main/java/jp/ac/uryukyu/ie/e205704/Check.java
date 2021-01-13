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
    public static boolean notChecker(int sx ,int sy){
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
                        if (Piece.p[mx][my] == Piece.turn) {
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
}
