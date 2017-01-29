package app.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Task implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "task_id_generator", sequenceName = "task_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_generator")
	private Long id;
	
	@Column(length = 64)
	public String Name;	

	@Column(length = 86)
	public String Description;	
		
	@Column
	public Date StartDate = new Date();
		 
	@Column
	public Date DeadLineDate;   //fecha fin establecida por el Manager
	
	@Column
	public Date DeliveryDate;   //Fecha de entrega de tarea, registrada por el UserProgrmmr 
	
	@Column
	public Boolean ActPend = true;     //Tarea activa o pendiente
	
	@Column
	public Short Score;
	
	/*@ManyToMany
	@JoinTable(name="task_has_temas",joinColumns={@JoinColumn(name="task_id")},inverseJoinColumns={@JoinColumn(name="theme_id")})
	private List<Theme> temas;*/
	
	@OneToMany
	@JoinColumn(name="taskId")
	private List<TaskHasThemes> tahths;
	
		
	@Override
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String name){
		Name = name;
	}
	
	public String getDescription(){
		return Description;
	}
	
	public void setDescription(String descript){
		Description = descript;
	}
	
	public Date getStartDate(){
		return StartDate;
	}
	
	public void setStarDate(Date starDate){
		StartDate = starDate;
	}	
	
	public Date getDeadLineDate(){
		return DeadLineDate;
	}
	
	public void setDeadLineDate(Date deadLineDate){
		DeadLineDate = deadLineDate;
	}
	
	public Date getDeliveryDate(){
		return DeliveryDate;
	}
	
	public Short getScore(){
		return Score;
	}
	
		
	
}
