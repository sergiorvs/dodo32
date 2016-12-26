package domain;

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
public class Project implements BaseEntity<Long>{
	
	@Id
	@SequenceGenerator(name = "project_id_generator", sequenceName = "project_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_generator")
	private Long id;
	
	
	@Column(length = 64)
	public String Name;
	
	@Column(length = 64)
	public String Description;

	@Column
	public Boolean actFinis;
	
	@ManyToMany(mappedBy = "projectsId")
	private List<Manager> menagers;
	
	@OneToMany
	@JoinColumn(name="projectId")
	public List<Task> tasks;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
