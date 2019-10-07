#include <stdio.h>
#include "pch.h"
#include "test.h"
/*
* 1.�����⵽һ��
* 2.����Ŀ�ڵ�.h�ļ�
* 3.�������.h�ļ�
* 4.C++ϵͳ�ļ�
* 5.Cϵͳ�ļ�
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


