package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Category;
import com.example.entity.Comment;
import com.example.entity.Course;
import com.example.entity.EnrolledCourses;
import com.example.entity.Feedback;
import com.example.entity.User;
import com.example.entity.Video;
import com.example.repositiories.CategoryRepo;
import com.example.repositiories.CommentRepo;
import com.example.repositiories.CourseRepo;
import com.example.repositiories.EnrolledCourseRepo;
import com.example.repositiories.FeedbackRepo;
import com.example.repositiories.UserRepo;
import com.example.repositiories.VideoRepo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	CourseRepo cr;
	@Autowired
	EnrolledCourseRepo ecr;
	@Autowired
	CommentRepo cmtr;
	@Autowired
	FeedbackRepo fr;
	
	
	@Autowired
	CategoryRepo cat;
	

	@Autowired
	VideoRepo vr;
	
	@Autowired
	UserRepo ur;
	
	@Override
	public List<Course> courseStats() {
		List<Course> courses=cr.findAll();
		List<Comment> comments=cmtr.findAll();
		List<Feedback> feedbacks=fr.findAll();
		List<EnrolledCourses> ecs=ecr.findAll();
		for (int i=0;i<courses.size();i++) {
			courses.get(i).setVideosize(courses.get(i).getVideo().size());
			for(int j=0;j<comments.size();j++) {
				if(courses.get(i).getCourseId()==comments.get(j).getCourse().getCourseId() ) {
					courses.get(i).setTotalcomment(courses.get(i).getTotalcomment()+1);
					
				}
			}
			float avgrating = 0;
			for (Feedback f :feedbacks) {
				avgrating = avgrating + f.getRatings();
			}
			int rating = (int) (avgrating / (courses.get(i).getFeedbacks().size()));
			courses.get(i).setAvgrating(rating);
			for(int l=0;l<ecs.size();l++) {
				if(courses.get(i).getCourseId()==ecs.get(l).getCourse().getCourseId() ) {
					courses.get(i).setEnrollments(courses.get(i).getEnrollments()+1);
					System.out.println(courses.get(i).getTotalcomment());
				}
			}
				
		}
		return courses;
	}
	
	@Override
	public List<Category> getAllCategory() {
		return cat.findAll();
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return cat.findById(id);
	}

	@Override
	public boolean addCategory(Category c) {
		return cat.save(c) != null;
	}

	@Override
	public void deleteCategory(int id) {
		cat.deleteById(id);

	}

	@Override
	public boolean updateCategory(Category c,Optional<Category> ctest,int id) {

	List<Course>cotest=ctest.get().getCourses();	
	c.setCourses(cotest);
		System.out.println(c.getCourses());
		return cat.save(c) != null;
	}

	@Override
	public List<Course> getAllCourse() {
		return cr.findAll();
	}

	@Override
	public Optional<Course> getCourseById(int id) {
	
		return cr.findById(id);
	}

	@Override
	public boolean addCourse(Course c, int id) {
//		System.out.println(id);
		Optional<Category> cate=cat.findById(id);
		System.out.println(cate.get().getCategoryId());
		List<Course> courses =cate.get().getCourses();
		courses.add(c);
		
		cate.get().setCourses(courses);
		cat.save(cate.get());
		return true;
	}

	@Override
	public void deleteCourse(int i) {
		cr.deleteById(i);

	}

	
//	public boolean updateCategory(Category c,Optional<Category> ctest,int id) {
//
//		List<Course>cotest=ctest.get().getCourses();	
//		c.setCourses(cotest);
//			System.out.println(c.getCourses());
//			return cat.save(c) != null;
//		}
	
	@Override
	public boolean updateCourse(Course c,Optional<Course> ctest) {
		List<Video> video = ctest.get().getVideo();
		String cat_name=ctest.get().getCategory();
		Category category=cat.findByCategoryName(cat_name);
		c.setCategory(category);
		c.setVideo(video);
		return cr.save(c) != null;	
	}
	
	@Override
	public boolean addVideo(Video v,int id) {

		Optional<Course> co=cr.findById(id);
		List<Video>videos =co.get().getVideo();
		videos.add(v);
		co.get().setVideo(videos);
		cr.save(co.get());
		return true;
	}

	@Override
	public List<Video> getAllVideo() {
		return vr.findAll();
	}

	@Override
	public Optional<Video> getVideoById(int id) {
		return vr.findById(id);
	}

	@Override
	public boolean updateVideo(Video v,int id) {
		
		
		Optional<Video> video = vr.findById(v.getVideoId());
		Course course=cr.findByCourseName(video.get().getCourse());
		v.setCourse(course);
		vr.save(v);

		return true;
	}

	@Override
	public void deleteVideo(int i) {
		vr.deleteById(i);

	}

	@Override
	public long getCategoryCount() {
		return cat.count();
	}
	
	
	
	@Override
	public long getCourseCount() {
		return cr.count();
	}
	
	
	@Override
	public long getVideoCount() {
		return cr.count();
	}
	@Override
	public boolean lockAccount(int uid) {
	
		Optional<User> user=ur.findById(uid);
		user.get().setLocked(true);
		ur.save(user.get());
		
		
	
		return true;
	}

	@Override
	public boolean unlocakAccount(int uid) {
		Optional<User> user=ur.findById(uid);
		user.get().setLocked(false);
		ur.save(user.get());
		
		
		
		return true;
	}

	@Override
	public List<User> getLockedAccount() {

		return ur.getLockedUsers();
	}

	
	@Override
	public List<User> getAllUser() {
		return ur.findAll();
	}

	
	

}
