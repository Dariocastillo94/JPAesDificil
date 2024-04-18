package jpa_ValoracionMateria.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa_ValoracionMateria.model.Estudiante;
import jpa_ValoracionMateria.model.Valoracion;


public class ControladorEstudiante extends SuperControlador_JPA{

	private static ControladorEstudiante instance = null;
	public ControladorEstudiante() {
		super("estudiante",Estudiante.class);
		
	}
	public static ControladorEstudiante getInstance() {
		if(instance == null) {
			instance = new ControladorEstudiante();
		}
		return instance;
	}
	

	public List<Estudiante> getAll() {

		EntityManager em = getEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);

		return (List<Estudiante>) q.getResultList();
	}
	

	
}
