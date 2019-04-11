/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciontwitter;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Pablo Alonso Vazquez <pav.vigo@gmail.com>
 */
public class frameMain extends JFrame{
    JPanel panelContenedorTweets = new JPanel();
    GestorTweet gt = new GestorTweet();
    ArrayList<MiniTweet> al_miniTweet;
    JScrollPane jsp = new JScrollPane();
    
    public frameMain() throws HeadlessException {
        panelContenedorTweets.setLayout(new GridLayout(6,1,5,5));
        al_miniTweet = gt.getMiniTweets();
        
        for(int i = 0;i < 5;i++){
        panelContenedorTweets.add(new panTweet(al_miniTweet.get(i)));
                }
        this.add(panelContenedorTweets);
        this.pack();
        this.setSize(500,500);
        this.setVisible(true);
    }
    
    
    
    
    
}
