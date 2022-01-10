#include"FileSystem.h"

/*
 *测试主函数
 */
int main()
{
    FileSystem sf;
    MFD* mfd = new MFD;
   //mfd = (MFD*)malloc(sizeof(MFD));
    if (mfd == NULL)
    {
        exit(0);
    }
    mfd->head = mfd->tail = NULL;
    sf.initUser(mfd);

    char userName[20];
    char cmd[20];
    while (true)
    {
        cout << "C:\\user\\tdl>";
        cin >> cmd;
        while (true)
        {
            if (strcmp(cmd, "cd") == 0) {
                cout << "please input user:";
                cin >> userName;
                break;
            }
            else if (strcmp(cmd, "user") == 0) {
                sf.displayUser(mfd);
            }
            else if (strcmp(cmd, "help") == 0)
            {
                cout << "---------------------------" << endl;
                cout << "\t帮助说明：" << endl;
                cout << "---------------------------" << endl;
                cout << "user - 查看所有用户" << endl;
                cout << "cd - 进入用户目录" << endl;
                cout << "create - 创建文件" << endl;
                cout << "delete - 删除文件" << endl;
                cout << "dir - 显示用户目录下所有文件" << endl;
                cout << "open - 打开文件" << endl;
                cout << "close - 关闭文件" << endl;
                cout << "read - 读文件操作" << endl;
                cout << "write - 写文件操作" << endl;
                cout << "ls - 显示用户目录下所有打开的文件" << endl;
                cout << "show - 位图显示文件" << endl;
                cout << "cd - 返回上级目录" << endl;
                cout << "exit - 退出程序" << endl;
                cout << "help - 帮助" << endl;
            }
            cout << "please use 'cd' commond to choose user !" << endl;
            cout << "C:\\user\\tdl>";
            cin >> cmd;
        }
        //cout << "login: ";
        //cin >> userName;
        Map* user;
        user = sf.queryUser(userName, mfd);
        if (user == NULL)
        {
            cout << "No such user ! " << endl;
        }
        else
        {
            //为用户初始化打开文件目录
            AFD* afd = new AFD;
            //afd = (AFD*)malloc(sizeof(AFD));
            if (afd == NULL)
            {
                cout << "The memory is not enough ! " << endl;
                exit(0);
            }
            afd->head = afd->tail = NULL;
            afd->max_open = 5;
            afd->current_open = 0;

            char command[20];
            char file_name[20];
            bool file_protect[3];
            bool open_file_protect[3];
            int file_length;
            while (true)
            {
                cout << "--------------------------------" << endl;
                cout <<"C:\\user\\tdl\\"<< userName << ">";
                cin >> command;
                //输入命令进行操作
                if (strcmp(command, "create") == 0)
                {
                    cout << "Please input file (file_name file_protect(r-w-x) file_length) : " << endl;
                    cin >> file_name >> file_protect[0] >> file_protect[1] >> file_protect[2] >> file_length;
                    sf.createFile(user, file_name, file_protect, file_length);
                }
                else if (strcmp(command, "dir") == 0)
                {
                    sf.displayUserFile(user);
                }
                else if (strcmp(command, "delete") == 0)
                {
                    cout << "Please input the file's name you want to delete : ";
                    cin >> file_name;
                    sf.deleteFile(user, file_name, afd);
                }
                else if (strcmp(command, "open") == 0)
                {
                    cout << "Please input the file name you want to open : ";
                    cin >> file_name >> open_file_protect[0] >> open_file_protect[1] >> open_file_protect[2];
                    sf.openFile(user, file_name, afd, open_file_protect);
                    //sf.displayOpenFile(afd, user);
                }
                else if (strcmp(command, "close") == 0)
                {
                    cout << "Please input the file you want to close : ";
                    cin >> file_name;
                    sf.closeFile(afd, file_name);
                    //sf.displayOpenFile(afd, user);
                }
                else if (strcmp(command, "read") == 0)
                {
                    cout << "Please input the file you want to read : ";
                    cin >> file_name;
                    sf.readFile(afd, file_name);
                    //sf.displayOpenFile(afd, user);
                }
                else if (strcmp(command, "write") == 0)
                {
                    cout << "Please input the file you want to write : ";
                    cin >> file_name;
                    sf.writeFile(afd, file_name);
                    //sf.displayOpenFile(afd, user);
                }
                else if (strcmp(command, "ls") == 0)
                {
                    sf.displayOpenFile(afd, user);
                }
                else if (strcmp(command, "user") == 0)
                {
                    sf.displayUser(mfd);
                }
                else if (strcmp(command, "cd") == 0)
                {
                    break;
                }
                else if (strcmp(command, "show") == 0)
                {
                    cout << "Please input the file you want to show :";
                    cin >> file_name;
                    sf.showfile(user, file_name);
                }
                else if (strcmp(command, "exit") == 0)
                {
                    exit(0);
                }
                else if (strcmp(command, "help") == 0)
                {
                    cout << "---------------------------" << endl;
                    cout << "\t帮助说明：" << endl;
                    cout << "---------------------------" << endl;
                    cout << "user - 查看所有用户" << endl;
                    cout << "cd - 进入用户目录" << endl;
                    cout << "create - 创建文件" << endl;
                    cout << "delete - 删除文件" << endl;
                    cout << "dir - 显示用户目录下所有文件" << endl;
                    cout << "open - 打开文件" << endl;
                    cout << "close - 关闭文件" << endl;
                    cout << "read - 读文件操作" << endl;
                    cout << "write - 写文件操作" << endl;
                    cout << "ls - 显示用户目录下所有打开的文件" << endl;
                    cout << "show - 位图显示文件" << endl;
                    cout << "cd - 返回上级目录" << endl;
                    cout << "exit - 退出程序" << endl;
                    cout << "help - 帮助" << endl;
                   


                }
                else
                {
                    cout << "No such command \"" << command << "\"" << endl;
                }
            }
        }
    }
    return 0;
}

