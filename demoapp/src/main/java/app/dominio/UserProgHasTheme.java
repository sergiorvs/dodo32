package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class UserProgHasTheme implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "userprtheme_id_generator", sequenceName = "userprtheme_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userprtheme_id_generator")
	private Long id;
	
	@Column
	public Long ThemeScore;
	
	@Override
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
}

