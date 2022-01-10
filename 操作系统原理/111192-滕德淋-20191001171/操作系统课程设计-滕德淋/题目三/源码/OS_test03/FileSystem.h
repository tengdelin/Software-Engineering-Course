#pragma once
/*
 *模拟文件管理
 */

#include<iostream>
#include<malloc.h>
#include<string.h>
using namespace std;

/*
 *定义文件数据结构
 */
typedef struct file
{
	char file_name[20];
	bool file_protect[3];
	bool open_file_protect[3]; //仅在文件打开时有效
	int  read, write; //定义为读写指针
	//int file_lenght;
	int* file_length = new int[255];
	struct file* next;
} File;

/*
 *用户与文件的映射
 */
typedef struct x_map
{
	char userName[20];
	File* file;
	struct x_map* next;
} Map;

/*
 *定义主文件目录
 */
typedef struct mfd
{
	Map* head, * tail;
} MFD;

/*
 *打开文件目录
 */
typedef struct afd
{
	File* head, * tail;
	int max_open;
	int current_open;
} AFD;

class FileSystem
{
public:
	FileSystem();
	~FileSystem();

	/*
	 *进行用户的初始化
	 */
	void initUser(MFD* mfd);

	/*
	*进行系统用户的输出
	*/
	void displayUser(MFD* mfd);

	/*
	 *进行用户的查找，找到则返回用户映射指针
	 */
	Map* queryUser(char userName[], MFD* mfd);

	/*
	 *进行文件的创建操作
	 *成功则返回true ， 否则返回false
	 */
	bool createFile(Map* user, char file_name[], bool file_protect[3], int file_length);

	/*
	 *进行文件删除操作
	 */
	bool deleteFile(Map* user, char file_name[], AFD* afd);

	/*
	 *进行文件打开操作
	 */
	bool openFile(Map* user, char file_name[], AFD* afd, bool open_file_protect[]);

	/*
	 *进行读操作
	 */
	bool readFile(AFD* afd, char file_name[]);

	/*
	 *进行文件的写操作
	 */
	bool writeFile(AFD* afd, char file_name[]);

	/*
	 *关闭文件
	 */
	bool closeFile(AFD* afd, char file_name[]);

	/*
	 *进行用户文件的显示
	 */
	void displayUserFile(Map* user);

	/*
	 *显示打开的文件
	 */
	void displayOpenFile(AFD* afd, Map* user);

	/*
	* 显示位图文件
	*/
	void showfile(Map* user, char file_name[]);

private:

};

