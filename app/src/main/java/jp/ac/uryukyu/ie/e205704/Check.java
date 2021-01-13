package jp.ac.uryukyu.ie.e205704;

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
                        if (Piece.p[mx][my] == turn) {
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
        for(int x=1; x<=8; x++){
            for(int y=1;y<=8;y++){
                if(Piece.p[x][y] == Piece.NULL){
                        return false;
                }
            }
        }
        winchecker();
        return true;
    }

    public static void winchecker(){
        int blackCnt = 0;
        int whiteCnt = 0;
        for(int x=1; x<=8; x++){
            for(int y=1;y<=8;y++){
                if(Piece.p[x][y] == Piece.BLACK){
                    blackCnt++;
                }
                else if(Piece.p[x][y] == Piece.WHITE){
                    whiteCnt++;
                }
            }
        }
        System.out.printf("黒 : %d\n白 : %d\n",blackCnt,whiteCnt);
    }
    public static boolean passChecker(int turn){
        if(turn == Piece.BLACK){
            bb = true;
        }
        else{
            ww = true;
        }
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
            ww=false;
            bb=false;
            return false;
        }
        else if(bb && ww){
            winchecker();
        }
        
        return true;
    }
}
