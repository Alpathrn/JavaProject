/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.controleur.Connexion;
import projet.modele.Bulletin;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class BulletinDAO  extends DAO<Bulletin>{
    
    private FenetreMAJ fenetre;
    private Connexion connect;

    public BulletinDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }

    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO Bulletin VALUES ('"+ fenetre.getEcrireId().getText()+"', '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"', '"+fenetre.getSelectInfo2().getSelectedItem().toString()+"', '"+ fenetre.getEcrireInfo1().getText()+"')";
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
            int Rs = stmt.executeUpdate("UPDATE `Bulletin` SET `trimestre_id`='"+fenetre.getSelectInfo2().getSelectedItem().toString()+"',`inscription_id`='"+fenetre.getSelectInfo3().getSelectedItem().toString()+"',`appréciation`='"+ fenetre.getEcrireInfo1().getText()+"' WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();   
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Supprimer(FenetreMAJ supp){
        this.fenetre = supp;
        try 
        {
            Statement stmt = this.connect.getConn().createStatement();
            int Rs = stmt.executeUpdate("DELETE FROM `Bulletin` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `DetailBulletin` WHERE bulletin_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose(); 
            } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    @Override
    public boolean ajouter(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bulletin recuperer(String id) {
        Bulletin bulletin = new Bulletin();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Bulletin WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          bulletin = new Bulletin(id, result.getString("trimestre_id"),result.getString("inscription_id"),result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bulletin;
  } 


}
    

