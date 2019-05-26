/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Enseignement;

/**
 *
 * @author Leonie
 */
public class EnseignementDAO  extends DAO<Enseignement>{

    public EnseignementDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Enseignement obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Enseignement obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Enseignement obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Enseignement recuperer(String id) {
    Enseignement enseignement = new Enseignement();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          enseignement = new Enseignement(id, result.getString("classe_id"),result.getString("discipline_id"),result.getString("personne_id"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return enseignement;
    }
    
}
