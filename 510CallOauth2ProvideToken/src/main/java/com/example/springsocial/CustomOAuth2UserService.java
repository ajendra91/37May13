package com.example.springsocial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

        Map<String, Object> attributes= oAuth2User.getAttributes();
        String registrationId= oAuth2UserRequest.getClientRegistration().getRegistrationId();
        String id=null,name=null,email=null,pic=null;
            if(registrationId.equalsIgnoreCase("google")) {
            	id =(String) attributes.get("sub");
            	pic= (String) attributes.get("picture");
            } else if (registrationId.equalsIgnoreCase("facebook")) {
                
            } else if (registrationId.equalsIgnoreCase("github")) {
                
            } 
            name= (String) attributes.get("name");
            email= (String) attributes.get("email");
        
        
        
        User user = new User();

        user.setProvider(registrationId);
        user.setProviderId(id);
        user.setName(name);
        user.setEmail(email);
        user.setImageUrl(pic);
        userRepository.save(user);
        
        return UserPrincipal.create(user, oAuth2User.getAttributes());
       
    }

   

  

}
