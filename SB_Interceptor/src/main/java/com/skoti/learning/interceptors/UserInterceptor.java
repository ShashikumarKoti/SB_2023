package com.skoti.learning.interceptors;

import com.skoti.learning.exception.APIErrors;
import com.skoti.learning.exception.APIException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class UserInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws APIException {
        String userId = request.getHeader("USERID");
        String country = request.getHeader("COUNTRY");
        validateHeaders(userId, country);
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {
        System.out.println("Request URL: " + request.getRequestURL());
    }

    private void validateHeaders(String userId, String country) {
        Set<APIErrors> errors = new HashSet<>();
        if (Objects.isNull(userId) || userId.isEmpty()) {
            errors.add(new APIErrors("INVALID_USER_ID", "UserId cannot be empty"));
        }

        if (Objects.isNull(country) || country.isEmpty()) {
            errors.add(new APIErrors("INVALID_COUNTRY", "Country cannot be empty"));
        }

        if (errors.size() > 0) {
            throw new APIException(HttpStatus.FORBIDDEN, errors);
        }
    }
}
