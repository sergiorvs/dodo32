package domain;

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
public class ConvocatoryMeeting implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "convmeet_id_generator", sequenceName = "convmeet_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "convmeet_id_generator")
	private Long id;
	
	@Column
	private Date meetingDate;
	
	@Column(length = 64)
	private String Name;
	
	@Column
	public Boolean actPast;
	
	@OneToMany
	@JoinColumn(name="convocatoryId")
	private List<UserprHasConvoc> userhasconv;
	
	@OneToMany
	@JoinColumn(name="convocatoryId")
	private List<MeetingOptions> meetingOpcions;

	@Override
	public Long getId() {		
		return id;
	}

	@Override
	public void setId(Long id) {		
		this.id = id;
	}
	
}
