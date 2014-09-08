package Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Entity.Imagenes;

/**
 * Clase de servicios de BD de imagenes.
 * 
 * @author jhenaoz
 */
@Path("imagenes")
public class ServiceImages {

	public static final String PERSISTENCE = "Reto1Telematica";

	/**
	 * @param ruta
	 * @return
	 */
	public String addImage(String ruta, String title, String description) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		EntityTransaction et = null;
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE);
			em = emf.createEntityManager();
			et = em.getTransaction();
			et.begin();
			Imagenes img = new Imagenes(ruta);
			img.setTitle(title);
			img.setDescription(description);
			em.persist(img);
			;
			et.commit();
			System.out.println("imagen Guardada");
			return "ruta almacenada con exito";
		} catch (Exception e) {
			e.printStackTrace();
			return "algun problema paso";
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Imagenes> retriveImages() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		List<Object> resultado = null;
		List<Imagenes> response = new ArrayList<Imagenes>();
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE);
			em = emf.createEntityManager();
			String query = "Select i.name ,i.id, i.description, i.title from Imagenes i";
			Query q = em.createQuery(query);
			resultado = q.getResultList();

			for (Object obj : resultado) {
				Imagenes img = new Imagenes();
				Object arr[] =(Object[]) obj;
				img.setName((String)arr[0]);
				img.setId((int) arr[1]);
				img.setDescription((String)arr[2]);
				img.setTitle((String)arr[3]);
				response.add(img);
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return response;
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteImage(@PathParam("id")int id){
		try{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Imagenes img = em.find(Imagenes.class, id);
		if (img != null) {
			em.remove(img);
			em.getTransaction().commit();
			return "true";
		}
		return "false";
		}catch(Exception e){
			e.printStackTrace();
			return "false";
		}
	}
}
