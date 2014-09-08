package Entity;

import java.io.Serializable;
import javax.persistence.*;
/**
 * Entity implementation class for Entity: Imagenes
 *
 */
@Entity
public class Imagenes implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2607599704562226638L;

	public Imagenes(){}
	public Imagenes(String ruta) {
		this.name = ruta;
	}
	
	@Id
	@SequenceGenerator(name="secuenciaImagenes" , allocationSize=10,
	initialValue=1, sequenceName="secuenciaImagenes")
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="secuenciaImagenes")
	private int id;
	
	@Column(nullable=false , unique=true)
	private String name;
	
	@Column
	private String title;
	@Column
	private String description;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
