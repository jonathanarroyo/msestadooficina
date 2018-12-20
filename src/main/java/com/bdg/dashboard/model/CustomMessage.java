package com.bdg.dashboard.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomMessage<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String text;
	private final T data;
	private final int priority;
	private final boolean secret;

	

	public CustomMessage(@JsonProperty("text") String text, @JsonProperty("data")  T data,@JsonProperty("priority")  int priority, @JsonProperty("secret") boolean secret) {
		super();
		this.text = text;
		this.data = data;
		this.priority = priority;
		this.secret = secret;
	}

	public String getText() {
		return text;
	}

	public int getPriority() {
		return priority;
	}

	public boolean isSecret() {
		return secret;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "CustomMessage [text=" + text + ", data=" + data + ", priority=" + priority + ", secret=" + secret + "]";
	}
}
