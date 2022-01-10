# -*- conding = utf-8 -*-
# @Time: 2021/3/30 14:14
# @Author: tdl
# @file: make_label.py
# @sortware: PyCharm

import os
import imghdr

#生成label文件
def get_label(path,label):
    fh=open(label,'w')
    # 表示人脸label
    label=0
    for root,dirs,files in os.walk (path):
        #循环每个文件夹
        for subdir in dirs:
            #文件夹完整路径
            subdir_path =os.path.join(root,subdir)
            #循环每个人物文件夹下面每张照片
            for file in os.listdir(subdir_path):
            #照片完整路
                filepath= os.path.join(subdir_path,file)
            #判断文件类型是不是图片类
                imgType=imghdr.what(filepath)
                if imgType == 'jpg' or imgType=='png' or imgType=='jpeg':
                #保存图片路径
                    fh.write(filepath)
                    fh.write(';')
                #标签
                    fh.write(str(label))
                    fh.write('\n')
            #每个人的标签不一样，从0开始计数
            label=label+1
    fh.close()

