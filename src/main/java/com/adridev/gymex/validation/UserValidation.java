package com.adridev.gymex.validation;

import com.adridev.gymex.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        //Comprueba que el tipo de objeto que se va a validar sea del tipo User
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        System.out.println("Usuario que llega: " + user);
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            System.out.println("Las contraseñas no coinciden");
            errors.rejectValue("confirmPassword","{register.confirmPassword.notEqual}");
        }
    }
}
