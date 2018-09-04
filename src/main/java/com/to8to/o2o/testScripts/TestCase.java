package com.to8to.o2o.testScripts;

import com.google.gson.JsonObject;
import com.mongodb.util.JSON;
import com.to8to.o2o.configuration.Contans;
import com.to8to.o2o.testScripts.goods.TestCaseGoodsBusinessForUI;
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
    public void onShelvesGoodsSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/onShelvesGoodsSuccess.json");
        String jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        TestCaseGoodsBusinessForUI tb = new TestCaseGoodsBusinessForUI();
        tb.addGoodsSuccess();
        tb.submitGoodsForReviewSuccess();
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("id", TestCaseGoodsBusinessForUI.result);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        auditGoodsPassedSuccess();
        given()
                .contentType("application/json")
                .header("s","/biz/t8t-scm-oos/app")
                .header("m","views.business.goodsServiceForUI.onShelvesGoods")
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
