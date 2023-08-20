package apirest.ola;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

class OlaTest {

	@Test
	void deveObterOlaComSucesso() {
		Response res = RestAssured.request(Method.GET, "http://restapi.wcaquino.me:80/ola");
		
		/*
		System.out.println(res.statusCode());
		System.out.println(res.headers().toString());
		System.out.println(res.body().asString());
		*/
		
		assertEquals("Ola Mundo!", res.body().asString());
		assertEquals(200, res.statusCode());
	}
	
	@Test
	void deveObterOlaComSucessoHamcrest() {
		Response res = request(Method.GET, "http://restapi.wcaquino.me:80/ola");
		
		System.out.println(res.statusCode());
		System.out.println(res.headers().toString());
		System.out.println(res.body().asString());
		
		//assertEquals("Ola Mundo!", res.body().asString());
		assertThat(res.body().asString(), is("Ola Mundo!"));
		
		//assertEquals(200, res.statusCode());
		assertThat(res.statusCode(), is(200));
	}
	
	@Test
	void deveObterOlaComSucessoBDD() {
		given()
			.baseUri("http://restapi.wcaquino.me")
			.port(80)
			.log().all()
		.when()
			.get("/ola")
		.then()
			.log().all()
			.body(is("Ola Mundo!"))
			.statusCode(is(200))
		;
	}

}
