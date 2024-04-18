package jpa_ValoracionMateria.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa_ValoracionMateria.model.Entidad;

public class SuperControlador_JPA {

	private static EntityManager em=null;
	private String nombreTabla = "";
	private Class tipoEntidad;
	/**
	 * 
	 * @param nombreTabla
	 * @param tipoEntidad
	 */
	public SuperControlador_JPA(String nombreTabla,Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
		}
	/**
	 * Metodo para iniciar una conexion
	 * @return
	 */
	protected  EntityManager getEntityManager() {
		if(em==null) {
			em = Persistence.createEntityManagerFactory("Valoraciones").createEntityManager();
		}
		return em;
	}

	/**
	 * 
	 */
	public List<? extends Entidad> findAll () {
		
		Query q = getEntityManager()
				.createNativeQuery("SELECT * FROM " + this.nombreTabla, this.tipoEntidad);
		
		return (List<Entidad>) q.getResultList();
		
	}
	/**
	 * 
	 */
	public void update(Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Entidad e) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		
	}
	public void persist(Entidad e) {
		EntityManager em=getEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		
	}
}
