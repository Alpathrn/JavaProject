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
public class Enseignement {
    
    protected String id;
    protected String classe_id;
    protected String discipline_id;
    protected String personne_id;
    
    /**
    * constructeur par defaut
    */
    public Enseignement() {
        id=null;
        classe_id=null;
        discipline_id=null;
        personne_id=null;
    }

    /**
    * constructeur surchargé
    * @param id
    * @param classe_id
    * @param discipline_id
    * @param personne_id
    */
    public Enseignement(String id, String classe_id, String discipline_id, String personne_id) {
        this.id = id;
        this.classe_id = classe_id;
        this.discipline_id = discipline_id;
        this.personne_id = personne_id;
    }
    
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Enseignement(ArrayList<String> tab) {
        id=tab.get(0);
        classe_id=tab.get(1);
        discipline_id=tab.get(2);
        personne_id=tab.get(3);
    }
    
    //getter
    public String getId() {
        return id;
    }

    public String getClasse_id() {
        return classe_id;
    }

    public String getDiscipline_id() {
        return discipline_id;
    }

    public String getPersonne_id() {
        return personne_id;
    }
    
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setClasse_id(String classe_id) {
        this.classe_id = classe_id;
    }

    public void setDiscipline_id(String discipline_id) {
        this.discipline_id = discipline_id;
    }

    public void setPersonne_id(String personne_id) {
        this.personne_id = personne_id;
    }
    
    /**
     * methode toString renvoyant une chaine de caractere avec les informations sur les employes
     * @return 
     */
    @Override
    public String toString() {
        return "Enseignement{" + "id=" + id + ", classe_id=" + classe_id + ", discipline_id=" + discipline_id + ", personne_id=" + personne_id + '}';
    }
    
}
