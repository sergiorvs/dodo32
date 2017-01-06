package app.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Vote implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "vote_id_generator", sequenceName = "vote_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_id_generator")
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
