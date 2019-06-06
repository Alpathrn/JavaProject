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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projet.controleur.Connexion;

/**
 *
 * @author hdela
 */
public class FenetreConnexion extends JFrame {
    private JFrame frame_Connexion;
    private JLabel lbl_nom, lbl_login, lbl_mdp, lbl_port;
    private JTextField text_nom, text_login, text_port; 
    private JPasswordField pw_mdp;
    private JButton btn_local;
    static Connexion maconnexion;
    
    public FenetreConnexion()
    {
        frame_Connexion = new JFrame();
        frame_Connexion.setTitle("Connexion a la BDD"); 
	frame_Connexion.setSize(1450, 700);

        lbl_nom = new JLabel("Nom de la BDD:");
        lbl_nom.setBounds(150, 100, 150, 20);
        text_nom = new JTextField("projet");
        text_nom.setBounds(300, 100, 150, 20);
        lbl_login = new JLabel("Login:");
        lbl_login.setBounds(150, 200, 150, 20);
        text_login = new JTextField("root");
        text_login.setBounds(300, 200, 150, 20);         
        lbl_mdp = new JLabel("Mot de passe:");
        lbl_mdp.setBounds(150, 250, 150, 20);
        pw_mdp = new JPasswordField("root");
        pw_mdp.setBounds(300, 250, 150, 20);         
        lbl_port = new JLabel("Port:");
        lbl_port.setBounds(150, 300, 150, 20);
        text_port = new JTextField("3306");
        text_port.setBounds(300, 300, 150, 20);
        btn_local = new JButton("Connexion locale");
        btn_local.setBounds(150, 600, 150, 20);
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
    }
}
