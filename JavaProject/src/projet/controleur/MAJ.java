/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import projet.modele.DAO.*;
import projet.view.FenetreAccueil;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 */
public class MAJ implements ActionListener{
    
    private FenetreMAJ fenMAJ;
    private Connexion connexion;
    
    public MAJ(FenetreMAJ fenetre, Connexion conn)
    {
        this.fenMAJ = fenetre;
        this.connexion = conn;    
    }
   
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object clic = e.getSource();
        
        if(clic == fenMAJ.getbtn(0)) // savoir sur quel bouton on a cliqué
        {fenMAJ.settype(1);}
        if(clic == fenMAJ.getbtn(1))// savoir sur quel bouton on a cliqué
        {fenMAJ.settype(2);}
        if(clic == fenMAJ.getbtn(2))// savoir sur quel bouton on a cliqué
        {fenMAJ.settype(3);}
        
        // ActionListener avec la fenêtre d'ajout
        if(!(this.fenMAJ == null))
        {
            
            // AnneeScolaire
            if (fenMAJ.gettable()==1) 
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {   
                        new AnneeScolaireDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new AnneeScolaireDAO(connexion).Supprimer(fenMAJ);
                } 
                
            }

            // Bulletin
            if (fenMAJ.gettable()==2)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new BulletinDAO(connexion).Ajouter(fenMAJ); 
                }
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new BulletinDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new BulletinDAO(connexion).Supprimer(fenMAJ);
                } 
            }

            // Classe
            if (fenMAJ.gettable()==3)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new ClasseDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new ClasseDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new ClasseDAO(connexion).Supprimer(fenMAJ);
                } 
            }

            // DetailBulletin
            if (fenMAJ.gettable()==4)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new DetailBulletinDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new DetailBulletinDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new DetailBulletinDAO(connexion).Supprimer(fenMAJ);
                } 
            }

            // Discipline
            if (fenMAJ.gettable()==5)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new DisciplineDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new DisciplineDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new DisciplineDAO(connexion).Supprimer(fenMAJ);
                } 
            }

            // Ecole
            if (fenMAJ.gettable()==6)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new EcoleDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new EcoleDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new EcoleDAO(connexion).Supprimer(fenMAJ);
                } 
            }
            // Enseignement
            if (fenMAJ.gettable()==7)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new EnseignementDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new EnseignementDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new EnseignementDAO(connexion).Supprimer(fenMAJ);
                } 
            }

            // Evaluation
            if (fenMAJ.gettable()==8)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new EvaluationDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new EvaluationDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new EvaluationDAO(connexion).Supprimer(fenMAJ);
                } 
            }
            
            // Inscription
            if (fenMAJ.gettable()==9)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new InscriptionDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new InscriptionDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new InscriptionDAO(connexion).Supprimer(fenMAJ);
                } 
            }
            
            //Niveau
            if (fenMAJ.gettable()==10)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new NiveauDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new NiveauDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new NiveauDAO(connexion).Supprimer(fenMAJ);
                } 
            }
            
            //Personne
            if  (fenMAJ.gettable()==11)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new PersonneDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new PersonneDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new PersonneDAO(connexion).Supprimer(fenMAJ);
                }
            }
            
            //Trimestre
            if  (fenMAJ.gettable()==12)
            {
                if(fenMAJ.gettype()==1 && clic==fenMAJ.getBtnV())
                {
                    new TrimestreDAO(connexion).Ajouter(fenMAJ); 
                }
                if(fenMAJ.gettype()==2 && clic==fenMAJ.getBtnV())
                {
                     new TrimestreDAO(connexion).Maj(fenMAJ);
                }
                if(fenMAJ.gettype()==3 && clic==fenMAJ.getBtnV())
                {
                    new TrimestreDAO(connexion).Supprimer(fenMAJ);
                }
            }
            
            if(e.getSource() == fenMAJ.getBtnR())
            {
                fenMAJ.dispose();
                new FenetreAccueil(connexion);
            }
           
        }

    
}
