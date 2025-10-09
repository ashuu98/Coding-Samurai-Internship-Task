package quizapp;



public class Quiz {
    private Question[] questions;

    public Quiz() {
        questions = new Question[] {
            new Question("Which language runs in a browser?", 
                         new String[]{"Java", "C", "Python", "JavaScript"}, 3),
            new Question("Which company developed Java?", 
                         new String[]{"Sun Microsystems", "Apple", "Microsoft", "Google"}, 0),
            new Question("What is the size of int in Java?", 
                         new String[]{"2 bytes", "4 bytes", "8 bytes", "Depends on OS"}, 1),
            new Question("Which keyword is used for inheritance?", 
                         new String[]{"this", "super", "extends", "implements"}, 2),
            new Question("Which method is the entry point in Java?", 
                         new String[]{"start()", "main()", "run()", "init()"}, 1)
        };
    }

    public Question getQuestion(int index) {
        if (index >= 0 && index < questions.length)
            return questions[index];
        return null;
    }

    public int getTotalQuestions() {
        return questions.length;
    }
}

