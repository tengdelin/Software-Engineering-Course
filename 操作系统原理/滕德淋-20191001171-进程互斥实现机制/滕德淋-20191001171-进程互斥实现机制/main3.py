# -*- conding = utf-8 -*-
# @Time: 2021/3/30 16:15
# @Author: tdl
# @file: main3.py
# @sortware: PyCharm

# -*- conding = utf-8 -*-
# @Time: 2021/3/30 15:42
# @Author: tdl
# @file: main1.py
# @sortware: PyCharm
'''
用peterson算法解决读写临界资源互斥问题版本
'''

# -*- conding = utf-8 -*-
# @Time: 2021/3/29 18:16
# @Author: tdl
# @file: main.py
# @sortware: PyCharm

import os
import imghdr
import time
import threading
import cv2
from imutils import *
from make_images import *
from make_label import *
from make_xml import *

# 互斥信号量
#peterson算法
flag=[0,0]    #初始值都为false
turn=0     #turn 表示优先让哪个进程进入临界区

# 打开摄像头，并保存图片到指定路径
def func0():
    cap = cv2.VideoCapture(0)  # 计算机自带的摄像头为0，外部设备为1
    global i #计数
    i = 0
    #peterson算法信号量
    global turn
    global flag
    while (1):
        ret, frame = cap.read()  # ret:True/False,代表有没有读到图片  frame:当前截取一帧的图片
        cv2.imshow("capture", frame)

        # if (cv2.waitKey(10) & 0xFF) == ord('s'):  # 不断刷新图像，这里是1ms 返回值为当前键盘按键值
        # gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)  # RGB图像转为单通道的灰度图像
        # gray = cv2.resize(gray, (320, 240))  # 图像大小为320*240
        i += 1
        # if i%0==0:
        # cv2.imwrite('img/%d.jpg'%i, frame)

        flag[0] = 1
        turn = 1
        while (flag[1]==1 & turn==1):
            continue
        cv2.imwrite('img/1.jpg', frame)
        flag[0] = 0
        if (cv2.waitKey(10) & 0xFF) == ord('q'):
            break


# 从指定路径读取图片，进行人脸识别，进行显示
def func1():
    # 定义人物名字
    # global name
    name = ['liushilong', 'tengdelin', 'tianhaoran', 'zhaoliying', 'zhaowenpeng']
    # 定义人脸识别模型
    # global model
    model = cv2.face.EigenFaceRecognizer_create()
    # 导入训练好的模型
    model.read('predict_face_test.xml')
    global i
    global turn
    global flag
    flag[1] = 1
    turn = 0
    while (flag[0] == 1& turn == 0):
        continue
    # 读入测试图片来做测试
    while (1):
        for file in os.listdir('img'):
            file = os.path.join('img', file)
            # 判断文件类型
            imgType = imghdr.what(file)
            if imgType == 'jpeg' or imgType == 'jpg':
                # 读入图片
                image = imread(file)
                # 变为灰度图
                gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
                # 级联分类器
                detector = cv2.CascadeClassifier('haarcascade_frontalface_alt.xml')
                rects = detector.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=3, minSize=(20, 20),flags=cv2.CASCADE_SCALE_IMAGE)
                # 循环每个人脸
                for (x, y, w, h) in rects:
                    # 画矩形
                    cv2.rectangle(image, (x, y), (x + w, y + h), (0, 255, 0), 2)
                    # 人脸识别
                    face = cv2.resize(gray[y:y + h, x:x + w], (200, 200))
                    # 颜测物
                    params = model.predict(face)
                    # 写上人物名字
                    cv2.putText(image, name[params[0]], (x, y - 20), cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 0, 0), 2)
                    # show(image)
                    cv2.imshow("tdl", image)
                    if (cv2.waitKey(10) & 0xFF) == ord('q'):
                        break
        flag[1]=0


if __name__ == '__main__':
    # 制作数据集
    # predict_face('face', 'out') # 输入文件夹，输出文件夹
    # print('数据集制作成功，请筛选图片')
    # os.system("pause")
    # # 制作标签路径
    # get_label('out','label.txt') # 文件夹路径
    # print('label.txt文件生成成功请确定路径')
    # os.system("pause")
    # # 制作训练模型
    # make_xml('label.txt','predict_face_test.xml')
    # print('训练模型制作完成，正在开始程序....')
    # time.sleep(1)

    # 开启摄像头，并开始识别
    func0_threading = threading.Thread(target=func0)
    func1_threading = threading.Thread(target=func1)
    func0_threading.start()
    func1_threading.start()
