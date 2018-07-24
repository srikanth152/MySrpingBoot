package course.config.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="USER_DETAILS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
//	@EmbeddedId
//	@JoinTable(name="ADDRESS",joinColumns=@JoinColumn(referencedColumnName="userId"))
	@ElementCollection(fetch=FetchType.EAGER) // by default it fetches the sub class data in LAZY way.
	@JoinTable(name="USER_ADDRESS",
	joinColumns=@JoinColumn(name="userId")) // creates the join table with specified name, if not provide hibernate creates name using parent_child class name
	@GenericGenerator(name="hilo-gen", strategy="increment")
	@CollectionId(columns={@Column(name="ADDRESS_ID")},generator = "hilo-gen", type = @Type(type="long") ) // generates a primary key with the name ADDREES_ID and uses the hilo-gen //startegy for the value
	private List<Address> address = new ArrayList<>();
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public User() {
		
	}
	
	public User(String firstName,String lastName,String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
