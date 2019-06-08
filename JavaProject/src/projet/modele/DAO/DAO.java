/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele.DAO;
import java.sql.Connection;
import projet.view.FenetreMAJ;

/**
 *
 * @author Leonie
 * Openclassroom
 * @param <T>
 */

public abstract class DAO<T> {
    
        private FenetreMAJ fenetre;
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract void Ajouter(FenetreMAJ ajout);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract void Supprimer(FenetreMAJ ajout);

  /**
  * Méthode de mise à jour
  * @param obj
  * @return boolean
  */
  public abstract void Maj(FenetreMAJ ajout);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T recuperer(String id);
}