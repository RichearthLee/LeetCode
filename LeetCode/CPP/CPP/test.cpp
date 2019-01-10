//#include <stdio.h>
#include "pch.h"
#include "test.h"
/*
* 1.从特殊到一般
* 2.本项目内的.h文件
* 3.其他库的.h文件
* 4.C++系统文件
* 5.C系统文件
*/

using namespace std;

test::test(int id , int num)
{
	this->id = id;
	this->num = num;

}

test::~test()
{
}

int test::getId() {
	std::cout << id << endl;
	printf("%d\n", id);
	return id;
}


