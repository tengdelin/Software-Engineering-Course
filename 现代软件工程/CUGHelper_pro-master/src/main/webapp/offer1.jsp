<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/27
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>舞动青春</title>
    <style type="text/css">
        body, div, h2, h3, ul, li, p {
            margin: 0;
            padding: 0;
        }

        a {
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        ul {
            list-style-type: none;
        }

        body {
            color: #333;
            background: #a7ab8c;
            font: 12px/1.5 \5b8b\4f53;
        }

        #msgBox {
            width: 500px;
            background: #fff;
            border-radius: 5px;
            margin: 10px auto;
            padding-top: 10px;
        }

        #msgBox form h2 {
            font-weight: 400;
            font: 400 18px/1.5 \5fae\8f6f\96c5\9ed1;
        }

        #msgBox form {
            background: url(img/boxBG.jpg) repeat-x 0 bottom;
            padding: 0 20px 15px;
        }

        #userName, #conBox {
            color: #777;
            border: 1px solid #d0d0d0;
            border-radius: 6px;
            background: #fff url(img/inputBG.png) repeat-x;
            padding: 3px 5px;
            font: 14px/1.5 arial;
        }

        #userName.active, #conBox.active {
            border: 1px solid #7abb2c;
        }

        #userName {
            height: 20px;
            width: 90px;
        }

        #conBox {
            width: 448px;
            resize: none;
            height: 200px;
            overflow: auto;
        }

        #msgBox form div {
            position: relative;
            color: #999;
            margin-top: 10px;
        }

        #msgBox img {
            border-radius: 3px;
        }

        #face {
            position: absolute;
            top: 0;
            left: 172px;
        }

        #face img {
            width: 30px;
            height: 30px;
            cursor: pointer;
            margin-right: 6px;
            opacity: 0.5;
            filter: alpha(opacity=50);
        }

        #face img.hover, #face img.current {
            width: 28px;
            height: 28px;
            border: 1px solid #f60;
            opacity: 1;
            filter: alpha(opacity=100);
        }

        #sendBtn {
            border: 0;
            width: 112px;
            height: 30px;
            cursor: pointer;
            margin-left: 10px;
            background: url(img/btn.png) no-repeat;
        }

        #sendBtn.hover {
            background-position: 0 -30px;
        }

        #msgBox form .maxNum {
            font: 26px/30px Georgia, Tahoma, Arial;
            padding: 0 5px;
        }

        #msgBox .list {
            padding: 10px;
        }

        #msgBox .list h3 {
            position: relative;
            height: 33px;
            font-size: 14px;
            font-weight: 400;
            background: #e3eaec;
            border: 1px solid #dee4e7;
        }

        #msgBox .list h3 span {
            position: absolute;
            left: 6px;
            top: 6px;
            background: #fff;
            line-height: 28px;
            display: inline-block;
            padding: 0 15px;
        }

        #msgBox .list ul {
            overflow: hidden;
            zoom: 1;
        }

        #msgBox .list ul li {
            float: left;
            clear: both;
            width: 100%;
            border-bottom: 1px dashed #d8d8d8;
            padding: 10px 0;
            background: #fff;
            overflow: hidden;
        }

        #msgBox .list ul li.hover {
            background: #f5f5f5;
        }

        #msgBox .list .userPic {
            float: left;
            width: 50px;
            height: 50px;
            display: inline;
            margin-left: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        #msgBox .list .content {
            float: left;
            width: 400px;
            font-size: 14px;
            margin-left: 10px;
            font-family: arial;
            word-wrap: break-word;
        }

        #msgBox .list .userName {
            display: inline;
            padding-right: 5px;
        }

        #msgBox .list .userName a {
            color: #2b4a78;
        }

        #msgBox .list .msgInfo {
            display: inline;
            word-wrap: break-word;
        }

        #msgBox .list .times {
            color: #889db6;
            font: 12px/18px arial;
            margin-top: 5px;
            overflow: hidden;
            zoom: 1;
        }

        #msgBox .list .times span {
            float: left;
        }

        #msgBox .list .times a {
            float: right;
            color: #889db6;
            display: none;
        }

        .tr {
            overflow: hidden;
            zoom: 1;
        }

        .tr p {
            float: right;
            line-height: 30px;
        }

        .tr * {
            float: left;
        }
    </style>
    <script type="text/javascript">
        /*-------------------------- +
          获取id, class, tagName
         +-------------------------- */
        var get = {
            byId: function (id) {
                return typeof id === "string" ? document.getElementById(id) : id
            },
            byClass: function (sClass, oParent) {
                var aClass = [];
                var reClass = new RegExp("(^| )" + sClass + "( |$)");
                var aElem = this.byTagName("*", oParent);
                for (var i = 0; i < aElem.length; i++) reClass.test(aElem[i].className) && aClass.push(aElem[i]);
                return aClass
            },
            byTagName: function (elem, obj) {
                return (obj || document).getElementsByTagName(elem)
            }
        };
        /*-------------------------- +
          事件绑定, 删除
         +-------------------------- */
        var EventUtil = {
            addHandler: function (oElement, sEvent, fnHandler) {
                oElement.addEventListener ? oElement.addEventListener(sEvent, fnHandler, false) : (oElement["_" + sEvent + fnHandler] = fnHandler, oElement[sEvent + fnHandler] = function () {
                    oElement["_" + sEvent + fnHandler]()
                }, oElement.attachEvent("on" + sEvent, oElement[sEvent + fnHandler]))
            },
            removeHandler: function (oElement, sEvent, fnHandler) {
                oElement.removeEventListener ? oElement.removeEventListener(sEvent, fnHandler, false) : oElement.detachEvent("on" + sEvent, oElement[sEvent + fnHandler])
            },
            addLoadHandler: function (fnHandler) {
                this.addHandler(window, "load", fnHandler)
            }
        };

        /*-------------------------- +
          设置css样式
          读取css样式
         +-------------------------- */
        function css(obj, attr, value) {
            switch (arguments.length) {
                case 2:
                    if (typeof arguments[1] == "object") {
                        for (var i in attr) i == "opacity" ? (obj.style["filter"] = "alpha(opacity=" + attr[i] + ")", obj.style[i] = attr[i] / 100) : obj.style[i] = attr[i];
                    } else {
                        return obj.currentStyle ? obj.currentStyle[attr] : getComputedStyle(obj, null)[attr]
                    }
                    break;
                case 3:
                    attr == "opacity" ? (obj.style["filter"] = "alpha(opacity=" + value + ")", obj.style[attr] = value / 100) : obj.style[attr] = value;
                    break;
            }
        };

        EventUtil.addLoadHandler(function () {
            var oMsgBox = get.byId("msgBox");
            var oUserName = get.byId("userName");
            var classify = document.getElementById("select");
            var oConBox = get.byId("conBox");
            var oSendBtn = get.byId("sendBtn");
            var oMaxNum = get.byClass("maxNum")[0];
            var oCountTxt = get.byClass("countTxt")[0];
            var oList = get.byClass("list")[0];
            var oUl = get.byTagName("ul", oList)[0];
            var aLi = get.byTagName("li", oList);
            var aFtxt = get.byClass("f-text", oMsgBox);
            var aImg = get.byTagName("img", get.byId("face"));
            var bSend = false;
            var timer = null;
            var oTmp = "";
            var i = 0;
            var maxNum = 1000;

            //禁止表单提交
            EventUtil.addHandler(get.byTagName("form", oMsgBox)[0], "submit", function () {
                return false
            });

            //为广播按钮绑定发送事件
            EventUtil.addHandler(oSendBtn, "click", fnSend);

            //为Ctrl+Enter快捷键绑定发送事件
            EventUtil.addHandler(document, "keyup", function (event) {
                var event = event || window.event;
                event.ctrlKey && event.keyCode == 13 && fnSend()
            });

            //发送广播函数
            function fnSend() {
                var reg = /^\s*$/g;
                if (reg.test(oUserName.value)) {
                    alert("\u8bf7\u586b\u5199\u60a8\u7684\u59d3\u540d");
                    oUserName.focus()
                } else if (!/^[u4e00-\u9fa5\w]{2,8}$/g.test(oUserName.value)) {
                    alert("\u59d3\u540d\u75312-8\u4f4d\u5b57\u6bcd\u3001\u6570\u5b57\u3001\u4e0b\u5212\u7ebf\u3001\u6c49\u5b57\u7ec4\u6210\uff01");
                    oUserName.focus()
                } else if (reg.test(oConBox.value)) {
                    alert("\u968f\u4fbf\u8bf4\u70b9\u4ec0\u4e48\u5427\uff01");
                    oConBox.focus()
                } else if (!bSend) {
                    alert("\u4f60\u8f93\u5165\u7684\u5185\u5bb9\u5df2\u8d85\u51fa\u9650\u5236\uff0c\u8bf7\u68c0\u67e5\uff01");
                    oConBox.focus()
                } else {
                    var oLi = document.createElement("li");
                    var oDate = new Date();
                    oLi.innerHTML = "<div class=\"userPic\"><img src=\"" + get.byClass("current", get.byId("face"))[0].src + "\"></div>\
							 <div class=\"content\">\
							 	<div class=\"userName\"><a href=\"javascript:;\">" + oUserName.value + "(" + classify.value + ")" + "</a>:</div>\
								<div class=\"msgInfo\">" + oConBox.value.replace(/<[^>]*>|&nbsp;/ig, "") + "</div>\
								<div class=\"times\"><span>" + format(oDate.getMonth() + 1) + "\u6708" + format(oDate.getDate()) + "\u65e5 " + format(oDate.getHours()) + ":" + format(oDate.getMinutes()) + "</span><a class=\"del\" href=\"javascript:;\">\u5220\u9664</a></div>\
							 </div>";
                    //插入元素
                    aLi.length ? oUl.insertBefore(oLi, aLi[0]) : oUl.appendChild(oLi);

                    //重置表单
                    get.byTagName("form", oMsgBox)[0].reset();
                    for (i = 0; i < aImg.length; i++) aImg[i].className = "";
                    aImg[0].className = "current";

                    //将元素高度保存
                    var iHeight = oLi.clientHeight - parseFloat(css(oLi, "paddingTop")) - parseFloat(css(oLi, "paddingBottom"));
                    var alpah = count = 0;
                    css(oLi, {"opacity": "0", "height": "0"});
                    timer = setInterval(function () {
                        css(oLi, {"display": "block", "opacity": "0", "height": (count += 8) + "px"});
                        if (count > iHeight) {
                            clearInterval(timer);
                            css(oLi, "height", iHeight + "px");
                            timer = setInterval(function () {
                                css(oLi, "opacity", (alpah += 10));
                                alpah > 100 && (clearInterval(timer), css(oLi, "opacity", 100))
                            }, 30)
                        }
                    }, 30);
                    //调用鼠标划过/离开样式
                    liHover();
                    //调用删除函数
                    delLi()
                }
            };

            //事件绑定, 判断字符输入
            EventUtil.addHandler(oConBox, "keyup", confine);
            EventUtil.addHandler(oConBox, "focus", confine);
            EventUtil.addHandler(oConBox, "change", confine);

            //输入字符限制
            function confine() {
                var iLen = 0;
                for (i = 0; i < oConBox.value.length; i++) iLen += /[^\x00-\xff]/g.test(oConBox.value.charAt(i)) ? 1 : 0.5;
                oMaxNum.innerHTML = Math.abs(maxNum - Math.floor(iLen));
                maxNum - Math.floor(iLen) >= 0 ? (css(oMaxNum, "color", ""), oCountTxt.innerHTML = "\u8fd8\u80fd\u8f93\u5165", bSend = true) : (css(oMaxNum, "color", "#f60"), oCountTxt.innerHTML = "\u5df2\u8d85\u51fa", bSend = false)
            }

            //加载即调用
            confine();

            //发布按钮鼠标划过样式
            EventUtil.addHandler(oSendBtn, "mouseover", function () {
                this.className = "hover"
            });

            //发布按钮鼠标离开样式
            EventUtil.addHandler(oSendBtn, "mouseout", function () {
                this.className = ""
            });

            //li鼠标划过/离开处理函数
            function liHover() {
                for (i = 0; i < aLi.length; i++) {
                    //li鼠标划过样式
                    EventUtil.addHandler(aLi[i], "mouseover", function (event) {
                        this.className = "hover";
                        oTmp = get.byClass("times", this)[0];
                        var aA = get.byTagName("a", oTmp);
                        if (!aA.length) {
                            var oA = document.createElement("a");
                            oA.innerHTML = "删除";
                            oA.className = "del";
                            oA.href = "javascript:;";
                            oTmp.appendChild(oA)
                        } else {
                            aA[0].style.display = "block";
                        }
                    });

                    //li鼠标离开样式
                    EventUtil.addHandler(aLi[i], "mouseout", function () {
                        this.className = "";
                        var oA = get.byTagName("a", get.byClass("times", this)[0])[0];
                        oA.style.display = "none"
                    })
                }
            }

            liHover();

            //删除功能
            function delLi() {
                var aA = get.byClass("del", oUl);

                for (i = 0; i < aA.length; i++) {
                    aA[i].onclick = function () {
                        var oParent = this.parentNode.parentNode.parentNode;
                        var alpha = 100;
                        var iHeight = oParent.offsetHeight;
                        timer = setInterval(function () {
                            css(oParent, "opacity", (alpha -= 10));
                            if (alpha < 0) {
                                clearInterval(timer);
                                timer = setInterval(function () {
                                    iHeight -= 10;
                                    iHeight < 0 && (iHeight = 0);
                                    css(oParent, "height", iHeight + "px");
                                    iHeight == 0 && (clearInterval(timer), oUl.removeChild(oParent))
                                }, 30)
                            }
                        }, 30);
                        this.onclick = null
                    }
                }
            }

            delLi();

            //输入框获取焦点时样式
            for (i = 0; i < aFtxt.length; i++) {
                EventUtil.addHandler(aFtxt[i], "focus", function () {
                    this.className = "active"
                });
                EventUtil.addHandler(aFtxt[i], "blur", function () {
                    this.className = ""
                })
            }

            //格式化时间, 如果为一位数时补0
            function format(str) {
                return str.toString().replace(/^(\d)$/, "0$1")
            }

            //头像
            for (i = 0; i < aImg.length; i++) {
                aImg[i].onmouseover = function () {
                    this.className += " hover"
                };
                aImg[i].onmouseout = function () {
                    this.className = this.className.replace(/\s?hover/, "")
                };
                aImg[i].onclick = function () {
                    for (i = 0; i < aImg.length; i++) aImg[i].className = "";
                    this.className = "current"
                }
            }
        });
    </script>

    <head lang="en">
        <meta charset="utf-8"/>
        <title>舞动青春</title>
        <link rel="stylesheet" type="text/css" href="css/public.css"/>
        <link rel="stylesheet" type="text/css" href="css/proList.css"/>
    </head>
<body>
<%@include file="header.jsp"%>
<%--<div class="head">--%>
<%--    <div class="wrapper clearfix">--%>
<%--        <div class="clearfix" id="top">--%>
<%--            <h1 class="fl"><a href="index.html"><img src="img/logo.png"/></a></h1>--%>
<%--            <div class="fr clearfix" id="top1">--%>
<%--                <p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>--%>
<%--                </p>--%>
<%--                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：步道乐跑"/><input--%>
<%--                        type="button"/></form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <ul class="clearfix" id="bott">--%>
<%--            <li><a href="index.html">首页</a></li>--%>
<%--            <li><a href="#">学习天地</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix">--%>
<%--                        <a href="cet.html">--%>
<%--                            <dl>--%>
<%--                                <dt><img src="img/CET.png"/></dt>--%>
<%--                                <dd>四六级书籍</dd>--%>
<%--                            </dl>--%>
<%--                        </a><a href="test.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/考研.png"/></dt>--%>
<%--                            <dd>考研书籍</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="schoolbook.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/学校教材.jpg"/></dt>--%>
<%--                            <dd>学校教材</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="question.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/题目问答.jpg"/></dt>--%>
<%--                            <dd>题目问答</dd>--%>
<%--                        </dl>--%>
<%--                    </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="#">舞动青春</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="left.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live1.jpg"/></dt>--%>
<%--                            <dd>失物招领</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="get.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live2.jpg"/></dt>--%>
<%--                            <dd>代取快递</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="market.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live3.jpg"/></dt>--%>
<%--                            <dd>二手市场</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="run.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live4.jpg"/></dt>--%>
<%--                            <dd>外卖跑腿</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="offer1.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live5.jpg"/></dt>--%>
<%--                            <dd>有偿发布</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="#">校外访客</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="show.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/2.png"/></dt>--%>
<%--                            <dd>地大简介</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="map.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/3.png"/></dt>--%>
<%--                            <dd>校园地图</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="rounding.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/4.png"/></dt>--%>
<%--                            <dd>景点介绍</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="http://www.okaoyan.com/fenshuxian/110746_4.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/5.png"/></dt>--%>
<%--                            <dd>往年考研真题与录取分数</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="life.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/6.png"/></dt>--%>
<%--                            <dd>在校学生体验</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="#">江湖秘籍</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="happy.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/lepao.jpg"/></dt>--%>
<%--                            <dd>乐跑互助</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="lesson.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/wangke.jpg"/></dt>--%>
<%--                            <dd>帮刷网课</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="work.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/keshe.jpg"/></dt>--%>
<%--                            <dd>悬赏课设</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="love.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/biaobai.jpg"/></dt>--%>
<%--                            <dd>表白墙</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="share.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/share.jpg"/></dt>--%>
<%--                            <dd>资源分享</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li>--%>
<%--                <a href="https://www.cug.edu.cn/" target="_blank">CUG</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </div>--%>
<%--</div>--%>
<!------------------------------banner------------------------------>
<div class="banner"><a href="#"><img src="img/temp/live0.jpg"/></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix">
        <a href="index.jsp">首页</a>
    </div>
</div><!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix"><h3 class="fl">有偿发布</h3>
    </div>
</div>

<div id="msgBox">
    <div class="list">
        <h3><span>悬赏发布</span></h3>
        <ul>
            <li>
            </li>
        </ul>
    </div>

    <form>
        <h2>有求必应</h2>

        <div>
            <input id="userName" class="f-text" value=""/>
            <select id="select">
                <option value="学习类">学习类</option>
                <option value="生活类">生活类</option>
                <option value="校外访客">校外访客</option>
                <option value="其他">其他</option>
            </select>
            <p id="face"><img src="img/face1.gif" class="current"/><img src="img/face2.gif"/><img
                    src="img/face3.gif"/><img src="img/face4.gif"/><img src="img/face5.gif"/><img
                    src="img/face6.gif"/><img src="img/face7.gif"/><img src="img/face8.gif"/></p>
        </div>
        <div><textarea id="conBox" class="f-text"></textarea></div>
        <div class="tr">
            <p>
                <span class="countTxt">还能输入</span><strong class="maxNum">1000</strong><span>个字</span>
                <input id="sendBtn" type="button" value="" title="快捷键 Ctrl+Enter"/>
            </p>
        </div>
    </form>
</div>


<!--footer-->
<div class="footer">
    <p class="dibu">CUG软工小队<br/>
    </p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>