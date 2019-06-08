/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.controleur.Connexion;
import projet.modele.AnneeScolaire;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 * //Openclassroom
 */
public class AnneeScolaireDAO  extends DAO<AnneeScolaire>{

    private FenetreMAJ fenetre;
    private Connexion connect;
    
    public AnneeScolaireDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }
    
    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO AnnéeScolaire VALUE ('"+ fenetre.getEcrireId().getText()+"')"; 
            stmt.executeUpdate(requete);
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();   
        } catch (SQLException ex) 
        {Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public void Supprimer(FenetreMAJ supp) {
        this.fenetre = supp;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            int Rs = stmt.executeUpdate("DELETE FROM `AnnéeScolaire` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `Trimestre` WHERE annéescolaire_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            Rs = stmt.executeUpdate("DELETE FROM `Classe` WHERE annéescolaire_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose(); 
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouter(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    @Override
public boolean supprimer(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnneeScolaire recuperer(String id) {
            AnneeScolaire annee = new AnneeScolaire();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM AnnéeScolaire WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
         annee = new AnneeScolaire(id);         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return annee;
  }

  
    
}
