import time
from tkinter import *
import Bilibili as BL
from numpy import *


def test_all():
    print("\n----------整体测试开始---------")
    usr = username.get().strip()
    pwd = password.get().strip()
    # 创建实例化对象
    bili = BL.BiliBili()
    # 登录
    login = bili.login(usr, pwd, False)
    if login:
        print("login success!")
    else:
        print("login failed!")
        return -1
    # 搜索
    search = bili.search(False)
    if search:
        print("search success!")
    else:
        print("search failed!")
        return -1
    # 选取视频
    select = bili.select(False)
    if select != "":
        print("select success!")
    else:
        print("select failed!")
        return -1
    # 点赞
    like = bili.like(False)
    if like:
        print("like success!")
    else:
        print("like failed!")
        return -1

    # 评论
    comment = bili.comment(select, True)
    if comment:
        print("comment success!")
    else:
        print("comment failed!")
        return -1
    print("---------整体测试完成---------")
    return 0


def test_login():
    time_list = []
    for i in range(10):
        t1 = time.time()
        print("----------登录测试开始---------", i)
        usr = username.get().strip()
        pwd = password.get().strip()
        # 创建实例化对象
        bili = BL.BiliBili()
        # 登录
        login = bili.login(usr, pwd, True)
        if login:
            print("----------登录测试完成---------", i)
        else:
            print("----------登录测试失败---------", i)
        t2 = time.time()
        t = t2 - t1
        time_list.append(t)
        print(i, "次测试用时", t)
    print("10次平均时间为：", mean(time_list))


def test_search():
    time_list = []
    for i in range(10):
        print("----------搜索测试开始---------", i)
        usr = username.get().strip()
        pwd = password.get().strip()
        # 创建实例化对象
        bili = BL.BiliBili()
        # 登录
        login = bili.login(usr, pwd, False)
        if login:
            t1 = time.time()
            search = bili.search(True)
            t2 = time.time()
            t = t2 - t1
            print(i, "次测试用时", t)
            time_list.append(t)
            if search:
                print("----------搜索测试成功---------", i)
            else:
                print("----------搜索测试失败---------", i)
        else:
            print("----------搜索测试：登录失败---------", i)
    print("10次平均时间为：", mean(time_list))


def test_select():
    time_list = []
    for i in range(10):
        print("----------选择视频测试开始---------", i)
        usr = username.get().strip()
        pwd = password.get().strip()
        # 创建实例化对象
        bili = BL.BiliBili()
        login = bili.login(usr, pwd, False)
        if login:  # 登录
            search = bili.search(False)
            if search:  # 搜索
                t1 = time.time()
                select = bili.select(True)
                t2 = time.time()
                t = t2 - t1
                print(i, "次测试用时", t)
                time_list.append(t)
                if select != "":
                    print("----------选取视频测试成功---------", i)
                else:
                    print("----------选取视频测试失败---------", i)
            else:
                print("----------选取视频测试：搜索失败---------", i)
        else:
            print("----------选取视频测试：登录失败---------", i)
    print("10次平均时间为：", mean(time_list))


def test_like():
    time_list = []
    for i in range(10):
        print("----------点赞视频测试开始---------", i)
        usr = username.get().strip()
        pwd = password.get().strip()
        # 创建实例化对象
        bili = BL.BiliBili()
        login = bili.login(usr, pwd, False)
        if login:  # 登录
            search = bili.search(False)
            if search:  # 搜索
                select = bili.select(False)
                if select != "":  # 选择视频
                    t1 = time.time()
                    like = bili.like(True)
                    t2 = time.time()
                    t = t2 - t1
                    print(i, "次测试用时", t)
                    time_list.append(t)
                    if like:
                        print("----------点赞测试成功---------", i)
                    else:
                        print("----------点赞测试失败---------", i)
                else:
                    print("----------点赞测试：选取视频测试失败---------", i)
            else:
                print("----------点赞测试：搜索失败---------", i)
        else:
            print("----------点赞测试：登录失败---------", i)
    print("10次平均时间为：", mean(time_list))


def test_com():
    time_list = []
    for i in range(10):
        print("----------评论视频测试开始---------", i)
        usr = username.get().strip()
        pwd = password.get().strip()
        # 创建实例化对象
        bili = BL.BiliBili()
        login = bili.login(usr, pwd, False)
        if login:  # 登录
            search = bili.search(False)
            if search:  # 搜索
                select = bili.select(False)
                if select != "":  # 选择视频
                    t1 = time.time()
                    like = bili.comment(select, True)
                    t2 = time.time()
                    t = t2 - t1
                    print(i, "次测试用时", t)
                    time_list.append(t)
                    if like:
                        print("----------评论测试成功---------", i)
                    else:
                        print("----------评论测试失败---------", i)
                else:
                    print("----------评论测试：选取视频测试失败---------", i)
            else:
                print("----------评论测试：搜索失败---------", i)
        else:
            print("----------评论测试：登录失败---------", i)
    print("10次平均时间为：", mean(time_list))


def test_quit():
    quit()


if __name__ == '__main__':
    tk = Tk()
    tk.geometry("250x500+800+100")
    tk.title("B站测试控制台")
    Label(tk, text="账号:", font=('黑体', 15)).grid()
    Label(tk, text="密码:", font=('黑体', 15)).grid()

    username = Entry(tk)
    username.insert(0, "15826637783")
    username.grid(row=0, column=1)
    password = Entry(tk)
    password.insert(0, "Prussia118225")
    password.grid(row=1, column=1)

    button = Button(tk, text="整体流程测试", font='黑体', command=test_all)
    button.grid(row=2, column=1)

    button = Button(tk, text="登录10次", font='黑体', command=test_login)
    button.grid(row=3, column=1)

    button = Button(tk, text="搜索10次", font='黑体', command=test_search)
    button.grid(row=4, column=1)

    button = Button(tk, text="选择视频10次", font='黑体', command=test_select)
    button.grid(row=5, column=1)

    button = Button(tk, text="点赞10次", font='黑体', command=test_like)
    button.grid(row=6, column=1)

    button = Button(tk, text="评论10次", font='黑体', command=test_com)
    button.grid(row=7, column=1)

    button = Button(tk, text="退出测试", font='黑体', command=test_quit)
    button.grid(row=8, column=1)

    tk.mainloop()
