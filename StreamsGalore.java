import java.util.*;
import java.util.stream.Collectors;

public class StreamsGalore {
  public static void main(String[] args) {

    Student student1 = new Student("Jayesh", 20, new Address("1234"),
        Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

    Student student2 = new Student("Khyati", 20, new Address("1235"), Arrays
        .asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

    Student student3 = new Student("Jason", 20, new Address("1236"),
        Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

    List<Student> students = Arrays.asList(student1, student2, student3);


    /*****************************************************
     * Get student with exact match name "jayesh"
     *****************************************************/

    System.out.println("--------------------");

    Student jayesh = students.stream().filter(student -> student.getName().equals("Jayesh")).findFirst().get();
    System.out.println(jayesh.getName());


    /*****************************************************
     * Get student with matching address "1235"
     *****************************************************/

    System.out.println("--------------------");

    Student matchingAddress = students.stream().filter(student -> student.getAddress().getZipcode().equals("1235")).findFirst().get();
    System.out.println(matchingAddress.getName());


    /*****************************************************
     * Get all student having mobile numbers 3333.
     *****************************************************/
  
    System.out.println("--------------------");

    List<Student> mobileMatch = students.stream().filter(student -> student.getMobileNumbers().stream().anyMatch(mobileNumber -> mobileNumber.getNumber().equals("3333"))).toList();
    System.out.println(mobileMatch.stream().map(Student::getName).toList());


    /*****************************************************
     * Get all student having mobile number 1233 and 1234
     *****************************************************/
    
    System.out.println("--------------------");
    List<String> studentName = students.stream().filter(student -> student.getMobileNumbers().stream().map(MobileNumber::getNumber).toList()
            .containsAll(Arrays.asList("1233", "1234"))).map(Student::getName).toList();
    System.out.println(studentName);



    /*****************************************************
     * Create a List<Student> from the List<TempStudent>
     *****************************************************/
    TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"), Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

    TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"), Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

    List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);

    
    System.out.println("--------------------");

    List<Student> copy = tmpStudents.stream().map(tmp ->new Student(tmp.name, tmp.age, tmp.address, tmp.mobileNumbers)).toList();
    copy.forEach(System.out::println);


    /*****************************************************
     * Convert List<Student> to List<String> of student name
     *****************************************************/
    
    System.out.println("--------------------");

    List<String> name = tmpStudents.stream().map(tmp -> tmp.name).toList();
    System.out.println(String.join(",", name));
    System.out.println(name);

    /*****************************************************
     * Convert List<students> to String
     *****************************************************/

    System.out.println("--------------------");

    List<String> names = students.stream().map(Student::getName).toList();
    System.out.println(names);

    /*****************************************************
     * Change the case of List<String>
     *****************************************************/
    List<String> nameList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");

    System.out.println("--------------------");

    List<String> upperCase = nameList.stream().map(String::toUpperCase).collect(Collectors.toList());
    upperCase.forEach(System.out::println);




    /*****************************************************
     * Sort List<String>
     *****************************************************/
    List<String> namesList = Arrays.asList("Jayesh", "Dany", "Khyati", "Hello", "Mango");

    System.out.println("--------------------");

    Collections.sort(namesList);
    namesList.forEach(System.out::println);



  }
}
