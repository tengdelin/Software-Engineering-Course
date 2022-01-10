# -*- conding = utf-8 -*-
# @Time: 2021/3/30 14:09
# @Author: tdl
# @file: make_images.py
# @sortware: PyCharm

import os
import cv2



#人脸检测并保存
def facedetect(image, output):
    #获取文件名
    name=os.path.basename(image)
    #读入图片
    image=cv2.imread(image)
    #变成灰度图
    image=cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)
    #级联分类器,检测人脸
    detector= cv2.CascadeClassifier("haarcascade_frontalface_alt.xml") #自带的人脸检测模型
    rects = detector.detectMultiScale(image,scaleFactor=1.1,minNeighbors=3,minSize=(20,20), flags=cv2.CASCADE_SCALE_IMAGE)
    #循环每个人脸
    for (x,y,w,h) in rects:
        #截取人脸，并且都转化为200*200的固定大小
        f= cv2.resize(image[y:y+h,x:x+w],(200,200))
        #写入指定路径
        cv2.imwrite(os.path.join(output,name),f)

#检测并截取人脸
def predict_face(path,output):
    #如果该文件夹不存在则创建文件夹
    if not os.path.exists(output):
        os.makedirs(output)
    #循环每个人物的文件夹下的图片
    for files in os.listdir(path):
        #检测是不是文件夹
        if os.path.isdir(os.path.join(path,files)):
            #定义截取到的脸的输出路
            output2 = os.path.join(output,files)
            #如果该文件夹不存在则创建文件夹
            if not os.path.exists(output2):
                os.makedirs(output2)
            #人物文件夹的完整路径
            files = os.path.join(path,files)
            #循环每个人的每张照片
            for file in os.listdir(files):
                #照片完整路径
                file= os.path.join(files,file)
                #检测脸并保存
                facedetect(file,output2)
