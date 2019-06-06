/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Leonie
 */
public class FenetreAccueil extends JFrame implements ActionListener{
    
    private JButton btnMAJ, btnRecherche, btnReporting, btnVisualisation, btnConnexion; 
    private Connection connection;    
    private JPanel Accueil = new JPanel();

       
    public FenetreAccueil (Connection con) { 
        
        super("Accueil");
        this.setSize(900, 500);  
        this.connection = con;
        this.btnMAJ= new JButton("Mise à jour"); 
        this.btnRecherche = new JButton("Recherche"); 
        this.btnReporting = new JButton("Reporting");
        this.btnVisualisation = new JButton("Visualisation");  
        this.btnConnexion = new JButton("Connexion"); 
        boutonsAccueil();    
        this.getContentPane().add(Accueil);
        this.setVisible(true);
        
    }
    
    private void boutonsAccueil()
    {       
        btnMAJ.setBounds(150, 200, 150, 50);
        btnRecherche.setBounds(350, 200, 150, 50);
        btnReporting.setBounds(150, 500, 150, 50);
        btnVisualisation.setBounds(350, 500, 150, 50);
        //btnReporting.setForeground(Color.BLUE); 
        btnMAJ.addActionListener(this);
        btnRecherche.addActionListener(this);
        btnVisualisation.addActionListener(this);
        btnReporting.addActionListener(this);
        btnConnexion.addActionListener(this);
        Accueil.add(btnMAJ);
        Accueil.add(btnRecherche);
        Accueil.add(btnReporting);
        Accueil.add(btnVisualisation);
        Accueil.add(btnConnexion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object clic = e.getSource();

        if(clic == btnMAJ) 
        {
            
            this.setVisible(false);
            new FenetreMAJ(connection).setVisible(true);
            
        }
        else if(clic == btnRecherche) // accès à la fenêtre de mise à jour
        {
           this.setVisible(false);
            new FenetreRecherche(connection).setVisible(true);

        }
        else if(clic == btnReporting) // accès à la fenêtre de recherche
        {
            this.setVisible(false);
            new FenetreReporting(connection).setVisible(true);

        }
        else if(clic == btnVisualisation) // accès à la fenêtre de requêtes
        {
            /*
                new FenetreVisualisation(connection).setVisible(true);
            */
        }
        else if(clic == btnConnexion) //acces a la fenetre de connexion
        {
            this.setVisible(false);
            new FenetreConnexion().setVisible(true);
        }
    }
}
