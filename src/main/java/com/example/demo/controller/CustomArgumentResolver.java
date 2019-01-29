package com.example.demo.controller;

import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

public class CustomArgumentResolver extends PageableHandlerMethodArgumentResolver {

    ServletModelAttributeMethodProcessor resolverComposite = new ServletModelAttributeMethodProcessor(true);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return PageRequest.class.equals(parameter.getParameterType().getSuperclass());
    }

    @Override
    public Pageable resolveArgument(MethodParameter methodParameter, @Nullable ModelAndViewContainer mavContainer,
                                    NativeWebRequest webRequest, @Nullable WebDataBinderFactory binderFactory) {
        Object o = null;

        try {
            o = resolverComposite.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.print(o);
        return Search.from(super.resolveArgument(methodParameter, mavContainer, webRequest, binderFactory));
    }
}
