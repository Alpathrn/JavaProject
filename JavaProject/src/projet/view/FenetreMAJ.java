/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import projet.controleur.*;
import projet.modele.DAO.*;

/**
 *
 * @author 
 */
public class FenetreMAJ extends JFrame{
    
  
    private JPanel fondAccueil = new JPanel();
    private Connection connection;  
    private JComboBox<String> choixTable;
    private ArrayList<JLabel> AfficherInfo; // afficher le type d'information à saisir
    private ArrayList<JTextField> EcrireInfo; // ecriture du type d'information
    private JComboBox SelectInfo = new JComboBox();
    private int nbInfo1; // nombre d'information à ecrire
    private int nbInfo2; // nombre d'information à saisir
    private int type; //type d'action 
    private int table;
    private JButton btn[];
    private JPanel Action = new JPanel();
    
    public FenetreMAJ (Connection con) {         
        super("MAJ");
        this.setSize(900, 500);  
        this.connection = con;
        selectionTable(fondAccueil);
        SelectInfo.setPreferredSize(new Dimension(100, 20));
        this.btn = new JButton[3];
        Dimension d = new Dimension(50,50);
        for(int i = 0 ; i < 3 ; i++)
        {
            btn[i] = new JButton();
            btn[i].setSize(d);
        }
        btn[0].setText("Ajouter");
        btn[1].setText("Modifier");
        btn[2].setText("Supprimer");
        
        for(int i = 0; i < 3; i++)
        {
            btn[i].addActionListener(new MAJ(this,connection));
        }
        
        this.setLayout(new BorderLayout());
        for(int i = 0 ; i < 3; i++)
        {
            Action.add(btn[i]);
        }
        this.getContentPane().add(Action, BorderLayout.NORTH);
        this.getContentPane().add(fondAccueil);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);    
    }
    
     /**
     * fonctions de selectione de la table pour la recherche et la mise à jour
     * 
     * @param fond, indique le fond (recherche ou maj) sur lequel on travaille
     */
    public void selectionTable(JPanel fond) 
    {
       String[] options_table = { "Sélectionner une table", "AnneeScolaire", "Bulletin", "Classe", "DetailBulletin", "Discipline", "Ecole", "Enseignement", "Evaluation"};
       choixTable = new JComboBox(options_table); 
       choixTable.setBounds(150, 20, 200, 50);
       fond.add(choixTable);
       
       choixTable.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {       
                        try {   
                            selectionCriteres(fond);
                        } catch (SQLException ex) {
                            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.out.print(""+type);
                    }
                });
       
    }
    public void recupID(String table)throws SQLException 
    {
        Statement stmt = connection.createStatement();
        ResultSet Rs = stmt.executeQuery("SELECT DISTINCT id FROM "+table+"");                     
        while(Rs.next())
            {
                SelectInfo.addItem(Rs.getString("ID"));                    
            } 
    }
    
    /**
     * fonctions de selection des différents critères correspondant à la table précédemment sélectionnée 
     * 
     * @param fond, indique le fond (recherche ou maj) sur lequel on travaille
     */
    public int selectionCriteres(JPanel fond) throws SQLException 
    {
        // remise à nu du fond
        for(int i=0; i<nbInfo1; i++)
        {
            fond.remove(AfficherInfo.get(i));
            fond.remove(EcrireInfo.get(i));
            fond.repaint();
        }
        // création ou remise à zéro des listes de label ou champs de texte 
        if(AfficherInfo!=null)
            AfficherInfo.clear();
        else
            AfficherInfo = new ArrayList<JLabel>();

        if(EcrireInfo!=null)
            EcrireInfo.clear();
        else
            EcrireInfo = new ArrayList<JTextField>();
       
        
        // remise à zéro du nombre de criteres
        nbInfo1 = 0;

        // conditions sur la table sélectionnée
        switch((String)choixTable.getSelectedItem())
        {
            case "AnneeScolaire":
                if(type==1)
                {
                nbInfo1=1;
                AfficherInfo.add(new JLabel("ID:"));
                EcrireInfo.add(new JTextField());
                }
                if(type==2 || type==3)
                {
                nbInfo2=1;
                AfficherInfo.add(new JLabel("ID à modifier:"));
                recupID("AnnéeScolaire");
                }
                table=1;
                break;    
                
            case "Bulletin":
                if(type==2)
                {
                nbInfo1=1;
                AfficherInfo.add(new JLabel("ID à modifier:"));
                recupID("Bulletin");
                }
                
                table=2;
                break; 
            case "Classe":
                nbInfo1=4;
                AfficherInfo.add(new JLabel("Code:"));
                AfficherInfo.add(new JLabel("Nom:"));
                AfficherInfo.add(new JLabel("Bâtiment:"));
                AfficherInfo.add(new JLabel("Directeur:"));
                table=3;
                break; 
            case "DetailBulletin":
                nbInfo1=4;
                AfficherInfo.add(new JLabel("Numéro:"));
                AfficherInfo.add(new JLabel("Code de service:"));
                AfficherInfo.add(new JLabel("Rotation"));
                AfficherInfo.add(new JLabel("Salaire"));
                table=4;
                break;
            case "Discipline":
                nbInfo1=4;
                AfficherInfo.add(new JLabel("Code de service:"));
                AfficherInfo.add(new JLabel("Numéro de chambre:"));
                AfficherInfo.add(new JLabel("Surveillant:"));
                AfficherInfo.add(new JLabel("Nombre de lits:"));
                table=5;
                break;
            case "Ecole":
                nbInfo1=6;
                AfficherInfo.add(new JLabel("Numéro:"));
                AfficherInfo.add(new JLabel("Nom:"));
                AfficherInfo.add(new JLabel("Prénom:"));
                AfficherInfo.add(new JLabel("Adresse:"));
                AfficherInfo.add(new JLabel("Téléphone:"));
                AfficherInfo.add(new JLabel("Mutuelle:"));
                table=6;
                break;
            case "Enseignement":
                nbInfo1=4;
                AfficherInfo.add(new JLabel("Numéro malade:"));
                AfficherInfo.add(new JLabel("Code de service:"));
                AfficherInfo.add(new JLabel("Numéro de chambre:"));
                AfficherInfo.add(new JLabel("Lit:"));
                table=7;
                break; 
            case "Inscription":
                nbInfo1=2;
                AfficherInfo.add(new JLabel("Numéro docteur:"));
                AfficherInfo.add(new JLabel("Numéro malade:"));
                table=8;
                break;
            default: 
                break;
        }
        // quelle que soit la table et ses criteres, on les affiche sur le fond recherche ou mise à jour
        for(int i=0; i<nbInfo1; i++)
        {
            AfficherInfo.get(i).setBounds(150, 100+i*50, 150, 20);
            EcrireInfo.get(i).setBounds(300, 100+i*50, 150, 20);
            fond.add(AfficherInfo.get(i));
            fond.add(EcrireInfo.get(i));
            fond.repaint();
        } 
        // quelle que soit la table et ses criteres, on les affiche sur le fond recherche ou mise à jour
        for(int i=0; i<nbInfo2; i++)
        {
            AfficherInfo.get(i).setBounds(150, 100+i*50, 150, 20);
            SelectInfo.setBounds(300, 100+i*50, 150, 20);
            SelectInfo.setForeground(Color.blue);
            fond.add(AfficherInfo.get(i));
            fond.add(SelectInfo);
            fond.repaint();
        } 
        return table;
    }
           
    public int gettable() {
        return table;
    }
    
    public JButton getbtn(int i)
    {
        return btn[i];
    }
    
    public ArrayList<JTextField> getEcrireType() 
    {
        return EcrireInfo;
    }

    public void setType(int type) {
        this.type = type;
    }
    
}
