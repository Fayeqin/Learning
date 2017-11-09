/*
���⣺�Թ����� 
�㷨������������� 
���ݽṹ���ڽӱ� 
*/
#include <stdio.h>
#include <stdlib.h>
#define R 7 

typedef struct _Branch
{
	int row;
	int column;

	_Branch * nextBranch;
}
* Branch;

typedef struct _Root
{
	int row;
	int column;

	_Root * nextRoot;
	_Branch * nextBranch;
}
* Root;

/////////////////////////////ȫ�ֱ��� 
int map[R][R];//�Թ� 
Root treeRoot;//���� 
int level = 1;//�ڼ��� 
/////////////////////// 

void printMap()
{
	printf("\n---------------------------------------------------------------------\n");

	int i = 0;
	int j = 0;

	for (i = 0; i < R; i++)
	{
		for (j = 0; j < R; j++)
		{
			if (map[i][j] == -1)
			{
				printf("\t��");
			}
			else
			{
				printf("\t%d", map[i][j]);
			}
		}
		printf("\n");
	}
}

Branch findBranch(Root tempRoot, int templevel)//Ѱ· 
{
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));	
	int tempRow = tempRoot -> row;
	int tempColumn = tempRoot -> column;

	//up
	if (map[tempRow - 1][tempColumn] == 0)
	{
		tempBranch -> row = tempRow - 1;
		tempBranch -> column = tempColumn;
		map[tempRow - 1][tempColumn] = templevel + 1;//���ڵ�ǰ�Ĳ�����һ 

		return tempBranch;
	}
	else if (map[tempRow - 1][tempColumn] == 9)//������9 
	{
		level = 0;//�ҵ��˳��ڣ��ѵ�ǰ�������0��������NULL 
	}
	
	//right
	if (map[tempRow][tempColumn + 1] == 0)
	{
		tempBranch -> row = tempRow;
		tempBranch -> column = tempColumn + 1;
		map[tempRow][tempColumn + 1] = templevel + 1;

		return tempBranch;
	}
	else if (map[tempRow][tempColumn + 1] == 9)
	{
		level = 0;
	}

	//down
	if (map[tempRow + 1][tempColumn] == 0)
	{
		tempBranch -> row = tempRow + 1;
		tempBranch -> column = tempColumn;
		map[tempRow + 1][tempColumn] = templevel + 1;
		
		return tempBranch;
	}
	else if (map[tempRow + 1][tempColumn] == 9)
	{
		level = 0;
	}

	//left
	if (map[tempRow][tempColumn - 1] == 0)
	{
		tempBranch -> row = tempRow;
		tempBranch -> column = tempColumn - 1;
		map[tempRow][tempColumn - 1] = templevel + 1;
		
		return tempBranch;
	}
	else if (map[tempRow][tempColumn - 1] == 9)
	{
		level = 0;
	}
	return NULL;
}

void addRoot(Branch tempBranch)
{
	Root tempRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Root tempBranchRoot = (struct _Root *) malloc (sizeof(struct _Root));
	//��ʼ�� 
	{ 
		tempBranchRoot -> row = tempBranch -> row;
		tempBranchRoot -> column = tempBranch -> column;
		tempBranchRoot -> nextBranch = NULL;
		tempBranchRoot -> nextRoot = NULL;
	}
	 
	tempRoot = treeRoot;
	while (tempRoot -> nextRoot != NULL)
	{
		tempRoot = tempRoot -> nextRoot;
	}
	tempRoot -> nextRoot = tempBranchRoot;
}

void createRoot(Root tempRoot)
{
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));
	tempBranch = tempRoot -> nextBranch;

	while (tempBranch != NULL)
	{
		addRoot(tempBranch);//�ѵ�ǰbranch���root 
		tempBranch = tempBranch -> nextBranch;
	} 
}

void createTree()
{
	Root tempRoot = (struct _Root *) malloc (sizeof(struct _Root));
	Branch tempBranch = (struct _Branch *) malloc(sizeof(struct _Branch));
	Branch lastBranch = (struct _Branch *) malloc(sizeof(struct _Branch));
	
	tempRoot = treeRoot;

	while (level != 0)//��ʶ�������Ϊ0�ʹ����ҵ��˳��� 
	{
		tempBranch = findBranch(tempRoot, map[tempRoot -> row][tempRoot -> column]);
		//Ϊ��ǰroot����branch 
		while (tempBranch != NULL)//�������branch 
		{
			tempBranch -> nextBranch = NULL;
			tempRoot -> nextBranch = tempBranch;
			lastBranch = tempBranch;

			tempBranch = findBranch(tempRoot, map[tempRoot -> row][tempRoot -> column]);

			while (tempBranch != NULL)
			{
				lastBranch -> nextBranch = tempBranch;
				lastBranch = tempBranch;
				tempBranch = findBranch(tempRoot, map[tempRoot -> row][tempRoot -> column]);
			}
		}
		createRoot(tempRoot);//�ѵ�ǰroot��branch������root�����ڱ�β 
		tempRoot = tempRoot -> nextRoot;//����Ѱ����һ��root 

		printMap();
	}
}

int main(void)

{
	map[0][0] = -1; map[0][1] = -1; map[0][2] = -1; map[0][3] = -1; map[0][4] = -1; map[0][5] = -1; map[0][6] = -1;
	map[1][0] = -1; map[1][1] =  1; map[1][2] =  0; map[1][3] =  0; map[1][4] =  0; map[1][5] =  0; map[1][6] = -1;
	map[2][0] = -1; map[2][1] = -1; map[2][2] = -1; map[2][3] =  0; map[2][4] = -1; map[2][5] = -1; map[2][6] = -1;
	map[3][0] = -1; map[3][1] = -1; map[3][2] = -1; map[3][3] =  0; map[3][4] = -1; map[3][5] = -1; map[3][6] = -1;
	map[4][0] = -1; map[4][1] =  0; map[4][2] =  0; map[4][3] =  0; map[4][4] =  0; map[4][5] =  0; map[4][6] = -1;
	map[5][0] = -1; map[5][1] = -1; map[5][2] = -1; map[5][3] =  0; map[5][4] = -1; map[5][5] =  9; map[5][6] = -1;
	map[6][0] = -1; map[6][1] = -1; map[6][2] = -1; map[6][3] = -1; map[6][4] = -1; map[6][5] = -1; map[6][6] = -1; 
	printMap();

	//��ʼ���� 
	{
		treeRoot = (struct _Root *) malloc (sizeof(struct _Root));
		treeRoot -> nextRoot = NULL;
		treeRoot -> row = 1;
		treeRoot -> column = 1;
	}
	
	createTree();

	return 0;

}
