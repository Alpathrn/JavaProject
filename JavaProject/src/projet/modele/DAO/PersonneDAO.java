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
import projet.modele.Enseignement;
import projet.modele.Personne;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 *
 */
public class PersonneDAO  extends DAO<Personne>{
    
    private FenetreMAJ fenetre;

    public PersonneDAO(Connection conn) {
        super(conn);
    }

        public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.createStatement();
            String requete = "INSERT INTO Personne VALUES ('"+fenetre.getEcrireType().get(0).getText()+"', '"+fenetre.getEcrireType().get(1).getText()+"', '"+fenetre.getEcrireType().get(2).getText()+"', '"+fenetre.getEcrireType().get(3).getText()+"')";
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
            //int Rs = stmt.executeUpdate("UPDATE `Personne` SET `id`='"+fenetre.getComboBoxChambre().getSelectedItem()+"',`nom`='"+fenetre.getJTexField(1).getText()+"',`prénom`='"+fenetre.getJTexField(2).getText()+"',`type`='"+fenetre.getJTexField(3).getText()+"', WHERE id = '"+fenetre.getitem1()+"'";
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
            Statement stmt = this.connect.createStatement();
            int Rs = stmt.executeUpdate("DELETE FROM `Personne` WHERE id = '"+fenetre.getEcrireType().get(0).getText()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `Enseignement` WHERE personne_id = '"+fenetre.getEcrireType().get(0).getText()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();   
            } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
         }

    @Override
    public boolean ajouter(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne recuperer(String id) {
    Personne personne = new Personne();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Personne WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          personne = new Personne(id, result.getString("nom"),result.getString("prenom"),result.getString("type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return personne;
    }   


}
