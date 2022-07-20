import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestTemplatePrac {
    public static void main(String[] args) {

        //(1) Instantiate a RestTemplate
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        //(2) Declare an URI
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("http")
                        .host("worldtimeapi.org")
                        .path("/api/timezone/{continents}/{city}")
                        .encode()
                        .build();

        URI uri = uriComponents.expand("Asia", "Seoul").toUri();


//        String result1 = restTemplate.getForObject(uri, String.class);
//
//        System.out.println(result1);
//
//        WorldTime worldTime = restTemplate.getForObject(uri, WorldTime.class);
//
//        System.out.println(worldTime.getTimezone());
//        System.out.println(worldTime.getDatetime());
//        System.out.println(worldTime.getDay_of_week());

        /*
        ResponseEntity<WorldTime> response =
                restTemplate.getForEntity(uri, WorldTime.class);

        System.out.println("# datetime: " + response.getBody().getDatetime());
        System.out.println("# timezone: " + response.getBody().getTimezone());
        System.out.println("# HTTP Status Code: " + response.getStatusCode());
        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
        System.out.println("# Content Type: " + response.getHeaders().getContentType());

        System.out.println(response.getHeaders().entrySet());
*/
        ResponseEntity<WorldTime> response =
                restTemplate.exchange(uri,
                        HttpMethod.GET,
                        null,
                        WorldTime.class);



























    }
}


