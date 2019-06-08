/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.BorderLayout;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import projet.controleur.Recherche;

/**
 *
 * @author
 */
public class FenetreRecherche extends JFrame{
    
    private JPanel NomRecherche = new JPanel();
    private JPanel Titre = new JPanel();
    private JPanel Retour = new JPanel();
    private Connection connection;    
    private JButton btn[];
    private JLabel titre = new JLabel();

   public FenetreRecherche(Connection con)
    {
        super("Recherche");
        this.setSize(900,500);  
        this.connection = con;
        this.btn = new JButton[5];
        
        Dimension d = new Dimension(50,50);
        for(int i = 0 ; i < 5 ; i++)
        {
            btn[i] = new JButton();
            btn[i].setSize(d);
        }
        btn[0].setText("Recherche 1");
        btn[1].setText("Recherche 2");
        btn[2].setText("Recherche 3");
        btn[3].setText("Recherche 4");
        btn[4].setText("Retour à l'accueil");
        titre.setText("Veuillez choisir quelle diagramme vous voulez afficher"); 
        
        for(int i = 0; i < 5 ; i++)
        {
            btn[i].addActionListener(new Recherche(this,connection));   
        }
        
        this.setLayout(new BorderLayout());
        

        Titre.add(titre);
        
        for(int i = 0 ; i < 4 ; i++)
        {
            NomRecherche.add(btn[i]);
        }
        
        Retour.add(btn[4]);
        
        this.getContentPane().add(Titre, BorderLayout.NORTH);
        this.getContentPane().add(NomRecherche, BorderLayout.CENTER);
        this.getContentPane().add(Retour, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);    
    }
    
    public JButton getbtn(int i)
    {
        return btn[i];
    }
    

    public void setPanel(JPanel a)
    {
        NomRecherche.add(a, BorderLayout.CENTER);
        NomRecherche.validate();
    }
    
    public JPanel getPanel()
    {
        return this.NomRecherche;
        
    }

    
}

    