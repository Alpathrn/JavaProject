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
public class Trimestre {
    
    protected String id;
    protected String numero;
    protected String debut;
    protected String fin;
    protected String anneescolaire_id;
    
    /**
    * constructeur par defaut
    */
    public Trimestre() {
        id=null;
        numero=null;
        debut=null;
        fin=null;
        anneescolaire_id=null;
    }
    
    /**
    * constructeur surchargé
    * @param id
    * @param numero
    * @param debut
    * @param fin
    * @param anneescolaire_id
    */
    public Trimestre(String id, String numero, String debut, String fin, String anneescolaire_id) {
        this.id = id;
        this.numero = numero;
        this.debut = debut;
        this.fin = fin;
        this.anneescolaire_id = anneescolaire_id;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Trimestre(ArrayList<String> tab) {
        id=tab.get(0);
        numero=tab.get(1);
        debut=tab.get(2);
        fin=tab.get(3);
        anneescolaire_id=tab.get(4);
    }
    
    //getter
    public String getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public String getDebut() {
        return debut;
    }

    public String getFin() {
        return fin;
    }

    public String getAnneescolaire_id() {
        return anneescolaire_id;
    }
    
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public void setFin(String fin) {
        this.fin = fin;
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
        return "Trimestre{" + "id=" + id + ", numero=" + numero + ", debut=" + debut + ", fin=" + fin + ", anneescolaire_id=" + anneescolaire_id + '}';
    }  
}
