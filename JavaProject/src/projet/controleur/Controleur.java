package projet.controleur;

import java.sql.*;
import javax.swing.JOptionPane;
import projet.view.FenetreReporting;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * Contrôle l'interrogation de la BDD dans la Fenetre
 *
 */
public class Controleur {
  
    /**
     *
     * une methode principal (main) pour lancer l'application
     *
     * @param s
     */
      public static void main(String[] s) { 
        try {
            Connexion connexion = new Connexion();
        } catch (SQLException ex) {
            Logger.getLogger(Controleur.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
     
 


