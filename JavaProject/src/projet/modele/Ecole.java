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
public class Ecole {
    
   protected String id;
    protected String nom;
    
    /**
    * constructeur par defaut
    */
    public Ecole() {
        id=null;
        nom=null;
    }
    /**
    * constructeur surchargé
    * @param id
    * @param nom
    */
    public Ecole(String id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Ecole(ArrayList<String> tab) {
        id=tab.get(0);
        nom=tab.get(1);
    }
    //getter
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * methode toString renvoyant une chaine de caractere avec les informations sur les employes
     * @return 
     */
    @Override
    public String toString() {
        return "Ecole{" + "id=" + id + ", nom=" + nom + '}';
    }
    
}
