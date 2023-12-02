package com.mycompany.microservice.projectUtils;

import java.beans.PropertyDescriptor;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Component
public class BeanUtilsCopyProperty {

    public String[] ignoreNullProperty(Object source) {
        BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] propertyDescriptors = src.getPropertyDescriptors();

        Set<String> collect = Arrays.asList(propertyDescriptors).stream()
                .filter((pd) -> src.getPropertyValue(pd.getName()) == null)
                .map((p) -> p.getName())
                .collect(Collectors.toSet());

        return collect.toArray(String[]::new);
    }

}
