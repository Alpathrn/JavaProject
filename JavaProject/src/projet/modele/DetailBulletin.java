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
public class DetailBulletin {
    
    protected String id;
    protected String bulletin_id;
    protected String enseignement_id;
    protected String appreciation;
    
    /**
    * constructeur par defaut
    */
    public DetailBulletin() {
        id=null;
        bulletin_id=null;
        enseignement_id=null;
        appreciation=null;
    }
    
    /**
    * constructeur surchargé
    * @param id
    * @param bulletin_id
    * @param enseignement_id
    * @param appreciation
    */
    public DetailBulletin(String id, String bulletin_id, String enseignement_id, String appreciation) {
        this.id = id;
        this.bulletin_id = bulletin_id;
        this.enseignement_id = enseignement_id;
        this.appreciation = appreciation;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public DetailBulletin(ArrayList<String> tab) {
        id=tab.get(0);
        bulletin_id=tab.get(1);
        enseignement_id=tab.get(2);
        appreciation=tab.get(3);
    }
    
    //getter 
    public String getId() {
        return id;
    }

    public String getBulletin_id() {
        return bulletin_id;
    }

    public String getEnseignement_id() {
        return enseignement_id;
    }

    public String getAppreciation() {
        return appreciation;
    }
    
    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setBulletin_id(String bulletin_id) {
        this.bulletin_id = bulletin_id;
    }

    public void setEnseignement_id(String enseignement_id) {
        this.enseignement_id = enseignement_id;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }
    /**
     * methode toString renvoyant une chaine de caractere avec les informations sur les employes
     * @return 
     */
    @Override
    public String toString() {
        return "DetailBulletin{" + "id=" + id + ", bulletin_id=" + bulletin_id + ", enseignement_id=" + enseignement_id + ", appreciation=" + appreciation + '}';
    }

    
    
    
}
