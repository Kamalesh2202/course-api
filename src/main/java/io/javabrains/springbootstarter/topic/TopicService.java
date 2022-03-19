package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
										new Topic("Spring-Boot","SpringBoot Crash Course","Crash course for Springboot."),
										new Topic("NodeJs","NodeJs Crash Course","Crash course for NodeJs."),
										new Topic("ReactJs","ReactJs Crash Course","Crash course for ReactJs.")
									));
	
	public List<Topic> getAllTopics(){
		//return topics;
		//return (List<Topic>) topicRepository.findAll();
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add); //lambda expression
		return topics;
	}
	
	public Topic getTopic(String id) { //Check for isPresent() to avoid NullPointerException
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).orElse(null);
	
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
		
	}

	public void updateTopic(Topic topic, String id) {
//		for(Topic x : topics) {
//			if(x.getId().equals(id)) {
//				x.setId(topic.getId());
//				x.setName(topic.getName());
//				x.setDescription(topic.getDescription());
//				return;
//			}
//		}
		
		topicRepository.save(topic);
	}

	public void deleteTopic(String id) {
		//topics.removeIf(t -> t.getId().equals(id));
		topicRepository.deleteById(id);
	}
	
}
