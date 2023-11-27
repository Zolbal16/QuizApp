package com.quiz;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quiz {
    private List<QuizQuestion> questions;
    private int score;
    private Random random;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        random = new Random();
    }

    public void generateQuestions(String topic) {
        questions.clear();
        List<QuizQuestion> allQuestions = getQuestionsByTopic(topic);
        for (int i = 0; i < 10 && !allQuestions.isEmpty(); i++) {
            int index = random.nextInt(allQuestions.size());
            questions.add(allQuestions.get(index));
            allQuestions.remove(index);
        }
    }

    private List<QuizQuestion> getQuestionsByTopic(String topic) {
        switch (topic.toLowerCase()) {
            case "geography":
                return loadGeographyQuestions();
            case "chemistry":
                return loadChemistryQuestions();
            case "history":
                return loadHistoryQuestions();
            case "physics":
                return loadPhysicsQuestions();
            case "literature":
                return loadLiteratureQuestions();
            default:
                return new ArrayList<>();
        }
    }
    

    private List<QuizQuestion> loadGeographyQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the world's largest ocean?", "Pacific Ocean"));
        questions.add(new QuizQuestion("In which country is Mount Kilimanjaro located?", "Tanzania"));
        questions.add(new QuizQuestion("What is the longest river in the world?", "Nile"));
        questions.add(new QuizQuestion("Which country is known as the Land of the Rising Sun?", "Japan"));
        questions.add(new QuizQuestion("What is the smallest country in the world?", "Vatican City"));
        questions.add(new QuizQuestion("Which desert is the largest in the world?", "Sahara"));
        questions
                .add(new QuizQuestion("Which city is famous for its iconic Opera House and Harbour Bridge?", "Sydney"));
        questions.add(
                new QuizQuestion("In which continent is the Amazon Rainforest primarily located?", "South America"));
        questions.add(new QuizQuestion("What is the name of the highest mountain peak in the world?", "Mount Everest"));
        questions.add(new QuizQuestion("Which river flows through Paris?", "Seine"));
        return questions;
    }

    private List<QuizQuestion> loadChemistryQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the chemical symbol for gold?", "Au"));
        questions.add(new QuizQuestion("Which element is known as the lightest gas?", "Hydrogen"));
        questions.add(new QuizQuestion("What is the main component of natural gas?", "Methane"));
        questions.add(new QuizQuestion("What is the chemical formula for table salt?", "NaCl"));
        questions.add(new QuizQuestion("Which element is credited with the discovery of radioactivity?", "Uranium"));
        questions.add(new QuizQuestion("What is the chemical symbol for iron?", "Fe"));
        questions.add(new QuizQuestion("What type of bond is formed when electrons are shared between atoms?",
                "Covalent bond"));
        questions.add(new QuizQuestion("What is the most abundant gas in Earth's atmosphere?", "Nitrogen"));
        questions.add(new QuizQuestion("What is the pH of pure water?", "7"));
        questions.add(new QuizQuestion("Which acid is commonly found in batteries?", "Sulfuric acid"));
        return questions;
    }

    private List<QuizQuestion> loadHistoryQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("Who was the first President of the United States?", "George Washington"));
        questions.add(new QuizQuestion("Which war ended with the Treaty of Versailles in 1919?", "World War I"));
        questions.add(new QuizQuestion("What ancient civilization built the pyramids of Giza?", "Egyptians"));
        questions.add(new QuizQuestion("Who was known as the 'Maid of Orléans'?", "Joan of Arc"));
        questions.add(new QuizQuestion("In which year did the fall of the Berlin Wall occur?", "1989"));
        questions.add(new QuizQuestion("Who wrote the Declaration of Independence?", "Thomas Jefferson"));
        questions.add(new QuizQuestion("Which empire was ruled by Genghis Khan?", "Mongol Empire"));
        questions.add(new QuizQuestion("What was the main cause of the Cold War?",
                "Political and military tension between the USA and the USSR"));
        questions.add(new QuizQuestion("Who discovered the Americas in 1492?", "Christopher Columbus"));
        questions.add(new QuizQuestion("What was the longest reigning dynasty in Chinese history?", "Zhou Dynasty"));
        return questions;
    }

    private List<QuizQuestion> loadPhysicsQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the speed of light in a vacuum?", "Approximately 299,792 kilometers per second"));
        questions.add(new QuizQuestion("Who is known for the theory of relativity?", "Albert Einstein"));
        questions.add(new QuizQuestion("What is the unit of electrical resistance?", "Ohm"));
        questions.add(new QuizQuestion("What is the force that keeps objects in orbit around a planet?", "Gravitational force"));
        questions.add(new QuizQuestion("What is the smallest particle of an element that retains the properties of that element?", "Atom"));
        questions.add(new QuizQuestion("What is the first law of thermodynamics also known as?", "Law of Conservation of Energy"));
        questions.add(new QuizQuestion("Which physicist is associated with the uncertainty principle?", "Werner Heisenberg"));
        questions.add(new QuizQuestion("What is the name of the force that opposes motion between two surfaces that are in contact?", "Friction"));
        questions.add(new QuizQuestion("Who invented the first practical telephone?", "Alexander Graham Bell"));
        questions.add(new QuizQuestion("What phenomenon describes the bending of light as it passes from one medium to another?", "Refraction"));
        return questions;
    }

    private List<QuizQuestion> loadLiteratureQuestions() {
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("Who wrote 'Romeo and Juliet'?", "William Shakespeare"));
        questions.add(new QuizQuestion("What is the title of the first Harry Potter book?",
                "Harry Potter and the Philosopher's Stone"));
        questions.add(new QuizQuestion("Which author wrote 'The Great Gatsby'?", "F. Scott Fitzgerald"));
        questions.add(new QuizQuestion("Who is the author of 'Pride and Prejudice'?", "Jane Austen"));
        questions.add(new QuizQuestion("What dystopian novel features the characters Winston Smith and Big Brother?",
                "1984"));
        questions.add(new QuizQuestion("Who wrote 'The Divine Comedy'?", "Dante Alighieri"));
        questions.add(new QuizQuestion("Which Russian author wrote 'War and Peace'?", "Leo Tolstoy"));
        questions.add(new QuizQuestion("What is the name of the Hobbit featured in 'The Lord of the Rings'?",
                "Frodo Baggins"));
        questions.add(new QuizQuestion("Who is the author of 'To Kill a Mockingbird'?", "Harper Lee"));
        questions.add(new QuizQuestion("What famous poet wrote 'The Raven'?", "Edgar Allan Poe"));
        return questions;
    }

    public boolean checkAnswer(String userAnswer, String correctAnswer) {
        boolean isCorrect = userAnswer.equalsIgnoreCase(correctAnswer);
        if (isCorrect) {
            score++;
        }
        return isCorrect;
    }
    
    public int getScore() {
        return score;
    }

    public List<QuizQuestion> getQuestions() {
        return questions;
    }
}
