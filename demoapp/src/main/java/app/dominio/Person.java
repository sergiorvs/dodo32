	package app.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Person implements BaseEntity<Long>{

	@Id
	@SequenceGenerator(name = "person_id_generator", sequenceName = "person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_generator")
	private Long id;

	@Column(length = 64, nullable=true)
	private String firstName;

	@Column(length = 64, nullable=true)
	private String lastName;

	@Column(length = 64, unique=true,  nullable=true)
	private String username;

	@Column(length = 64, nullable=true)
	public String email;
	
	@Column(length = 64, nullable=true)
	private String password;    //private !!! 
	
	@Column(length = 64)
	public Date birthDate;
	
	@Column(nullable=false)
	public Short typePerson;    //1 : Manager  ,   2: UserProgrammer
	
	/*
	@OneToMany
	@JoinColumn(name="personId")
	public List<Manager> managers;
	
	
	@OneToMany
	@JoinColumn(name="personId")
	public List<UserProgmmr> usersProgr;	
	*/
	
	
	@Override
	public Long getId() {
		return id;
	}	
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthdate(){
		return birthDate;
	}
	
	public void setBirthdate(Date birthDateNew){
		this.birthDate = birthDateNew;
	}
	public String getemail(String email){
		return email;
	}
	
	public void setemail(String email){
		this.email = email;
	}
	
	public void setUserName(String username_){
		username = username_;
	}
	
	public String getUserName(){
		return username;
	}
	
	public void setPassw(String password){
		this.password = password;
	}
	
	public void setType(String typepers){ //typepers:  1 para managere ,  2 para Progremmer
		Short code;
		typepers = typepers.substring(typepers.length()-1);
		code = Short.parseShort(typepers);
		typePerson = code;
	}
	
	public Short getType(){
		return typePerson;
	}	
	
	
}
