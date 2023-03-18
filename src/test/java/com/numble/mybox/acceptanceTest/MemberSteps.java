package com.numble.mybox.acceptanceTest;

import com.numble.mybox.member.service.dto.MemberRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

class MemberSteps {

    public static ExtractableResponse<Response> 회원_생성(MemberRequest request) {
        Map<String, String> params = new HashMap<>();
        params.put("name", request.getName());
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(params)
                .when().post("/members")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 회원_삭제(String url) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .when().delete(url)
                .then().log().all()
                .extract();
    }
}
