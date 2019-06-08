/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import projet.controleur.Connexion;

/**
 *
 * @author Leonie
 */
public class FenetreAccueil extends JFrame implements ActionListener{
    
    private JButton btnMAJ, btnRecherche, btnReporting, btnVisualisation, btnConnexion; 
    private Connexion connexion;    
    private JPanel Accueil = new JPanel();
    private JLabel image;
       
    public FenetreAccueil (Connexion con) { 
        
        super("Accueil");
        
        image = new JLabel( new ImageIcon( "Accueil.jpg"));
        image.setLayout( new FlowLayout());
        
        this.setSize(1200, 600);  
        this.connexion = con;
        this.btnMAJ= new JButton("Mise à jour"); 
        this.btnRecherche = new JButton("Recherche"); 
        this.btnReporting = new JButton("Reporting");
        this.btnVisualisation = new JButton("Visualisation");  
        this.btnConnexion = new JButton("Connexion"); 
        boutonsAccueil();    
        
        this.add(image);
        //this.getContentPane().add(Accueil);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        image.add(btnMAJ);
        image.add(btnRecherche);
        image.add(btnReporting);
        image.add(btnVisualisation);
        image.add(btnConnexion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object clic = e.getSource();

        if(clic == btnMAJ) 
        {
            
            this.setVisible(false);
            new FenetreMAJ(connexion).setVisible(true);
            
        }
        else if(clic == btnRecherche) // accès à la fenêtre de mise à jour
        {
           this.setVisible(false);
            new FenetreRecherche(connexion.getConn()).setVisible(true);

        }
        else if(clic == btnReporting) // accès à la fenêtre de recherche
        {
            this.setVisible(false);
            new FenetreReporting(connexion).setVisible(true);

        }
        else if(clic == btnVisualisation) // accès à la fenêtre de requêtes
        {
            this.setVisible(false);
            new FenetreVisualisation(connexion).setVisible(true);
        }
        else if(clic == btnConnexion) //acces a la fenetre de connexion
        {
            this.setVisible(false);
            new FenetreConnexion().setVisible(true);
        }
    }
}
