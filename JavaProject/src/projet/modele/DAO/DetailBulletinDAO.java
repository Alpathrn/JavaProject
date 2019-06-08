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
import projet.modele.DetailBulletin;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class DetailBulletinDAO  extends DAO<DetailBulletin>{
    
    private FenetreMAJ fenetre;
    private Connexion connect;

    public DetailBulletinDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }

        public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO DetailBulletin VALUES ('"+ fenetre.getEcrireId().getText()+"', '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"', '"+fenetre.getSelectInfo2().getSelectedItem().toString()+"', '"+ fenetre.getEcrireInfo1().getText()+"')";
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
            int Rs = stmt.executeUpdate("UPDATE `DetailBulletin` SET `bulletin_id`='"+fenetre.getSelectInfo2().getSelectedItem().toString()+"',`enseignement_id`='"+fenetre.getSelectInfo3().getSelectedItem().toString()+"',`appréciation`='"+ fenetre.getEcrireInfo1().getText()+"' WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
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
        int Rs = stmt.executeUpdate("DELETE FROM `DetailBulletin` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
        Rs = stmt.executeUpdate("DELETE FROM `Evaluation` WHERE detailbulletin_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
        new FenetreAccueil(connect).setVisible(true);
        fenetre.dispose();  
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public DetailBulletin recuperer(String id) {
    DetailBulletin detailb = new DetailBulletin();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM DetailBulletin WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          detailb = new DetailBulletin(id, result.getString("bulletin_id"),result.getString("enseignement"),result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return detailb;
    }


}
