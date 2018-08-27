package com.to8to.o2o.model;

import lombok.Data;

@Data
public class OosGoods {
    //自增id
    private int id;

    //供应商id，#取自 t8t_scm_mdm.supply_shop.id
    private int shop_id;

    //商品名称
    private String goods_name;

    //商品sku_id
    private String sku_id;

    //商品图片地址
    private String goods_img_url;

    //品牌id
    private int brand_id;

    //分类树ID，#取自 t8t_scm_mdm.mdm_goods_tree.id
    private int goods_tree_id;

    //零售价
    private double retail_price;

    //市场价
    private double market_price;

    //审核状态 0:草稿待提交 1:待审核 2:审核通过 3:已驳回 4:强制关闭 5:已撤销
    private byte goods_status;

    //商品状态变更原因
    private String reason_for_status;

    //创建人ID
    private int create_user;

    //创建时间
    private int create_time;

    //最近一次修改人ID
    private int update_user;

    //最近一次修改时间
    private int update_time;

    //上下架状态 0：默认状态 1：已上架 2：已下架
    private byte up_down_status;

    //热门状态 0 非热门 1 热门
    private byte hot_status;

}
