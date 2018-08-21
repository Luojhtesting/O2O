package com.to8to.o2o.testScripts.goods;

import com.to8to.o2o.configuration.Contans;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestCaseGoodsBusinessForUI {

    /**
     * Title:必填项字段输入合法，非必填输入格式正确，商品创建成功
     * 接口名称 "店铺-添加商品" views.business.goodsServiceForUI.addGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/addGoods
     */
    @Test
    public void addGoodsSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\addGoodsSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.addGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，商品提交审核成功
     * 接口名称 "店铺-提交审核商品" views.business.goodsServiceForUI.submitGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/submitGoods
     */
    @Test
    public void submitGoodsForReviewSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\submitGoodsForReviewSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.submitGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，商品撤销审核成功
     * 接口名称 "店铺-撤销商品" views.business.goodsServiceForUI.cancelGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/cancelGoods
     */
    @Test(dependsOnMethods = {"submitGoodsForReviewSuccess"})
    public void cancelGoodsForReviewSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\cancelGoodsForReviewSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.cancelGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，商品更新成功
     * 接口名称 "店铺-更新商品" views.business.goodsServiceForUI.updateGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/updateGoods
     */
    @Test
    public void updateGoodsSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\updateGoodsSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.updateGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，商品上架成功
     * 接口名称 "店铺-上架商品" views.business.goodsServiceForUI.onShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/onShelvesGoods
     */
    @Test
    public void onShelvesGoodsSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\onShelvesGoodsSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.onShelvesGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，商品下架成功
     * 接口名称 "店铺-下架商品" views.business.goodsServiceForUI.offShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/offShelvesGoods
     */
    @Test(dependsOnMethods = {"onShelvesGoodsSuccess"})
    public void offShelvesGoodsSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\offShelvesGoodsSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.offShelvesGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，批量商品上架成功
     * 接口名称 "店铺-批量上架商品" views.business.goodsServiceForUI.batchOnShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/batchOnShelvesGoods
     */
    @Test
    public void batchOnShelvesGoodsSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\batchOnShelvesGoodsSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.batchOnShelvesGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，批量商品下架成功
     * 接口名称 "店铺-批量下架商品" views.business.goodsServiceForUI.batchOffShelvesGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/batchOffShelvesGoods
     */
    @Test(dependsOnMethods = {"batchOnShelvesGoodsSuccess"})
    public void batchOffShelvesGoodsSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\batchOffShelvesGoodsSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.batchOffShelvesGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，获取商品列表成功
     * 接口名称 "店铺-获取商品列表" views.business.goodsServiceForUI.listGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/listGoods
     */
    @Test
    public void getGoodsListSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\getGoodsListSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.listGoods")
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
     * 接口名称 "店铺-获取商品分组" views.business.goodsServiceForUI.getGoodsCategory
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/getGoodsCategory
     */
    @Test
    public void getGoodsListGroupSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\getGoodsListGroupSuccess.json");

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
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\viewGoodsListSuccess.json");

        given()
            .contentType("application/json")
            .header("s","/biz/t8t-scm-oos/app")
            .header("m","views.business.goodsServiceForUI.viewGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，获取推荐商品列表成功
     * 接口名称 "获取推荐商品列表" views.business.HomePageManagerServiceForUI.getAdvertisingGoods
     * 请求类型 Https-post
     * 请求path oos/business/HomePageManagerServiceForUI/getAdvertisingGoods
     */
    @Test
    public void getAdvertisingGoodsListSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\getAdvertisingGoodsListSuccess.json");

        given()
                .contentType("application/json")
                .header("s","/biz/t8t-scm-oos/app")
                .header("m","views.business.HomePageManagerServiceForUI.getAdvertisingGoods")
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
     * Title:必填项字段输入合法，非必填输入格式正确，配置推荐商品列表成功
     * 接口名称 "配置推荐商品列表" views.business.HomePageManagerServiceForUI.setAdvertisingGoods
     * 请求类型 Https-post
     * 请求path oos/business/goodsServiceForUI/setAdvertisingGoods
     */
    @Test
    public void setAdvertisingGoodsListSuccess() {
        File jsonFile = new File(".\\src\\main\\resources\\goodsFile-Json\\business\\setAdvertisingGoodsListSuccess.json");

        given()
                .contentType("application/json")
                .header("s","/biz/t8t-scm-oos/app")
                .header("m","views.business.HomePageManagerServiceForUI.setAdvertisingGoods")
                .body(jsonFile)
                .when()
                .post(Contans.Path_TestUrl)
                //.prettyPeek()
                .then()
                .statusCode(200)
                .body("status",equalTo(200))
        ;
    }

}
