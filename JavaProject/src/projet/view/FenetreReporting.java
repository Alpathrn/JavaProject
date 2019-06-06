/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import projet.controleur.Reporting;

/**
 
 * @author
 */
public class FenetreReporting extends JFrame {
    
    private JPanel Type = new JPanel();
    private JPanel Nom = new JPanel();
   // private JPanel GRAPHE = new JPanel();
    private JPanel Retour = new JPanel();
    private Connection connection;    
    private JButton btn[];
    private JRadioButton camenbert;
    private JRadioButton barre;
    private JLabel titre = new JLabel();
    

    public FenetreReporting(Connection con)
    {
        super("Reporting");
        this.setSize(900, 500);  
        this.connection = con;
        this.btn = new JButton[5];
        this.camenbert = new JRadioButton("Camembert");
        this.barre = new JRadioButton("Histogramme");
        
        Dimension d = new Dimension(50,50);
        for(int i = 0 ; i < 5 ; i++)
        {
            btn[i] = new JButton();
            btn[i].setSize(d);
        }
        btn[0].setText("TD par ecole");
        btn[1].setText("Enseignement par classe");
        btn[2].setText("Inscription par classe");
        btn[3].setText("Retour à l'acceuil");
        titre.setText("Veuillez choisir quelle diagramme vous voulez afficher"); 
        
        for(int i = 0; i < 5 ; i++)
        {
            btn[i].addActionListener(new Reporting(this,connection));
        }
        
        this.setLayout(new BorderLayout());
        
        ButtonGroup group = new ButtonGroup();
        group.add(camenbert);
        group.add(barre);
             

        Type.add(titre);
        Type.add(camenbert);
        Type.add(barre);
        
        for(int i = 0 ; i < 4 ; i++)
        {
            Nom.add(btn[i]);
        }
        
        Retour.add(btn[3]);
        
        this.getContentPane().add(Type, BorderLayout.NORTH);
        this.getContentPane().add(Retour, BorderLayout.SOUTH);
        this.getContentPane().add(Nom, BorderLayout.CENTER);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);    
    }
    
    public JButton getbtn(int i)
    {
        return btn[i];
    }
    
    public JRadioButton type1()
    {
        return camenbert;
    }
    
    public JRadioButton type2()
    {
        return barre;
    }

    public void setPanel(JPanel a)
    {
        Nom.add(a, BorderLayout.CENTER);
        Nom.validate();
    }
    
    public JPanel getPanel()
    {
        return this.Nom;
        
    }
        
}
