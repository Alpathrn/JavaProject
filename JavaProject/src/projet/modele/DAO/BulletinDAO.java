/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Bulletin;

/**
 *
 * @author Leonie
 */
public class BulletinDAO  extends DAO<Bulletin>{

    public BulletinDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bulletin recuperer(String id) {
        Bulletin bulletin = new Bulletin();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          bulletin = new Bulletin(id, result.getString("trimestre_id"),result.getString("inscription_id"),result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return bulletin;
  } 
}
    

