import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

public class RestTemplatePrac3 {
    public static void main(String[] args) {

        RestTemplate restTemplate =
                new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        //(2) Declare an URI
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("https")
                        .host("catfact.ninja")
                        .path("/breeds")
                        .encode()
                        .build();

        URI uri = uriComponents.toUri();


        //Fetch data
        ResponseEntity<CatBreed> response =
                restTemplate.getForEntity(uri, CatBreed.class);

        System.out.println(response.getBody().getCurrent_page());
        System.out.println(response.getBody().getData());
    }
}
