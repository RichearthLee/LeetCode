// CPP.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"

#include <test.h>


using namespace std;

class stud//声明一个类
{
private://私有部分
	int num;
	char name[10];
	char sex;
public://公用部分
	stud(int n, const char nam[], char s)//构造函数
	{
		num = n;
		strcpy_s(name, nam);
		sex = s;
	}

	~stud() //析构函数
	{
		cout << "stud has been destructed!" << endl;//通过输出提示告诉我们析构函数确实被调用了
	}

	void display()//成员函数，输出对象的数据
	{
		cout << "num:" << num << endl;
		cout << "name:" << name << endl;
		cout << "sex:" << sex << endl;
	}
};
/*
struct ListNode {
	  int val;  //当前结点的值
	  ListNode *next;  //指向下一个结点的指针
	  ListNode(int x) : val(x), next(NULL) {}  //初始化当前结点值为x,指针为空
  };
  */

int main()
{
	//stud stud1(10010, "Wang-li", 'f'), stud2(10011, "Zhang-fun", 'm');//建立两个对象
	//stud1.display();//输出学生1的数据
	//stud2.display();//输出学生2的数据
 //   cout << "Hello World!\n";
	test t(3,2);
	ListNode *node;
	ListNode *node_1 = new ListNode(0);
	cout << t.getId() << endl << node_1->val << endl;

	

}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门提示: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
