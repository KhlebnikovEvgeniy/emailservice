package com.khlebnikovevgeniy.emailservice.domain;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class HttpResponse {
	protected String timeStamp;
	protected int statusCode;
	protected HttpStatus status;
	protected String message;
	protected String developerMessage;
	protected String path;
	protected String requestMethod;
	Map<?, ?> data;
}
