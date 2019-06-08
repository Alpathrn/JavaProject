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
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projet.controleur.Connexion;

/**
 *
 * @author hdela
 */
public class FenetreConnexion extends JFrame{
    
    private JLabel lbl_nom, lbl_login, lbl_mdp, lbl_port;
    private JTextField text_nom, text_login, text_port; 
    private final JPanel page = new JPanel();
    private final JPanel valider = new JPanel();
    private JPasswordField pw_mdp;
    private JButton btn_local;
    static Connexion maconnexion;
    private JLabel image;
    private JPanel crayon = new JPanel();
    
    public FenetreConnexion()
    {
        super("Connexion");
        setTitle("Connexion a la BDD");
	this.setSize(900,500);
        
        this.setLayout(new BorderLayout());
        image = new JLabel( new ImageIcon( "crayonCON.png"));
        crayon.add(image);
        
        page.setSize(900,500);
        page.setLayout(new GridLayout(5, 2));

        lbl_nom = new JLabel("Nom de la BDD:");
        page.add(lbl_nom);
        text_nom = new JTextField("javaproject");
        page.add(text_nom);
        lbl_login = new JLabel("Login:");
        page.add(lbl_login);
        text_login = new JTextField("root");
        page.add(text_login);
        lbl_mdp = new JLabel("Mot de passe:");
        page.add(lbl_mdp);
        pw_mdp = new JPasswordField("root");
        page.add(pw_mdp);
        lbl_port = new JLabel("Port:");
        page.add(lbl_port);
        text_port = new JTextField("8889");
        page.add(text_port);
        
        btn_local = new JButton("Connexion locale");
        btn_local.setSize(new Dimension(50,50));
        valider.add(btn_local);

        btn_local.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    try {
                        maconnexion = new Connexion(text_nom.getText(), text_login.getText(), pw_mdp.getText().toString(), text_port.getText());
                        JOptionPane.showMessageDialog(null, "Connexion à la BDD " + text_nom.getText() + " réussie!");
                        new FenetreAccueil(maconnexion).setVisible(true);
                        setVisible(false);
                    } catch (ClassNotFoundException cnfe) {
                        JOptionPane.showMessageDialog(null, "Connexion à la BDD échouée, problème de classe.");
                        cnfe.printStackTrace();
                    }
                } catch (SQLException exp) {
                    JOptionPane.showMessageDialog(null, "Connexion à la BDD échouée, " + text_nom.getText() + " n'existe pas.");
                    exp.printStackTrace();
                }
            }
        }); 
        
        page.setBackground(new Color(254,231,240));
        crayon.setBackground(new Color(254,231,240));
        valider.setBackground(new Color(254,231,240));
        this.getContentPane().add(page, BorderLayout.NORTH); 
        this.getContentPane().add(valider, BorderLayout.CENTER); 
        this.getContentPane().add(crayon,BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
