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
public class Evaluation {
    
    protected String id;
    protected String detailbulletin_id;
    protected String note;
    protected String appreciation;
    
    /**
    * constructeur par defaut
    */
    public Evaluation() {
        id=null;
        detailbulletin_id=null;
        note=null;
        appreciation=null;
    }
    
    /**
    * constructeur surchargé
    * @param id
    * @param detailbulletin_id
    * @param note
    * @param appreciation
    */
    public Evaluation(String id, String bulletin_id, String enseignement_id, String appreciation) {
        this.id = id;
        this.detailbulletin_id = bulletin_id;
        this.note = enseignement_id;
        this.appreciation = appreciation;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Evaluation(ArrayList<String> tab) {
        id=tab.get(0);
        detailbulletin_id=tab.get(1);
        note=tab.get(2);
        appreciation=tab.get(3);
    }

    //getter
    public String getId() {
        return id;
    }

    public String getDetailbulletin_id() {
        return detailbulletin_id;
    }

    public String getNote() {
        return note;
    }

    public String getAppreciation() {
        return appreciation;
    }
    
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setDetailbulletin_id(String detailbulletin_id) {
        this.detailbulletin_id = detailbulletin_id;
    }

    public void setNote(String note) {
        this.note = note;
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
        return "Evaluation{" + "id=" + id + ", detailbulletin_id=" + detailbulletin_id + ", note=" + note + ", appreciation=" + appreciation + '}';
    }
    
    
    
}
