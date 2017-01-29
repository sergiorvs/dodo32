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
	public Boolean actFinis=true;
	
	/*@ManyToMany(mappedBy = "projectsId")
	private List<Manager> menagers;*/
	
	@OneToMany
	@JoinColumn(name="projectId")
	public List<Task> tasks;
	
	@OneToMany
	@JoinColumn(name="projId")
	private List<Man_has_Proj> manhasproj;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name_){
		Name = name_;
	}
	
	public void setDescript(String descript){
		Description = descript;
	}
	
	public void setManhasproj(Man_has_Proj mhp){
		manhasproj.add(mhp);
	}
	
	public List<Man_has_Proj> getListManhasproj(){
		return manhasproj;
	}
	

}
