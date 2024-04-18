package jpa_ValoracionMateria.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import jpa_ValoracionMateria.model.Materia;
import jpa_ValoracionMateria.model.Profesor;

public class ControladorProfesor extends SuperControlador_JPA {

	private static ControladorProfesor instance = null;

	public ControladorProfesor() {
		super("profesor", Profesor.class);
	}

	public static ControladorProfesor getInstance() {
		if (instance == null) {
			instance = new ControladorProfesor();
		}
		return instance;
	}

	public List<Profesor> getAll() {

		EntityManager em = getEntityManager();
		Query q = em.createNativeQuery("SELECT * FROM profesor;", Profesor.class);

		return (List<Profesor>) q.getResultList();
	}
}
