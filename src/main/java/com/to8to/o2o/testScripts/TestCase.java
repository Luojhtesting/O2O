package com.to8to.o2o.testScripts;

import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import com.to8to.o2o.configuration.Contans;
import com.to8to.o2o.testScripts.goods.TestCaseGoodsBusinessForUI;
import com.to8to.o2o.util.FileUtil;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;
import java.util.Map;

import static com.to8to.o2o.testScripts.goods.TestCaseGoodsPlatformForUI.auditGoodsPassedSuccess;
import static com.to8to.o2o.util.FileUtil.fileReadData;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestCase {

    @Test
    public void getAdvertisingGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/getAdvertisingGoodsListSuccess.json");
        String jsonString = FileUtil.fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("cityId", Contans.cityId);
        jsonString = jo.toString();

        given()
                .contentType("application/json")
                .header("s","/biz/t8t-scm-oos/app")
                .header("m","views.business.HomePageManagerServiceForUI.getAdvertisingGoods")
                .body(jsonString)
                .when()
                .post(Contans.Path_TestUrl)
                .prettyPeek()
                .then()
                .statusCode(200)
                .body("status",equalTo(200))
        ;
    }
}
