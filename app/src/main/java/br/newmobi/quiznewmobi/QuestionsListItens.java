package br.newmobi.quiznewmobi;

/**
 * Created by figueiredo on 28/02/16.
 */
public class QuestionsListItens {

    String getQuestionID;
    String getQuestionType;
    String getQuestionDifficult;
    String getQuestionCategory;
    String getQuestion;
    String getOption1;
    String getOption2;
    String getOption3;
    String getOption4;
    String getChoice;
    String getChoicePosition;
    String getAnswer;


    public QuestionsListItens(String getQuestionType, String getQuestionDifficult, String getQuestionCategory, String getQuestion, String getOption1, String getOption2, String getOption3, String getOption4, String getAnswer, String getChoice, String getChoicePosition) {
        this.getQuestionType = getQuestionType;
        this.getQuestionDifficult = getQuestionDifficult;
        this.getQuestionCategory = getQuestionCategory;
        this.getQuestion = getQuestion;
        this.getOption1 = getOption1;
        this.getOption2 = getOption2;
        this.getOption3 = getOption3;
        this.getOption4 = getOption4;
        this.getAnswer = getAnswer;
        this.getChoice = getChoice;
        this.getChoicePosition = getChoicePosition;
    }


    public QuestionsListItens() {
    }


    public String getGetQuestionID() {
        return getQuestionID;
    }

    public void setGetQuestionID(String getQuestionID) {
        this.getQuestionID = getQuestionID;
    }

    public String getGetQuestionType() {
        return getQuestionType;
    }

    public void setGetQuestionType(String getQuestionType) {
        this.getQuestionType = getQuestionType;
    }

    public String getGetQuestionDifficult() {
        return getQuestionDifficult;
    }

    public void setGetQuestionDifficult(String getQuestionDifficult) {
        this.getQuestionDifficult = getQuestionDifficult;
    }

    public String getGetQuestionCategory() {
        return getQuestionCategory;
    }

    public void setGetQuestionCategory(String getQuestionCategory) {
        this.getQuestionCategory = getQuestionCategory;
    }

    public String getGetQuestion() {
        return getQuestion;
    }

    public void setGetQuestion(String getQuestion) {
        this.getQuestion = getQuestion;
    }

    public String getGetOption1() {
        return getOption1;
    }

    public void setGetOption1(String getOption1) {
        this.getOption1 = getOption1;
    }

    public String getGetOption2() {
        return getOption2;
    }

    public void setGetOption2(String getOption2) {
        this.getOption2 = getOption2;
    }

    public String getGetOption3() {
        return getOption3;
    }

    public void setGetOption3(String getOption3) {
        this.getOption3 = getOption3;
    }

    public String getGetOption4() {
        return getOption4;
    }

    public void setGetOption4(String getOption4) {
        this.getOption4 = getOption4;
    }

    public String getGetAnswer() {
        return getAnswer;
    }

    public void setGetAnswer(String getAnswer) {
        this.getAnswer = getAnswer;
    }


    public String getGetChoice() {
        return getChoice;
    }

    public void setGetChoice(String getChoice) {
        this.getChoice = getChoice;
    }


    public String getGetChoicePosition() {
        return getChoicePosition;
    }

    public void setGetChoicePosition(String getChoicePosition) {
        this.getChoicePosition = getChoicePosition;
    }
}
