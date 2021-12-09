/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandeau;

import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author nelsonrogers
 */
public class MyThread extends Thread {
    private final Bandeau bandeau;
    private List<ScenarioElement> myElements = new LinkedList<>();

    public MyThread(Bandeau bandeau, List<ScenarioElement> myElements) {
        this.bandeau = bandeau;
        this.myElements = myElements;
    }
    
    @Override
    public void run() {
        // Ressource partagée : bandeau
        synchronized(bandeau) {
            // On exécute les évènements du scénario
            for (ScenarioElement element : myElements) {
                for (int repeats = 0; repeats < element.repeats; repeats++) {
                    element.effect.playOn(bandeau);
                }
            }        
        }
    }
    
}
