#include<stdio.h>
//链表是由若干个结点构成的
#include <malloc.h>
typedef struct PolyNode* Polynomial;//结构指针
struct PolyNode {
	int coef;//系数
	int expon;//指数
	//链表还有一个域指针指向下一个结点
	Polynomial link;//指针

};

int main() {
	Polynomial P1, P2, PP, PS;//P1，P2都是链表结构的指针
	P1 = ReadPoly();//读入多项式
	P2 = ReadPoly();
	PP = Mult(P1, P2);//乘法运算
	PrintPoly(PP);
	PS = Add(P1, P2);
	PrintPoly(PS);//打印出和的多项式
	return 0;
}

//如何读入多项式
Polynomial ReadPoly(){
	Polynomial P, Rear,t;
	int c, e, N;
	scanf_s("%d", &N);//先读入总的对数N
	P = (Polynomial)malloc(sizeof(struct PolyNode));//链表头空节点
	P->link = NULL;
	Rear = P;
	while (N--) {
		scanf_s("%d %d", &c, &e);//读入系数，指数
		//Rear是当前结果表达式中的尾项指针
		//将当前项插入多项式尾部
		Attach(c, e, &Rear);//构造一个结点，把这个结点插到这个多项式里

	}
	t = P; P = P->link; free(t);//删除临时生成的头结点

	return P;

}

void Attach(int c, int e, Polynomial* pRear) {
	Polynomial P;

	P = (Polynomial)malloc(sizeof(struct PolyNode));
	//对新结点赋值
	P->coef = c;
	P->expon = e;
	P->link = NULL;
	(*pRear)->link = P;
	//*pRear表示当前结果表达式尾项指针
	*pRear = P;//修改pRear值,pRear实际上是指针的指针
}

//如何将两个多项式相加
Polynomial Add(Polynomial P1, Polynomial P2) {

	t1 = P1; t2 = P2;
	//先构造两个空结点
	P = (Polynomial)malloc(sizeof(struct PolyNode));
	P->link = NULL;//申请一个空结点
	Rear = P;//让Rear指向这个空结点
	while (t1 && t2) {//当t1和t2都不空的时候，比较他们的指数
		//相等则系数相加
		if (t1->expon == t2->expon) {

		}
		else if (t1->expon > t2->expon) {

		}
		else {

		}
	}
	//把另外一个后面不为空的接到结果多项式的后面，分别处理t1不空的情况和t2不空的情况
	while (t1) {

	}
	while (t2) {

	}

	return P;//返回结果多项式
}

//两个多项式相乘
Polynomial Mult(PolyNode P1, PolyNode P2) {
	
	Polynomial P, Rear, t1, t2, t;
	int c, e;
	if (!P1 || !P2) return NULL;



	t1 = P1; t2 = P2;

	P = (Polynomial)malloc(sizeof(struct PolyNode)); P->link = NULL;//先申请一个空结点P
	Rear = P;//让Rear指向这个空结点P

	//构造初始的多项式
	while (t2) {//先用P1的第一项乘以P2，得到P
		Attach(t1->coef * t2->coef, t1->expon + t2->expon, &Rear);
		t2 = t2->link;//t2往后挪

	}
	t1 = t1 ->link;
	while (t1) {//对t1的每一项进行循环
		t2 = P2; Rear = P;
		while (t2) {//对t2的每一项进行循环
			e = t1->expon + t2->expon;//指数相加
			c = t1->coef * t2->coef;//系数相乘
			while (Rear->link && Rear->link->expon > e)
				Rear = Rear->link;
			if (Rear->link && Rear->link->expon == e) {//指数相等，则系数相加
				//不需要申请一个新的结点，只要把系数相加即可
				if(Rear->link->coef+c)//判断加完以后系数是否等于0
					Rear->link->coef + c;
				else {//加完以后系数等于0，就把它删掉，把Rear指向的下一个结点删掉
					t = Rear->link;
					Rear ->link = t->link;
					free(t);
				}
			}
			else {//小于的情况
				//申请一个新的结点
				t = (Polynomial)malloc(sizeof(struct PolyNode));
				//把c和e赋给这个结点对应的系数和指数的分量里
				t->coef = c; t->expon = e;
				//把这个新结点插进去，用下面这两个语句
				t->link = Rear->link;
				Rear->link = t; Rear = Rear->link;
			}
			t2 = t2->link;//t2指针往后
		}
		t1 = t1->link;//t1指针往后
	}
	//怎么返回
	t2 = P; P = P->link; free(t2);

	return P;

}

//多项式输出
void PrintPoly(Polynomial P) {
	//输出多项式
	int flag = 0;//辅助调整输出格式用

	//先判别这个P多项式空不空，空则输出0 0，不空，则做下面的循环
	if (!P) { printf("0 0\n"); return; }

	while (P) {
		if (!flag)
			flag = 1;//理解成第一项前面没有空格，后面每一项前面都有空格
		else
			printf(" ");
		printf("%d %d", P->coef, P->expon);
		P = P->link;

		P = P->link;
	}
}