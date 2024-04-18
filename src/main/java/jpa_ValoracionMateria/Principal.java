package jpa_ValoracionMateria;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;



import jpa_ValoracionMateria.vista.PanelValoracionMateria_JPA;

public class Principal extends JFrame{

	
	public Principal(){
		super("Panel de valoracion materia");
		////
		this.setBounds(0, 0, 400, 400);
		PanelValoracionMateria_JPA pvm = new PanelValoracionMateria_JPA();
		
		this.getContentPane().add(pvm);
	}
	public static void main(String[] args) {
		Principal ventana = new Principal();
		ventana.setVisible(true);
	}

}
