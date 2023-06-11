/*************************************************************************-/
 * Author: Charles Trouilliere
 * Class: CS3560 Object-Oriented Design and Programming
 * Professor: Dr. Yun Sun
 * Date: 06/10/23
 * Classes: 1)Student 2)Question 3)VotingService 4)SimDriver
 * Description: This program is designed simulation tool called iVote service
 * based on the live poll idea (mentimeter) used in class.
 * Program supports support 2 types of questions: single and multichoice.
 * Students have unique IDs and each student can only submit one
 * answer. Once finished the program will output the iVote statistics.
 * ************************************************************************/
import java.util.*;
/**----------------SimulationDriver Class------------------------------------/
 * This class automatically simulates the whole process.This class also
 *  contains main which triggers the whole process and randomly generate the
 *  IDs and answers for a group of students.
 * ---------------------------------------------------------------------**/
// SimulationDriver class to simulate the whole process
public class SimDriver {
    public static void main(String[] args) {
        // Configure question types(single and mulit choice) and student answers
        List<String> choices1 = Arrays.asList("1. Yes", "2. No");
        List<Integer> correctAnswers1 = Arrays.asList(0); // Indices of correct answers
        Question question1 = new Question(" Is Java a high level language ?", choices1, correctAnswers1);

        List<String> choices2 = Arrays.asList("1. Yes", "2. No");
        List<Integer> correctAnswers2 = Arrays.asList(1);
        Question question2 = new Question("Are classes in the same package are implicitly imported into main?", choices2, correctAnswers2);

        List<String> choices3 = Arrays.asList("A) CPP", "B) Inheritance", "C) Encapsulation", "D) Abstraction");
        List<Integer> correctAnswers3 = Arrays.asList(1,2,3);
        Question question3 = new Question("What are the features in Java OOP: ", choices3, correctAnswers3);

        List<String> choices4 = Arrays.asList("A) Enumeration", "B) Vector", "C) mentimeter", "D) Hashtable");
        List<Integer> correctAnswers4 = Arrays.asList(0,1,3);
        Question question4 = new Question("Some data structures in Java are?", choices4, correctAnswers4);

        List<String> choices5 = Arrays.asList("A) C++", "B) C-Hashtag", "C) Java", "D) Pytoon");
        List<Integer> correctAnswers5 = Arrays.asList(0, 2);
        Question question5 = new Question("Identify the proper high level programming languages: ", choices5, correctAnswers5);

        // Configure VotingService(service objects) with a given question type
        VotingService service = new VotingService(question1);
        VotingService service2 = new VotingService(question2);
        VotingService service3 = new VotingService(question3);
        VotingService service4 = new VotingService(question4);
        VotingService service5 = new VotingService(question5);

        // Randomly generate a number of students(4-12) and their answers
        int numStudents = generateRandomNumber(4, 12);
        List<Student> students = generateStudents(numStudents);

        for (Student student : students) {
            List<Integer> answers = generateRandomAnswers(question1.getChoices().size());
            List<Integer> answers2 = generateRandomAnswers(question2.getChoices().size());
            List<Integer> answers3 = generateRandomAnswers(question3.getChoices().size());
            List<Integer> answers4 = generateRandomAnswers(question4.getChoices().size());
            List<Integer> answers5 = generateRandomAnswers(question5.getChoices().size());

            service.acceptSubmission(student, answers);
            service2.acceptSubmission(student,answers2);
            service3.acceptSubmission(student,answers3);
            service4.acceptSubmission(student,answers4);
            service5.acceptSubmission(student,answers5);

        }

        // Call the VotingService output function to display the result
        service.printStats();
        service2.printStats();
        service3.printStats();
        service4.printStats();
        service5.printStats();

    }

//----------------Helper methods------------------------------------//

 private static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private static List<Student> generateStudents(int count) {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            students.add(new Student("Student_ID# 00" + i));
        }
        return students;
    }

    private static List<Integer> generateRandomAnswers(int numChoices) {
        Random random = new Random();
        List<Integer> answers = new ArrayList<>();
        int numAnswers = random.nextInt(numChoices) + 1; // Randomly select the number of answers
        for (int i = 0; i < numAnswers; i++) {
            answers.add(random.nextInt(numChoices)); // Randomly select the answer index
        }
        return answers;
    }//end of main
}//end of class
