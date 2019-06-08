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
import projet.modele.Inscription;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class InscriptionDAO  extends DAO<Inscription>{
    
    private FenetreMAJ fenetre;
    private Connexion connect;

    public InscriptionDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }
    
    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO Inscription VALUES ('"+ fenetre.getEcrireId().getText()+"', '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"', '"+fenetre.getSelectInfo2().getSelectedItem().toString()+"')";
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
            int Rs = stmt.executeUpdate("UPDATE `Inscription` SET `classe_id`='"+fenetre.getSelectInfo2().getSelectedItem().toString()+"',`personne_id`='"+fenetre.getSelectInfo3().getSelectedItem().toString()+"' WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
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
        int Rs = stmt.executeUpdate("DELETE FROM `Inscription` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
        Rs = stmt.executeUpdate("DELETE FROM `Bulletin` WHERE inscription_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
        new FenetreAccueil(connect).setVisible(true);
        fenetre.dispose();   
         } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouter(Inscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Inscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Inscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscription recuperer(String id) {
    Inscription inscription = new Inscription();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Inscription WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          inscription = new Inscription(id, result.getString("classe_id"),result.getString("personne_id"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return inscription; }
  
}
