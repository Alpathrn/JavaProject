/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.DetailBulletin;

/**
 *
 * @author Leonie
 */
public class DetailBulletinDAO  extends DAO<DetailBulletin>{

    public DetailBulletinDAO(Connection conn) {
        super(conn);
    }
    @Override
    public boolean ajouter(DetailBulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(DetailBulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(DetailBulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public DetailBulletin recuperer(String id) {
    DetailBulletin detailb = new DetailBulletin();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          detailb = new DetailBulletin(id, result.getString("bulletin_id"),result.getString("enseignement"),result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return detailb;
    }
}
