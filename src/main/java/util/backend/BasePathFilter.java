package util.backend;

import io.restassured.config.SSLConfig;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import util.TypeLoader;
import util.WriterReader;

import static io.restassured.RestAssured.config;

public class BasePathFilter implements Filter {


    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {

        filterableRequestSpecification.given().baseUri(TypeLoader.getBasePathUrl()).config(config().sslConfig(new SSLConfig().relaxedHTTPSValidation()));
        filterableRequestSpecification.header("Authorization", "Bearer " + WriterReader.getToken());

        return filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
    }
}
