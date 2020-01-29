//package models;
//
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "book")
//public class Employee {
//    private long id;
//    private String title;
//    private String author;
//    private float price;
//
//	
//	@Id
//	@Column(name = "book_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public long getId() {
//	    return id;
//	}
//	
//	public Employee(){
//		super();
//	}
//	
//	
//	public Employee(String title, String author, float price) {
//		super();
//		this.title = title;
//		this.author = author;
//		this.price = price;
//	}
//
//
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getAuthor() {
//		return author;
//	}
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//	public float getPrice() {
//		return price;
//	}
//	public void setPrice(float price) {
//		this.price = price;
//	}
//}





package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
    private long id;
    private String name;
    private String contact;
    private String address;

	
	@Id
	@Column(name = "emp_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
	    return id;
	}
	
	public Employee(){
		super();
	}
	
	
	public Employee(String name, String contact, String address) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
	}


	public Employee(long id, String name, String contact, String address) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(long id) {
		this.id = id;
	}

}












