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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hdela
 */
public class Visualisation extends AbstractTableModel{
    private Connexion m_conn;
    private String m_choix_cat;
    
    /**
     * constructeur de la JTable
     * @param choix_cat
     * @param conn
     */
    public Visualisation(String choix_cat, Connexion conn)
    {
        this.m_conn= conn;
        this.m_choix_cat = choix_cat;
        
    }
    
    public Visualisation()
    {
        this.m_choix_cat= null;
    }
    
    /**
     * @return le nombre de ligne: toutes dans chaque table grace a SELECT * FROM table
     */
    @Override
    public int getRowCount() {
        int count=0;
        try {
            m_conn.setRset(m_conn.getStmt().executeQuery("SELECT * FROM "+m_choix_cat));
            m_conn.getRset().last();
            count = m_conn.getRset().getRow();
        } catch (SQLException ex) {
            Logger.getLogger(Visualisation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    @Override
    public int getColumnCount() {
        int count=0;
        switch(m_choix_cat){
            case "annéescolaire":
                count = 1;
                break;
            case "bulletin":
                count = 4;
                break;
            case "classe":
                count = 5;
                break;
            case "detail bulletin":
                count = 4;
                break;
            case "discipline":
                count = 2;
                break;
            case "ecole":
                count = 2;
                break;
            case "enseignement":
                count = 4;
                break;
            case "evaluation":
                count = 4;
                break; 
            case "inscription":
                count = 3;
                break;
            case "niveau":
                count = 2;
                break;    
            case "personne":
                count = 4;
                break;
            case "trimestre":
                count = 5;
                break;    
        }
        return count;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
                m_conn.getRset().absolute(rowIndex + 1);
                switch (columnIndex) {
                    case 0: 
                        return m_conn.getRset().getString(1);
                    case 1:
                        return m_conn.getRset().getString(2);
                    case 2:
                        return m_conn.getRset().getString(3);
                    case 3:
                        return m_conn.getRset().getString(4);
                    case 4:
                        return m_conn.getRset().getString(5);
                    case 5:
                        return m_conn.getRset().getString(6);
                    default:
                        return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
