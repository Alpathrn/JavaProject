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
import projet.modele.Evaluation;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class EvaluationDAO  extends DAO<Evaluation>{
    
    private FenetreMAJ fenetre;

    public EvaluationDAO(Connection conn) {
        super(conn);
    }

    public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.createStatement();
            String requete = "INSERT INTO Evaluation VALUES ('"+fenetre.getEcrireType().get(0).getText()+"', '"+fenetre.getEcrireType().get(1).getText()+"', '"+fenetre.getEcrireType().get(2).getText()+"', '"+fenetre.getEcrireType().get(3).getText()+"')";
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
            //int Rs = stmt.executeUpdate("UPDATE `Evaluation` SET `id`='"+fenetre.getComboBoxChambre().getSelectedItem()+"',`detailbulletin_id`='"+fenetre.getJTexField(1).getText()+"',`note`='"+fenetre.getJTexField(2).getText()+"',`appréciation`='"+fenetre.getJTexField(3).getText()+"', WHERE id = '"+fenetre.getitem1()+"'";
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
            int Rs = stmt.executeUpdate("DELETE FROM `Evaluation` WHERE id = '"+fenetre.getEcrireType().get(0).getText()+"'"); 
            new FenetreAccueil(connect).setVisible(true);
            fenetre.dispose();  
            } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
         }
    }

    @Override
    public boolean ajouter(Evaluation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Evaluation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Evaluation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Evaluation recuperer(String id) {
     Evaluation evaluation = new Evaluation();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Evaluation WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          evaluation = new Evaluation(id, result.getString("detailbulletin"),result.getString("note"),result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return evaluation;
    }

}
