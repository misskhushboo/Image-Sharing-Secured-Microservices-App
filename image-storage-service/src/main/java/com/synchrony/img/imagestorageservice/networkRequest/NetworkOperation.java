package com.synchrony.img.imagestorageservice.networkRequest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
public class NetworkOperation {

    public static Object makePostRequest(String uri, WebClient webClient, Class class1, BodyInserter bodyInserter) {

        try {
            return webClient.post()
                    .uri(uri)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(bodyInserter)
                    .retrieve()
                    .bodyToMono(class1)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object makePostRequest(String uri, WebClient webClient, Class class1, String queryparameter) {

        try {
            return webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(class1)
                    .block();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object makeGetRequest(String uri, WebClient webClient, Class class1) {

        try {
            return webClient.get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(class1)
                    .block();
        } catch (WebClientResponseException.Forbidden e){
            throw e;
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object oktaRequest(String url,String method, String accessToken){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parseMediaType("text/plain");
        MediaType JSON = MediaType.APPLICATION_JSON;
        //parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, "{}");
        Request request = new Request().Builder()
                .url(url)
                .method(method, body)
                .addHeader("Authorization", "Bearer {{"+accessToken+"}}")
                .build();
        Response response = client.newCall(request).execute();
    }
}
