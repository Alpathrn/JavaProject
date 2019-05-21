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
public class Bulletin {
        
    protected String id;
    protected String trimestre_id;
    protected String inscription_id;
    protected String appreciation;

    /**
    * constructeur par defaut
    */
    public Bulletin() {
        id=null;
        trimestre_id=null;
        inscription_id=null;
        appreciation=null;
    }

    /**
    * constructeur surchargé
    * @param id
    * @param trimestre_id
    * @param inscription_id
    * @param appreciation
    */
    public Bulletin(String id, String trimestre_id, String inscription_id, String appreciation) {
        this.id = id;
        this.trimestre_id = trimestre_id;
        this.inscription_id = inscription_id;
        this.appreciation = appreciation;
    }
    /**
    * constructeur surchargé avec une ArrayList
    * @param tab
    */
    public Bulletin(ArrayList<String> tab) {
        id=tab.get(0);
        trimestre_id=tab.get(1);
        inscription_id=tab.get(2);
        appreciation=tab.get(3);
    }
    //Getter
    public String getId() {
        return id;
    }

    public String getTrimestre_id() {
        return trimestre_id;
    }

    public String getInscription_id() {
        return inscription_id;
    }

    public String getAppreciation() {
        return appreciation;
    }
    //setter
    public void setId(String id) {
        this.id = id;
    }

    public void setTrimestre_id(String trimestre_id) {
        this.trimestre_id = trimestre_id;
    }

    public void setInscription_id(String inscription_id) {
        this.inscription_id = inscription_id;
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
        return "Bulletin{" + "id=" + id + ", trimestre_id=" + trimestre_id + ", inscription_id=" + inscription_id + ", appreciation=" + appreciation + '}';
    }

    
    
    
    
    
}
