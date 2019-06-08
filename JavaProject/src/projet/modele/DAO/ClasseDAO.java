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
import projet.modele.Classe;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class ClasseDAO  extends DAO<Classe>{
    
    private FenetreMAJ fenetre;
    private Connexion connect;

    public ClasseDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }

    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO Classe VALUES ('"+ fenetre.getEcrireId().getText()+"', '"+ fenetre.getEcrireInfo1().getText()+"', '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"', '"+fenetre.getSelectInfo2().getSelectedItem().toString()+"', '"+fenetre.getSelectInfo3().getSelectedItem().toString()+"')";
            stmt.executeUpdate(requete);
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();   
        } catch (SQLException ex) 
        {Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public void Maj(FenetreMAJ modif)
    {
        this.fenetre = modif;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            int Rs = stmt.executeUpdate("UPDATE `Classe` SET `nom`='"+ fenetre.getEcrireInfo1().getText()+"',`ecole_id`='"+fenetre.getSelectInfo2().getSelectedItem().toString()+"',`niveau_id`='"+fenetre.getSelectInfo3().getSelectedItem().toString()+"',`annéescolaire_id`='"+fenetre.getSelectInfo4().getSelectedItem().toString()+"' WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();   
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Supprimer(FenetreMAJ supp) 
    {
        this.fenetre = supp;
        try 
        {
            Statement stmt = this.connect.getConn().createStatement();
            int Rs = stmt.executeUpdate("DELETE FROM `Classe` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `Enseignement` WHERE classe_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            Rs = stmt.executeUpdate("DELETE FROM `Inscription` WHERE classe_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();  
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
    @Override
    public Classe recuperer(String id) {
    Classe classe = new Classe();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Classe WHERE id = " + id);// faire requete sql et completer
        if(result.first())
          classe = new Classe(id, result.getString("nom"),result.getString("ecole_id"),result.getString("niveau_id"),result.getString("anneescolaire"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return classe;
  } 
    
}
    
