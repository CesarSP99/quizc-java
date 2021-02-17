package org.fundacionjala.app.quizz.model;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private final String title;
    private final List<Question> questions;

    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    public static Quiz readJsonFile() throws IOException {
        Gson gson = new Gson();
        Quiz quiz;
        try (JsonReader reader = new JsonReader(new FileReader("./myQuiz.json"))) {
            quiz = gson.fromJson(reader, Quiz.class);
        }

        return quiz;
    }

    public void writeJsonFile() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("./myQuiz.json")) {
            gson.toJson(this, writer);
        } catch (JsonIOException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
