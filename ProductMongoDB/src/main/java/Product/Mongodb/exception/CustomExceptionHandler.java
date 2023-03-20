package Product.Mongodb.exception;


import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

import Product.Mongodb.model.APIError;


@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler({OfferNotValidException.class,CurrencyNotValidException.class})
	ResponseEntity<?> offerNotValidHandler(Exception exc, ServletWebRequest request){
		APIError apiError = new APIError();
		
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setPathUrl(request.getDescription(true));
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(Arrays.asList(exc.getMessage()));
		
		return new ResponseEntity(apiError, new HttpHeaders(), apiError.getStatus());
	}

}

