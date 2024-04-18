package jpa_ValoracionMateria.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa_ValoracionMateria.model.Materia;


public class ControladorMateria extends SuperControlador_JPA{

	private static ControladorMateria instance = null;

	public ControladorMateria() {
		super("materia",Materia.class);
	
	}
	/**
	 * Singleton 
	 * @return
	 */
	public static ControladorMateria getInstance() {
		if(instance == null) {
			instance = new ControladorMateria();
		}
		return instance;
	}
	public List<Materia> getAll() {
		
		EntityManager em = getEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM materia;", Materia.class);

		return (List<Materia>) q.getResultList();
	}
}
