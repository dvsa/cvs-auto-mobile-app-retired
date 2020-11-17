package util;

import io.restassured.config.SSLConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import util.TypeLoader;

import static io.restassured.RestAssured.config;

public class BasePathFilter implements Filter {

    private String token;

    public BasePathFilter(String token){
        this.token=token;
    }

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {

        filterableRequestSpecification.given().baseUri(TypeLoader.getBasePathUrl()).config(config().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
        filterableRequestSpecification.header("Authorization", "Bearer " + token);

        return filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
    }
}
