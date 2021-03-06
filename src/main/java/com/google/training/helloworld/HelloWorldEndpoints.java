package com.google.training.helloworld;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;

/**
 * Defines endpoint functions APIs.
 */
@Api(name = "helloworldendpoints", version = "v1",
scopes = {Constants.EMAIL_SCOPE },
        clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
        description = "API for hello world endpoints.")

public class HelloWorldEndpoints {

   // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "sayHello", path = "sayHello",
            httpMethod = HttpMethod.GET)

    public HelloClass sayHello() {
        return new HelloClass();
    }

    // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "sayHelloByName", path = "sayHelloByName",
            httpMethod = HttpMethod.GET)

    public HelloClass sayHelloByName (@Named("name") String name) {
        return new HelloClass(name);
    }
    
    /*@ApiMethod(name = "getCat", path = "getCat",
            httpMethod = HttpMethod.GET)

    public HelloClass getCat () {
        return new HelloClass(1);
    }*/
    
    @ApiMethod(name = "getAnime", path = "getAnime",
            httpMethod = HttpMethod.GET)
    public HelloClass getAnime(@Named("anime") String anime){
    	return new HelloClass(anime);
    }
    
    /*@ApiMethod(name="greetByPeriod", path="greetByPeriod", httpMethod=HttpMethod.GET)
    
    public HelloClass greetByPeriod(@Named("name") String name, @Named("period") String period)
    {
    	 return new HelloClass(name,period);
    }*/
    
    @ApiMethod(name = "addAnime", path = "addAnime",
            httpMethod = HttpMethod.GET)
    public HelloClass addAnime(@Named("anime") String anime, @Named("rating") int rating)
    {
    	return new HelloClass(anime, rating);
    }
    
    @ApiMethod(name = "register", path = "register",
            httpMethod = HttpMethod.GET)
    public HelloClass register(@Named("values") String[] values)
    {
    	return new HelloClass(values);
    }
    
    @ApiMethod(name = "login", path = "login",
            httpMethod = HttpMethod.GET)
    public HelloClass login(@Named("login") String login, @Named("password") String pass)
    {
    	//return user login
    	return new HelloClass(login, pass);
    }
    
    @ApiMethod(name = "recommend", path = "recommend",
            httpMethod = HttpMethod.GET)
    public HelloClass login(@Named("user") String login)
    {
    	//return the array of titles
    	return new HelloClass(login, true);
    }
}
