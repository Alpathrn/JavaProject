/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import projet.controleur.*;

/**
 *
 * @author 
 */
public class FenetreMAJ extends JFrame{
  
   // private JPanel fondAccueil = new JPanel();
    private Connexion connexion;  
    private JComboBox<String> choixTable;
    private JComboBox<String> TypePersonne;
    private JTextField EcrireId; 
    private JTextField EcrireInfo1;
    private JTextField EcrireInfo2; 
    private JTextField EcrireInfo3; 
    private JComboBox SelectInfo1= new JComboBox();
    private JComboBox SelectInfo2= new JComboBox();
    private JComboBox SelectInfo3 = new JComboBox();
    private JComboBox SelectInfo4 = new JComboBox();
    private int type; //type d'action 
    private int table;
    private JButton btn[];
    private JButton btnV;
    private JButton btnR;
    private GridLayout grille;
    private JLabel image;
    private JPanel crayon = new JPanel();
    
    public FenetreMAJ (Connexion con) {
       
        super("MAJ");
        JPanel Action = new JPanel();
        JPanel traitement = new JPanel();
        JPanel Retour = new JPanel();
        this.setSize(900, 500); 
        this.connexion = con;
        this.btn = new JButton[3];
        this.btnV = new JButton();
        this.btnR = new JButton();
        Dimension d = new Dimension(50,50);
        
        image = new JLabel( new ImageIcon( "crayon.png"));
        
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
            btn[i].addActionListener(new MAJ(this,connexion));
        }
        

        btnV.setText("Valider");
        btnV.setSize(d);
        btnV.addActionListener(new MAJ(this,connexion));
        
        btnR.setText("Retour");
        btnR.setSize(d);
        btnR.addActionListener(new MAJ(this,connexion));
        
        this.setLayout(new BorderLayout());
        
        for(int i = 0 ; i < 3; i++)
        {
            Action.add(btn[i]);
        }
        
        crayon.add(image);
        Retour.add(btnV);
        Retour.add(btnR);
        selectionTable(traitement);    
        Action.setBackground(new Color(212,231,255));
        Retour.setBackground(new Color(212,231,255));
        this.getContentPane().add(Action, BorderLayout.NORTH);
        this.getContentPane().add(Retour, BorderLayout.SOUTH);
        this.getContentPane().add(traitement,BorderLayout.CENTER);
        this.getContentPane().add(crayon,BorderLayout.WEST);
        this.setVisible(true);
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
        
       fond.setSize(900, 500);
       JPanel Choix  = new JPanel();
       JPanel Traiter  = new JPanel();
       Choix.setBackground(new Color(212,231,255));
       Traiter.setBackground(new Color(212,231,255));
       String[] options_table = { "Sélectionner une table", "AnneeScolaire", "Bulletin", "Classe", "DetailBulletin", "Discipline", "Ecole", "Enseignement", "Evaluation","Inscription","Niveau","Personne","Trimestre"};
       choixTable = new JComboBox(options_table); 
       Choix.add(choixTable);
       
       fond.setLayout(new BorderLayout());
       
       choixTable.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {       
                        try {   
                            selectionCriteres(Traiter);
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
       fond.add(Choix, BorderLayout.NORTH);
       fond.add(Traiter, BorderLayout.CENTER);
       fond.setBackground(Color.red);
       
    }

    public void recupID(String table, JComboBox Select)throws SQLException 
    {
        Select.setPreferredSize(new Dimension(100, 20));
        Statement stmt = connexion.getConn().createStatement();
        ResultSet Rs = stmt.executeQuery("SELECT DISTINCT id FROM "+table+""); 
        
        while(Rs.next())
            {
                Select.addItem(Rs.getString("ID"));  
            } 
    }
    
     /**
     * Méthode qui va permettre de gérer les interractions de 
     * la souris avec les différents cases quand on quitte une case 
     * POUR LE BLINDAGE
     */
    private void SiExiste(MouseEvent evt,String table) 
    {    
        // Pour une chambre on va vérifier si le numéro rentré n'est pas utilisé
        if(evt.getSource() == EcrireId)
        {
            try 
            {
                Statement stmt = connexion.getConn().createStatement();       
                {   
                    // Requête pour vérifier si le numéro existe déjà dans la table
                    ResultSet Rs = stmt.executeQuery("SELECT id FROM "+table+" WHERE id ="+EcrireId.getText());           
                    if (Rs.next()) 
                    {
                        // Message d'erreur si il existe déjà
                        JOptionPane.showMessageDialog(null, "Existe deja");
                    }              
                }
            } catch (SQLException ex) {
                Logger.getLogger(FenetreMAJ.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    /**
     * fonctions de selection des différents critères correspondant à la table précédemment sélectionnée 
     * 
     * @param ecrire, indique le ecrire (recherche ou maj) sur lequel on travaille
     */
    public void selectionCriteres(JPanel ecrire) throws SQLException 
    {
        ecrire.setBackground(new Color(212,231,255));
        // création ou remise à zéro du champs de texte 

        if(EcrireId!=null)
            EcrireId.removeAll();
        else
            EcrireId = new JTextField();
        
        if(EcrireInfo1!=null)
            EcrireInfo1.removeAll();
        else
            EcrireInfo1 = new JTextField();
        
        if(EcrireInfo2!=null)
            EcrireInfo2.removeAll();
        else
            EcrireInfo2 = new JTextField();
        
        if(EcrireInfo3!=null)
            EcrireInfo3.removeAll();
        else
            EcrireInfo3 = new JTextField();
      

        // conditions sur la table sélectionnée
        switch((String)choixTable.getSelectedItem())
        {
            case "AnneeScolaire":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId); 
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"AnnéeScolaire");}});
    
                }
                if(type==2)
                {
                    JOptionPane.showMessageDialog(null, "On ne peut pas modifier");
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("AnnéeScolaire",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=1;
                break;    
                
            case "Bulletin":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("ID Trimestre:"));
                recupID("Trimestre",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Inscription:"));
                recupID("Inscription",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("Appreciation:"));
                ecrire.add(EcrireInfo1);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Bulletin");}});

                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Bulletin",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Trimestre:"));
                recupID("Trimestre",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Inscription:"));
                recupID("Inscription",SelectInfo3);
                ecrire.add(SelectInfo3);
                ecrire.add(new JLabel("Appreciation:"));
                ecrire.add(EcrireInfo1);
                    
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Bulletin",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                
                table=2;
                break; 
                
            case "Classe":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(5, 5));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("ID Ecole:"));
                recupID("Ecole",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Niveau:"));
                recupID("Niveau",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Année Scolaire:"));
                recupID("AnneeScolaire",SelectInfo3);
                ecrire.add(SelectInfo3);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Classe");}});
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(5, 5));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Classe",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("ID Ecole:"));
                recupID("Ecole",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Niveau:"));
                recupID("Niveau",SelectInfo3);
                ecrire.add(SelectInfo3);
                ecrire.add(new JLabel("ID Année Scolaire:"));
                recupID("AnneeScolaire",SelectInfo4);
                ecrire.add(SelectInfo4);
                    
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Classe",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                
                table=3;
                break; 
                
            case "DetailBulletin":
                
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("ID Bulletin:"));
                recupID("Bulletin",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Enseignement:"));
                recupID("Enseignement",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("Appreciation:"));
                ecrire.add(EcrireInfo1);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"DetailBulletin");}});
    
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("DetailBulletin",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Bulletin:"));
                recupID("Bulletin",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Enseignement:"));
                recupID("Enseignement",SelectInfo3);
                ecrire.add(SelectInfo3);
                ecrire.add(new JLabel("Appreciation:"));
                ecrire.add(EcrireInfo1);
                    
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("DetailBulletin",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=4;
                break;
                
            case "Discipline":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(2, 2));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Discipline");}});
    
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(2, 2));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Discipline",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Discipline",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                
                table=5;
                break;
                
            case "Ecole":
               if(type==1)
                {
                ecrire.setLayout(new GridLayout(2, 2));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Ecole");}});
    
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(2, 2));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Ecole",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Ecole",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=6;
                break;
                
            case "Enseignement":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("ID Classe:"));
                recupID("Classe",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Discipline:"));
                recupID("Discipline",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Personne:"));
                recupID("Personne",SelectInfo3);
                ecrire.add(SelectInfo3);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Enseignement");}});
    

                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Enseignement",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Classe:"));
                recupID("Classe",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Discipline:"));
                recupID("Discipline",SelectInfo3);
                ecrire.add(SelectInfo3);
                ecrire.add(new JLabel("ID Personne:"));
                recupID("Personne",SelectInfo4);
                ecrire.add(SelectInfo4);
                    
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Enseignement",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=7;
                break; 
                
            case "Evaluation":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("ID DetailBulletin:"));
                recupID("DetailBulletin",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Note:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("Appreciation:"));
                ecrire.add(EcrireInfo2);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Evaluation");}});
    
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Evaluation",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID DetailBulletin:"));
                recupID("DetailBulletin",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("Note:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("Appreciation:"));
                ecrire.add(EcrireInfo2);
                    
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Evaluation",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=8;
                break;
                
            case "Inscription":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(3, 3));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("ID Classe:"));
                recupID("Classe",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Personne:"));
                recupID("Personne",SelectInfo2);
                ecrire.add(SelectInfo2);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Inscription");}});
    
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(3, 3));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Inscription",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("ID Classe:"));
                recupID("Classe",SelectInfo2);
                ecrire.add(SelectInfo2);
                ecrire.add(new JLabel("ID Personne:"));
                recupID("Personne",SelectInfo3);
                ecrire.add(SelectInfo3);
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Inscription",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=9;
                break;
                
            case "Niveau":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(2, 2));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Niveau");}});
    
                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(2, 2));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Niveau",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Niveau",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=10;
                break;
                
                case "Personne":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("Prenom:"));
                ecrire.add(EcrireInfo2);
                ecrire.add(new JLabel("Type:"));
                String[] type = { "Sélectionner un type de personne", "enseignant", "élève"};
                TypePersonne = new JComboBox(type); 
                ecrire.add(TypePersonne);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Personne");}});
                }
                
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(4, 4));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Personne",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Nom:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("Prenom:"));
                ecrire.add(EcrireInfo2);
                ecrire.add(new JLabel("Type:"));
                String[] type = { "Sélectionner un type de personne", "enseignant", "élève"};
                TypePersonne = new JComboBox(type); 
                ecrire.add(TypePersonne); 
                }
                
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Personne",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                table=11;
                break;
                
                case "Trimestre":
                if(type==1)
                {
                ecrire.setLayout(new GridLayout(5, 5));
                
                ecrire.add(new JLabel("ID:"));
                ecrire.add(EcrireId);
                ecrire.add(new JLabel("Numero:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("Debut:"));
                ecrire.add(EcrireInfo2);
                ecrire.add(new JLabel("Fin:"));
                ecrire.add(EcrireInfo3);
                ecrire.add(new JLabel("ID Année Scolaire:"));
                recupID("AnneeScolaire",SelectInfo1);
                ecrire.add(SelectInfo1);
                EcrireId.addMouseListener(new MouseAdapter() {public void mouseExited(MouseEvent evt) {SiExiste(evt,"Trimestre");}});
    

                }
                if(type==2)
                {
                ecrire.setLayout(new GridLayout(5, 5));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Trimestre",SelectInfo1);
                ecrire.add(SelectInfo1);
                ecrire.add(new JLabel("Numero:"));
                ecrire.add(EcrireInfo1);
                ecrire.add(new JLabel("Debut:"));
                ecrire.add(EcrireInfo2);
                ecrire.add(new JLabel("Fin:"));
                ecrire.add(EcrireInfo3);
                ecrire.add(new JLabel("ID Année Scolaire:"));
                recupID("AnneeScolaire",SelectInfo2);
                ecrire.add(SelectInfo2);

                    
                }
                if(type==3)
                {
                ecrire.setLayout(new GridLayout(1, 1));
                
                ecrire.add(new JLabel("ID à modifier:"));
                recupID("Trimestre",SelectInfo1);
                ecrire.add(SelectInfo1);
                }
                
                table=12;
                break; 
                
            default: 
                break;
        }
      
        ecrire.validate();//Ceci indique au composant de se repositionner et de se repeindre
    }

    public int gettable() {
        return table;
    }
    
    public JButton getbtn(int i)
    {
        return btn[i];
    }

    public JTextField getEcrireId() {
        return EcrireId;
    }
    
    public JTextField getEcrireInfo1() {
        return EcrireInfo1;
    }
    
    public JTextField getEcrireInfo2() {
        return EcrireInfo2;
    }    
    
    public JTextField getEcrireInfo3() {
        return EcrireInfo3;
    }

    public void settype(int type) {
        this.type = type;
    }

    public JButton getBtnV() {
        return btnV;
    }

    public JButton getBtnR() {
        return btnR;
    }
    
    public int gettype() {
        return type;
    }

    public JComboBox getSelectInfo1() {
        return SelectInfo1;
    }

    public JComboBox getSelectInfo2() {
        return SelectInfo2;
    }

    public JComboBox getSelectInfo3() {
        return SelectInfo3;
    }
    
    public JComboBox getSelectInfo4() {
        return SelectInfo4;
    }

    public JComboBox<String> getTypePersonne() {
        return TypePersonne;
    }
    
}
