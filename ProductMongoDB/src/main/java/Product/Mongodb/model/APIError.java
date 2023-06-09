package Product.Mongodb.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;





public class APIError {
	
private HttpStatus status;
private List<String> errors;
private LocalDateTime timeStamp;
private String pathUrl;
public HttpStatus getStatus() {
	return status;
}
public void setStatus(HttpStatus status) {
	this.status = status;
}
public List<String> getErrors() {
	return errors;
}
public void setErrors(List<String> errors) {
	this.errors = errors;
}
public LocalDateTime getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(LocalDateTime timeStamp) {
	this.timeStamp = timeStamp;
}
public String getPathUrl() {
	return pathUrl;
}
public void setPathUrl(String pathUrl) {
	this.pathUrl = pathUrl;
}
}
