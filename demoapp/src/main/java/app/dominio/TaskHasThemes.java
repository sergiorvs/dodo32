package app.dominio;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class TaskHasThemes implements BaseEntity<Long>{
	
	@Id
	@SequenceGenerator(name = "tahth_id_generator", sequenceName = "tahth_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tahth_id_generator")
	private Long id;
	
	@Column(name="themeId")
	private Long themeId;
	
	@Column(name="taskId")
	private Long taskId;
	
	
	@Override
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public void setThemeId(Long theme_id){
		themeId = theme_id;
	}
	
	public Long getThemeId(){
		return themeId;
	}
	
	public void setTaskId(Long task_Id){
		taskId = task_Id;
	}
	
	public Long getTaskId(){
		return taskId;
	}
	
	
}
