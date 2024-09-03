package com.quizapp.model;


public class Question {
    private String text;
    private String[] options;
    private String answer;

    public Question(String text, String[] options, String answer) {
        this.text = text;
        this.options = options;
        this.answer = answer;
    }

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

    
}
