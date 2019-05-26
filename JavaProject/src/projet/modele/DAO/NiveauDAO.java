/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Niveau;

/**
 *
 * @author Leonie
 */
public class NiveauDAO  extends DAO<Niveau>{

    public NiveauDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Niveau obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Niveau obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Niveau obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Niveau recuperer(String id) {
    Niveau niveau = new Niveau();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          niveau = new Niveau(id, result.getString("nom"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return niveau;}
    
}
