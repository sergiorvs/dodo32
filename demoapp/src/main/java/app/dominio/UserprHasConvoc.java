package app.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserprHasConvoc implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "userhasmeetcalls_id_generator", sequenceName = "userhasmeetcalls_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userhasmeetcalls_id_generator")
	private Long id;	
	
	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	

}

