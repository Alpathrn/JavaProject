/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import projet.view.FenetreReporting;
import projet.modele.ModeleReporting;
import projet.view.FenetreAccueil;

/**
 *
 * @author Leonie
 */
public class Reporting implements ActionListener{
    
     private FenetreReporting fenreport;
     private Connexion connexion;
     
     /**
     * Constructeur pour la fenêtre de reporting
     * @param fenetre
     * @param conn
     */
    public Reporting(FenetreReporting fenetre, Connexion conn)
    {
        this.fenreport = fenetre;
        this.connexion = conn;    
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
            if(e.getSource() == fenreport.getbtn(0))
            {   
                try 
                {
                    Statement stmt = connexion.getConn().createStatement();
                    ResultSet resultat = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM Classe WHERE école_id = '1') as result1, (SELECT COUNT(*) FROM Classe WHERE école_id = '2') as result2, (SELECT COUNT(*) FROM Classe WHERE école_id = '3') as result3");
                    resultat.next();                
                    String newStrData[]={"ECE_Paris","ECE_Tech","ECE_Lyon"};
                    int newNbrData[]={resultat.getInt("result1"),resultat.getInt("result2"),resultat.getInt("result3")};
                    String newReport="Nombre de classe dans chaque ecole";
                    JPanel recup = null;
                    if(fenreport.type1().isSelected())
                    {
                        ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"camembert");
                        recup = modele.getPanel();
                    }
                    else if(fenreport.type2().isSelected())
                    {
                        ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"barre");
                        recup = modele.getPanel();
                    }
                    fenreport.setPanel(recup);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(e.getSource() == fenreport.getbtn(1))
            {   
                try 
                {
                    Statement stmt = connexion.getConn().createStatement();
                    ResultSet resultat = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM Enseignement WHERE classe_id = '1') as result1, (SELECT COUNT(*) FROM Enseignement WHERE classe_id = '3') as result2, (SELECT COUNT(*) FROM Enseignement WHERE classe_id = '4') as result3");
                    resultat.next();                
                    String newStrData[]={"TD1","TD3","TD4"};
                    int newNbrData[]={resultat.getInt("result1"),resultat.getInt("result2"),resultat.getInt("result3")};
                    String newReport="Nombre d'enseignement par classe";
                    JPanel recup = null;
                    if(fenreport.type1().isSelected())
                    {
                        ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"camembert");
                        recup = modele.getPanel();
                    }
                    else if(fenreport.type2().isSelected())
                    {
                        ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"barre"); 
                        recup = modele.getPanel();
                    }
                    fenreport.setPanel(recup);
                } catch (SQLException ex) {
                    Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(e.getSource() == fenreport.getbtn(2))
            {   
                try {
                        Statement stmt = connexion.getConn().createStatement();
                        ResultSet resultat = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM Inscription WHERE classe_id = '1') as result1, (SELECT COUNT(*) FROM Inscription WHERE classe_id = '2') as result2, (SELECT COUNT(*) FROM Inscription WHERE classe_id = '3') as result3 ");
                        resultat.next(); 

                        String newStrData[]={"TD1","TD2","TD3"};
                        int newNbrData[]={resultat.getInt("result1"),resultat.getInt("result2"),resultat.getInt("result3")};
                        String newReport="Nombre d'inscription par classe";
                        JPanel recup = null;
                        if(fenreport.type1().isSelected())
                        {
                            ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"camembert");
                            recup = modele.getPanel();
                        }
                        else if(fenreport.type2().isSelected())
                        {
                            ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"barre"); 
                            recup = modele.getPanel();
                        }
                        fenreport.setPanel(recup);
                    } catch (SQLException ex) {
                        Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }

            if(e.getSource() == fenreport.getbtn(3))
            {   
                new FenetreAccueil(connexion).setVisible(true);
                fenreport.dispose();
            }
    }
}
