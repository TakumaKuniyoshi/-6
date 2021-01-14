package jp.ac.uryukyu.ie.e205704;

import java.awt.Color; 
import java.awt.Font; 
import java.awt.Insets; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Board implements ActionListener{

    Piece[][] pButton;

    static JFrame frame = new JFrame("リバーシ");
    static JPanel panel = new JPanel();
    JButton[][] b = new JButton[8][8]; 

    public Board(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setSize(680,750);
        panel.setLayout(null);
        panel.setBackground(new Color(44,144,59));
        header("スタート　黒の番です",Color.BLACK,Color.WHITE);
        frame.add(panel);

        pButton = new Piece[8][8];
        for(int i=0; i<64; i++) 
        { 
            int x = i/8; 
            int y = i%8; 
             
            pButton[x][y] = new Piece(); 
            pButton[x][y].setSize(80,80); 
            pButton[x][y].setBounds(x*80+10, y*80+10, 80, 80); 
            pButton[x][y].setMargin(new Insets(0,0,0,0)); 
            pButton[x][y].setBackground(Color.GRAY); 
            pButton[x][y].setFont(new Font("ＭＳゴシック", Font.PLAIN, 80)); 
            pButton[x][y].setActionCommand(String.valueOf(i));            //ボタン判別に利用 
            pButton[x][y].addActionListener(this); 
            panel.add(pButton[x][y]); 
        }
    }
    public void actionPerformed(ActionEvent e) { 
        String str = e.getActionCommand(); 
        System.out.println(str); 
        int data = Integer.parseInt(str); 
         
        int x = data/8; 
        int y = data%8;
        if(Piece.p[x+1][y+1] == Piece.NULL && Check.notChecker(x+1, y+1,Piece.turn)){
            Piece.doRev(x+1,y+1);
            Piece.p[x+1][y+1] = Piece.turn;
            putPiece(); 

            if(Piece.turn == Piece.BLACK){
                Piece.turn = Piece.WHITE;
            }
            else{
                Piece.turn = Piece.BLACK;
            }
            if(Check.passChecker(Piece.turn)){
                if(Piece.turn == Piece.BLACK){
                    Piece.turn = Piece.WHITE;
                }
                else{
                    Piece.turn = Piece.BLACK;
                }
            }
        }
        if(Piece.turn == Piece.BLACK){
            header("黒の番です",Color.BLACK,Color.WHITE);
        }
        else{
            header("白の番です",Color.WHITE,Color.BLACK);
        }
        Check.finChecker();
    }
    public void putPiece(){ 
         
        for(int i=0; i<100; i++) 
        { 
            int x = i/10; 
            int y = i%10; 
             
            if(Piece.p[x][y] == Piece.BLACK) 
            { 
                pButton[x-1][y-1].setText("●");             
            } 
            else if(Piece.p[x][y] == Piece.WHITE) 
            { 
                pButton[x-1][y-1].setText("○"); 
            } 
        } 
    }
    
    public static void header(String str,Color winc,Color losc){
        Dimension headerPanelDimension = new Dimension(640, 50);
		JPanel headerPanel = setPanel(winc, headerPanelDimension);
		JLabel headerLabel = new JLabel(str);
		headerLabel = setFont(losc,headerLabel,24);
		headerPanel.add(headerLabel);
		frame.add(headerPanel,BorderLayout.NORTH);
        frame.add(panel);  
    }

    public static JPanel setPanel(Color color, Dimension PanelDimension) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(PanelDimension);
		panel.setLayout(new BorderLayout());
		panel.setBackground(color);
        return(panel);
    }
    public static JLabel setFont(Color clr,JLabel label,int strSize) {
		label.setForeground(clr);
		Font labelFont = new Font("ＭＳ ゴシック",Font.PLAIN,strSize);
		label.setFont(labelFont);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		return(label);
    }
}