/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import projet.modele.Evaluation;

/**
 *
 * @author Leonie
 */
public class EvaluationDAO  extends DAO<Evaluation>{

    public EvaluationDAO(Connection conn) {
        super(conn);
    }

    @Override
    public boolean ajouter(Evaluation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprimer(Evaluation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifier(Evaluation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Evaluation recuperer(String id) {
     Evaluation evaluation = new Evaluation();  

    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE, 
        ResultSet.CONCUR_READ_ONLY
      ).executeQuery("SELECT * FROM ... WHERE ... = " + id);// faire requete sql et remplir
        if(result.first())
          evaluation = new Evaluation(id, result.getString("detailbulletin"),result.getString("note"),result.getString("appreciation"));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return evaluation;
    }
    
}
