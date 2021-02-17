package org.fundacionjala.app.quizz;

import org.fundacionjala.app.quizz.console.QuizUIHandler;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;
import org.fundacionjala.app.quizz.console.util.InputReader;

public class Menu {

    private Quiz quiz;
    private QuizAnswers quizAnswers;

    public Menu() {
        this.quiz = null;
        this.quizAnswers = null;
    }

    public boolean process() {
        showMainMenu();
        char option = InputReader.readOption();
        boolean shouldExit = false;
        switch (option) {
            case '1':
                quiz = QuizUIHandler.createQuiz();
                break;
            case '2':
                fillQuiz();
                break;
            case '3':
                showQuiz();
                break;
            case '4':
                shouldExit = true;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.println(System.lineSeparator());
        return shouldExit;
    }

    private void showQuiz() {
        if(quiz == null){
            System.out.println("You must create and fill a quiz");
            return;
        }
        if (quizAnswers == null) {
            System.out.println("You must fill your quiz before you can see the answers");
            return;
        }

        QuizUIHandler.showQuiz(quizAnswers);
    }

    private void fillQuiz() {
        if (quiz == null) {
            System.out.println("No quiz available, you must create first a quiz");
            return;
        }

        quizAnswers = QuizUIHandler.fillQuiz(quiz);
    }

    private void showMainMenu() {
        System.out.println("Quizc - A command quiz utility");
        System.out.println("======================================");
        System.out.println("1. Create quiz");
        System.out.println("2. Fill quiz");
        System.out.println("3. Show quiz");
        System.out.println("4. Exit");
        System.out.println("======================================");
    }
}
