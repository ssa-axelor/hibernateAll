package HIbernateRelation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class StudentM2M {

@Id
@GeneratedValue
		private int studentId;
		private String studentName;
		private int marks;

		 
	 
		@GeneratedValue(strategy=GenerationType.AUTO)  
		@ManyToMany
		private Set<CourseM2M> coursem2m;

		public int getStudentId() {
			return studentId;
		}

		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public int getMarks() {
			return marks;
		}

		public void setMarks(int marks) {
			this.marks = marks;
		}

		public Set<CourseM2M> getCourses() {
			return coursem2m;
		}

		public void setCourses(Set<CourseM2M> courses) {
			this.coursem2m = courses;
		}

		StudentM2M()
		{
			
		}
		
		StudentM2M(int studentId,String studentName,int marks)
		{
			this.studentId=studentId;
			this.studentName=studentName;
			this.marks=marks;
			
		}
	}