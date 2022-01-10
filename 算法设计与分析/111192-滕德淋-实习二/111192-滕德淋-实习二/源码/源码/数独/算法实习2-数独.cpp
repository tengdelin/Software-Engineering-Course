#include <conio.h>
#include <graphics.h>
#include <time.h>
#define MAP_COL 9
#define MAP_ROW 9


COORD currentPos = { 0,0 }, numPos = { 10,0 }, coord, waitPos;//鼠标事件，用来计算选择的数字
clock_t t1, t2;//开始结束时间
MOUSEMSG msg;//鼠标消息
int sleepTime = 0;//暂停的时间
int flag_w = 1;//判断红框
int num = 1;//鼠标所选择的数字
int process;//页面
int second = 0, minute = 0;//秒钟和分钟
int gameDifficulty = 0, gameMode = 0, restart, start, faults, auto_solve, endGame;//游戏难度，选择的模式，重新开始，失败，游戏结束
int isWin = 0, noMistake = 0;//判断是否赢了的标志和错误标志
int Map1[MAP_ROW][MAP_COL], Map2[MAP_ROW][MAP_COL];//1是地图，2是记录哪些空被挖走；
int Map_HL[MAP_ROW][MAP_COL], Map_Mistake[MAP_ROW][MAP_COL];


void dataInit();
void select1();
void start1();
void select2();
void start2();
void select3();
void start3();
void end();
void GameDraw();
void GameUpdate();
void HeighLight(int);
COORD FindLeftUpperCornor(COORD);
int FindMistake(int);
int WinJudge();
void GameInit(int);
void Dig(int);
int validate(int x[MAP_ROW][MAP_COL], int i, int j, int num);
void solve_soduku(int x[MAP_ROW][MAP_COL]);


int main()
{
	void (*fun[3])() = { select1,select2,select3 };
	initgraph(900, 660);

	while (1)
	{
		dataInit();
		while (process < 3)
			fun[process++]();
		t1 = clock();
		GameInit(gameMode);
		int Maptemp1[MAP_ROW][MAP_COL], Maptemp2[MAP_ROW][MAP_COL];
		int Maptemp3[MAP_ROW][MAP_COL], Maptemp4[MAP_ROW][MAP_COL];
		for (int i = 0; i < MAP_ROW; i++)
		{
			for (int j = 0; j < MAP_COL; j++)
			{
				Maptemp1[i][j] = Map1[i][j];
				Maptemp2[i][j] = Map2[i][j];
				Maptemp3[i][j] = Map_HL[i][j];
				Maptemp4[i][j] = Map_Mistake[i][j];

			}
		}

		while (1)
		{
			if (MouseHit())
				msg = GetMouseMsg();
			GameUpdate();
			GameDraw();
			if (noMistake == 0 && auto_solve != 1)
				isWin = WinJudge();
			if (isWin || start)
			{
				/*Sleep(1000);*/
				break;
			}
			if (restart)
			{
				for (int i = 0; i < MAP_ROW; i++)
				{
					for (int j = 0; j < MAP_COL; j++)
					{
						Map1[i][j] = Maptemp1[i][j];
						Map2[i][j] = Maptemp2[i][j];
						Map_HL[i][j] = Maptemp3[i][j];
						Map_Mistake[i][j] = Maptemp4[i][j];
					}
				}
				process = 0;
				restart = 0;
				start = 0;
				auto_solve = 0;
				sleepTime = 0;
				faults = 0;
				endGame = 0;
				t1 = clock();
				continue;
			}
		}
		if (isWin)
			end();
		if (endGame)
			break;
	}
	closegraph();
	return 0;
}


//数据初始化
void dataInit()
{
	process = 0;
	restart = 0;
	start = 0;
	auto_solve = 0;
	sleepTime = 0;
	faults = 0;
	endGame = 0;
	for (int i = 0; i < MAP_ROW; i++)
		for (int j = 0; j < MAP_COL; j++)
			Map1[i][j] = Map2[i][j] = Map_HL[i][j] = Map_Mistake[i][j] = 0;
}
//初始化的三个界面，首页、难度选择、开始游戏
void start1()
{
	BeginBatchDraw();
	setbkcolor(LIGHTBLUE); //设置窗口背景颜色
	settextcolor(BLACK);
	setbkmode(1); //设置文字背景透明
	cleardevice();
	TCHAR s[5];
	_stprintf_s(s, _T("%d/3"), process);
	outtextxy(0, 0, s);
	LOGFONT f;
	gettextstyle(&f);                     // 获取当前字体设置
	f.lfHeight = 100;             // 设置字体高度为 100
	wcscpy_s(f.lfFaceName, _T("楷体"));    // 设置字体为“黑体”(高版本 VC 推荐使用 _tcscpy_s 函数)
	f.lfQuality = ANTIALIASED_QUALITY;    // 设置输出效果为抗锯齿  
	settextstyle(&f);                     // 设置字体样式
	outtextxy(300, 100, _T("数  独"));
	f.lfHeight = 40;
	f.lfQuality = ANTIALIASED_QUALITY;    // 设置输出效果为抗锯齿  
	settextstyle(&f);
	outtextxy(300, 220, _T("   作者:小滕"));

	settextstyle(40, 0, _T("宋体"));
	//setlinecolor(BLACK);
	//setlinestyle(PS_SOLID, 3);


	//rectangle(340, 290, 560, 360);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>290 && currentPos.Y < 360)
	{
		settextcolor(RED);
		//line(370, 350, 530, 350);
	}
	else
		settextcolor(BLACK);
	outtextxy(370, 305, L"开始游戏");


	//rectangle(340, 390, 560, 460);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>390 && currentPos.Y < 460)
	{
		settextcolor(RED);
		//line(350, 450, 550, 450);
	}
	else
		settextcolor(BLACK);
	outtextxy(370, 405, L"退出游戏");
	EndBatchDraw();
}
void select1()
{
	int post = 1;
	while (post)
	{
		start1();
		MOUSEMSG msg = GetMouseMsg(); // 获取鼠标信息
		int x = msg.x;
		int y = msg.y;
		switch (msg.uMsg)
		{
		case WM_MOUSEMOVE:
			currentPos.X = x;
			currentPos.Y = y;
			break;
		case WM_LBUTTONUP:
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>290 && currentPos.Y < 360)
			{
				gameMode = 1;
				post = 0;
			}
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>390 && currentPos.Y < 460)
			{
				post = 0;
				exit(1);
			}
			break;
		default:
			break;
		}
	}


}
void start2()
{
	BeginBatchDraw();
	setbkcolor(LIGHTBLUE);
	settextcolor(BLACK);
	setbkmode(1); //设置文字背景透明
	cleardevice();
	TCHAR s[5];
	_stprintf_s(s, _T("%d/3"), process);
	outtextxy(0, 0, s);
	settextstyle(40, 0, _T("宋体"));
	setlinecolor(BLACK);
	setlinestyle(PS_SOLID, 3);


	rectangle(340, 90, 560, 160);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>90 && currentPos.Y < 160)
	{
		settextcolor(RED);

	}
	else
		settextcolor(BLACK);
	outtextxy(370, 105, L"简    单");


	rectangle(340, 190, 560, 260);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>190 && currentPos.Y < 260)
	{
		settextcolor(RED);

	}
	else
		settextcolor(BLACK);
	outtextxy(370, 205, L"一    般");


	rectangle(340, 290, 560, 360);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>290 && currentPos.Y < 360)
	{
		settextcolor(RED);

	}
	else
		settextcolor(BLACK);
	outtextxy(370, 305, L"困    难");


	rectangle(340, 390, 560, 460);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>390 && currentPos.Y < 460)
	{
		settextcolor(RED);

	}
	else
		settextcolor(BLACK);
	outtextxy(370, 405, L"返    回");
	EndBatchDraw();
}
void select2()
{
	int post = 1;
	while (post)
	{
		start2();
		MOUSEMSG msg = GetMouseMsg(); // 获取鼠标信息
		int x = msg.x;
		int y = msg.y;
		switch (msg.uMsg)
		{
		case WM_MOUSEMOVE:
			currentPos.X = x;
			currentPos.Y = y;
			break;
		case WM_LBUTTONUP:
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>90 && currentPos.Y < 160)
			{
				post = 0;
				gameDifficulty = 0;
			}
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>190 && currentPos.Y < 260)
			{
				post = 0;
				gameDifficulty = 1;
			}
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>290 && currentPos.Y < 360)
			{
				post = 0;
				gameDifficulty = 2;
			}
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>390 && currentPos.Y < 460)
			{
				post = 0;
				process -= 2;
			}
			break;
		default:
			break;
		}
	}


}
void start3()
{
	BeginBatchDraw();
	setbkcolor(LIGHTBLUE);
	settextcolor(BLACK);
	setbkmode(1); //设置文字背景透明
	cleardevice();
	TCHAR s[5];
	_stprintf_s(s, _T("%d/3"), process);
	outtextxy(0, 0, s);
	settextstyle(40, 0, _T("宋体"));
	setlinecolor(BLACK);
	setlinestyle(PS_SOLID, 3);


	rectangle(340, 190, 560, 260);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>190 && currentPos.Y < 260)
	{
		settextcolor(RED);
		//line(370, 250, 530, 250);
	}
	else
		settextcolor(BLACK);
	outtextxy(370, 205, L"开始游戏");


	rectangle(340, 390, 560, 460);
	if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>390 && currentPos.Y < 460)
	{
		settextcolor(RED);
		//line(370, 450, 530, 450);
	}
	else
		settextcolor(BLACK);
	outtextxy(370, 405, L"返    回");
	EndBatchDraw();
}
void select3()
{
	int post = 1;
	while (post)
	{
		start3();
		MOUSEMSG msg = GetMouseMsg(); // 获取鼠标信息
		int x = msg.x;
		int y = msg.y;
		switch (msg.uMsg)
		{
		case WM_MOUSEMOVE:
			currentPos.X = x;
			currentPos.Y = y;
			break;
		case WM_LBUTTONUP:
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>190 && currentPos.Y < 260)
				post = 0;
			if (currentPos.X > 340 && currentPos.X < 560 && currentPos.Y>390 && currentPos.Y < 460)
			{
				post = 0;
				process -= 2;
			}
			break;
		default:
			break;
		}
	}


}

//游戏主页面
void GameDraw()
{
	BeginBatchDraw();
	setbkcolor(LIGHTBLUE); //设置背景颜色
	setbkmode(1);
	cleardevice();
	LOGFONT f;
	gettextstyle(&f);                     // 获取当前字体设置
	f.lfHeight = 40;                      // 设置字体高度为 40
	wcscpy_s(f.lfFaceName, _T("楷体"));    // 设置字体为“楷体”(高版本 VC 推荐使用 _tcscpy_s 函数)
	f.lfQuality = ANTIALIASED_QUALITY;    // 设置输出效果为抗锯齿  
	settextstyle(&f);


	/*画九宫格的框线*/
	setlinecolor(BLACK);
	for (int row = 1; row <= MAP_ROW + 1; row++) //横线
	{
		if ((row - 1) % 3 == 0)
			setlinestyle(PS_SOLID, 3);
		else
			setlinestyle(PS_DASH, 1);
		line(60, row * 60, 600, row * 60);
	}
	for (int col = 1; col <= MAP_COL + 1; col++) //竖线
	{
		if ((col - 1) % 3 == 0)
			setlinestyle(PS_SOLID, 3);
		else
			setlinestyle(PS_DASH, 1);
		line(col * 60, 60, col * 60, 600);
	}


	/*先高亮后outtextxy数字，否则数字会被覆盖*/
	//高亮提示数字

	for (int i = 0; i < 9; i++)
		for (int j = 0; j < 9; j++)
			if (Map_HL[i][j])
			{
				if (Map_HL[i][j] == 1)
					setfillcolor(RGB(85, 242, 85));//相同数字用绿色显示
				else
					setfillcolor(RGB(174, 174, 174));//同行列宫用浅灰色显示
				solidrectangle((j + 1) * 60 + 2, (i + 1) * 60 + 2, (j + 2) * 60 - 2, (i + 2) * 60 - 2);
			}
	setfillcolor(RGB(99, 99, 99));
	if (flag_w)
		solidrectangle((waitPos.X + 1) * 60 + 2, (waitPos.Y + 1) * 60 + 2, (waitPos.X + 2) * 60 - 2, (waitPos.Y + 2) * 60 - 2);
	//高亮错误数字所在的框格
	setfillcolor(RGB(250, 44, 20));
	for (int i = 0; i < 9; i++)
		for (int j = 0; j < 9; j++)
			if (Map_Mistake[i][j])
				solidrectangle((j + 1) * 60 + 1, (i + 1) * 60 + 1, (j + 2) * 60 - 1, (i + 2) * 60 - 1);


	//画宫格数字
	TCHAR str[10];
	for (int row = 0; row < MAP_ROW; row++)
	{
		for (int col = 0; col < MAP_COL; col++)
		{
			//数字0就不需要显示了
			if (Map1[row][col])
			{
				if (Map2[row][col] == 1)
					settextcolor(BLUE);
				else if (Map_HL[row][col] || Map_Mistake[row][col])
					settextcolor(WHITE);
				else
					settextcolor(RGB(61, 61, 61));
				_stprintf_s(str, _T("%d"), Map1[row][col]);
				outtextxy((col + 1) * 60 + 20, (row + 1) * 60 + 10, str);
			}
		}
	}


	/*画数字键盘内外框*/
	setlinestyle(PS_SOLID, 1);
	rectangle(660, 60, 840, 300);
	rectangle(650, 50, 850, 310);


	////////////////////////////////////////////////////////////////////////
	//画数字键盘数字 & 计时器
	settextcolor(RGB(9, 74, 247));
	setlinestyle(PS_SOLID, 3);
	t2 = clock();
	second = (int)(double)(t2 - t1) / CLOCKS_PER_SEC;


	second -= sleepTime;
	minute = second / 60;
	second %= 60;
	_stprintf_s(str, _T("%02d:%02d"), minute, second);
	outtextxy(0, 0, str);





	int n = 1;
	outtextxy(720, 250, _T("撤销"));
	for (int col = 0; col <= 2; col++)
	{
		for (int row = 10; row <= 12; row++)
		{
			_stprintf_s(str, _T("%d"), n++);
			outtextxy((row + 1) * 60 + 20, (col + 1) * 60 + 10, str);
		}
	}
	//用红框标注数字键盘中的当前所选数字
	setlinecolor(RED);
	setlinestyle(PS_SOLID, 3);
	rectangle((numPos.X + 1) * 60, (numPos.Y + 1) * 60, (numPos.X + 2) * 60, (numPos.Y + 2) * 60);
	setfillcolor(RGB(249, 247, 176));


	///////////////////////////////////// 左下角  /////////////////////////////////////
	setlinecolor(BLACK);
	setlinestyle(PS_SOLID, 2);
	settextstyle(30, 0, _T("宋体"));
	setfillcolor(RGB(158, 160, 169));

	if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 350 && currentPos.Y < 400)
	{
		solidrectangle(660, 350, 840, 400);
		settextcolor(WHITE);
	}
	else
		settextcolor(BLACK);
	outtextxy(670, 360, _T(" 暂    停"));


	if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 420 && currentPos.Y < 470)
	{
		solidrectangle(660, 420, 840, 470);
		settextcolor(WHITE);
	}
	else
		settextcolor(BLACK);
	outtextxy(670, 430, _T(" 重玩此关"));

	if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 490 && currentPos.Y < 540)
	{
		solidrectangle(660, 490, 840, 540);
		settextcolor(WHITE);
	}
	else
		settextcolor(BLACK);
	outtextxy(670, 500, _T(" 自动求解"));

	if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 560 && currentPos.Y < 610)
	{
		solidrectangle(660, 560, 840, 610);
		settextcolor(WHITE);
	}
	else
		settextcolor(BLACK);
	outtextxy(670, 570, _T(" 新游戏"));

	setfillcolor(BLACK);
	solidcircle(650, 380, 5);
	solidcircle(650, 450, 5);
	solidcircle(650, 520, 5);
	solidcircle(650, 590, 5);


	EndBatchDraw();
}
//游戏主页面鼠标事件和数据
void GameUpdate()
{
	if (MouseHit())
		msg = GetMouseMsg();

	int x = msg.x;
	int y = msg.y;
	switch (msg.uMsg)
	{
	case WM_MOUSEMOVE:
		if (x > 60 && x < 600 && y > 60 && y < 600)
		{
			flag_w = 1;
			waitPos.X = (x - 60) / 60;
			waitPos.Y = (y - 60) / 60;
			coord.X = waitPos.Y;
			coord.Y = waitPos.X;
			coord = FindLeftUpperCornor(coord);
			if (Map1[waitPos.Y][waitPos.X])
				HeighLight(1);
			else
				HeighLight(0);
		}
		else
		{
			//消除红框
			flag_w = 0;
			//消除高亮
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					Map_HL[i][j] = 0;
		}
		currentPos.X = x;
		currentPos.Y = y;
		break;
	case WM_LBUTTONUP:
		if (x > 660 && x < 840 && y>60 && y < 240)
		{
			numPos.X = (x - 60) / 60;
			numPos.Y = (y - 60) / 60;
			num = 3 * numPos.Y + (numPos.X - 10) + 1;
		}
		else if (x > 720 && y > 240 && x < 780 && y < 300)
		{
			numPos.X = (x - 60) / 60;
			numPos.Y = (y - 60) / 60;
			num = 0;
		}
		else if (x > 60 && x < 600 && y > 60 && y < 600)
		{
			if (Map2[waitPos.Y][waitPos.X] == 1)
				Map1[waitPos.Y][waitPos.X] = num;
			else
			{
				clock_t t3, t4;
				t3 = clock();
				MessageBox(GetHWnd(), L"提示数字不可修改哦", L"注意", 0);
				t4 = clock();
				sleepTime += (int)(double)(t4 - t3) / CLOCKS_PER_SEC;
			}
			noMistake = FindMistake(gameMode);
			faults += noMistake;
		}
		else if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 350 && currentPos.Y < 400)
		{
			clock_t t3, t4;
			t3 = clock();
			MessageBox(GetHWnd(), L"已暂停", L"提示", 0);
			t4 = clock();
			sleepTime += (int)(double)(t4 - t3) / CLOCKS_PER_SEC;
		}
		else if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 420 && currentPos.Y < 470)
		{
			clock_t t3, t4;
			t3 = clock();
			int result = MessageBox(GetHWnd(), _T("您确定重新开始吗?"), _T("确定"), MB_YESNO);
			switch (result)
			{
			case IDNO:
				break;
			case IDYES:
				restart = 1;
				break;
			}
			t4 = clock();
			sleepTime += (int)(double)(t4 - t3) / CLOCKS_PER_SEC;
		}
		else if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 490 && currentPos.Y < 540)
		{
			clock_t t3, t4;
			t3 = clock();
			int result = MessageBox(GetHWnd(), _T("您确定自动求解吗?"), _T("确定"), MB_YESNO);
			switch (result)
			{
			case IDNO:
				break;
			case IDYES:
				solve_soduku(Map1);
				auto_solve = 1;
				break;
			}
			t4 = clock();
			sleepTime += (int)(double)(t4 - t3) / CLOCKS_PER_SEC;
		}
		else if (currentPos.X > 660 && currentPos.X < 840 && currentPos.Y > 560 && currentPos.Y < 610)
		{
			clock_t t3, t4;
			t3 = clock();
			int result = MessageBox(GetHWnd(), _T("您确定开始新游戏吗?"), _T("确定"), MB_YESNO);
			switch (result)
			{
			case IDNO:
				break;
			case IDYES:
				start = 1;
				break;
			}
			t4 = clock();
			sleepTime += (int)(double)(t4 - t3) / CLOCKS_PER_SEC;
		}

		break;
	default:
		break;
	}
}

//检测高亮
void HeighLight(int post)
{
	int i, j;
	//清除上次的高亮数据
	for (i = 0; i < 9; i++)
		for (j = 0; j < 9; j++)
			Map_HL[i][j] = 0;
	if (waitPos.Y >= 0 && waitPos.Y <= 8 && waitPos.X >= 0 && waitPos.X <= 8)
	{
		/*两种高亮模式*/
		if (post)//1.高亮相同的数字
		{
			for (i = 0; i < 9; i++)
				for (j = 0; j < 9; j++)
					if (Map1[i][j] == Map1[waitPos.Y][waitPos.X])
						Map_HL[i][j] = 1;


		}
		else//2.高亮同行、同列、同宫
		{
			for (i = 0; i < 9; i++)
				Map_HL[i][waitPos.X] = 2;
			for (i = 0; i < 9; i++)
				Map_HL[waitPos.Y][i] = 2;
			//2.1根据每一宫的左上角的行列来高亮对应的那一宫
			for (i = coord.X; i < coord.X + 3; i++)
				for (j = coord.Y; j < coord.Y + 3; j++)
					if (i >= 0 && i < 9 && j >= 0 && j < 9)
						Map_HL[i][j] = 2;
		}
	}


}
COORD FindLeftUpperCornor(COORD c1)
{
	COORD c2;
	for (int i = 0; i <= 6; i += 3)
	{
		c2.X = i;
		for (int j = 0; j <= 6; j += 3)
		{
			c2.Y = j;
			if (c1.X >= c2.X && c1.X <= c2.X + 2 && c1.Y >= c2.Y && c1.Y <= c2.Y + 2)
				return c2;
		}
	}
	//这是被迫加上的
	return c2;
}
//检测当前地图中是否有错误情况
int FindMistake(int mode)
{
	int i, j, r, c, post = 0;
	//清除上次的错误数据
	for (i = 0; i < 9; i++)
		for (j = 0; j < 9; j++)
			Map_Mistake[i][j] = 0;
	//对每列检查错误
	for (i = 0; i < 9; i++)
	{
		int arr[10] = { 0 };
		for (j = 0; j < 9; j++)
			arr[Map1[i][j]]++;
		for (j = 0; j < 9; j++)
			if (arr[Map1[i][j]] >= 2 && Map1[i][j] != 0)
			{
				Map_Mistake[i][j] = 1;
				post = 1;
			}
	}
	//对每行检查错误
	for (i = 0; i < 9; i++)
	{
		int arr[10] = { 0 };
		for (j = 0; j < 9; j++)
			arr[Map1[j][i]]++;
		for (j = 0; j < 9; j++)
			if (arr[Map1[j][i]] >= 2 && Map1[j][i] != 0)
			{
				post = 1;
				Map_Mistake[j][i] = 1;
			}


	}
	//对每宫检查错误
	for (i = 0; i <= 6; i += 3)
	{
		for (j = 0; j <= 6; j += 3)
		{
			int arr[10] = { 0 };
			for (r = i; r <= i + 2; r++)
				for (c = j; c <= j + 2; c++)
					arr[(Map1[r][c])]++;
			for (r = i; r <= i + 2; r++)
				for (c = j; c <= j + 2; c++)
					if (arr[Map1[r][c]] >= 2 && Map1[r][c] != 0)
					{
						Map_Mistake[r][c] = 1;
						post = 1;
					}

		}
	}
	return post;
}
//判断是否胜利
int WinJudge()
{
	int post = 1, P = 0;
	for (int i = 0; i < 9; i++)
	{
		for (int j = 0; j < 9; j++)
			if (Map1[i][j] == 0)
			{
				post = 0;
				P = 1;
				break;
			}
		if (P)
			break;
	}
	return post;
}

//游戏初始化，生成地图
void GameInit(int post)
{
	srand((unsigned)time(NULL));
	int a[10];
	int b[10] = { 0 };
	for (int i = 1; i <= 9; i++)
	{
		do {
			a[i] = rand() % 9 + 1;
		} while (b[a[i]]);
		b[a[i]]++;
	}
	//现在两个数组a和b已经生成了对应关系了(很乱，但一一对应)
	//生成数独地图的初始化地图
	if (post)
	{
		int map[9][9] = { {9,8,2,5,3,6,1,7,4},
		{4,3,6,7,1,9,5,8,2},
		{1,5,7,4,8,2,3,6,9},
		{8,4,5,6,2,7,9,3,1},
		{2,6,3,1,9,5,7,4,8},
		{7,1,9,8,4,3,2,5,6},
		{3,2,4,9,5,8,6,1,7},
		{6,9,1,3,7,4,8,2,5},
		{5,7,8,2,6,1,4,9,3} };

		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				Map1[i][j] = a[(map[i][j])];

	}
	Dig(gameDifficulty);
}
//挖空
void Dig(int post)
{
	srand((unsigned)time(NULL));
	int way[3][9] = { { 3,3,3,3,3,4,4,5,5 },
	  { 4,4,4,4,4,5,5,6,6 },
	  { 5,5,5,5,5,6,6,7,7 } };
	int t[9] = { 0 };
	int tmp[9] = { 0 }, n = 0;
	for (int i = 0; i < 9; i++)
	{
		do {
			n = rand() % 9;
		} while (t[n]);
		t[n]++;
		tmp[i] = way[post][n];
	}
	int m = 0, x, y;
	for (int i = 0; i < 9; i += 3)
		for (int j = 0; j < 9; j += 3)
		{
			int dig[3][3] = { 0 };
			for (int k = 0; k < tmp[m]; k++)
			{
				do {
					x = rand() % 3;
					y = rand() % 3;
				} while (dig[x][y]);
				dig[x][y] = 1;
				Map2[i + x][j + y] = 1;//标记被挖去的位置
			}
			m++;


		}
	for (int i = 0; i < 9; i++)
		for (int j = 0; j < 9; j++)
			if (Map2[i][j])
				Map1[i][j] = 0;
}

//游戏结束页
void end()
{
	setbkcolor(WHITE);
	settextcolor(BLACK);
	setbkmode(1);
	setfillcolor(RGB(158, 160, 169));
	cleardevice();
	LOGFONT f;
	gettextstyle(&f);
	f.lfHeight = 200;
	wcscpy_s(f.lfFaceName, _T("楷体"));
	f.lfQuality = ANTIALIASED_QUALITY;
	settextstyle(&f);
	outtextxy(30, 50, _T("恭喜通关"));
	outtextxy(30, 350, _T("太棒了！"));
	settextstyle(40, 0, _T("宋体"));


	outtextxy(550, 60, _T("完成时间："));
	solidrectangle(550, 110, 850, 160);
	outtextxy(550, 190, _T("错误次数："));
	solidrectangle(550, 240, 850, 290);
	outtextxy(550, 330, _T("总得分  ："));
	solidrectangle(550, 380, 850, 430);


	TCHAR str[20];
	settextcolor(WHITE);
	_stprintf_s(str, _T("%02d分%02d秒"), minute, second);
	outtextxy(620, 110, str);
	_stprintf_s(str, _T("%d"), faults);
	outtextxy(680, 240, str);
	float a = (1 - (minute + (float)second / 60) / ((gameDifficulty + 1) * 10)) * 20;
	float b = (float)(80 - faults) / 80 * 80;
	if ((minute * 60 + second) > (600 * (gameDifficulty + 1)))
		a = 0;
	if (faults >= 30)
		b = 0;
	float scores = a + b;
	_stprintf_s(str, _T("%.2f"), scores);
	outtextxy(650, 380, str);
	Sleep(1000);
	int result = MessageBox(GetHWnd(), _T("再来一局?"), _T("hello"), MB_YESNO);
	switch (result)
	{
	case IDNO:
		endGame = 1;
		break;
	case IDYES:
		break;
	}
}

//validate函数负责检查下x[i][j]是否为可行的值
int validate(int x[MAP_ROW][MAP_COL], int i, int j, int num)
{
	int row, column;
	int isPossible = 1;
	//遍历第i行查询是否有重复的值
	for (column = 0; column < 9; column++)
	{
		if (num == x[i][column]) isPossible *= 0;
		else isPossible *= 1;
	}
	//遍历第j列查询是否有重复的值
	for (row = 0; row < 9; row++)
	{
		if (num == x[row][j]) isPossible *= 0;
		else isPossible *= 1;
	}
	//遍历x[i][j]所在宫(box)查询是否有重复的值
	int box_i, box_j;
	//定位宫的位置,宫的首位置
	int offset_x, offset_y;
	//计算x方向(即j序号增加方向)偏移量
	offset_x = j - j % 3;
	//计算y方向(即i序号增加方向)偏移量
	offset_y = i - i % 3;
	for (box_i = 0; box_i < 3; box_i++)
	{
		for (box_j = 0; box_j < 3; box_j++)
		{
			//将box_i,box_j修正到正确的九宫格
			if (num == x[box_i + offset_y][box_j + offset_x]) isPossible *= 0;
			else isPossible *= 1;
		}
	}
	//验证无误返回1，否则返回0
	return isPossible;
}
//自动求解
void solve_soduku(int x[MAP_ROW][MAP_COL])
{
	int i, j, num, flag = 0;
	//新建一个二维数组负责记录不可更改数字（即开始时就被填入的数字）的位置
	int can_not_modify[9][9] = { 0 };
	for (i = 0; i < 9; i++)
	{
		for (j = 0; j < 9; j++)
		{
			if (x[i][j] != 0) can_not_modify[i][j] = 1;
		}
	}
	//初始化i和j
	i = 0;
	j = 0;
	//遍历九宫格，从x[0][0]开始尝试
	while (i < 9)
	{
		while (j < 9)
		{
			//判断是否为上一行试错跳转而来
		start:if (flag == 1 && j == -1)
		{
			i--;
			j = 8;
			goto start;
		}
		//判断是否为试错跳转而来且当前值不可修改
		else if (flag == 1 && can_not_modify[i][j] == 1)
		{
			//继续返回上一层
			j--;
			continue;
		}
		//判断当前格子是否不可修改
		else if (can_not_modify[i][j] == 1)
		{
			j++;
			continue;
		}
		//开始尝试
		else
		{
			num = x[i][j];
			//若当前格子还未赋值，即不是由上一次试错跳转而来，从1开始尝试
			if (num == 0) num = 1;
			//若flag==1即是由上一次试错而来，从上一次错误的值+1继续尝试
			else if (flag == 1) num = x[i][j] + 1;
			//初始化跳转标识的值
			flag = 0;
			//从num开始向后逐个尝试
			for (; num <= 10; num++)
			{
				//用validate函数判断尝试的值是否可行
				//如果可行将当前格子的值变为num
				if (validate(x, i, j, num) == 1 && num < 10)
				{
					x[i][j] = num;
					j++;
					break;
				}
				//如果到9还没有可行的值填入，说明前面有错，初始当前值为0，返回上一次尝试
				else if (num == 10)
				{
					x[i][j] = 0;
					j--;
					//打上跳转标识flag=1
					flag = 1;
					break;
				}
			}
		}
		}
		//一行填满从下一行第一个继续尝试
		j = 0;
		i++;
	}
}
