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
import projet.modele.Trimestre;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 * 
 */
public class TrimestreDAO  extends DAO<Trimestre>{
    
    private FenetreMAJ fenetre;
    private Connexion connect;

    public TrimestreDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }
    
     public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO Trimestre VALUES ('"+ fenetre.getEcrireId().getText()+"', '"+ fenetre.getEcrireInfo1().getText()+"', '"+ fenetre.getEcrireInfo2().getText()+"', '"+ fenetre.getEcrireInfo3().getText()+"', '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"')";
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
            int Rs = stmt.executeUpdate("UPDATE `Trimestre` SET `numéro`='"+ fenetre.getEcrireInfo1().getText()+"',`début`='"+ fenetre.getEcrireInfo2().getText()+"',`fin`='"+ fenetre.getEcrireInfo3().getText()+"',`annéescolaire_id`='"+fenetre.getSelectInfo2().getSelectedItem().toString()+"' WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
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
            int Rs = stmt.executeUpdate("DELETE FROM `Trimestre` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `Bulletin` WHERE trimestre_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();
             } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouter(Trimestre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Trimestre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Trimestre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trimestre recuperer(String id) {
    Trimestre trimestre = new Trimestre();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Trimestre WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          trimestre = new Trimestre(id, result.getString("numero"),result.getString("debut"),result.getString("fin"),result.getString("anneescolaire"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return trimestre; }


    
}
