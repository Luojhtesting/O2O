package com.to8to.o2o.testScripts;

import com.to8to.o2o.configuration.Contans;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestCase {
    @Test
    public void getGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/customer/getGoodsListSuccess.json");

        given()
                .contentType("application/json")
                .header("s","/biz/t8t-scm-oos/app")
                .header("m","views.customer.goodsServiceForUI.listGoods")
                .body(jsonFile)
                .when()
                .post(Contans.Path_TestUrl)
                .prettyPeek()
                .then()
                .statusCode(200)
                //.body("",equalTo(""))
        ;
    }
}
