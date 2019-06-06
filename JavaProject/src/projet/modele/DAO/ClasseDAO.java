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
import projet.modele.Classe;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class ClasseDAO  extends DAO<Classe>{
    
    private FenetreMAJ fenetre;

    public ClasseDAO(Connection conn) {
        super(conn);
    }

    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.createStatement();
            String requete = "INSERT INTO Classe VALUES ('"+ fenetre.getEcrireType().get(0).getText()+"', '"+ fenetre.getEcrireType().get(1).getText()+"', '"+ fenetre.getEcrireType().get(2).getText()+"', '"+ fenetre.getEcrireType().get(3).getText()+"', '"+ fenetre.getEcrireType().get(4).getText()+"')";
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
            //int Rs = stmt.executeUpdate("UPDATE `Classe` SET `id`='"+fenetre.getComboBoxChambre().getSelectedItem()+"',`nom`='"+fenetre.getJTexField(1).getText()+"',`ecole_id`='"+fenetre.getJTexField(2).getText()+"',`niveau_id`='"+fenetre.getJTexField(3).getText()+"',`annéescolaire_id`='"+fenetre.getJTexField(4).getText()+"', WHERE id = '"+fenetre.getitem1()+"'";
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
            int Rs = stmt.executeUpdate("DELETE FROM `Classe` WHERE id = '"+ fenetre.getEcrireType().get(0).getText()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `Enseignement` WHERE classe_id = '"+ fenetre.getEcrireType().get(0).getText()+"'");
            Rs = stmt.executeUpdate("DELETE FROM `Inscription` WHERE classe_id = '"+ fenetre.getEcrireType().get(0).getText()+"'");
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();  
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public boolean ajouter(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe recuperer(String id) {
    Classe classe = new Classe();  

    try {
      ResultSet result = this.connect.createStatement(
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
    
