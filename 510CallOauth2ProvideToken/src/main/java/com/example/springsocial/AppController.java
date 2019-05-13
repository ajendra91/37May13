package com.example.springsocial;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@RestController
public class AppController {
	
	
	@Autowired
	public CustomUserDetailsService customUserDetailsService;

	
	@RequestMapping("/app")
	public Authentication he(@RequestParam String token,Principal pal,HttpServletRequest request) {
		System.out.println(token);
		//return SecurityContextHolder.getContext().getAuthentication();
		
		
		
		
	 //String bearerToken = request.getHeader("Authorization");
		// String jwt=null;
	      //  if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
	          //  jwt= bearerToken.substring(7, bearerToken.length());
	        //}
	        
	       // if (StringUtils.hasText(jwt)) {
	        	//Jwts.parser().setSigningKey("926D96C90030DD58429D2751AC1BDBBC").parseClaimsJws(jwt);
	        	
	        	 Claims claims = Jwts.parser()
	                     .setSigningKey("926D96C90030DD58429D2751AC1BDBBC")
	                     .parseClaimsJws(token)
	                     .getBody();

	        	 Long userId= Long.parseLong(claims.getSubject());
	        	 System.out.println(userId);
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(userId);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                //SecurityContextHolder.getContext().setAuthentication(authentication);
	       // }
                
                return authentication;
		
		
	}
	
}
