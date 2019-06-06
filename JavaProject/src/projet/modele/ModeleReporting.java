/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.modele;

/**
 *
 * @author Leonie
 */
import projet.view.*;

import java.awt.*; 
import java.sql.Connection;
import javax.swing.*; 
import org.jfree.chart.*;
import org.jfree.chart.plot.*; 
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 * Classe ModeleReporting pour la création des graphiques 
 * @author basileroth
 */
public class ModeleReporting extends JPanel 
{


   private String[] NomVariables;
   private int[] ValeurVariables;
   private String Titre;
   private String Type;
   private JPanel panel1;
   private Connection conn;
   private FenetreReporting fenetre;
   

   public ModeleReporting(Connection conn, FenetreReporting fen)
   {
       this.fenetre = fen;
       this.conn =conn;
   }


    public ModeleReporting(String[] nomV,int[] valeurV,String titre,String type) 
    { 
        NomVariables=nomV;
        ValeurVariables=valeurV;
        Titre=titre;
        Type=type;
       
        this.panel1 = new JPanel(new BorderLayout()); 
        setSize(400, 250); 
        
        DefaultPieDataset pieDataset = new DefaultPieDataset(); 
        for(int i=0;i<NomVariables.length;i++)
        {
            pieDataset.setValue(NomVariables[i]+" = "+ValeurVariables[i],ValeurVariables[i]); 
        }
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i <NomVariables.length; i++)
        {
            dataset.addValue(ValeurVariables[i], NomVariables[i],"");
        }

        JFreeChart pieChartBar = ChartFactory.createBarChart(Titre,"", "", dataset,PlotOrientation.VERTICAL, true, true, true); 
        JFreeChart pieChart = ChartFactory.createPieChart3D(Titre, pieDataset, true, true, true); 

        ChartPanel PIE = new ChartPanel(pieChart); 
        ChartPanel BAR = new ChartPanel(pieChartBar); 

        if(Type.equals("camembert"))
        {
           panel1.add(PIE);
        }    
        else if(Type.equals("barre"))
        {
          panel1.add(BAR);
        }
        
        
  } 
    
    public JPanel getPanel()
    {
        return this.panel1;
        
    }


    
}

