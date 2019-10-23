package com.lambdaschool.lifegpa.controllers;

import com.lambdaschool.lifegpa.logging.Loggable;
import com.lambdaschool.lifegpa.models.Role;
import com.lambdaschool.lifegpa.models.User;
import com.lambdaschool.lifegpa.models.UserMinimum;
import com.lambdaschool.lifegpa.models.UserRoles;
import com.lambdaschool.lifegpa.services.RoleService;
import com.lambdaschool.lifegpa.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Loggable
@RestController
public class OpenController
{
    private static final Logger logger = LoggerFactory.getLogger(OpenController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    // Create the user and Return the access token
    // http://localhost:2019/createnewuser
    // Just create the user
    // http://localhost:2019/createnewuser?access=false
    //
    // {
    //     "username" : "Mojo",
    //     "password" : "corgie",
    //     "email" : "home@local.house"
    // }

//    @PostMapping(value = "/createnewuser",
//                 consumes = {"application/json"},
//                 produces = {"application/json"})
//    public ResponseEntity<?> addNewUser(HttpServletRequest httpServletRequest,
//                                        @RequestParam(defaultValue = "false")
//                                                boolean getaccess,
//                                        @Valid
//                                        @RequestBody
//                                                User newminuser) throws URISyntaxException
//    {
//        logger.trace(httpServletRequest.getMethod()
//                                       .toUpperCase() + " " + httpServletRequest.getRequestURI() + " accessed");
//        System.out.println(newminuser.getUsername());
//        // Create the user
//
//
//        ArrayList<UserRoles> newRoles = new ArrayList<>();
//        newRoles.add(new UserRoles(new User(), roleService.findByName("admin")));
//        User newuser = new User(newminuser.getUsername(), newminuser.getPassword(), newminuser.getEmail(), newRoles);
//
//        newuser.setUsername(newminuser.getUsername());
//        newuser.setPassword(newminuser.getPassword());
//        newuser.setEmail(newminuser.getEmail());
//        newuser.setUserroles(newRoles);
//        System.out.println(newminuser.getPassword());
//        newuser.getPassword();
//        newuser = userService.save(newuser);
//        System.out.println("2");
//        // set the location header for the newly created resource - to another controller!
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newUserURI = ServletUriComponentsBuilder.fromUriString(httpServletRequest.getServerName() + ":" + httpServletRequest.getLocalPort() + "/users/user/{userId}")
//                                                    .buildAndExpand(newuser.getUserid())
//                                                    .toUri();
//        System.out.println("3");
//
//        responseHeaders.setLocation(newUserURI);
//
//        String theToken = "";
//        if (getaccess)
//        {
//            // return the access token
//            RestTemplate restTemplate = new RestTemplate();
//            String requestURI = "http://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getLocalPort() + "/login";
//
//            List<MediaType> acceptableMediaTypes = new ArrayList<>();
//            acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
//            System.out.println("4");
//
//            HttpHeaders headers = new HttpHeaders();
//            System.out.println("11");
//            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//            System.out.println("12");
//
//            headers.setAccept(acceptableMediaTypes);
//            System.out.println("13");
//
////            // Don't forget to comment back in OAUTHCLIENTID and OAUTHCLIENTSECRET
//            headers.setBasicAuth(System.getenv("OAUTHCLIENTID"),
//                                 System.getenv("OAUTHCLIENTSECRET"));
////            headers.setBasicAuth("lambda-client", "lambda-secret");
//
//            System.out.println("5");
//
//            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//            map.add("grant_type",
//                    "password");
//            map.add("scope",
//                    "read write trust");
//            map.add("username",
//                    newminuser.getUsername());
//            map.add("password",
//                    newminuser.getPassword());
//
//            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map,
//                                                                                 headers);
//            System.out.println("6");
//
//            theToken = restTemplate.postForObject(requestURI,
//                                                  request,
//                                                  String.class);
//        } else
//        {
////             nothing;
//        }
//        return new ResponseEntity<>(
//                theToken,
//                responseHeaders,
//                HttpStatus.CREATED);
//    }
//
@PostMapping(value = "/createnewuser",
        consumes = {"application/json"},
        produces = {"application/json"})
public ResponseEntity<?> addNewUser(HttpServletRequest request,
                                    @Valid
                                    @RequestBody
                                            User newuser) throws URISyntaxException {
    logger.trace(request.getMethod()
            .toUpperCase() + " " + request.getRequestURI() + " accessed");
    Role role = roleService.findByName("admin");
    ArrayList<UserRoles> newRoles = new ArrayList<>();
    newRoles.add(new UserRoles(newuser,
            role));
    newuser.setUserroles(newRoles);

    newuser = userService.save(newuser);

    // set the location header for the newly created resource
    HttpHeaders responseHeaders = new HttpHeaders();
    URI newUserURI = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{userid}")
            .buildAndExpand(newuser.getUserid())
            .toUri();
    responseHeaders.setLocation(newUserURI);

    return new ResponseEntity<>(null,
            responseHeaders,
            HttpStatus.CREATED);
}
//    @PostMapping(value = "/createnewuser",
//            consumes = {"application/json"},
//            produces = {"application/json"})
//    public ResponseEntity<?> addNewUser(HttpServletRequest request, @Valid
//    @RequestBody
//            User newuser) throws URISyntaxException
//    {
//        logger.trace(request.getMethod()
//                .toUpperCase() + " " + request.getRequestURI() + " accessed");
//
//        ArrayList<UserRoles> newRoles = new ArrayList<>();
//        newRoles.add(new UserRoles(newuser, roleService.findByName("user")));
//        newuser.setUserroles(newRoles);
//
//        newuser = userService.save(newuser);
//
//        // set the location header for the newly created resource - to another controller!
//        HttpHeaders responseHeaders = new HttpHeaders();
//        URI newRestaurantURI = ServletUriComponentsBuilder.fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/users/user/{userId}")
//                .buildAndExpand(newuser.getUserid())
//                .toUri();
//        responseHeaders.setLocation(newRestaurantURI);
//
//        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
//    }
    @ApiIgnore
    @GetMapping("favicon.ico")
    void returnNoFavicon()
    {
        logger.trace("favicon.ico endpoint accessed!");
    }
}