前端：
用idea或其他集成开发工具打开Vue目录；
在运行之前请在电脑安装nodejs和npm；
然后在该项目目录下的终端中运行：npm install，会生成一个model_node的文件夹；
最后点击运行，即可运行前端项目，占用端口8080；



后端：
用idea或其他集成开发工具打开springboot目录；
配置JDK-1.8，并且使用maven导入依赖包；
然后点击运行，即可运行后端项目，占用端口9090；
说明：后端链接了数据库，并且链接的是我自己的一个云服务器上面的MySQL数据库，不知道到时候删没删；
如果要搭建自己的数据库请建立自己的数据库，并导入springboot-vue.sql；
然后修改application.properties文件里面对应的配置，即可完成。