'use strict'

const express = require('express')
let route = express.Router()
const apiCtrl = require('../controllers/apiController.js')

//请求首页轮播图数据
route.get('/api/getlunbo', apiCtrl.getlunbo)
//获取商品列表数据
route.get('/api/getgoods', apiCtrl.getgoods)
//请求失物列表
route.get('/api/getnewslist', apiCtrl.getnewslist)
//获取失物详细信息
route.get('/api/getnew/:newid', apiCtrl.getnew)
//获取校园生活目录
route.get('/api/getimgcategory', apiCtrl.getimgcategory)
//获取右侧的数据
route.get('/api/getimages/:cateid', apiCtrl.getimages)
//获取商品轮播图
route.get('/api/getthumimages/:imgid', apiCtrl.getimage)
//获取库存等信息
route.get('/api/goods/getinfo/:id', apiCtrl.getgoodsinfo)
//获取商品描述
route.get('/api/goods/getdesc/:id', apiCtrl.getgooddesc)




//-------------------------------未用到下面的接口，不过下面的接口可以用来扩展功能
//4.0 获取评论内容
route.get('/api/getcomments/:artid', apiCtrl.getcomments)
//4.0.1 提交评论数据
route.post('/api/postcomment/:artid', apiCtrl.postcomment)

// 6.0 
// 6.0.1 获取详情页轮播图可以直接使用// 3.0.1 图片分享详情中的缩略图数组方法/api/getthumimages/:imgid
// 6.0.2 获取详情页第二区域块（商品购物区 ,商品标题，价格等）和 参数区域块（商品参数）
route.get('/api/getimageInfo/:imgid', apiCtrl.getimageInfo)

// 6.0.5 获取商品评论 可以直接请求：//4.0 获取评论内容  --》 /api/getcomments/:artid
// 6.0.6 提交评论，可以直接请求： //4.0.1 提交评论数据 ---》 /api/postcomment/:artid
// 6.0.7 获取购物车页面数据
route.get('/api/goods/getshopcarlist/:ids', apiCtrl.getshopcarlist)

// 测试 get 提交过来的数据
route.get('/api/get', (req, res) => {
    // 将 get 提交过来的数据，通过 getMsg 属性返回给客户端
	var obj = { message: 'get 请求 ok', data: req.query };
	res.end(JSON.stringify(obj));
})

// 测试 post 提交过来的数据
route.post('/api/post', (req, res) => {
	console.log(req.body)
	// 将 post 提交过来的数据，通过 postMsg 属性返回给客户端
	var obj = { message: 'post 请求 ok', data: req.body };
	res.end(JSON.stringify(obj));
});

route.all('/api/jsonp', (req, res) => {
	// 获取 提交过来的 callback 回调函数的名字
	var callbackFn = req.query.callback;

	// 组装数据对象，并将数据结果，序列化为 JSON 字符串
	var obj = { message: 'jsonp 请求 ok' };
	var jsonStr = JSON.stringify(obj);

	// 返回 JSONP 数据
	res.end(`${callbackFn}(${jsonStr})`);
});

// 获取品牌列表
route.get('/api/getprodlist', apiCtrl.getprodlist);
// 根据Id，删除品牌列表
route.get('/api/delproduct/:id', apiCtrl.delproduct);
// 添加品牌数据
route.post('/api/addproduct', apiCtrl.addproduct)

// 获取评论列表
route.get('/api/getcmtlist', apiCtrl.getcmtlist)
route.post('/api/postcmt', apiCtrl.postcmt)

module.exports = route