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
import projet.modele.Ecole;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class EcoleDAO  extends DAO<Ecole>{
    
    private FenetreMAJ fenetre;
    private Connexion connect;

    public EcoleDAO(Connexion conn) {
        super(conn.getConn());
        this.connect = conn;
    }

     public void Ajouter(FenetreMAJ ajout)
    {
        this.fenetre = ajout;
        try 
        {
            Statement stmt = connect.getConn().createStatement();
            String requete = "INSERT INTO Ecole VALUES ('"+ fenetre.getEcrireId().getText()+"', '"+ fenetre.getEcrireInfo1().getText()+"')";
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
            int Rs = stmt.executeUpdate("UPDATE `Ecole` SET `nom`='"+ fenetre.getEcrireInfo1().getText()+"' WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
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
        int Rs = stmt.executeUpdate("DELETE FROM `Ecole` WHERE id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");      
        Rs = stmt.executeUpdate("DELETE FROM `Classe` WHERE école_id = '"+fenetre.getSelectInfo1().getSelectedItem().toString()+"'");
        new FenetreAccueil(connect).setVisible(true);
        fenetre.dispose();   
         
        } catch (SQLException ex) {
            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean ajouter(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean modifier(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean supprimer(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ecole recuperer(String id) {
    Ecole ecole = new Ecole();  

    try {
      ResultSet result = this.connect.getConn().createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM Ecole WHERE id = " + id);// faire requete sql et remplir
        if(result.first())
          ecole = new Ecole(id, result.getString("nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ecole;}


    
}
