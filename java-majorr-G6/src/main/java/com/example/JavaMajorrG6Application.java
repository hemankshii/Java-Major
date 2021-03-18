package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Category;
import com.example.entity.Course;
import com.example.entity.EnrolledCourseVideo;
import com.example.entity.Profile;
import com.example.entity.User;
import com.example.entity.Video;
import com.example.repositiories.CategoryRepo;
import com.example.repositiories.ProfileRepo;
import com.example.repositiories.UserRepo;





@SpringBootApplication
public class JavaMajorrG6Application implements CommandLineRunner {

	
	@Autowired
	UserRepo ur;
	@Autowired
	ProfileRepo pr;
	@Autowired
	CategoryRepo catr;
	
	
	public static void main(String[] args) {
		SpringApplication.run(JavaMajorrG6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Video vid1=new Video("r1", "react1", "r1.mp4");
//		Video vid2=new Video("r2", "react2", "r2.mp4");
//		List<Video> videos=new ArrayList<>();
//		videos.add(vid2);videos.add(vid1);
//		Course course=new Course("angular", "learn angular", null, 290, 0);
//		Course course1=new Course("react", "learn react", null, 123, 0);
//		course1.setVideo(videos);
//		List<Course> courses=new ArrayList<>();
//		courses.add(course1);courses.add(course);
//		Category category=new Category("frontend", "learn frontend", null, courses);
//		catr.save(category);
//		Profile p=new Profile("Vedang T", null, null, "Male");
//		User u=new User("uname", "abc@gmail.com", "123xyz", true, true, "kjfsgbikrg");
//		p.setUser(u);
//		u.setProfile(p);
//		ur.save(u);
//		
		
	}

}
