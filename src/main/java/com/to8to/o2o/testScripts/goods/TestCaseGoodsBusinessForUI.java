package com.to8to.o2o.testScripts.goods;

import com.google.gson.JsonObject;
import com.to8to.o2o.configuration.Contans;
import com.to8to.o2o.util.FileUtil;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static com.to8to.o2o.util.FileUtil.fileReadData;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestCaseGoodsBusinessForUI {

    public static int[] result = new int[10];//商品id
    private static String jsonString;//文件内容
    private static String assertString;//断言字符
    private static String skuId;

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品创建成功
     * 接口名称 "店铺-添加商品" views.business.goodsServiceForUI.addGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/addGoods
     */
    @Test
    public void addGoodsSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/addGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("createGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        Response response = given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.addGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        .extract()
            .response()
        ;

        result[0] = response.path("result");
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品提交审核成功
     * 接口名称 "店铺-提交审核商品" views.business.goodsServiceForUI.submitGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/submitGoods
     */
    @Test
    public void submitGoodsForReviewSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/submitGoodsForReviewSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("submitGoodsDTO").put("id", result[0]);
        jo.getJSONObject("args").getJSONObject("submitGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.submitGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;

    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品撤销审核成功
     * 接口名称 "店铺-撤销商品" views.business.goodsServiceForUI.cancelGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/cancelGoods
     */
    @Test
    public void cancelGoodsForReviewSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/cancelGoodsForReviewSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("cancelGoodsDTO").put("id", result[0]);
        jo.getJSONObject("args").getJSONObject("cancelGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.cancelGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品更新成功
     * 接口名称 "店铺-更新商品" views.business.goodsServiceForUI.updateGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/updateGoods
     */
    @Test
    public void updateGoodsSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/updateGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("updateGoodsDTO").put("id", result[0]);
        jo.getJSONObject("args").getJSONObject("updateGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.updateGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品上架成功
     * 接口名称 "店铺-上架商品" views.business.goodsServiceForUI.onShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/onShelvesGoods
     */
    @Test
    public void onShelvesGoodsSuccess() {
        submitGoodsForReviewSuccess();//调用提交审核测试用例
        auditGoodsPassedAction();//调用审核通过测试用例
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/onShelvesGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("id", result[0]);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.onShelvesGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品下架成功
     * 接口名称 "店铺-下架商品" views.business.goodsServiceForUI.offShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/offShelvesGoods
     */
    @Test
    public void offShelvesGoodsSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/offShelvesGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("id", result[0]);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.offShelvesGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，批量商品上架成功
     * 接口名称 "店铺-批量上架商品" views.business.goodsServiceForUI.batchOnShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/batchOnShelvesGoods
     */
    @Test
    public void batchOnShelvesGoodsSuccess() {
        addAction(2);
        submitAction(2);
        auditGoodsPassedAction(2);
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/batchOnShelvesGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONArray("batchShelvesGoodsDTO").getJSONObject(0).put("id", result[0]);
        jo.getJSONObject("args").getJSONArray("batchShelvesGoodsDTO").getJSONObject(1).put("id", result[1]);
        jo.getJSONObject("args").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.batchOnShelvesGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，批量商品下架成功
     * 接口名称 "店铺-批量下架商品" views.business.goodsServiceForUI.batchOffShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/batchOffShelvesGoods
     */
    @Test
    public void batchOffShelvesGoodsSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/batchOffShelvesGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONArray("batchShelvesGoodsDTO").getJSONObject(0).put("id", result[0]);
        jo.getJSONObject("args").getJSONArray("batchShelvesGoodsDTO").getJSONObject(1).put("id", result[1]);
        jo.getJSONObject("args").put("shopId", Contans.shopId);
        jsonString = jo.toString();


        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.batchOffShelvesGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品列表成功
     * 接口名称 "店铺-获取商品列表" views.business.goodsServiceForUI.listGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/listGoods
     */
    @Test
    public void getGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/getGoodsListSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("listGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.listGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品分组成功
     * 接口名称 "店铺-获取商品分组" views.business.goodsServiceForUI.getGoodsCategory
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/getGoodsCategory
     */
    @Test
    public void getGoodsListGroupSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/getGoodsListGroupSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.getGoodsCategory")
            .body(jsonFile)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品分组成功
     * 接口名称 "店铺-查看商品信息" views.business.goodsServiceForUI.viewGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/viewGoods
     */
    @Test
    public void viewGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/viewGoodsListSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("goodsId", result[0]);
        jo.getJSONObject("args").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        Response response = given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.viewGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        .extract()
            .response()
        ;

        skuId = response.path("result.skuId");
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，配置推荐商品列表成功
     * 接口名称 "配置推荐商品列表" views.business.HomePageManagerServiceForUI.setAdvertisingGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/setAdvertisingGoods
     */
    @Test
    public void setAdvertisingGoodsListSuccess() {
        onShelvesGoodsAction();
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/setAdvertisingGoodsListSuccess.json");
        jsonString = FileUtil.fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("cityId", Contans.cityId);
        jo.getJSONObject("args").getJSONArray("skuIds").put(0,skuId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.HomePageManagerServiceForUI.setAdvertisingGoods")
            .header("rpc-uid","12331")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取推荐商品列表成功
     * 接口名称 "获取推荐商品列表" views.business.HomePageManagerServiceForUI.getAdvertisingGoods
     * 请求类型 Https-post
     * 请求path oos/business/HomePageManagerServiceForUI/getAdvertisingGoods
     */
    @Test
    public void getAdvertisingGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/getAdvertisingGoodsListSuccess.json");
        jsonString = FileUtil.fileReadData(jsonFile);
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
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }


    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取未下架商品列表成功
     * 接口名称 "获取未下架商品列表" views.business.HomePageManagerServiceForUI.getGoods
     * 请求类型 Https-post
     * 请求path oos/business/HomePageManagerServiceForUI/getGoods
     */
//    @Test
//    public void getNotShelvesGoodsListSuccess() {
//        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/getNotShelvesGoodsListSuccess.json");
//
//        given()
//            .contentType("application/json")
//            .header("s","/biz/t8t-scm-oos/app")
//            .header("m","views.business.HomePageManagerServiceForUI.getGoods")
//            .body(jsonFile)
//        .when()
//            .post(Contans.Path_TestUrl)
//            //.prettyPeek()
//        .then()
//            .statusCode(200)
//            .body("status",equalTo(200))
//        ;
//    }

    public static void addAction(int i) {
        for (int j=0;j<i;j++) {
            File jsonFile = new File("./src/main/resources/goodsFile-Json/business/addGoodsSuccess.json");
            jsonString = fileReadData(jsonFile);
            JSONObject jo = new JSONObject(jsonString);
            jo.getJSONObject("args").getJSONObject("createGoodsDTO").put("shopId", Contans.shopId);
            jsonString = jo.toString();

            Response response = given()
                    .contentType("application/json")
                    .header("s","/biz/t8t-scm-oos/app")
                    .header("m","views.business.goodsServiceForUI.addGoods")
                    .body(jsonString)
                    .when()
                    .post(Contans.Path_TestUrl)
                    //.prettyPeek()
                    .then()
                    .statusCode(200)
                    .body("status",equalTo(200))
                    .extract()
                    .response()
                    ;

            result[j] = response.path("result");
        }
    }

    public static void submitAction(int i) {
        for (int j=0;j<i;j++) {
            File jsonFile = new File("./src/main/resources/goodsFile-Json/business/submitGoodsForReviewSuccess.json");
            jsonString = fileReadData(jsonFile);
            JSONObject jo = new JSONObject(jsonString);
            jo.getJSONObject("args").getJSONObject("submitGoodsDTO").put("id", result[j]);
            jo.getJSONObject("args").getJSONObject("submitGoodsDTO").put("shopId", Contans.shopId);
            jsonString = jo.toString();

            given()
                    .contentType("application/json")
                    .header("s","/biz/t8t-scm-oos/app")
                    .header("m","views.business.goodsServiceForUI.submitGoods")
                    .body(jsonString)
                    .when()
                    .post(Contans.Path_TestUrl)
                    //.prettyPeek()
                    .then()
                    .statusCode(200)
                    .body("status",equalTo(200))
            ;
        }
    }

    public static void auditGoodsPassedAction(int i) {
        for (int j=0;j<i;j++) {
            File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/auditGoodsPassedSuccess.json");
            jsonString = fileReadData(jsonFile);
            JSONObject jo = new JSONObject(jsonString);
            jo.getJSONObject("args").put("goodsId", result[j]);
            jsonString = jo.toString();

            given()
                    .contentType("application/json")
                    .header("s","/biz/t8t-scm-oos/app")
                    .header("m","views.platform.goodsServiceForUI.passedGoods")
                    .body(jsonString)
                    .when()
                    .post(Contans.Path_TestUrl)
                    //.prettyPeek()
                    .then()
                    .statusCode(200)
                    .body("status",equalTo(200))
            ;
        }
    }

    public static void onShelvesGoodsAction() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/onShelvesGoodsSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("id", result[0]);
        jo.getJSONObject("args").getJSONObject("shelvesGoodsDTO").put("shopId", Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.onShelvesGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    public static void auditGoodsPassedAction() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/auditGoodsPassedSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("goodsId", result[0]);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.passedGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            //.prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;

    }
}
