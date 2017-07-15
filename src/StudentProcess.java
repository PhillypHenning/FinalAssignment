import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentProcess {


	
	
	// Task 1 
	public static void main(String[] args){
		Student[] students = {
				 new Student("Jack", "Smith", 50.0, "IT"),
				 new Student("Aaron", "Johnson", 76.0, "IT"),
				 new Student("Maaria", "White", 35.8, "Business"),
				 new Student("John", "White", 47.0, "Media"),
				 new Student("Laney", "White", 62.0, "IT"),
				 new Student("Jack", "Jones", 32.9, "Business"),
				 new Student("Wesley", "Jones", 42.89, "Media")};
		
	List<Student> studs =  new ArrayList<>(Arrays.asList(students));                      			
	System.out.println("Task 1\nComplete Student list:");
	studs.stream().forEach(System.out::println);  
	System.out.print("\n"); //Spacing / clarity 
	
	
	
	//Task 2
	System.out.println("Task 2\nStudents who got 50.0-100.0 sorted by grade:");
	List<Student> studsHigh = studs.stream()
	.filter(t->t.grade >= 50)
	.collect(Collectors.toList());
	
	studsHigh.stream().forEach(System.out::println); 
	System.out.print("\n"); //Spacing / clarity 
	
	
	// Task 3
	System.out.println("Task 3\nFirst Student who got 50.0-100.0:");
	Student highest = studsHigh.stream().findFirst().get(); 
	System.out.println(highest);
	System.out.print("\n"); //Spacing / clarity 
	
	
	// Task 4
	Comparator<Student> byLastName = Comparator.comparing(Student::getLastName);
	Comparator<Student> byFirstName = Comparator.comparing(Student::getFirstName);
	
	System.out.println("Task 4\nStudents ascending order by last name then first:");
	studs.stream().sorted(byLastName.thenComparing(byFirstName)).forEach(System.out::println);
	
	System.out.println("\nStudents in descending order by last name then first:");
	studs.stream().sorted(byLastName.thenComparing(byFirstName).reversed()).forEach(System.out::println);	
	System.out.print("\n"); //Spacing / clarity 
		
		
	//Task 5
	System.out.println("Task 5\nUnique Student last names:");
	Set<String> a = studs.stream().map(Student::getLastName).collect(Collectors.toSet());
	a.stream().sorted((s1, s2) -> s1.compareTo(s2)).forEach(System.out::println);
	// Learning experience, in a stream each action taken is sequential, therefore the sort happens prior to the print.
	System.out.print("\n"); //Spacing / clarity
	
	
	//Task 6
	System.out.println("Task 6\nStudent names in order by last name then first name:");
	studs.stream().sorted(byLastName.thenComparing(byFirstName)).forEach(t -> System.out.println(t.getFullName()));
	System.out.print("\n"); //Spacing / clarity
	
	
	//Task 7	
	System.out.println("Task 7\nStudents by department:");
	Map<String, List<Student>> studentsByDepartment = studs.stream().collect(Collectors.groupingBy(Student::getDepartment));
	studentsByDepartment.forEach((k,v) ->     
		System.out.println(k + ",\n\t" + v.stream().map(t-> t).collect(Collectors.toList()).toString().replace("[", "").replace("]", "") .replace(",", "\n").replace("\n ", "\n\t")) 
	// I'm curious to know if there is a better way than this ^^
	);
	System.out.print("\n"); //Spacing / clarity
	
	
	//Task 8
	System.out.println("Task 8 \nCount of Students by department:");
	studentsByDepartment.forEach((k,v) -> 
		System.out.println(k + " has " + v.size()+ " Student" + ((v.size() > 1) ? "s" : ""))
	);
	System.out.print("\n"); //Spacing / clarity
	
	
	// Task 9
	System.out.print("Task 9\nSum of Students' grades: ");
	double j = studs.stream().mapToDouble(p -> p.getGrade()).sum();
	System.out.print(j);	
	}
}
