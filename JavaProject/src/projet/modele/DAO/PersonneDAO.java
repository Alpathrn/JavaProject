/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Personne;

/**
 *
 * @author Leonie
 *
 */
public class PersonneDAO  extends DAO<Personne>{

    public PersonneDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne recuperer(String id) {
    Personne personne = new Personne();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          personne = new Personne(id, result.getString("nom"),result.getString("prenom"),result.getString("type"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return personne;
    }   
}
