package javaAdvance.collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class JobApplication {
	int id;
	String name;
	String email;
	String skill;
	String status;

	JobApplication(int id, String name, String email, String skill, String status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.skill = skill;
		this.status = status;
	}

	@Override
	public String toString() {
		return id + " - " + name + " - " + email + " - " + skill + " - " + status;
	}
}

public class CollectionCommonExample {
		    public static void main(String[] args) {

		        List<JobApplication> applications = new ArrayList<>();

		        applications.add(new JobApplication(101, "Vijay", "vijay@gmail.com", "Java", "APPLIED"));
		        applications.add(new JobApplication(102, "Amit", "amit@gmail.com", "React", "APPLIED"));
		        applications.add(new JobApplication(103, "Vijay", "vijay@gmail.com", "Java", "APPLIED"));
		        applications.add(new JobApplication(104, "Neha", "neha@gmail.com", "Java", "SHORTLISTED"));
		        applications.add(new JobApplication(105, "Ravi", "ravi@gmail.com", "DevOps", "REJECTED"));

		        // 1. ArrayList
		        System.out.println("1. ArrayList:");
		        System.out.println(applications);

		        // 2. HashSet
		        Set<String> uniqueEmails = new HashSet<>();
		        for (JobApplication app : applications) {
		            uniqueEmails.add(app.email);
		        }
		        System.out.println("\n2. HashSet unique emails:");
		        System.out.println(uniqueEmails);

		        // 3. LinkedHashSet
		        Set<String> orderedUniqueEmails = new LinkedHashSet<>();
		        for (JobApplication app : applications) {
		            orderedUniqueEmails.add(app.email);
		        }
		        System.out.println("\n3. LinkedHashSet ordered unique emails:");
		        System.out.println(orderedUniqueEmails);

		        // 4. TreeSet
		        Set<String> sortedEmails = new TreeSet<>();
		        for (JobApplication app : applications) {
		            sortedEmails.add(app.email);
		        }
		        System.out.println("\n4. TreeSet sorted unique emails:");
		        System.out.println(sortedEmails);

		        // 5. HashMap
		        Map<Integer, JobApplication> applicationMap = new HashMap<>();
		        for (JobApplication app : applications) {
		            applicationMap.put(app.id, app);
		        }
		        System.out.println("\n5. HashMap find by id 104:");
		        System.out.println(applicationMap.get(104));

		        // 6. LinkedHashMap
		        Map<String, Object> response = new LinkedHashMap<>();
		        response.put("status", "success");
		        response.put("message", "Applications fetched successfully");
		        response.put("totalRecords", applications.size());
		        response.put("data", applications);
		        System.out.println("\n6. LinkedHashMap ordered response:");
		        System.out.println(response);

		        // 7. TreeMap
		        Map<String, Integer> skillCount = new TreeMap<>();
		        for (JobApplication app : applications) {
		            skillCount.put(app.skill, skillCount.getOrDefault(app.skill, 0) + 1);
		        }
		        System.out.println("\n7. TreeMap skill count sorted by skill:");
		        System.out.println(skillCount);

		        // 8. ConcurrentHashMap
		        ConcurrentMap<String, Integer> statusCounter = new ConcurrentHashMap<>();
		        for (JobApplication app : applications) {
		            statusCounter.merge(app.status, 1, Integer::sum);
		        }
		        System.out.println("\n8. ConcurrentHashMap status counter:");
		        System.out.println(statusCounter);

		        // 9. ArrayDeque as Queue
		        Queue<JobApplication> processingQueue = new ArrayDeque<>();
		        processingQueue.offer(applications.get(0));
		        processingQueue.offer(applications.get(1));
		        System.out.println("\n9. ArrayDeque queue processing:");
		        System.out.println(processingQueue.poll());

		        // 10. PriorityQueue
		        PriorityQueue<JobApplication> priorityQueue =
		                new PriorityQueue<>((a, b) -> a.id - b.id);

		        priorityQueue.offer(applications.get(4)); // 105
		        priorityQueue.offer(applications.get(0)); // 101

		        System.out.println("\n10. PriorityQueue by lowest id:");
		        System.out.println(priorityQueue.poll());
		    }
		}

