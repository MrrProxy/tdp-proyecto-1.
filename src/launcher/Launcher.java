package launcher;

import entities.Student;
import gui.SimplePresentationScreen;
//Diego Biernat
public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
	
		Student estudiante = new Student(105974, "Biernat", "Diego", "diego_biernat@hotmail.com", "https://github.com/MrrProxy/tdp-proyecto-1.", "/images/Foto.png");
		SimplePresentationScreen sps = new SimplePresentationScreen(estudiante);
		sps.setVisible(true);
		
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            }
        });
    }
}