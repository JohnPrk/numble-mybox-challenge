package com.numble.mybox.acceptanceTest;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.numble.mybox.acceptanceTest.MemberSteps.회원_삭제;
import static com.numble.mybox.acceptanceTest.MemberSteps.회원_생성;
import static org.assertj.core.api.Assertions.assertThat;

class MemberAcceptanceTest extends AcceptanceSetUp {

    @Test
    void 회원을_생성하고_201_상태코드와_정보를_확인한다() {
        //when
        ExtractableResponse<Response> 회원_생성_결과 = 회원_생성(사용자1);

        //then
        assertThat(회원_생성_결과.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(회원_생성_결과.jsonPath().getString("name")).isEqualTo(사용자1.getName());
    }

    @Test
    void 회원을_삭제하고_204_상태코드를_받는다() {
        //given
        String url = 회원_생성(사용자1).header("Location");

        //when
        ExtractableResponse<Response> 회원_삭제_결과 = 회원_삭제(url);

        //then
        assertThat(회원_삭제_결과.statusCode()).isEqualTo(HttpStatus.NO_CONTENT.value());
    }
}
