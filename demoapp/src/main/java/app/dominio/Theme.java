package app.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;



@Entity
public class Theme implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "theme_id_generator", sequenceName = "theme_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_id_generator")
	private Long id;
	
	@Column(length = 64)
	public String Nombre;
		
	/*@ManyToMany(mappedBy = "temas")
	private List<Task> tasks;*/
	
	
	@OneToMany
	@JoinColumn(name="themeId")
	private List<UserProgHasTheme> userprhasthe;
	
	@OneToMany
	@JoinColumn(name="themeId")
	private List<TaskHasThemes> tahths;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
