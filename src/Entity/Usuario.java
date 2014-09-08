package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	private long fbId;
	@Column
	private String name;
	@Column
	private String email;
	
	public long getFbId() {
		return fbId;
	}
	public void setFbId(long fbId) {
		this.fbId = fbId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
