import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class RestTeamplatePrac2 {
    public static void main(String[] args) {
        //https://catfact.ninja/fact
        //위 url에서 정보 받아오는 거 해보기
//(1) Instantiate a RestTemplate
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        //(2) Declare an URI
        UriComponents uriComponents =
                UriComponentsBuilder
                        .newInstance()
                        .scheme("https")
                        .host("catfact.ninja")
                        .path("/fact")
                        .encode()
                        .build();

        URI uri = uriComponents.toUri();

        ResponseEntity<CatFact> response =
                restTemplate.getForEntity(uri, CatFact.class);

        System.out.println(response.getBody().getFact());
        System.out.println(response.getBody().getLength());

    }
}
