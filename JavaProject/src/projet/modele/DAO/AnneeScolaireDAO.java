/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.AnneeScolaire;

/**
 *
 * @author Leonie
 * //Openclassroom
 */
public class AnneeScolaireDAO  extends DAO<AnneeScolaire>{

    public AnneeScolaireDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(AnneeScolaire obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnneeScolaire recuperer(String id) {
            AnneeScolaire annee = new AnneeScolaire();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE... = " + id);// faire requete sql et remplir
        if(result.first())
         annee = new AnneeScolaire(id);         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return annee;
  }
    
}
