package com.day09cartBase;

public class Goods {
	private Integer goodsId; //商品id
	private String goodsName;//商品名称
	private String goodsDesc; //	商品简介
	private Integer price;//商品价格
	
	//构造方法	
	public Goods(Integer goodsId, String goodsName, String goodsDesc,
			Integer price) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.price = price;
	}
	
	//get set方法
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	
}
