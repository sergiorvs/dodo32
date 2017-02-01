package app.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dominio.MeetingCall;
import app.dominio.UserprHasConvoc;
import app.repositorio.MeetingCallRepository;
import app.repositorio.UserProgrammerRepository;
import app.repositorio.UserprHasConvocRepository;

@Service
public class MeetingCallService {
	@Autowired
	MeetingCallRepository meetingCallRepository;
	
	@Autowired
	UserprHasConvocRepository userProgHasConvRepository;
	
	@Autowired
	UserProgrammerRepository userProgRepository;
	
	
	public MeetingCall saveMeeting(String name, String[] meetProg, Long manid){
		MeetingCall meeting = new MeetingCall();
		meeting.setName(name);
		meeting.setManagerId(manid);
		
		MeetingCall meetingcall = meetingCallRepository.save(meeting);		
		
		for (int i = 0; i< meetProg.length ; i++){
			UserprHasConvoc userhcovoc = new UserprHasConvoc();
			userhcovoc.setMeetingCallId(meetingcall.getId());
			userhcovoc.setUserProgmmrId(userProgRepository.findProgrammer( Long.parseLong(meetProg[i]) ).getId() ); 
			userProgHasConvRepository.save(userhcovoc);
		}
		
		return meetingcall;
	}

	public List<MeetingCall> findMeetingCallsByIdManager(Long idman){
		return meetingCallRepository.findMeetingCallsByIdManager(idman);
	}
}

