from selenium import webdriver

import os, base64
import requests as req
from PIL import Image
from io import BytesIO


def test():
    # driver = webdriver.Chrome(r'/usr/bin/chromedriver')
    # driver.implicitly_wait(100)
    # driver.get("https://gaokao.chsi.com.cn/zsgs/gspydyzgmd--method-groupByYx.dhtml")
    # selector = driver.find_element_by_css_selector("#cnt1 > ul")
    # list = selector.find_elements_by_tag_name("a")
    # str = "https://gaokao.chsi.com.cn/zsgs/gspydyzgmd.do?method=showZsgsImageByXm&year=2021&jxId=&yxdm="
    # yxid=[]
    # data = open("yxid.txt", 'w+')
    # for i in list:
    #     # yxid.append()
    #     print(i.get_attribute("href")[-5:], file=data)
    #     # mkdir(i.text)

    start = []
    yxid = []
    with open("start.txt", "r") as f:
        for line in f.readlines():
            line = line.strip('\n')  # 去掉列表中每一个元素的换行符
            start.append(line)

    with open("yxid.txt", "r") as f:
        for line in f.readlines():
            line = line.strip('\n')  # 去掉列表中每一个元素的换行符
            yxid.append(line)

    driver = webdriver.Chrome(r'/usr/bin/chromedriver')
    driver.implicitly_wait(3)
    str = "https://gaokao.chsi.com.cn/zsgs/gspydyzgmd.do?method=listStu&year=2021&yxdm="
    str2 = "&start="
    url = []
    data = open("img_url.txt", 'w+')
    for yx in yxid:
        for page in start:
            driver.get(str + yx + str2 + page)
            try:
                print(driver.find_element_by_css_selector("#result-img > img").get_attribute("src"), file=data)
            except Exception:
                print(yx)
                break


def mkdir(path):
    # 判断路径是否存在
    # 存在     True
    # 不存在   False
    isExists = os.path.exists(path)

    # 判断结果
    if not isExists:
        # 如果不存在则创建目录
        # 创建目录操作函数
        os.makedirs(path)
        print(path + ' 创建成功')
        return True
    else:
        # 如果目录存在则不创建，并提示目录已存在
        print(path + ' 目录已存在')
        return False


def downimg():
    url = []
    with open("foods_url.txt", "r") as f:
        for line in f.readlines():
            line = line.strip('\n')  # 去掉列表中每一个元素的换行符
            url.append(line)
    for i in range(0, 938, 1):
        response = req.get(url[i])  # 将这个图片保存在内存
        # 将这个图片从内存中打开，然后就可以用Image的方法进行操作了
        image = Image.open(BytesIO(response.content))
        # 得到这个图片的base64编码
        ls_f = base64.b64encode(BytesIO(response.content).read()).decode('utf-8')
        # 打印出这个base64编码
        # print(ls_f)
        # print('data:image/jpeg;base64,%s' % ls_f)
        #########################
        # # 下面是将base64编码进行解码
        imgdata = base64.b64decode(ls_f)

        # # 将它用写入一个图片文件即可保存
        file = open('img/' + str(i) + '.jpg', 'wb')
        file.write(imgdata)
        # # 关闭这个文件
        file.close()


if __name__ == '__main__':
    downimg()
