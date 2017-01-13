package com.theironyard.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Recipe not found at that id.")
public class RecipeIdNotFoundException extends RuntimeException {

}
