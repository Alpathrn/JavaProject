/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Classe;

/**
 *
 * @author Leonie
 */
public class ClasseDAO  extends DAO<Classe>{

    public ClasseDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe recuperer(String id) {
    Classe classe = new Classe();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et completer
        if(result.first())
          classe = new Classe(id, result.getString("nom"),result.getString("ecole_id"),result.getString("niveau_id"),result.getString("anneescolaire"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return classe;
  } 
}
    
