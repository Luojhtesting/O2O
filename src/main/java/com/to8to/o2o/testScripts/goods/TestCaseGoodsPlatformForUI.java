package com.to8to.o2o.testScripts.goods;

import com.to8to.o2o.configuration.Contans;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;

import static com.to8to.o2o.util.FileUtil.fileReadData;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestCaseGoodsPlatformForUI {

    private static String jsonString;//文件内容

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品列表成功
     * 接口名称 "ERP-获取商品列表" views.platform.goodsServiceForUI.listGoods
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/listGoods
     */
    @Test
    public void getGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/getGoodsListSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.listGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品分类成功
     * 接口名称 "ERP-获取商品分类" views.platform.goodsServiceForUI.getGoodsCategory
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/getGoodsCategory
     */
    @Test
    public void getGoodsListCategorySuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/getGoodsListCategorySuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.getGoodsCategory")
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
     * Title:必填项字段输入合法，非必填输入格式正确，商品审核通过成功
     * 接口名称 "ERP-商品审核通过" views.platform.goodsServiceForUI.passedGoods
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/passedGoods
     */
    @Test
    public static void auditGoodsPassedSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/auditGoodsPassedSuccess.json");
        jsonString = fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("goodsId", TestCaseGoodsBusinessForUI.result[0]);
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

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品审核驳回成功
     * 接口名称 "ERP-商品审核驳回 views.platform.goodsServiceForUI.rejectGoods
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/rejectGoods
     */
    @Test
    public void auditGoodsRejectSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/auditGoodsRejectSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.rejectGoods")
            .body(jsonFile)
        .when()
            .post(Contans.Path_TestUrl)
            .prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品强制下架成功
     * 接口名称 "ERP-商品强制下架" views.platform.goodsServiceForUI.forceOffShelves
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/forceOffShelves
     */
    @Test
    public void GoodsForceOffShelvesSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/GoodsForceOffShelvesSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.forceOffShelves")
            .body(jsonFile)
        .when()
            .post(Contans.Path_TestUrl)
            .prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品批量审核通过成功
     * 接口名称 "ERP-商品批量审核通过" views.platform.goodsServiceForUI.batchPassedGoods
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/batchPassedGoods
     */
    @Test
    public void auditGoodsBatchPassedSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/auditGoodsBatchPassedSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.batchPassedGoods")
            .body(jsonFile)
        .when()
            .post(Contans.Path_TestUrl)
            .prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品批量审核驳回成功
     * 接口名称 "ERP-商品批量审核驳回" views.platform.goodsServiceForUI.batchRejectGoods
     * 请求类型 Https-post
     * 请求path oos/platform/goodsServiceForUI/batchRejectGoods
     */
    @Test
    public void auditGoodsBatchRejectSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/platform/auditGoodsBatchRejectSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.platform.goodsServiceForUI.batchRejectGoods")
            .body(jsonFile)
        .when()
            .post(Contans.Path_TestUrl)
            .prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }
}
