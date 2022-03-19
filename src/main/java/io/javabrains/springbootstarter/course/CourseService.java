package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String topicId){
		//return topics;
		//return (List<Topic>) topicRepository.findAll();
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add); //lambda expression
		return courses;
	}
	
	public Course getCourse(String id) { //Check for isPresent() to avoid NullPointerException
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).orElse(null);
	
	}

	public void addCourse(Course course) {
		//topics.add(topic);
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
//		for(Topic x : topics) {
//			if(x.getId().equals(id)) {
//				x.setId(topic.getId());
//				x.setName(topic.getName());
//				x.setDescription(topic.getDescription());
//				return;
//			}
//		}
		
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		courseRepository.deleteById(id);
	}
	
}
