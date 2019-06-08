/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controleur;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hdela
 */
public class Visualisation {
    private String table;
    
    /**
     * constructeur de la JTable
     * @param _table, nom de la table a aller recuperer dans la BDD
     * 
     */
    public Visualisation(String _table)
    {
        this.table=_table;
    }
    
    public Visualisation()
    {
        this.table= null;
    }
    
    /**
     * 
     * @return le nombre de ligne: toutes dans chaque table grace a SELECT * FROM table
     */
    public int getRowCount(Connexion conn, String choix_cat) {
        int count=0;
        try {
            conn.setRset(conn.getStmt().executeQuery("SELECT * FROM "+choix_cat));
            conn.getRset().last();
            count = conn.getRset().getRow();
        } catch (SQLException ex) {
            Logger.getLogger(Visualisation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
}
