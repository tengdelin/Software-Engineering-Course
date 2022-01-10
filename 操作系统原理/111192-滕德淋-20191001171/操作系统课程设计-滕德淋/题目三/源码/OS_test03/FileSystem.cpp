#include"FileSystem.h"

FileSystem::FileSystem()
{
}

FileSystem::~FileSystem()
{
}

void FileSystem::initUser(MFD* mfd)
{
	//初始化十个不同用户
	for (int i = 1; i <= 10; i++)
	{
		Map* m = new Map;
		// Map* m;
		//m = (Map*)malloc(sizeof(Map));
		if (m == NULL)
		{
			exit(0);
		}
		cout << "Please input init user name : ";
		cin >> m->userName;
		m->file = NULL;
		m->next = NULL;
		if (mfd->head == NULL)
		{
			mfd->head = mfd->tail = m;
		}
		else
		{
			mfd->tail->next = m;
			mfd->tail = m;
		}
	}
}

void FileSystem::displayUser(MFD* mfd)
{
	Map* m = NULL;
	m = mfd->head;
	cout << "user : " << endl;
	while (m)
	{
		cout << "-------" << endl;
		cout << m->userName << endl;
		m = m->next;
	}
}

Map* FileSystem::queryUser(char userName[], MFD* mfd)
{
	Map* m = NULL;
	m = mfd->head;
	while (m)
	{
		if (strcmp(userName, m->userName) == 0)
		{
			return m;
		}
		m = m->next;
	}
	return NULL;
}

bool FileSystem::createFile(Map* user, char file_name[], bool file_protect[3], int file_length)
{
	File* file = new File;
	if (file == NULL)
	{
		return false;
	}

	//进行文件的初始化
	strcpy(file->file_name, file_name);
	file->file_protect[0] = file_protect[0];
	file->file_protect[1] = file_protect[1];
	file->file_protect[2] = file_protect[2];
	//int *fl = new int[file_length];
	for (int i = 0; i < 255; i++)
	{
		if (i < file_length) {
			file->file_length[i] = 1;
		}
		else {
			file->file_length[i] = 0;
		}
	}
	//file->file_length = file_length;
	file->read = file->write = 0;
	file->next = NULL;

	if (user->file == NULL)
	{
		user->file = file;
	}
	else
	{
		File* op, * preOp = NULL;
		op = user->file;
		//查找是否存在同名文件
		while (op)
		{
			if (strcmp(op->file_name, file->file_name) == 0)
			{
				cout << "The file name " << file->file_name << " is already exit ! " << endl;
				return false;
			}
			preOp = op;
			op = op->next;
		}
		preOp->next = file;
	}
}

void FileSystem::displayUserFile(Map* user)
{
	cout << "The fileList of " << user->userName << endl;
	File* file = NULL;
	file = user->file;
	cout << "name\t-rwx-\tlength" << endl;
	int count = 0;
	if (file == NULL) {
		return;
	}
	for (int i = 0; i < 255; i++) 
	{
		if (file->file_length[i] == 1)
		{
			count++;
		}
	}
	while (file)
	{
		cout << file->file_name << "\t" << file->file_protect[0] << " " << file->file_protect[1] << " " << file->file_protect[2] << "\t" <<count<< endl;
		file = file->next;
	}
}

void FileSystem::showfile(Map* user, char file_name[])
{
	File* file = NULL;
	file = user->file;
	while (file) {
		if (strcmp(file_name, file->file_name) == 0) {
			for (int i = 0; i < 255; i++)
			{
				cout << file->file_length[i] << " ";
			}
			cout << endl;
			return;
		}
		file = file->next;
	}
	cout << endl;
	cout << "user " << user->userName << " has not the file \"" << file_name << "\"" << endl;
}



bool FileSystem::deleteFile(Map* user, char file_name[], AFD* afd)
{
	File* file = NULL, * prefile = NULL, * temp;
	file = afd->head;
	if (file == NULL) {
		return false;
	}
	//在打开文件中查找
	while (file)
	{
		if (strcmp(file_name, file->file_name) == 0)
		{
			cout << "\"" << file_name << "\" is open , please close it before ! \n";
			return false;
		}
		file = file->next;
	}
	file = user->file;
	//在文件中进行查找
	while (file)
	{
		if (strcmp(file_name, file->file_name) == 0)
		{
			if (file == user->file)
			{
				temp = file;
				user->file = file->next;
			}
			else
			{
				temp = file;
				prefile->next = file->next;
			}
			delete temp;
			return true;
		}
		prefile = file;
		file = file->next;
	}
	if (prefile->next == NULL)
	{
		cout << "user " << user->userName << " has not the file \"" << file_name << "\"" << endl;
	}
	return false;
}

bool FileSystem::openFile(Map* user, char file_name[], AFD* afd, bool open_file_protect[])
{
	File* file = NULL;
	file = user->file;
	while (file)
	{
		if (strcmp(file->file_name, file_name) == 0)
		{
			break;
		}
		file = file->next;
	}
	if (file)
	{
		File* xfile = new File;
		if (xfile == NULL)
		{
			return false;
		}
		*xfile = *file;
		//根据文件的权限进行打开权限的赋值
		if (xfile->file_protect[0] >= open_file_protect[0])
		{
			xfile->open_file_protect[0] = open_file_protect[0];
		}
		else
		{
			cout << "no read priority ! " << endl;
			return false;
		}
		if (xfile->file_protect[1] >= open_file_protect[1])
		{
			xfile->open_file_protect[1] = open_file_protect[1];
		}
		else
		{
			cout << "no write priority ! " << endl;
			return false;
		}
		if (xfile->file_protect[2] >= open_file_protect[2])
		{
			xfile->open_file_protect[2] = open_file_protect[2];
		}
		else
		{
			cout << "no excute priority ! " << endl;
			return false;
		}
		xfile->next = NULL;
		if (afd->head == NULL)
		{
			afd->head = afd->tail = xfile;
			afd->current_open += 1;
		}
		else if (afd->current_open < afd->max_open)
		{
			afd->tail->next = xfile;
			afd->tail = xfile;
			afd->current_open += 1;
		}
		else
		{
			cout << "The open file is too many ! " << endl;
			return false;
		}
	}
	else
	{
		cout << "the " << file_name << " is not exit !" << endl;
		return false;
	}
}

bool FileSystem::closeFile(AFD* afd, char file_name[])
{
	File* file = NULL, * preFile = NULL, * temp = NULL;
	//在打开文件链表中进行查找
	file = afd->head;
	while (file)
	{
		if (strcmp(file->file_name, file_name) == 0)
		{
			if (file == afd->head)
			{
				if (file == afd->tail)
				{
					temp = file;
					afd->head = afd->tail = NULL;
				}
				else
				{
					temp = file;
					afd->head = file->next;
				}
			}
			else if (file == afd->tail)
			{
				temp = file;
				preFile->next = NULL;
				afd->tail = preFile;
			}
			else
			{
				temp = file;
				preFile->next = file->next;
			}
			delete temp;
			return true;
		}
		preFile = file;
		file = file->next;
	}
	cout << "The file is not exit ! " << endl;
	return false;
}

bool FileSystem::readFile(AFD* afd, char file_name[])
{
	File* file = NULL;
	file = afd->head;
	while (file)
	{
		if (strcmp(file->file_name, file_name) == 0)
		{
			if (file->open_file_protect[0])
			{
				file->read++;
				return true;
			}
			else
			{
				cout << "no read priority ! \n" << endl;
				return false;
			}
		}
		file = file->next;
	}
	cout << "no such file ! " << endl;
	return false;
}

bool FileSystem::writeFile(AFD* afd, char file_name[])
{
	File* file = NULL;
	file = afd->head;
	while (file)
	{
		if (strcmp(file->file_name, file_name) == 0)
		{
			if (file->open_file_protect[1])
			{
				file->write++;
				return true;
			}
			else
			{
				cout << "no write priority ! \n" << endl;
				return false;
			}
		}
		file = file->next;
	}
	cout << "no such file ! " << endl;
	return false;
}

void FileSystem::displayOpenFile(AFD* afd, Map* user)
{
	cout << "The open file of " << user->userName << " : " << endl;
	File* file;
	file = afd->head;
	while (file)
	{
		cout << file->file_name << " " << file->file_protect[0] << " " << file->file_protect[1] << " " << file->file_protect[2] << " " << file->file_length << " ";
		cout << "readcout : " << file->read << " writecout : " << file->write << endl;
		file = file->next;
	}
}