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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import projet.controleur.Connexion;
import projet.controleur.Visualisation;

/**
 *
 * @author hdela
 */
public class FenetreVisualisation extends JFrame{
    
    JTableHeader th_visu;
    private JButton btnR;
    private JLabel image;
    private JPanel crayon = new JPanel();
    private Connexion connexion; 
        
    public FenetreVisualisation(Connexion conn){
        
        super("Visualisation");
        setTitle("Visualisation de la BDD"); 
	this.setSize(900,500);
        this.connexion= conn;
        JPanel Retour = new JPanel();
        JPanel ChoixVisu = new JPanel();
        JPanel Visu = new JPanel();
        
        JTable tb_visu = new JTable();
        tb_visu.setBounds(50, 100, 700, 550);
        JScrollPane scr_visu = new JScrollPane(tb_visu);
        scr_visu.setBounds(20, 100, 700, 550); 
        
        image = new JLabel( new ImageIcon( "crayonVISU.png"));
        crayon.add(image);
        
        this.btnR = new JButton();
        btnR.setText("Retour à l'accueil");
        btnR.setSize(new Dimension(50,50));
        Retour.add(btnR);
        
        btnR.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {  dispose();
                new FenetreAccueil(connexion);
            }
        });
        
        String[] options_table = { "Sélectionner une table", "annéescolaire", "bulletin", "classe", "detailbulletin", "discipline", "ecole", "enseignement", "evaluation", "inscription", "niveau", "personne", "trimestre"};
        JComboBox cb_visu = new JComboBox(options_table); 
        cb_visu.setBounds(10, 10, 10, 10);
        
        cb_visu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tb_visu.setModel(new Visualisation((String) cb_visu.getSelectedItem(), conn));
                th_visu = tb_visu.getTableHeader();
                switch((String) cb_visu.getSelectedItem())
                {
                    case "annéescolaire":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        break;
                    case "bulletin":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Trimestre");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Inscription");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Appreciation");
                        break;
                    case "classe":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Nom");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Ecole");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Niveau");
                        th_visu.getColumnModel().getColumn(4).setHeaderValue("Année Scolaire");
                        break;
                    case "detail bulletin":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Bulletin");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Enseignement");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Appreciation");
                        break;
                    case "discipline":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Nom");
                        break;
                    case "ecole":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Nom");
                        break;
                    case "enseignement":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Classe");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Discipline");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Personne");
                        break;
                    case "evaluation":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Detail Bulletin");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Note");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Appreciation");
                        break; 
                    case "inscription":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Classe");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Personne");
                        break;
                    case "niveau":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Nom");
                        break;    
                    case "personne":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Nom");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Prenom");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Type");
                        break;
                    case "trimestre":
                        th_visu.getColumnModel().getColumn(0).setHeaderValue("Id");
                        th_visu.getColumnModel().getColumn(1).setHeaderValue("Numero");
                        th_visu.getColumnModel().getColumn(2).setHeaderValue("Debut");
                        th_visu.getColumnModel().getColumn(3).setHeaderValue("Fin");
                        th_visu.getColumnModel().getColumn(4).setHeaderValue("Année scolaire");
                        break;    
                }
            }
        });
        
        Visu.add(scr_visu);
        ChoixVisu.add(cb_visu);
        Visu.setBackground(new Color(237,230,255));
        ChoixVisu.setBackground(new Color(237,230,255));
        Retour.setBackground(new Color(237,230,255));
        this.getContentPane().add(Visu);
        this.getContentPane().add(crayon, BorderLayout.WEST);
        this.getContentPane().add(ChoixVisu, BorderLayout.NORTH);
        this.getContentPane().add(Retour, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
