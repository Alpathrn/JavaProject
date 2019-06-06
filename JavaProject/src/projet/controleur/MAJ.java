/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import projet.modele.DAO.*;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class MAJ implements ActionListener{
    
    private FenetreMAJ fenMAJ;
    private Connection connection;
    
    public MAJ(FenetreMAJ fenetre, Connection conn)
    {
        this.fenMAJ = fenetre;
        this.connection = conn;    
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object clic = e.getSource();
        
        if(clic == fenMAJ.getbtn(0)) // savoir sur quel bouton on a cliqué
        {fenMAJ.setType(1);}
        if(clic == fenMAJ.getbtn(1))// savoir sur quel bouton on a cliqué
        {fenMAJ.setType(2);}
        if(clic == fenMAJ.getbtn(2))// savoir sur quel bouton on a cliqué
        {fenMAJ.setType(3);}
        
        // ActionListener avec la fenêtre d'ajout
        if(!(this.fenMAJ == null))
        {
            
            // AnneeScolaire
            if (fenMAJ.gettable()==1) 
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new AnneeScolaireDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new AnneeScolaireDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new AnneeScolaireDAO(connection).Supprimer(fenMAJ);
                } 
                
            }

            // Bulletin
            if (fenMAJ.gettable()==2)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new BulletinDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new BulletinDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new BulletinDAO(connection).Supprimer(fenMAJ);
                } 
            }

            // Classe
            if (fenMAJ.gettable()==3)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new ClasseDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new ClasseDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new ClasseDAO(connection).Supprimer(fenMAJ);
                } 
            }

            // DetailBulletin
            if (fenMAJ.gettable()==4)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new DetailBulletinDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new DetailBulletinDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new DetailBulletinDAO(connection).Supprimer(fenMAJ);
                } 
            }

            // Discipline
            if (fenMAJ.gettable()==5)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new DisciplineDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new DisciplineDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new DisciplineDAO(connection).Supprimer(fenMAJ);
                } 
            }

            // Enseignement
            if (fenMAJ.gettable()==6)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new EnseignementDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new EnseignementDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new EnseignementDAO(connection).Supprimer(fenMAJ);
                } 
            }

            // Evaluation
            if (fenMAJ.gettable()==7)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new EvaluationDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new EvaluationDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new EvaluationDAO(connection).Supprimer(fenMAJ);
                } 
            }
            
            // Inscription
            if (fenMAJ.gettable()==8)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new InscriptionDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new InscriptionDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new InscriptionDAO(connection).Supprimer(fenMAJ);
                } 
            }
            
            //Niveau
            if (fenMAJ.gettable()==9)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new NiveauDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new NiveauDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new NiveauDAO(connection).Supprimer(fenMAJ);
                } 
            }
            
            //Personne
            if  (fenMAJ.gettable()==10)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new PersonneDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new PersonneDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new PersonneDAO(connection).Supprimer(fenMAJ);
                }
            }
            
            //Trimestre
            if  (fenMAJ.gettable()==11)
            {
                if(clic == fenMAJ.getbtn(0))
                {
                    new TrimestreDAO(connection).Ajouter(fenMAJ); 
                }
                if(clic == fenMAJ.getbtn(1))
                {
                     new TrimestreDAO(connection).Maj(fenMAJ);
                }
                if(clic == fenMAJ.getbtn(2))
                {
                    new TrimestreDAO(connection).Supprimer(fenMAJ);
                }
            }
            
            /*if(e.getSource() == fenMAJ.getretour())
            {
                try {
                    fenMAJ.dispose();
                    new FenetreAccueil(connection);
                } catch (SQLException ex) {Logger.getLogger(ButtonController.class.getName()).log(Level.SEVERE, null, ex);}
            }*/
           
        }
    }
    
}
