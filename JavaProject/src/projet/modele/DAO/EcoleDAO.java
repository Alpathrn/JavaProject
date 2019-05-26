/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Ecole;

/**
 *
 * @author Leonie
 */
public class EcoleDAO  extends DAO<Ecole>{

    public EcoleDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Ecole obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ecole recuperer(String id) {
    Ecole ecole = new Ecole();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          ecole = new Ecole(id, result.getString("nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return ecole;}
    
}
