package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Category;
import com.example.entity.Course;
import com.example.entity.User;
import com.example.entity.Video;
import com.example.service.AdminService;
import com.example.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService aservice;
	
	
	@GetMapping(path="/coursereports")
	public List<Course> courseReports(){
		return aservice.courseStats();
		
	}
	
	
	// show all categories
		@GetMapping("/category")
		public ResponseEntity<List<Category>> AllCategory() {

			List<Category> li = aservice.getAllCategory();
			for (Category l : li) {
				System.out.println(l);
			}
			return ResponseEntity.status(HttpStatus.OK).body(li);
		}

		// show category by id
		@GetMapping(value = "/category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
		public Optional<Category> CategoryById(@PathVariable int id) {
			System.out.println(id);
			return aservice.getCategoryById(id);

		}
		
		// add category
		@PostMapping("/category")
		public boolean addCategory(@RequestBody Category c) {
			return aservice.addCategory(c);
//			if(c.getCategoryId()==0) {
//				asi.addCategory(c);
//			}else {
//				asi.updateCategory(c);
//			}
//			return "redirect:/category";

		}

		// delete category by id
		@DeleteMapping("/category/{id}")
		public void deleteCategory(@PathVariable int id) {
			aservice.deleteCategory(id);
		}

		// update category by id
		@PutMapping("/category/{cat_id}")
		public boolean updateCategory(@RequestBody Category c, @PathVariable int cat_id) {
			c.setCategoryId(cat_id);
			Optional<Category> ctest=aservice.getCategoryById(cat_id);
			return aservice.updateCategory(c,ctest,cat_id);

		}
		
		// total categories
		@GetMapping("/category/total")
		public long totalCategory() {
			return aservice.getCategoryCount();
		}
		
		

		// show all courses
		@GetMapping("/course")
		public ResponseEntity<List<Course>> AllCourse() {
			List<Course> li = aservice.getAllCourse();
			for (Course l : li) {
				System.out.println(l);
			}
			return ResponseEntity.status(HttpStatus.OK).body(li);
		}

		// show course by id
		@GetMapping("/course/{id}")
		public Optional<Course> CourseById(@PathVariable int id) {
			System.out.println(id);
			return aservice.getCourseById(id);

		}

		// add course
		@PostMapping("/course/{cat_id}")
		public boolean addCourse(@RequestBody Course c, @PathVariable int cat_id) {
			return aservice.addCourse(c, cat_id);
		}

		// delete course by id
		@DeleteMapping("/course/{id}")
		public void deleteCourse(@PathVariable int id) {
			aservice.deleteCourse(id);
		}

		// update category by id
		@PutMapping("/course/{co_id}/{cat_id}")
		public boolean updateCourse(@RequestBody Course c, @PathVariable int co_id,@PathVariable int cat_id) {
			
			c.setCourseId(co_id);
			Optional<Course> ctest=aservice.getCourseById(co_id);
			return aservice.updateCourse(c,ctest);

		}

		// total courses
			@GetMapping("/course/total")
			public long totalCourses() {
				return aservice.getCourseCount();
			}
		
		
		// show all videos
		@GetMapping("/video")
		public ResponseEntity<List<Video>> AllVideos() {
			List<Video> li2 = aservice.getAllVideo();
			for (Video l : li2) {
				System.out.println(l);
			}
			return ResponseEntity.status(HttpStatus.OK).body(li2);
		}

		// show video by id
		@GetMapping("/video/{id}")
		public Optional<Video> VideoById(@PathVariable int id) {
			return aservice.getVideoById(id);

		}

		// add video
		@PostMapping("/video/{co_id}")
		public boolean addVideo(@RequestBody Video c, @PathVariable int co_id) {
			return aservice.addVideo(c,co_id);
		}

		// delete video
		@DeleteMapping("/video/{id}")
		public void deleteVideo(@PathVariable int id) {
			aservice.deleteVideo(id);
		}

		// update video by id
		@PutMapping("/video/{v_id}/{co_id}")
		public boolean updateVideo(@RequestBody Video v, @PathVariable int v_id,@PathVariable int co_id) {
			v.setVideoId(v_id);
			return aservice.updateVideo(v,co_id);
		}
		
		
		// total courses
		@GetMapping("/video/total")
		public long totalVideos() {
			return aservice.getVideoCount();
		}
		
		//USERS
		
		@GetMapping("/user")
		public ResponseEntity<List<User>> AllUsers() {

			List<User> li = aservice.getAllUser();
			for (User l : li) {
				System.out.println(l);
			}
			return ResponseEntity.status(HttpStatus.OK).body(li);
		}

		
		@GetMapping(path="/lockedusers")
		public List<User> getLocked(){
			return aservice.getLockedAccount();
		}
		@PutMapping(path="/unlockuser/{u_id}")
		public boolean unlock(@PathVariable int u_id){
			return aservice.unlocakAccount(u_id); 
		}
		@PutMapping(path="/lockuser")
		public boolean lock(){
			return aservice.lockAccount(4);
		}


}
