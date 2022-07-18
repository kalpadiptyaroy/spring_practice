package springwebmvc;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class LoginValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) 
    {
       return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) 
    {
    	System.out.println("Validating...");
        ValidationUtils.rejectIfEmpty(errors, "userName", "user.userName.empty");
        ValidationUtils.rejectIfEmpty(errors, "password", "user.password.empty");
    }
    
    
}
