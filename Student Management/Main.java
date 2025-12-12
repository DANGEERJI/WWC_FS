import java.util.*;

class Student {
   private String id, name;
   private int marks;

   public Student(String id, String name, int marks) {
      this.id = id;
      this.name = name;
      this.marks = marks;
   }

   public String getId() { return id; }
   public int getMarks() { return marks; }

   public String getRole() { return "Undergrad"; }

   @Override
   public String toString() {
      return id + " " + name + " (" + marks + ") " + getRole();
   }
}

class GraduateStudent extends Student {
   private String area;

   public GraduateStudent(String id, String name, int marks, String area) {
      super(id, name, marks);
      this.area = area;
   }

   @Override
   public String getRole() {
      return "Grad(" + area + ")";
   }
}

class Teacher{
   private String id, name, subject;

   public Teacher(String id, String name, String subject){
      this.id = id;
      this.name = name;
      this.subject = subject;
   }

   public void report(List<Student> students){
      students.forEach(student-> {
         System.out.println("Student Id: " + student.getId() + " Marks: " + student.getMarks());
      });
   }

   @Override
   public String toString(){
      return id + " " + name + " (" + subject + ")";
   }
}

class Repository<T> {
   private Map<String, T> data = new HashMap<>();
   public void save(String id, T obj) { data.put(id, obj); }
   public T find(String id) { return data.get(id); }
   public void delete(String id) { data.remove(id); }
}

public class Main {
   public static void main(String[] args) {
      List<Student> students= new ArrayList<>();
      students.add(new Student("s1", "Alice", 90));
      students.add(new Student("s2", "Charlie", 85));
      students.add(new Student("s3", "Bob", 78));
      students.add(new GraduateStudent("G1", "Dina", 92, "CS")); 

      Repository<Student> repo = new Repository<>();
      for(Student s:students){
         repo.save(s.getId(),s);
      }
      System.out.println("ALL Students: ");
      students.forEach(System.out::println);

      System.out.println("\nLOOKUP S2: ");
      Student s = repo.find("S2");
      System.out.println(s!=null ? s: "Not Found");

      Iterator<Student> it = students.iterator();
      while(it.hasNext()){
         Student st = it.next();

         if(st.getMarks() < 90){
            it.remove();
            repo.delete(st.getId());
         }
      }
      System.out.println("\nAfter Removal: ");
      students.forEach(System.out::println);

      List<Teacher> teachers = new ArrayList<>();
      teachers.add(new Teacher("T1", "Mr. Ansh", "Full Stack"));
      teachers.add(new Teacher("T2", "Mr. Tapesh", "Java"));
      teachers.add(new Teacher("T3", "Mr. Alok", "DBMS"));

      System.out.println("\nALL Teachers: ");
      teachers.forEach(System.out::println);

      System.out.println("\nHere's the Student Report: ");
      teachers.get(0).report(students);
   }
}