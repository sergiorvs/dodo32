package app.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;



@Entity
public class UserProgmmr implements BaseEntity<Long>{
	/*@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;*/
	
	@Id
	@SequenceGenerator(name = "userpr_id_generator", sequenceName = "userpr_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userpr_id_generator")
	private Long id;
	
	@OneToOne
	private Person pers;
	
	@Column
	public Long TotalScore;
	
	@OneToMany
	@JoinColumn(name="userProgmmrId")
	public List<Task> tasks;	
	
	@OneToMany
	@JoinColumn(name="userProgmmrId")
	public List<UserProgHasTheme> userhasthemes;
	
	@OneToMany
	@JoinColumn(name="userProgmmrId")
	public List<UserprHasConvoc> userhasmc;
	
	@OneToMany
	@JoinColumn(name="userProgmmrId")
	public List<MeetingOptions> meetingOpcions;
	
	@OneToMany
	@JoinColumn(name="userProgrmId")
	public List<Vote> votes;
	
	
	@Override
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	public Person getPerson(){
		return pers;
	}
	
	public void setPerson(Person persn){
		pers = persn;
	}


	
	
}
