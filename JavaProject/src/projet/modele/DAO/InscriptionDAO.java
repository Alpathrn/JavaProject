/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Inscription;

/**
 *
 * @author Leonie
 */
public class InscriptionDAO  extends DAO<Inscription>{

    public InscriptionDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Inscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Inscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Inscription obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inscription recuperer(String id) {
    Inscription inscription = new Inscription();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          inscription = new Inscription(id, result.getString("classe_id"),result.getString("personne_id"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return inscription; }
    
}
