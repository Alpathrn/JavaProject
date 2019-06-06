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
import projet.modele.Discipline;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class DisciplineDAO  extends DAO<Discipline>{
    
    private FenetreMAJ fenetre;

    public DisciplineDAO(Connection conn) {
        super(conn);
    }

      public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.createStatement();
                String requete = "INSERT INTO Discipline VALUES ('"+fenetre.getEcrireType().get(0).getText()+"', '"+fenetre.getEcrireType().get(1).getText()+"')";
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
            //int Rs = stmt.executeUpdate("UPDATE `Discipline` SET `id`='"+fenetre.getComboBoxChambre().getSelectedItem()+"',`nom`='"+fenetre.getJTexField(1).getText()+"', WHERE id = '"+fenetre.getitem1()+"'";
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
        int Rs = stmt.executeUpdate("DELETE FROM `Discipline` WHERE id = '"+fenetre.getEcrireType().get(0).getText()+"'");      
        Rs = stmt.executeUpdate("DELETE FROM `Enseignement` WHERE discipline_id = '"+fenetre.getEcrireType().get(0).getText()+"'");
        new FenetreAccueil(connect).setVisible(true);
        fenetre.dispose();   
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouter(Discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Discipline recuperer(String id) {
        Discipline discipline = new Discipline();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Discipline WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          discipline = new Discipline(id, result.getString("nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return discipline;}

    
}
