/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciontwitter;

/**
 *
 * @author Pablo Alonso Vazquez <pav.vigo@gmail.com>
 * 
 * Clase que simplifica los tweets de la api y da metodos sencillos de acceso.
 */
public class MiniTweet {

    public MiniTweet(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
   private String username;
   private String text;
    
    
    
    
}
