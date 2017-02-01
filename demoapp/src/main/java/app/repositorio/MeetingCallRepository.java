package app.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import app.dominio.MeetingCall;

public interface MeetingCallRepository extends Repository<MeetingCall,Long> {
	MeetingCall save(MeetingCall meetingCall);
	
	@Query(value="SELECT * FROM meeting_call WHERE manager_id=?1",nativeQuery = true)
	List<MeetingCall>  findMeetingCallsByIdManager(@Param("idman")Long idman);
}
