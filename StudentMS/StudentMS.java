package StudentMS;
import java.util.*;


class Student{
    private String name,id;
    private int marks;

    public Student(String name, String id, int marks){
        this.name = name;
        this.id = id;
        this.marks = marks;

    }

    public int getMarks(){
        return this.marks;
    }

    public String getId(){
        return this.id;
    }

    public String getRole(){
        return "undergraduate";
    }


    public String toString(){
        return id + " " + name + " " + marks + " " + getRole();
    }

}

class Teacher extends Student{

    public Teacher(String name, String id, int marks){
        super(name, id, marks);
    }

    @Override
    public String getRole(){
        return "teacher";
    }



}

class GraduateStudent extends Student{

    private String area;

    public GraduateStudent(String name, String id, int marks,String area) {
        super(name, id, marks);
        this.area = area;
    }

    @Override
    public String getRole(){
        return "graduate";
    }


}


class Repositery<T> {

    private Map<String,T> data = new HashMap<>();

    public void save(String id , T obj) {
        data.put(id, obj)   ;
    }

    public T find(String id){
        return data.get(id);
    }

    public void delete(String id) {
        data.remove(id);
    }


    public void getReport(){
        System.out.println("id name marks role");
        for(Map.Entry<String,T> entries : data.entrySet()){
            System.out.println(entries.getValue()) ;
        }

    }




}





public class StudentMS {

    public static void main(String args[]){
        List<Student> list  = new ArrayList<>();
        list.add(new Student("Jetha", "s1", 20));
        list.add(new Student("Bhide", "s2", 60));
        list.add(new Student("Taraak", "s3", 80));
        list.add(new GraduateStudent("Sodhi", "g1", 80,"CSE"));




        Repositery<Student> repo = new Repositery<>();

        for(Student s : list ) repo.save(s.getId(), s);

        System.out.println("All");
        list.forEach(System.out::println);


        System.out.println("lookup S2");
        Student s  = repo.find("s2");
        System.out.println(s != null ? s : "Not found");

        // Iterator<Student> it = list.iterator();
        
        // while(it.hasNext()){
        //     Student st  = it.next();
        //     if(st.getMarks() < 80) {
        //         it.remove();
        //         repo.delete(st.getId());
        //     }
        // }


        // System.out.println("after removal");
        // list.forEach(System.out::println);

        System.out.println("Report");
        repo.getReport();

    }
    
}
