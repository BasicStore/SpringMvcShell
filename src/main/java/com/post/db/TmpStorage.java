package com.post.db;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.post.dm.Incident;
import com.post.dm.Person;
import com.post.dm.User;

@Repository
public class TmpStorage {

	private static List<User> validUserList;
	
	private static List<Incident> incidentList;
	
	private static List<Person> actorsList;
	
	
	public TmpStorage() {
		loadArtificialData();
	}
	
	
	private static void loadArtificialData() {

//		public Incident(long id, Person reporter, String type, Severity severity, LocalDateTime startDate, LocalDateTime endDate,
//				String periodInQuestion, String dateSubmitted, List<Statement> statementList, LocalDateTime submissionDate) {
//		NULL NULL
		
	// 	public Statement(long id, Person author, String comments, String summary) {	
		
		
//		public Person(long id, String firstName, String lastName, String addresss, MaritalStatus maritalStatus, String occupation,
//				LocalDate dateOfBirth, String email, String mobileTel, String homeTel, String workTel, String placeOfBirth,
//				String countryOfBirth) {
		
		
// public User(long id, String username, @NotNull @Size(max = 20) String pass, List<String> roleList) {
		
		
	}
	
	
	
	public String getTestMsg() {
		return "test msg goes here....";
	}
	
	
	
	
	
}
