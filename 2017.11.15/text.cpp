#include <stdio.h>
#include <stdlib.h>
#include "a.h"
#include "b.h"


int main(void)
{
	int input;
	
	initTree();
	
	int data[7] = { 5,7,6,9,3,2,4 };
	
	for (int x = 0; x < 7; x++)
	{
		addData(data[x]);
	}
	printTree();
		
	printf("\n\n�����������:");
	scanf("%d", &input);
	searchData(input);
	
	printf("\n----------------------------------------\n");
	
	TreeNode tree=NULL;
	printf("��ʼ���ݣ�");
	for (int x = 0; x < 7; x++)
	{
		printf("%d ", data[x]);
		tree=Insert(tree,data[x]);
	}
	printf("\n");
	printf("�������У�");
	print(tree);
	printf("\n");
	

	
	return 0;
}
