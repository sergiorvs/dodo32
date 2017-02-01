package app.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class MeetingCall implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "meetcall_id_generator", sequenceName = "meetcall_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meetcall_id_generator")
	private Long id;
	
	@Column
	private Date meetingDate;
	
	@Column(length = 64)
	private String Name;
	
	@Column
	public Boolean actPast;
	
	@Column(name="managerId")
	private Long managerId;
	
	@OneToMany
	@JoinColumn(name="meetingCallId")
	private List<UserprHasConvoc> userhasmc;
	
	@OneToMany
	@JoinColumn(name="meetingCallId")
	private List<MeetingOptions> meetingOpcions;

	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
	public void setManagerId(Long managId){
		managerId = managId;
	}
	
	public Long getManagerId(){
		return managerId;
	}
	
	public void setName(String meetName){
		Name = meetName;
	}
	
	public String getName(){
		return Name;
	}
	
}
