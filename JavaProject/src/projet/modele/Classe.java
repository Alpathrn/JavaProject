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
public class Classe {
    
    protected String id;
    protected String nom;
    protected String ecole_id;
    protected String niveau_id;
    protected String anneescolaire_id;

    /**
    * constructeur par defaut
    */
    public Classe() {
        id=null;
        nom=null;
        ecole_id=null;
        niveau_id=null;
        anneescolaire_id=null;
    }
    /**
    * constructeur surchargé
    * @param id
    * @param nom
    * @param ecole_id
    * @param niveau_id
    * @param anneescolaire_id
    */
    public Classe(String id, String nom, String ecole_id, String niveau_id, String anneescolaire_id) {
        this.id = id;
        this.nom = nom;
        this.ecole_id = ecole_id;
        this.niveau_id = niveau_id;
        this.anneescolaire_id = anneescolaire_id;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Classe(ArrayList<String> tab) {
        id=tab.get(0);
        nom=tab.get(1);
        ecole_id=tab.get(2);
        niveau_id=tab.get(3);
        anneescolaire_id=tab.get(4);
    }
    //getter
    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEcole_id() {
        return ecole_id;
    }

    public String getNiveau_id() {
        return niveau_id;
    }

    public String getAnneescolaire_id() {
        return anneescolaire_id;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEcole_id(String ecole_id) {
        this.ecole_id = ecole_id;
    }

    public void setNiveau_id(String niveau_id) {
        this.niveau_id = niveau_id;
    }

    public void setAnneescolaire_id(String anneescolaire_id) {
        this.anneescolaire_id = anneescolaire_id;
    }
    /**
     * methode toString renvoyant une chaine de caractere avec les informations sur les employes
     * @return 
     */
    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", nom=" + nom + ", ecole_id=" + ecole_id + ", niveau_id=" + niveau_id + ", anneescolaire_id=" + anneescolaire_id + '}';
    }
   
    
    
    
}
