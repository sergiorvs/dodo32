package domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Manager implements BaseEntity<Long> {
	
	@Id
	@SequenceGenerator(name = "manager_id_generator", sequenceName = "manager_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_id_generator")
	private Long id;
	
	@OneToMany
	@JoinColumn(name="managerId")
	public List<Task> tasks;	
	
	@OneToMany
	@JoinColumn(name="managerId")
	private List<ConvocatoryMeeting> convocations;
		
	@ManyToMany
	@JoinTable(name="manager_has_projects",joinColumns={@JoinColumn(name="manager_id")},inverseJoinColumns={@JoinColumn(name="project_id")})
	private List<Project> projectsId;
	
	
	@Override
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
}
