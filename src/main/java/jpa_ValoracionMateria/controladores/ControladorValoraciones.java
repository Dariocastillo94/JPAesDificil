package jpa_ValoracionMateria.controladores;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import jpa_ValoracionMateria.model.Entidad;
import jpa_ValoracionMateria.model.Valoracion;

public class ControladorValoraciones extends SuperControlador_JPA{

	private static ControladorValoraciones instance=null;
	
	public ControladorValoraciones() {
		super("valoracionmateria", Valoracion.class);
	}
	public static ControladorValoraciones getInstance() {
		if(instance==null) {
			instance = new ControladorValoraciones();
		}
		return instance;
	}

	public Valoracion findProfeMaEst(int idProfesor, int idEstudiante, int idMateria) {
	    try {
	        return(Valoracion)getEntityManager().createNativeQuery(
	        		"SELECT * FROM valoracionmateria WHERE idProfesor= "+idProfesor+" and idEstudiante= "+idEstudiante+
	        		" and idMateria= "+idMateria, Valoracion.class).getSingleResult();
	    }catch(NoResultException e) {
	    	return null;
	    }
	}
	public Valoracion obtenerValoracionPorEstudiante(int id) {
		try {
			return(Valoracion)getEntityManager().createNativeQuery("select*from valoracionmateria where idEstudiante="
					+ id,Valoracion.class).getSingleResult();
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public void update(Valoracion e,int nota,Date fecha) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		e.setValoracion(nota);
		e.setFecha(fecha);
		em.merge(e);
		em.getTransaction().commit();
		
	}
	
	public void persist(int nota, int idProfesor, int idEstudiante, int idMateria,Date fecha) {
		Valoracion v = new Valoracion();
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		v.setValoracion(nota);
		v.setIdProfesor(idProfesor);
		v.setIdEstudiante(idEstudiante);
		v.setIdMateria(idMateria);
		v.setFecha(fecha);
		em.persist(v);
		em.getTransaction().commit();
		
	}
}	
