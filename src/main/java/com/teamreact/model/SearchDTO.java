package com.teamreact.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchDTO {
	public static final int MAX_10 = 10;
	public static final int MAX_100 = 100;
	public static final int MAX_200 = 200;

	@JsonProperty("search")
	private String search;

	@JsonProperty("start")
	private Integer start;

	@JsonProperty("length")
	private Integer length;

	public SearchDTO() {
		start = 0;
		length = MAX_10;
	}

	public String getKeyword() {
		if (search != null) {
			return search;
		}
		return null;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		if (length != null && length > MAX_200) {
			length = MAX_200;
		}
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
}
