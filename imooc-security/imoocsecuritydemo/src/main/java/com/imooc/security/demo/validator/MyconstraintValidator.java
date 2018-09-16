package com.imooc.security.demo.validator;

import com.imooc.security.demo.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * zhshl  2018/9/16
 */
public class MyconstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    @Autowired
    private IHelloService helloService;
    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        helloService.hello();
        System.out.println(value);
        if(value == null || value.equals("")){
            return  false;
        }
        return true;
    }
}
