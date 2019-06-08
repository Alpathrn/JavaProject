/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import projet.controleur.Connexion;
import projet.controleur.Visualisation;

/**
 *
 * @author hdela
 */
public class FenetreVisualisation extends JFrame{
        
    public FenetreVisualisation(Connexion conn){
        super("Visualisation");
        setTitle("Visualisation de la BDD"); 
	setSize(750, 625);
        
        JTable tb_visu = new JTable();                    
        tb_visu.setBounds(20, 100, 700, 550);
        JScrollPane scr_visu = new JScrollPane(tb_visu);
        scr_visu.setBounds(20, 100, 700, 550);
        
        String[] options_table = { "Sélectionner une table", "annee scolaire", "bulletin", "classe", "detail bulletin", "discipline", "ecole", "enseignement", "evaluation", "inscription", "niveau", "personne", "trimestre"};
        JComboBox cb_visu = new JComboBox(options_table); 
        cb_visu.setBounds(10, 10, 10, 10);
        
        Visualisation visu = new Visualisation();
        
        this.getContentPane().add(tb_visu,BorderLayout.CENTER);
        this.getContentPane().add(scr_visu);
        this.getContentPane().add(cb_visu, BorderLayout.NORTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
