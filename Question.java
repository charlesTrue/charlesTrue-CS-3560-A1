import java.util.*;
/**----------------Questions Class------------------------------------/
 * This class class represents  poll questions
 * ---------------------------------------------------------------------**/
class Question {
    private String question;
    private List<String> choices;
    private List<Integer> correctAnswers;

    public Question(String question, List<String> choices, List<Integer> correctAnswers) {
        this.question = question;
        this.choices = choices;
        this.correctAnswers = correctAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public List<Integer> getCorrectAnswers() {
        return correctAnswers;
    }
}