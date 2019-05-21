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
public class Personne {
    
    protected String id;
    protected String nom;
    protected String prenom;
    protected String type;
    
    /**
    * constructeur par defaut
    */
    public Personne() {
        id=null;
        nom=null;
        prenom=null;
        type=null;
    }
    
    /**
    * constructeur surchargé
    * @param id
    * @param nom
    * @param prenom
    * @param type
    */
    public Personne(String id, String nom, String prenom, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.type = type;
    }
    
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Personne(ArrayList<String> tab) {
        id=tab.get(0);
        nom=tab.get(1);
        nom=tab.get(2);
        type=tab.get(3);
    }
    //getter
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getType() {
        return type;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * methode toString renvoyant une chaine de caractere avec les informations sur les employes
     * @return 
     */
    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", type=" + type + '}';
    }
    
    
    

}
