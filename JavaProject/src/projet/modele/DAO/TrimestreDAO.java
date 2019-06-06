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

    public TrimestreDAO(Connection conn) {
        super(conn);
    }
    
     public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.createStatement();
            String requete = "INSERT INTO Trimestre VALUES ('"+fenetre.getEcrireType().get(0).getText()+"', '"+fenetre.getEcrireType().get(1).getText()+"', '"+fenetre.getEcrireType().get(2).getText()+"', '"+fenetre.getEcrireType().get(3).getText()+"', '"+fenetre.getEcrireType().get(4).getText()+"')";
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
            //int Rs = stmt.executeUpdate("UPDATE `Trimestre` SET `id`='"+fenetre.getComboBoxChambre().getSelectedItem()+"',`numéro`='"+fenetre.getJTexField(1).getText()+"',`début`='"+fenetre.getJTexField(2).getText()+"',`fin`='"+fenetre.getJTexField(3).getText()+"',`annéescolaire_id`='"+fenetre.getJTexField(4).getText()+"', WHERE id = '"+fenetre.getitem1()+"'";
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
            int Rs = stmt.executeUpdate("DELETE FROM `Trimestre` WHERE id = '"+fenetre.getEcrireType().get(0).getText()+"'");      
            Rs = stmt.executeUpdate("DELETE FROM `Bulletin` WHERE trimestre_id = '"+fenetre.getEcrireType().get(0).getText()+"'");
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
      ResultSet result = this.connect.createStatement(
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
