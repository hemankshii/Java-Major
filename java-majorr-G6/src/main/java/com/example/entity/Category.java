package com.example.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
public class Category {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;
    private String categoryDesc;
    private String categoryLogo;
    
   
    
//    @OneToMany(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="categoryId", referencedColumnName = "categoryId")
//    List<Course> courses;
//    
    @OneToMany(targetEntity = Course.class,fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinColumn(name="categoryId", referencedColumnName = "categoryId")
//     @JsonIgnore
     List<Course> courses;



	public Category(String categoryName, String categoryDesc, String categoryLogo, List<Course> courses) {
		super();
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.categoryLogo = categoryLogo;
		this.courses = courses;
	}
	
	public Category(int categoryId, List<Course> courses) {
		super();
		this.categoryId = categoryId;
		this.courses = courses;
	}



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int categoryId, String categoryName, String categoryDesc, String categoryLogo,
			List<Course> courses) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDesc = categoryDesc;
		this.categoryLogo = categoryLogo;
		this.courses = courses;
	}

	public int getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public String getCategoryDesc() {
		return categoryDesc;
	}



	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}



	public String getCategoryLogo() {
		return categoryLogo;
	}



	public void setCategoryLogo(String categoryLogo) {
		this.categoryLogo = categoryLogo;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	
}
