package com.synchrony.img.imagestorageservice.config;

public class ImgConfig {

    private void getImagesNetworkRequest(String accessToken){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, "{}");
        Request request = new Request.Builder()
                .url("https://api.imgur.com/3/account/mskhushboo123/images")
                .method("GET", body)
                .addHeader("Authorization", "Bearer {{"+accessToken+"}}")
                .build();
        Response response = client.newCall(request).execute();
    }

    private void getAccountBaseInformation(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, "{}");
        Request request = new Request.Builder()
                .url("https://api.imgur.com/3/account/mskhushboo123")
                .method("GET", body)
                .addHeader("Authorization", "Client-ID {{"+ConfigVariables.CLIENT_ID+"}}")
                .build();
        Response response = client.newCall(request).execute();
    }

    private void deleteImage(String accessToken, String deleteHash){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(JSON, "{}");
        Request request = new Request.Builder()
                .url("https://api.imgur.com/3/account/mskhushboo123/image/{{"+deleteHash+"}}")
                .method("DELETE", body)
                .addHeader("Authorization", "Bearer {{"+accessToken+"}}")
                .build();
        Response response = client.newCall(request).execute();
    }
}
