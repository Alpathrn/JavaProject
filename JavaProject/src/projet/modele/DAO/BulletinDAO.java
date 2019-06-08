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
import projet.modele.Bulletin;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class BulletinDAO  extends DAO<Bulletin>{
    
    private FenetreMAJ fenetre;

    public BulletinDAO(Connection conn) {
        super(conn);
    }

    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.createStatement();
            String requete = "INSERT INTO Bulletin VALUES ('"+ fenetre.getEcrireType().get(0).getText()+"', '"+ fenetre.getEcrireType().get(1).getText()+"', '"+ fenetre.getEcrireType().get(2).getText()+"', '"+ fenetre.getEcrireType().get(3).getText()+"')";
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
            Statement stmt = connect.createStatement();
            //int Rs = stmt.executeUpdate("UPDATE `Bulletin` SET `id`='"+fenetre.getComboBoxChambre().getSelectedItem()+"',`trimestre_id`='"+fenetre.getJTexField(1).getText()+"',`inscription_id`='"+fenetre.getJTexField(2).getText()+"',`appréciation`='"+fenetre.getJTexField(3).getText()+"', WHERE id = '"+fenetre.getitem1()+"'";
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
            Statement stmt = this.connect.createStatement();
            int Rs = stmt.executeUpdate("DELETE FROM `Bulletin` WHERE id = '"+ fenetre.getEcrireType().get(0).getText()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `DetailBulletin` WHERE bulletin_id = '"+ fenetre.getEcrireType().get(0).getText()+"'");
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
      ResultSet result = this.connect.createStatement(
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
    

