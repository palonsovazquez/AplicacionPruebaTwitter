/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciontwitter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
*
* @author Mario Pérez
*
*/
public class Autorizacion {
    private Twitter OAuthTwitter = null;
Autorizacion()  { //Constructor de la clase
    
   
ConfigurationBuilder configBuilder = new ConfigurationBuilder();
configBuilder.setDebugEnabled(true)
.setOAuthConsumerKey(JOptionPane.showInputDialog("Introduzca la AuthConsumerKey"))
.setOAuthConsumerSecret(JOptionPane.showInputDialog("Introduzca el Consumer secret de la aplicación "));
OAuthTwitter = new TwitterFactory(configBuilder.build()).getInstance();
RequestToken requestToken = null;
AccessToken accessToken = null;
String url = null;
do {
try {
requestToken = OAuthTwitter.getOAuthRequestToken();
System.out.println("Request Tokens obtenidos con éxito.");
System.out.println("Request Token: " + requestToken.getToken());
System.out.println("Request Token secret: " + requestToken.getTokenSecret());
url = requestToken.getAuthorizationURL();
System.out.println("URL:");
System.out.println(requestToken.getAuthorizationURL());
} catch (TwitterException ex) {
//Logger.getLogger(TwitterJavaGT.class.getName()).log(Level.SEVERE, null, ex);
}
BufferedReader lectorTeclado = new BufferedReader(new InputStreamReader(System.in));
//Abro el navegador. Firefox, en este caso.
Runtime runtime = Runtime.getRuntime();
try {
runtime.exec("firefox " + url);
} catch (Exception e) {
}
//Nos avisa de que introduciremos el PIN a continuación
System.out.print("Introduce el PIN del navegador y pulsa intro.nn PIN: ");
//Leemos el PIN
String pin = null;
    try {
        pin = lectorTeclado.readLine();
    } catch (IOException ex) {
        Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
    }
if (pin.length() > 0) {
    try {
        accessToken = OAuthTwitter.getOAuthAccessToken(requestToken, pin);
    } catch (TwitterException ex) {
        Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
    }
} else {
    try {
        accessToken = OAuthTwitter.getOAuthAccessToken(requestToken);
    } catch (TwitterException ex) {
        Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);
    }
}
} while (accessToken == null);
System.out.println("nnAccess Tokens obtenidos con éxito.");
System.out.println("Access Token: " + accessToken.getToken());
System.out.println("Access Token secret: " + accessToken.getTokenSecret());
FileOutputStream fileOS = null;
File file;
String content = accessToken.getToken() + "n" + accessToken.getTokenSecret();
try {
file = new File("auth_file.txt");
fileOS = new FileOutputStream(file);
//Si el archivo no existe, se crea
if (!file.exists()) {
file.createNewFile();
}
//Se obtiene el contenido en Bytes
byte[] contentInBytes = content.getBytes();
fileOS.write(contentInBytes);
fileOS.flush();
fileOS.close();
System.out.println("Escritura realizada con éxito.");
} catch (IOException e) {
e.printStackTrace();
} finally {
try {
if (fileOS != null) {
fileOS.close();
}
} catch (IOException e) {
e.printStackTrace();
}
}

OAuthTwitter = new TwitterFactory(configBuilder.build()).getInstance();
}

    public Twitter getOAuthTwitter() {
        return OAuthTwitter;
    }

}