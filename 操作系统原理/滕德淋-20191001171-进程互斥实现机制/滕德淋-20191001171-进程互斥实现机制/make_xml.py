# -*- conding = utf-8 -*-
# @Time: 2021/3/30 14:16
# @Author: tdl
# @file: make_xml.py
# @sortware: PyCharm



import cv2
import numpy as np

def make_xml(label_txt,out_xml):
    # 保存图片数
    images = []
    # 保存标签
    labels = []
    # 打开文件
    fh = open(label_txt)
    # 循环每一行
    for line in fh:
        # 以;切分字符
        arr = line.split(';')
        # 第0部分为图片路径，读取文件
        img = cv2.imread(arr[0], 0)
        # 保存图片数据
        images.append(img)
        # 保存对应的标签数据
        labels.append(int(arr[1]))
    # 安装 pencv扩展包
    # pip install opencv-contrib-python
    # 定义脸识别模型
    model = cv2.face.EigenFaceRecognizer_create()
    # mode1= cv2.face.FisherFaceRecognizer_create()
    # mode1= cv2.face.LBPHFaceRecognizer_create()
    # 并训练模型
    model.train(np.array(images), np.array(labels))
    # 保存模型
    model.save(out_xml)