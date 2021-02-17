package org.fundacionjala.app.quizz.console;

import java.util.Set;

import org.fundacionjala.app.quizz.model.Answer;
import org.fundacionjala.app.quizz.model.Question;
import org.fundacionjala.app.quizz.model.Quiz;
import org.fundacionjala.app.quizz.model.QuizAnswers;
import org.fundacionjala.app.quizz.console.util.InputReader;

public class QuizUIHandler {

	public static Quiz createQuiz() {
		return new QuizUIMenu().handleCreateQuiz();
	}

	public static QuizAnswers fillQuiz(Quiz quiz) {
		QuizAnswers quizAnswers = new QuizAnswers(quiz);
		QuestionInputHandler questionHandler = new QuestionInputHandler();

		System.out.println("Quiz: " + quiz.getTitle());
		for (Question question : quiz.getQuestions()) {
			Set<String> answers = questionHandler.askQuestionValue(question);
			Answer answer = new Answer(question, answers);
			quizAnswers.addAnswer(answer);
		}

		return quizAnswers;
	}

	public static void showQuiz(QuizAnswers quizAnswers) {
		System.out.println(quizAnswers.getQuiz().getTitle());
		System.out.println("=============================================");

		// I was requested to improve this output by showing the question title and the answer itself but it's
		// already implemented in the toString method of the Answer class, so I added enumeration for each answer
		// in the answered quiz.
		int answerNumber = 1;
		for (Answer answer : quizAnswers.getAnswers()) {
			System.out.println(answerNumber + ". " + answer);
			answerNumber++;
		}

		System.out.println("=============================================");
		System.out.println("Press ENTER to continue");
		InputReader.readLine();
	}
}
