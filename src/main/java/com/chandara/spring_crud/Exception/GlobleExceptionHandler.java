package com.chandara.spring_crud.Exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobleExceptionHandler {

	public ResponseEntity<?> handleApiException(ApiException e){
		ErrorRespone errorRespone = new ErrorRespone(e.getStatus(), e.getMessage());
		return ResponseEntity
				             .status(e.getStatus())
				             .body(errorRespone);
	}
}
