package com.Sushant.EcomApp.Ecommerce.App.utils;

import com.Sushant.EcomApp.Ecommerce.App.Entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class JwtUtil {
    private final String secret_key="782y3e98ybzjkshbaksdjb";
    
    protected String generateToken(User user)
    {
        Map<String,Object> claims=new HashMap<>();
        claims.put("role",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
        return createToken(claims,user);
    }

    private String createToken(Map<String, Object> claims, User user) {
        return "";
    }
}
