package com.work;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLEncoder;

public class Calculator {
    private int result = 0;
    private char last_operator = '+';

    public int funct_calc(int a, int b, char op) {
        try {
            String uri = "http://localhost:8888";
            String temp = uri + "?a=" + a + "&b=" + b + "&op=" + URLEncoder.encode("" + op, "UTF-8");
            HttpGet httpGet = new HttpGet(temp);

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpResponse response = httpClient.execute(httpGet);

            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null)
                result.append(line);

            return Integer.parseInt(result.toString());
        } catch (Exception e) {
        }
        throw new IllegalArgumentException("Illegal operator");
    }

    public void set_last_operator(char op) {
        last_operator = op;
    }

    public void calculate(int num) {
        result = funct_calc(result, num, last_operator);
    }

    public int get_result() {
        return result;
    }
}
