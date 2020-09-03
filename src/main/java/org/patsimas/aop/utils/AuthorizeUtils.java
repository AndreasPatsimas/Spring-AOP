package org.patsimas.aop.utils;

import org.patsimas.aop.exceptions.AuthorizationFailedException;
import org.springframework.util.ObjectUtils;

import java.security.Principal;

public class AuthorizeUtils {

    public static void authorizeRequest(String username, String principal){

        if(ObjectUtils.isEmpty(principal) || !principal.equals(username))
            throw new AuthorizationFailedException("Unauthorized for this action");
    }
}
