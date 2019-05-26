/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele;

import java.util.ArrayList;

/**
 *
 * @author Leonie
 */
public class AnneeScolaire {
        protected String id;

    /**
    * constructeur par defaut
    */
    public AnneeScolaire() {
        id=null;
    }

    /**
    * constructeur surchargé
    * @param id
    */
    public AnneeScolaire(String id) {
        this.id = id;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public AnneeScolaire(ArrayList<String> tab) {
        id=tab.get(0);
    }
    
    //get
    public String getId() {
        return id;
    }
    //set
    public void setId(String id) {
        this.id = id;
    }
      /**
     * methode toString renvoyant une chaine de caractere avec les informations sur les employes
     * @return 
     */
    @Override
    public String toString() {
        return "AnneeScolaire{" + "id=" + id + '}';
    }
    
    

    
        
        
    
}
