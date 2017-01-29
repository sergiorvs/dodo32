package app.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Man_has_Proj implements BaseEntity<Long>  {
	@Id
	@SequenceGenerator(name = "manhproj_id_generator", sequenceName = "manhproj_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manhproj_id_generator")
	private Long id;

	@Column(name="manId")
	private Long manId;
	
	@Column(name="projId")
	private Long projId;
	
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}	
	
	public void setManId(Long manid_){
		manId = manid_;
	}
	
	public Long getManId(){
		return manId;
	}
	
	public void setProjId(Long projid_){
		projId = projid_;
	}
		
	
}
