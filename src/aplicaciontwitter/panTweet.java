/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciontwitter;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Pablo Alonso Vazquez pav.vigo@gmail.com
 * Panel que formatea los minitweets en elementos de la interfaz grafica.
 * 
 * 
 */
public class panTweet extends JPanel{
    MiniTweet mt;
    JTextField jlUser;
    JTextArea jlTweet;

    public panTweet(MiniTweet mt) {
        this.mt = mt;
        initComponents();
        
        
        
        
    }
    
    public void initComponents(){
    jlUser = new JTextField(mt.getUsername());
    jlUser.setEditable(false);
    jlTweet = new JTextArea(mt.getText());
    jlTweet.setEditable(false);
    jlTweet.setColumns(20);
    
    jlTweet.setWrapStyleWord(true);
    this.setLayout(new GridLayout(2,1,5,5));
    this.add(jlUser);
    this.add(jlTweet);
    
    
    
    }
    
}
