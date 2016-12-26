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
public class MeetingOptions implements BaseEntity<Long>{
	@Id
	@SequenceGenerator(name = "meetopc_id_generator", sequenceName = "meetopc_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meetopc_id_generator")
	private Long id;
	
	@Column
	public Date dateOpcion;
	
	@OneToMany
	@JoinColumn(name="meetingOpcionId")
	public List<Vote> votes;	

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
