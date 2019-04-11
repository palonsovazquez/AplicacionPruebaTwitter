/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciontwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author Pablo Alonso Vazquez pav.vigo@gmail.com
 * 
 * Clase encargada de gestionar los tweets y encapsular el uso de la api.
 * 
 * 
 */
public class GestorTweet {
    private Twitter twitter = new Autorizacion().getOAuthTwitter();
    
    /**
     * 
     * @return un ArrayList de Minitweets del home timeline de la cuenta
     */
    public ArrayList<MiniTweet>  getMiniTweets() {
    
        List<Status> rl = null;
        try {
            rl = twitter.getHomeTimeline();
        } catch (TwitterException ex) {
            Logger.getLogger(GestorTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<MiniTweet> al_miniTweets = new ArrayList<>();
        for (Status status : rl) {
        al_miniTweets.add(new MiniTweet(status.getUser().getName(),status.getText()));
    }
        
        
        
    
    

    return al_miniTweets;
    }
    /**
     * Al enviarle un  @param texto lo envia como tweet.
     */
    public void tuitear(String texto){
        try {
            twitter.updateStatus(texto);
        } catch (TwitterException ex) {
            Logger.getLogger(GestorTweet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    
    }
    
    
}
