/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Trimestre;

/**
 *
 * @author Leonie
 * 
 */
public class TrimestreDAO  extends DAO<Trimestre>{

    public TrimestreDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Trimestre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Trimestre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Trimestre obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trimestre recuperer(String id) {
    Trimestre trimestre = new Trimestre();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          trimestre = new Trimestre(id, result.getString("numero"),result.getString("debut"),result.getString("fin"),result.getString("anneescolaire"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return trimestre; }
    
}
