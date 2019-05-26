/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Discipline;

/**
 *
 * @author Leonie
 */
public class DisciplineDAO  extends DAO<Discipline>{

    public DisciplineDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Discipline obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Discipline recuperer(String id) {
        Discipline discipline = new Discipline();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          discipline = new Discipline(id, result.getString("nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return discipline;}
    
}
