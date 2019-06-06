/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import projet.modele.ModeleReporting;
import projet.view.FenetreAccueil;
import projet.view.FenetreRecherche;
import projet.view.FenetreReporting;

/**
 *
 * @author Alpaïde
 */
public class Recherche implements ActionListener{
    
    private ResultSet ResultSet;
    private ResultSetMetaData ResultatSetMeta;
    private FenetreRecherche fenrecherche;
    private Connection connection;
     
     /**
     * Constructeur pour la fenêtre de reporting
     * @param fenetre
     * @param conn
     */
    public Recherche(FenetreRecherche fenetre, Connection conn)
    {
        this.fenrecherche = fenetre;
        this.connection = conn;    
    }
    
 
    
    
@Override
    public void actionPerformed(ActionEvent e)
    {            
        if(e.getSource() == fenrecherche.getbtn(0))
            {   
                try 
                {
                    Statement stmt = connection.createStatement();
                    ResultSet resultat = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM Classe WHERE école_id = '1') as result1, (SELECT COUNT(*) FROM Classe WHERE école_id = '2') as result2, (SELECT COUNT(*) FROM Classe WHERE école_id = '3') as result3");
                    resultat.next();                
                    String newStrData[]={"ECE_Paris","ECE_Tech","ECE_Lyon"};
                    int newNbrData[]={resultat.getInt("result1"),resultat.getInt("result2"),resultat.getInt("result3")};
                    String newReport="Nombre de classe dans chaque ecole";
                    JPanel recup = null;
                    fenrecherche.setPanel(recup);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(e.getSource() == fenrecherche.getbtn(1))
            {   
                try 
                {
                    Statement stmt = connection.createStatement();
                    ResultSet resultat = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM Enseignement WHERE classe_id = '1') as result1, (SELECT COUNT(*) FROM Enseignement WHERE classe_id = '3') as result2, (SELECT COUNT(*) FROM Enseignement WHERE classe_id = '4') as result3");
                    resultat.next();                
                    String newStrData[]={"TD1","TD3","TD4"};
                    int newNbrData[]={resultat.getInt("result1"),resultat.getInt("result2"),resultat.getInt("result3")};
                    String newReport="Nombre d'enseignement par classe";
                    JPanel recup = null;
                    if(fenrecherche.type1().isSelected())
                    {
                        ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"camembert");
                        recup = modele.getPanel();
                    }
                    else if(fenrecherche.type2().isSelected())
                    {
                        ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"barre"); 
                        recup = modele.getPanel();
                    }
                    fenrecherche.setPanel(recup);
                } catch (SQLException ex) {
                    Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if(e.getSource() == fenrecherche.getbtn(2))
            {   
                try {
                        Statement stmt = connection.createStatement();
                        ResultSet resultat = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM Inscription WHERE classe_id = '1') as result1, (SELECT COUNT(*) FROM Inscription WHERE classe_id = '2') as result2, (SELECT COUNT(*) FROM Inscription WHERE classe_id = '3') as result3 ");
                        resultat.next(); 

                        String newStrData[]={"TD1","TD2","TD3"};
                        int newNbrData[]={resultat.getInt("result1"),resultat.getInt("result2"),resultat.getInt("result3")};
                        String newReport="Nombre d'inscription par classe";
                        JPanel recup = null;
                        if(fenrecherche.type1().isSelected())
                        {
                            ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"camembert");
                            recup = modele.getPanel();
                        }
                        else if(fenrecherche.type2().isSelected())
                        {
                            ModeleReporting modele = new ModeleReporting(newStrData,newNbrData,newReport,"barre"); 
                            recup = modele.getPanel();
                        }
                        fenrecherche.setPanel(recup);
                    } catch (SQLException ex) {
                        Logger.getLogger(Reporting.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        if(e.getSource() == fenrecherche.getbtn(4))
            {   
                new FenetreAccueil(connection).setVisible(true);
                fenrecherche.dispose();
            }
    }
    
       /**
     * methode permettant de recuperer les resultats de la requete
     * prise en parametre
     * @param requete
     * @return 
     * @throws java.sql.SQLException
     */
    /*
    public ArrayList recupChamps(String recherche) throws SQLException {
  
        Statement stmt = connection.createStatement();
        ResultSet = stmt.executeQuery(recherche);
        // recuperation du resultat de l'ordre
        ResultatSetMeta = ResultSet.getMetaData();
        // calcul du nombre de colonnes du resultat
        int nbColonne = ResultatSetMeta.getColumnCount();
        // creation d'une ArrayList de String
        ArrayList<ArrayList<String>> resultats;
        resultats = new ArrayList<ArrayList<String>>();
        // tant qu'il reste une ligne 
        while (ResultSet.next()) {
            ArrayList<String> attributs;
            attributs = new ArrayList<String>();
            for (int i = 1; i < nbColonne + 1; i++) {
                //recuperation des champs  
                String champ = (ResultSet.getString(i));
                attributs.add(champ);
            }
            resultats.add(attributs);
        }
        return resultats;
    }*/
    /**
 * methode permettant le resultat de la requete selectionnée
 * @param choix
 * @return 
 * @throws java.sql.SQLException
 */   
    /*
public ArrayList recherche(int choix) throws SQLException
 {   
     ArrayList<ArrayList<String>> resultats = new ArrayList<ArrayList<String>>();
     switch(choix)
     {
         case 1: // R1 sujet
           
             String S1="SELECT nom, prénom FROM Personne WHERE type LIKE '%enseignant%';"; 
             resultats=recupChamps(S1);
             break; 
         case 2: // R2 sujet
             String S2="SELECT nom FROM Discipline;";
             resultats=recupChamps(S2);
            break;
         case 3: // R3 sujet
             String S3="SELECT service.nom, batiment, prenom, employe.nom, specialite\n" +
             "FROM service, employe, docteur\n" +
             "WHERE directeur=employe.numero AND employe.numero=docteur.numero;";
             resultats=recupChamps(S3);
            break;
         case 4: // R4 sujet
             String S4="SELECT no_chambre, lit, service.nom, prenom, malade.nom, mutuelle\n" +
             "FROM malade, hospitalisation, service\n" +
             "WHERE code=code_service AND numero=no_malade AND batiment='B'\n" +
             "AND mutuelle LIKE'MN%';";
             resultats=recupChamps(S4);
             break;
         case 5: // R5 sujet
             String S5="SELECT DISTINCT code_service, AVG(salaire) as 'moyenne_des_salaires'\n" +
             "FROM infirmier\n" +
             "GROUP BY code_service;";
             resultats=recupChamps(S5);
             break;

               
 
     }
     return resultats;
  }
    */
}
