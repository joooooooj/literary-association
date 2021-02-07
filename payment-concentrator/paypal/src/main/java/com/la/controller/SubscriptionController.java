package com.la.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.la.dto.SubscriptionCreatedDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/")
public class SubscriptionController {

    @PostMapping(value = "/subscribe/{productId}")
    public ResponseEntity<?> createSubscription(@PathVariable Integer productId) {
        RestTemplate restTemplate = new RestTemplate();
        String createPlanApi = "https://api-m.sandbox.paypal.com/v1/billing/plans";

        String productPayPalId = "";
        int price = 0;

        if (productId.equals(1)) {
            productPayPalId = "PROD-9H810166MU5400145";
            price = 10;
        }

        String defJson = "{\n" +
                "      \"product_id\": \"" + productPayPalId + "\",\n" +
                "      \"name\": \"Basic Plan\",\n" +
                "      \"description\": \"Basic plan\",\n" +
                "      \"billing_cycles\": [\n" +
                "        {\n" +
                "          \"frequency\": {\n" +
                "            \"interval_unit\": \"MONTH\",\n" +
                "            \"interval_count\":" + 1 + "\n" +
                "          },\n" +
                "          \"tenure_type\": \"TRIAL\",\n" +
                "          \"sequence\": 1,\n" +
                "          \"total_cycles\": 1\n" +
                "        },\n" +
                "        {\n" +
                "          \"frequency\": {\n" +
                "            \"interval_unit\": \"MONTH\",\n" +
                "            \"interval_count\": 1\n" +
                "          },\n" +
                "          \"tenure_type\": \"REGULAR\",\n" +
                "          \"sequence\": 2,\n" +
                "          \"total_cycles\": 12,\n" +
                "          \"pricing_scheme\": {\n" +
                "            \"fixed_price\": {\n" +
                "              \"value\": \"" + price + "\",\n" +
                "              \"currency_code\": \"USD\"\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      ],\n" +
                "      \"payment_preferences\": {\n" +
                "        \"auto_bill_outstanding\": true,\n" +
                "        \"setup_fee\": {\n" +
                "          \"value\": \"10\",\n" +
                "          \"currency_code\": \"USD\"\n" +
                "        },\n" +
                "        \"setup_fee_failure_action\": \"CONTINUE\",\n" +
                "        \"payment_failure_threshold\": 3\n" +
                "      },\n" +
                "      \"taxes\": {\n" +
                "        \"percentage\": \"10\",\n" +
                "        \"inclusive\": false\n" +
                "      }\n" +
                "    }";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Accept", "*/*");
        headers.set("Accept-Language", "en_US");
        headers.set("Authorization", "Bearer " + "A21AALbge_nqHFimUKPf0lrriGiQi3erbj-M6lbOKTBYpRf89E6JjIpX_eFC5YoSUqbu_CfqFxe38cWwbFV71GFx1Bw66PE8A");
        headers.set("PayPal-Request-Id", "PROD-4WU9356076871170G");
        HttpEntity<String> entity = new HttpEntity<String>(defJson, headers);

        String jsonResponse = restTemplate.postForObject(createPlanApi, entity, String.class);
        Gson gson = new Gson();
        String id = gson.fromJson(jsonResponse, JsonObject.class).get("id").getAsString();
        System.out.println(id);

        String subscriptionUrl = "https://api-m.sandbox.paypal.com/v1/billing/subscriptions";
        String defJsonForSub = "{\"plan_id\": \"" + id + "\"}";
        HttpHeaders headers2 = new HttpHeaders();
        headers2.setContentType(MediaType.APPLICATION_JSON);
        headers2.set("Accept", "*/*");
        headers2.set("Accept-Language", "en_US");
        headers2.set("Authorization", "Bearer " + "A21AALbge_nqHFimUKPf0lrriGiQi3erbj-M6lbOKTBYpRf89E6JjIpX_eFC5YoSUqbu_CfqFxe38cWwbFV71GFx1Bw66PE8A");
        headers2.set("PayPal-Request-Id", "SUBSCRIPTION-21092019-001");
        HttpEntity<String> entity2 = new HttpEntity<String>(defJsonForSub, headers2);
        String jsonResponseForSub = restTemplate.postForObject(subscriptionUrl, entity2, String.class);

        String redirectUrl = gson.fromJson(jsonResponseForSub, JsonObject.class).get("links").getAsJsonArray().get(0).getAsJsonObject().get("href").getAsString();
        System.err.println(redirectUrl);
        return new ResponseEntity<>(new SubscriptionCreatedDTO("AUoKNW_Sjoz8cYq6N_P33gzaxwUscgYfvlVOvP_35MvZdX3JPsqeczYH96m3Lh1ZslUGs7gfBOISjZfs", id, redirectUrl), HttpStatus.OK);
    }
}
