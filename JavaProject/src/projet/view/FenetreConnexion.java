/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
    private JPasswordField pw_mdp;
    private JButton btn_local;
    static Connexion maconnexion;
    
    public FenetreConnexion()
    {
        super("Connexion");
        setTitle("Connexion a la BDD"); 
	setSize(900, 500);

        lbl_nom = new JLabel("Nom de la BDD:");
        lbl_nom.setBounds(150, 100, 150, 20);
        page.add(lbl_nom);
        text_nom = new JTextField("projet");
        text_nom.setBounds(300, 100, 150, 20);
        page.add(text_nom);
        lbl_login = new JLabel("Login:");
        lbl_login.setBounds(150, 200, 150, 20);
        page.add(lbl_login);
        text_login = new JTextField("root");
        text_login.setBounds(300, 200, 150, 20); 
        page.add(text_login);
        lbl_mdp = new JLabel("Mot de passe:");
        lbl_mdp.setBounds(150, 250, 150, 20);
        page.add(lbl_mdp);
        pw_mdp = new JPasswordField("root");
        pw_mdp.setBounds(300, 250, 150, 20); 
        page.add(pw_mdp);
        lbl_port = new JLabel("Port:");
        lbl_port.setBounds(150, 300, 150, 20);
        page.add(lbl_port);
        text_port = new JTextField("3306");
        text_port.setBounds(300, 300, 150, 20);
        page.add(text_port);
        btn_local = new JButton("Connexion locale");
        btn_local.setBounds(150, 600, 150, 20);
        page.add(btn_local);
        btn_local.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try {
                    try {
                        maconnexion = new Connexion(text_nom.getText(), text_login.getText(), pw_mdp.getText().toString(), text_port.getText());
                        JOptionPane.showMessageDialog(null, "Connexion à la BDD " + text_nom.getText() + " réussie!");
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
        
        this.add(page);
    }
}
