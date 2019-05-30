package projet.conteneur;
import java.sql.*;
import javax.swing.JOptionPane;
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
          /*try{
            Connexion co = new Connexion("projet", "root", "");
              
          } catch(SQLException | ClassNotFoundException ex){
              
          }*/
          try {
            try {
                Connexion con = new Connexion("projet", "root", "");
                JOptionPane.showMessageDialog(null, "Connexion à la BDD Projet réussie!");
            } catch (ClassNotFoundException cnfe) {
                JOptionPane.showMessageDialog(null, "Connexion à la BDD échouée, problème de classe.");
                cnfe.printStackTrace();
            }
        } catch (SQLException exp) {
            JOptionPane.showMessageDialog(null, "Connexion à la BDD échouée, Projet n'existe pas.");
            exp.printStackTrace();
        }
    }
}
     
 


