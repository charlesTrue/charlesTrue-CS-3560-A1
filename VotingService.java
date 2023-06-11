import java.util.*;
/**----------------VotingService Class------------------------------------/
 * This class  handles submissions, calculates results an contains print method
 * ---------------------------------------------------------------------**/
class VotingService {
    // VotingService class
        private Question question;
        private Map<String, List<Integer>> studentAnswers;

        public VotingService(Question question) {
            this.question = question;
            this.studentAnswers = new HashMap<>();
        }

        public void acceptSubmission(Student student, List<Integer> answers) {
            studentAnswers.put(student.getId(), answers);
        }

        // Method used to Print all Statistical material
        public void printStats() {
            System.out.println("***Submission Statistics***");
            System.out.println("Total number of students answered: " + studentAnswers.size());

            // Prints the unique student IDs that answered
            System.out.println("Student IDs that answered:");
            for (String studentId : studentAnswers.keySet()) {
                System.out.println(studentId);
            }

            // Print questions and answers
            System.out.println("Question: " + question.getQuestion());
            System.out.println("Choices: " + question.getChoices());

            // Calculate correct, wrong answers percentage of all correct answers
            int correctCount = 0;
            int wrongCount = 0;
            int correctAnsPercent;
            for (List<Integer> answers : studentAnswers.values()) {
                boolean isCorrect = answers.equals(question.getCorrectAnswers());
                if (isCorrect) {
                    correctCount++;
                } else {
                    wrongCount++;
                }
            }
            correctAnsPercent = 100 *   correctCount/studentAnswers.size();

            System.out.println("Total number of correct answers: " + correctCount);
            System.out.println("Total number of wrong answers: " + wrongCount);
            System.out.println("Percentage of correct answers:" + correctAnsPercent + "%" + "\n\n");
        }//end of print stats

    }// end of class
