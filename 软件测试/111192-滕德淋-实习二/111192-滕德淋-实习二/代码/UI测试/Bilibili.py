import random
from time import sleep
from selenium import webdriver
import base64
import json
import requests
from selenium.webdriver import ActionChains
from PIL import Image


class BiliBili(object):
    # 初始化测试浏览器驱动
    def __init__(self):
        # 启动浏览器
        self.driver = webdriver.Chrome(r'/usr/bin/chromedriver')
        self.driver.implicitly_wait(3)
        # 最大化
        self.driver.maximize_window()
        self.screen_name = "code.png"
        self.img_name = "new_code.png"
        self.uname = "tdl"
        self.pwd = "123456789tdl"
        self.typeid = 21
        self.rectangle = (1565, 476, 1690, 527)

    # 登录
    def login(self, usr, pwd, flag):
        self.driver.get("https://www.bilibili.com/")
        try:
            self.driver.find_element_by_css_selector(".header-login-entry").click()
            print("login-version-1")
        except Exception:
            self.driver.find_element_by_css_selector(".unlogin-avatar").click()
            print("login-version-2")

        # 转到登录界面操作
        for handle in self.driver.window_handles:
            self.driver.switch_to.window(handle)  # 去到当前页面
            if "哔哩哔哩弹幕视频网 - ( ゜- ゜)つロ 乾杯~ - bilibili" in handle.title():
                break
        self.driver.find_element_by_id("login-username").send_keys(
            usr)  # 15527762018  13722065859   18062104471  15884113649  15826637783
        self.driver.find_element_by_id("login-passwd").send_keys(
            pwd)  # 123456789tdl   1258562890lele   pzh.1212     123456789tdl  Prussia118225
        sleep(3)
        try:
            self.driver.find_element_by_css_selector(".btn-login").click()
        except Exception:
            self.driver.find_element_by_css_selector(".btn-login").click()
        sleep(10)

        # 进行验证码破解

        # 保存当前网页图片
        for i in (0, 10, 1):
            self.driver.save_screenshot(self.screen_name)
            result = self.base64_api(uname=self.uname, pwd=self.pwd, img=self.screen_name, typeid=self.typeid)
            print(result)
            split = result.split("|")
            for str1 in split:
                str_split = str1.split(",")
                self.click_locxy(int(str_split[0]), int(str_split[1]), True)
            sleep(3)
            self.driver.find_element_by_css_selector(".geetest_commit_tip").click()
            sleep(3)
            # 返回登录成功是否成功
            if self.driver.title == "哔哩哔哩 (゜-゜)つロ 干杯~-bilibili":
                if flag:
                    self.quit_to_console()
                return True
            sleep(3)
        return False

    # 注册--由于只有一个电话号码注册一个账号，所以无法进行测试
    def register(self):
        pass

    # 搜索
    def search(self, flag):
        # 转界面操作
        for handle in self.driver.window_handles:
            self.driver.switch_to.window(handle)  # 去到当前页面
            if "哔哩哔哩 (゜-゜)つロ 干杯~-bilibili" in handle.title():
                break
        # print(self.driver.title)# 测试界面是否是主页面
        kword = "python"
        try:
            self.driver.find_element_by_css_selector(".nav-search-input").send_keys(kword)
            self.driver.find_element_by_css_selector(".nav-search-btn").click()
            print("search-version-1")
        except Exception:
            self.driver.find_element_by_css_selector(".nav-search-keyword").send_keys(kword)
            self.driver.find_element_by_css_selector(".nav-search-submit").click()
            print("search-version-2")

        # 转到搜索结果界面操作
        for handle in self.driver.window_handles:
            self.driver.switch_to.window(handle)  # 去到当前页面
            if "搜索结果" in handle.title():
                break
        if self.driver.title == kword + " _ 搜索结果_哔哩哔哩_Bilibili":
            if flag:
                self.quit_to_console()
            return True
        else:
            return False

    # 选择视频
    def select(self, flag):
        # # ------获取全部视频链接，这里在爬虫，与自动化测试没什么关系
        # data = open("url.txt", 'w+')
        # for i in range(0, 49, 1.jpg):
        #     video_list = self.driver.find_element_by_css_selector(".video-list")
        #     list = video_list.find_elements_by_css_selector(".img-anchor")
        #     print("第" + str(i) + "页", file=data)
        #     for l in list:
        #         print(l.get_attribute("href"), file=data)
        #     self.driver.find_element_by_css_selector(".icon-arrowdown3").click()
        #     # 转界面操作
        #     for handle in self.driver.window_handles:
        #         self.driver.switch_to.window(handle)  # 去到当前页面
        #         if "page=" + str(i) in self.driver.current_url:
        #             break
        #     # 放慢速度，担心B站服务器受不了
        #     sleep(1.jpg)
        #     self.driver.refresh()
        #     sleep(1.jpg)
        # data.close()
        # # ------结束爬虫

        video_list = self.driver.find_element_by_css_selector(".video-list")
        list = video_list.find_elements_by_css_selector(".img-anchor")
        list[3].click()  # 选择第一个视频播放
        vtitle = list[3].get_attribute("title")
        # 转到播放界面操作
        for handle in self.driver.window_handles:
            self.driver.switch_to.window(handle)  # 去到当前页面
            if vtitle in handle.title():
                break
        if self.driver.title == vtitle + "_哔哩哔哩_bilibili":
            if flag:
                self.quit_to_console()
            return vtitle
        else:
            return False

    # 点赞
    def like(self, flag):
        likenum1 = self.driver.find_element_by_css_selector(".like").get_attribute("title")
        number1 = "".join(list(filter(str.isdigit, likenum1)))
        print(number1)
        sleep(5)
        self.driver.find_element_by_css_selector(".van-icon-videodetails_like").click()
        sleep(5)
        self.driver.refresh()
        sleep(10)
        likenum2 = self.driver.find_element_by_css_selector(".like").get_attribute("title")
        number2 = "".join(list(filter(str.isdigit, likenum2)))
        print(number2)
        if abs(int(number2) - int(number1)) == 1:
            if flag:
                self.quit_to_console()
            return True
        else:
            return False

    # 评论
    def comment(self, vtitle, flag):
        # 转到界面操作
        for handle in self.driver.window_handles:
            self.driver.switch_to.window(handle)  # 去到当前页面
            if vtitle + "_哔哩哔哩_bilibili" in handle.title():
                break
        sleep(10)
        # comnums_before = self.driver.find_element_by_css_selector(".results").text
        # print(comnums_before)
        com = str(random.randint(0, 50)) + "_这是一条友善的评论_" + str(random.randint(0, 100))
        comtextarea = self.driver.find_elements_by_css_selector(".ipt-txt")
        comtextarea[0].send_keys(com)
        sleep(10)
        try:
            self.driver.find_element_by_css_selector(".comment-submit").click()
            if flag:
                self.quit_to_console()
            return True
        except Exception:
            return False
        # sleep(30)
        # self.driver.find_element_by_css_selector(".new-sort").click()
        # sleep(10)
        # self.driver.refresh()
        # sleep(10)
        # comnums_after = self.driver.find_element_by_css_selector(".results").text
        # print(comnums_after)
        # if int(comnums_after) - int(comnums_before) == 1:
        #     return True
        # else:
        #     return False

        # # comment_list = self.driver.find_elements_by_css_selector(".reply-wrap")
        # # print("----" + comment_list[1].find_element_by_css_selector(".text").text)
        # if comment_list[1].find_element_by_css_selector(".text").text == com:
        #     return True
        # else:
        #     return False

    # 关闭浏览器
    def quit_to_console(self):
        self.driver.quit()

    # 调用图鉴api进行验证码破解
    def base64_api(self, uname, pwd, img, typeid):
        with open(img, 'rb') as f:
            base64_data = base64.b64encode(f.read())
            b64 = base64_data.decode()
        data = {"username": uname, "password": pwd, "typeid": typeid, "image": b64}
        result = json.loads(requests.post("http://api.ttshitu.com/predict", json=data).text)
        if result['success']:
            return result["data"]["result"]
        else:
            return result["message"]

    # # 鼠标点击事件
    # def click_locxy(self, img_div, x, y, left_click=True):
    #     '''
    #     dr:浏览器
    #     x:页面x坐标
    #     y:页面y坐标
    #     left_click:True为鼠标左键点击，否则为右键点击
    #     '''
    #     if left_click:
    #         ActionChains(img_div).move_by_offset(x, y).click().perform()
    #     else:
    #         ActionChains(img_div).move_by_offset(x, y).context_click().perform()
    #     ActionChains(img_div).move_by_offset(-x, -y).perform()  # 将鼠标位置恢复到移动前

    # 鼠标点击事件
    # 鼠标点击事件
    def click_locxy(self, x, y, left_click=True):
        '''
        dr:浏览器
        x:页面x坐标
        y:页面y坐标
        left_click:True为鼠标左键点击，否则为右键点击
        '''
        if left_click:
            ActionChains(self.driver).move_by_offset(x, y).click().perform()
        else:
            ActionChains(self.driver).move_by_offset(x, y).context_click().perform()
        ActionChains(self.driver).move_by_offset(-x, -y).perform()  # 将鼠标位置恢复到移动前
