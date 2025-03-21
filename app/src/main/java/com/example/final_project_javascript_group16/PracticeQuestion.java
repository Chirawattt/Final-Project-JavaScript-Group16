package com.example.final_project_javascript_group16;

public class PracticeQuestion {
    private String questionText;
    private String expectedOutput;
    private int difficultyLevel; // 0 = ง่าย, 1 = ปานกลาง, 2 = ยาก

    private String solutionHint;


    public PracticeQuestion(String questionText, String expectedOutput, int difficultyLevel, String solutionHint) {
        this.questionText = questionText;
        this.expectedOutput = expectedOutput;
        this.difficultyLevel = difficultyLevel;
        this.solutionHint = solutionHint;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public String getSolutionHint() {
        return solutionHint;
    }
}
