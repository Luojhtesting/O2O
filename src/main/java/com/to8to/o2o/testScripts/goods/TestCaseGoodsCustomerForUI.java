package com.to8to.o2o.testScripts.goods;

import com.to8to.o2o.configuration.Contans;
import com.to8to.o2o.util.FileUtil;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class TestCaseGoodsCustomerForUI {
    
    private static String jsonString;//文件内容

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品列表成功
     * 接口名称 "用户-获取商品列表" views.customer.goodsServiceForUI.listGoods
     * 请求类型 Https-post
     * 请求path oos/customer/goodsServiceForUI/listGoods
     */
    @Test
    public void getGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/customer/getGoodsListSuccess.json");
        jsonString = FileUtil.fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").getJSONObject("listGoodsDTO").put("shopId",Contans.shopId);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.customer.goodsServiceForUI.listGoods")
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
     * 接口名称 "用户-获取商品分组" views.customer.goodsServiceForUI.getGoodsCategory
     * 请求类型 Https-post
     * 请求path oos/customer/goodsServiceForUI/getGoodsCategory
     */
    @Test
    public void getGoodsListGroupSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/customer/getGoodsListGroupSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.customer.goodsServiceForUI.getGoodsCategory")
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
     * Title:必填项字段输入合法，非必填输入格式正确，查看商品信息成功
     * 接口名称 "用户-查看商品信息" views.customer.goodsServiceForUI.viewGoods
     * 请求类型 Https-post
     * 请求path oos/customer/goodsServiceForUI/viewGoods
     */
    @Test
    public void viewGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/customer/viewGoodsListSuccess.json");
        jsonString = FileUtil.fileReadData(jsonFile);
        JSONObject jo = new JSONObject(jsonString);
        jo.getJSONObject("args").put("goodsId",TestCaseGoodsBusinessForUI.result[0]);
        jsonString = jo.toString();

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.customer.goodsServiceForUI.viewGoods")
            .body(jsonString)
        .when()
            .post(Contans.Path_TestUrl)
            .prettyPeek()
        .then()
            .statusCode(200)
            .body("status",equalTo(200))
        ;
    }

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，配置推荐商品列表成功
     * 接口名称 "get淘便宜 商品列表" views.customer.homePageServiceForUI.selectRecommendGoods
     * 请求类型 Https-post
     * 请求path oos/customer/goodsServiceForUI/selectRecommendGoods
     */
    @Test
    public void selectRecommendGoodsListSuccess() {
        File jsonFile = new File("./src/main/resources/goodsFile-Json/business/selectRecommendGoodsListSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.customer.goodsServiceForUI.selectRecommendGoods")
            .body(jsonFile)
        .when()
            .post(Contans.Path_TestUrl)
            .prettyPeek()
        .then()
            .statusCode(200)
            .body("",equalTo(""))
        ;
    }

}
