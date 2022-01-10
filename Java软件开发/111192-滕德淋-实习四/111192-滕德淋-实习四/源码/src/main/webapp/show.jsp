<%--
  Created by IntelliJ IDEA.
  User: 滕德淋
  Date: 2021/4/27
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head lang="en">
    <meta charset="utf-8" />
    <title>校外访客</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <link rel="stylesheet" type="text/css" href="css/proList.css" />
</head>

<body>
<!------------------------------head------------------------------>
<%@include file="header.jsp"%>
<%--<div class="head">--%>
<%--    <div class="wrapper clearfix">--%>
<%--        <div class="clearfix" id="top">--%>
<%--            <h1 class="fl"><a href="index.html"><img src="img/logo.png" /></a></h1>--%>
<%--            <div class="fr clearfix" id="top1">--%>
<%--                <p class="fl"><a href="#" id="login">登录</a><a href="#" id="reg">注册</a>--%>
<%--                </p>--%>
<%--                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：步道乐跑" /><input--%>
<%--                        type="button" /></form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <ul class="clearfix" id="bott">--%>
<%--            <li><a href="index.html">首页</a></li>--%>
<%--            <li><a href="flowerDer.html">学习天地</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix">--%>
<%--                        <a href="cet.html">--%>
<%--                            <dl>--%>
<%--                                <dt><img src="img/CET.png" /></dt>--%>
<%--                                <dd>四六级书籍</dd>--%>
<%--                            </dl>--%>
<%--                        </a><a href="test.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/考研.png" /></dt>--%>
<%--                            <dd>考研书籍</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="schoolbook.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/学校教材.jpg" /></dt>--%>
<%--                            <dd>学校教材</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="question.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/题目问答.jpg" /></dt>--%>
<%--                            <dd>题目问答</dd>--%>
<%--                        </dl>--%>
<%--                    </a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="decoration.html">舞动青春</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="left.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live1.jpg" /></dt>--%>
<%--                            <dd>失物招领</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="get.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live2.jpg" /></dt>--%>
<%--                            <dd>代取快递</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="market.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live3.jpg" /></dt>--%>
<%--                            <dd>二手市场</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="run.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live4.jpg" /></dt>--%>
<%--                            <dd>外卖跑腿</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="offer1.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/live5.jpg" /></dt>--%>
<%--                            <dd>有偿发布</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="paint.html">校外访客</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="show.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/2.png" /></dt>--%>
<%--                            <dd>地大简介</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="map.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/3.png" /></dt>--%>
<%--                            <dd>校园地图</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="rounding.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/4.png" /></dt>--%>
<%--                            <dd>景点介绍</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="http://www.okaoyan.com/fenshuxian/110746_4.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/5.png" /></dt>--%>
<%--                            <dd>往年考研真题与录取分数</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="life.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/6.png" /></dt>--%>
<%--                            <dd>在校学生体验</dd>--%>
<%--                        </dl>--%>
<%--                    </a></div>--%>
<%--                </div>--%>
<%--            </li>--%>
<%--            <li><a href="perfume.html">江湖秘籍</a>--%>
<%--                <div class="sList">--%>
<%--                    <div class="wrapper  clearfix"><a href="happy.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/lepao.jpg" /></dt>--%>
<%--                            <dd>乐跑互助</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="lesson.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/wangke.jpg" /></dt>--%>
<%--                            <dd>帮刷网课</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="work.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/keshe.jpg" /></dt>--%>
<%--                            <dd>悬赏课设</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="love.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/biaobai.jpg" /></dt>--%>
<%--                            <dd>表白墙</dd>--%>
<%--                        </dl>--%>
<%--                    </a><a href="share.html">--%>
<%--                        <dl>--%>
<%--                            <dt><img src="img/share.jpg" /></dt>--%>
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
<!-----------------banner------------------------------->
<div class="banner"><a href="#"><img src="img/temp/1.jpeg" /></a></div>
<!-----------------address------------------------------->
<div class="address">
    <div class="wrapper clearfix"><a href="index.jsp">首页</a><span>/</span><a href="#"
                                                                              class="on">校外访客</a><span>/</span><a href="show.jsp" class="on">地大简介</a>
    </div>
</div>
<!-------------------current---------------------->
<div class="current">
    <div class="wrapper clearfix">
        <h3 class="fl">校外访客</h3>
    </div>
</div>
<!----------------proList------------------------->

</ul>
<div id="vsb_content_2_85929_u111">
    <div id="vsb_content_2">
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            中国地质大学是教育部直属全国重点大学,
            是国家批准设立研究生院的大学，是国家“211工程”、国家“双一流”建设高校。中国地质大学位于武汉东湖之畔，南望山麓，学校以地球科学为主要特色，学科涵盖理学、工学、文学、管理学、经济学、法学、教育学、艺术学等门类，地质学、地质资源与地质工程2个一级学科入选“双一流”建设学科。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            <strong>校园概貌</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            中国地质大学位于武汉东湖国家自主创新示范区腹地，现有南望山校区、未来城校区等两个校区，校园占地总面积1474353平方米，校舍总面积867111平方米。学校拥有国家4A级旅游景区——逸夫博物馆，校园环境优美，教育、科研、学术氛围浓厚，拥有现代化的教学楼群、图书馆、学生公寓、体育场馆等相关配套设施，为莘莘学子提供了良好的学习、生活和成长的环境。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;"><strong>办学思想</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            坚持弘扬“艰苦朴素，求真务实”校训精神，坚持弘扬“严在地大”的校风学风，坚持弘扬“谋求人与自然和谐发展”的价值观，着力培养能够担当民族复兴大任、“品德高尚、基础厚实、专业精深、知行合一”的高素质人才，着力为解决区域、行业乃至人类面临的资源环境问题提供高水平的人才和科技支撑。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            秉承“强化特色、争创一流、依法治校、开放包容”的治校理念，营造“独立思考、严谨治学、勇于探索、追求卓越”的文化氛围，努力构建优越而独特的教学和科研环境。以提高办学质量为中心，推进“跨学科专业交叉融合、教学与科研实践融合、创新创业教育与专业教育融合“的“三融合”人才培养模式改革，提升科技创新和社会服务能力。坚持实施人才强校、科技兴校和国际化战略，大力推进以学术卓越计划为核心的综合改革，在建成地球科学一流、多学科协调发展的高水平大学的基础上，努力建设成为地球科学领域国际知名研究型大学，致力于实现地球科学领域世界一流大学的办学目标。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;"><strong>办学条件</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校现有教职员工3254人，其中教师1858人。中国科学院院士11人，博士生导师464人，教授539人，副教授984人。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            国家杰出青年科学基金获得者16人，国家优秀青年科学基金获得者19人，教育部“新世纪优秀人才”入选者29人。学校拥有国家自然科学基金委创新研究群体3个，教育部创新团队3个，国家级教学团队6个，国家级教学名师1人，湖北省教学名师9人。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校现有各类科研机构、实验室、研究院（所、中心）86个，其中国家重点实验室2个，国家工程技术研究中心1个，科技部地质工程国际科技合作基地1个，科技部创新人才培养示范基地1个。学校拥有完善的实验实践教学体系，有国家级实验教学示范中心3个，国家级虚拟仿真实验教学中心1个。自建校起，学校相继在周口店、北戴河、秭归等地建立了教学实习基地。其中周口店野外实习基地被誉为“地质工程师的摇篮”，为“全国地质实验（实践）教学示范中心”、“国家基础学科人才培养能力（野外实践）基地”。学校图书馆馆舍面积2.7万余平方米，拥有丰富的文献资源，形成了以科技文献为主体，以地学文献为特色的馆藏体系，构建了以信息技术为基础的服务平台，为师生提供有效的文献资源保障。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            <strong>学科布局</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校围绕学科前沿和经济社会发展的需求，构建以地球科学为主导，多学科相互支撑、协调发展的学科生态系统。现有2个国家一级重点学科，16个湖北省重点学科，“地质学”、“地质资源与地质工程”
            两个一级学科在全国历次学科评估中均排名第一；有23个学院（所）、67个本科专业；有16个一级学科博士点，34个一级学科硕士点，15个博士后科研流动站；有工程硕士、MBA、MPA等10个专业学位授予权，其中工程硕士专业包涵14个工程领域。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            <strong>人才培养</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校拥有“学士－硕士－博士”完整的人才培养体系。其中全日制在校学生30239人，包括本科生18080人，硕士研究生9302人，博士研究生1916人，国际学生941人；成教及网络教育注册学生6万余人。拥有国家地质学理科人才培养基地和国土资源部地质工科人才培养基地。建校60余年来，为国家培养了近30万名高级人才。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校全面落实立德树人根本任务，以培养“品德高尚、基础厚实、专业精深、知行合一”的优秀人才为目标，努力构建跨学科专业交叉融合、教学与科研实践融合、创新创业教育与专业教育融合的“三融合”人才培养模式。我校学生在具有广泛影响力的全国挑战杯大赛、数学建模大赛、英语竞赛、电子设计大赛等高水平赛事中屡获佳绩。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校把弘扬优良体育传统与健全人格培养相结合，逐步形成了特色鲜明的体育教育教学体系。我校学生在国际国内重大体育比赛中，累计获得金牌250余枚，银铜牌500余枚。2012年5月，学校登山队成功登顶珠峰，成为我国第一支登上世界最高峰的大学登山队。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            <strong>科学研究</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校在地质学、矿产资源能源、地质工程、地球物理、水文地质与环境地质、地理信息系统与测绘、材料科学与化学、经济与管理等研究领域具有特色和优势，取得一批重要成果。2010年以来，获国家科技进步特等奖2项（参与）、国家自然科学二等奖1项、国家科技进步二等奖3项，省部级科技奖励38项，获“中国科学十大进展”1项、“十大地质科技进展”2项、“十大地质找矿成果”2项。科睿唯安（原汤森路透）“高被引科学家”
            5人，爱思唯尔“高被引学者”
            9人，入选ESI高被引论文作者61人。学校主办的《地球科学》（中文版）被国际著名检索系统EI
            Compendex收录，《地球科学学刊》（英文版）被国际著名检索系统SCIE收录，《中国地质大学学报》（社会科学版）进入CSSCI。</p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校坚持立足湖北和长江经济带，面向全国，大力推进政产学研合作，积极服务行业、区域和地方经济社会发展。学校与武汉市人民政府联合组建武汉地质资源环境工业技术研究院，采用市场化运营模式，搭建创新创业生态系统，着力促进科技成果转化，服务国家创新驱动战略。学校还在“珠三角”和“长三角”地区分别建立产学研平台和产业孵化基地（深圳研究院、浙江研究院）。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;"><strong>国际交流</strong>
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            学校积极开展对外学术、科技和文化交流，先后与美国、法国、澳大利亚、俄罗斯等国家的100多所大学签订了友好合作协议。2012年成立由我校发起，联合斯坦福大学、麦考瑞大学、滑铁卢大学、香港大学、牛津大学等十二所世界知名大学组建“地球科学国际大学联盟”，联盟高校在地学领域通过资源共享、交流合作，实现人才培养和科技创新的发展共赢。近年来，学校公派出国访问、留学，攻读硕士、博士学位的师生每年900余人次，邀请来校访问、讲学、与会的境外专家每年400余人次。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">
            以学校为支撑建立了美国布莱恩特大学孔子学院、美国阿尔弗莱德大学孔子学院、保加利亚大特尔诺沃大学孔子学院。拥有“中美联合非开挖工程研究中心”等6个国际科研合作中心。贯彻落实国家“一带一路”战略，设立“丝绸之路学院”、“约旦研究中心”和“丝绸之路地质资源国际研究中心”。
        </p>
        <p style="text-align: justify; line-height: 2em;font-size: larger;text-indent: 2em;">相关数据截至2020年12月</p>
        <br><br><br>
    </div>
</div>
</div>

<!--footer-->
<div class="footer">
    <p class="dibu">CUG软工小队<br />
    </p>
</div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/pro.js" type="text/javascript" charset="utf-8"></script>
<script src="js/cart.js" type="text/javascript" charset="utf-8"></script>
</body>

</html>
