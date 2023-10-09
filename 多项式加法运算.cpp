#include <malloc.h>
#include "����ʽ�ӷ�����.h"
struct PolyNode {
	int coef;//ϵ��
	int expon;//ָ��
	struct PolyNode *link;//ָ����һ���ڵ��ָ��
};
typedef struct PolyNode* Polynomial;
Polynomial P1, P2;//P1,P2�������ֽṹ��ָ��

Polynomial PolyAdd(Polynomial P1, Polynomial P2) {
	Polynomial front, rear, temp;//ָ�����ʽ��ͷ��β
	int sum;
	//������ʱ�սڵ�
	rear = (Polynomial)malloc(sizeof(struct PolyNode));
	front = rear;//��front��¼�������ʽ����ͷ���
	while(P1&&P2)//����������ʽ���з����������ʱ��P1,P2����Ϊ��
		switch (Compare(P1->expon, P2->expon)) {
		case 1:
			Attach(P1->expon, P2->expon,&rear);
			P1 = P1->link;
			break;
		case -1:
			Attach(P2->coef, P2->expon, &rear);
			P2 = P2->link;
			break;
		case 0:
			sum = P1->coef + P2->coef;
			if (sum) Attach(sum, P1->expon, &rear);
			P1 = P1->link;
			P2 = P2->link;
			break;

		}
	//�˳�ѭ����˵����һ��Ϊ���ˣ������һ������Ķ��ӵ��������ʽ��
	//��δ���������һ������ʽ�����н�����θ��Ƶ��������ʽ��
	//P1���գ����ʣ�µĽӵ��������ʽ��
	for (; P1; P1 = P1->link)Attach(P1->coef, P1->expon, &rear);
	for (; P2; P2 = P2->link)Attach(P2->coef, P2-> expon, &rear);
	//ɨβ����
	rear->link = NULL;
	temp = front;
	front = front->link;//��frontָ��������ʽ��һ��������
	free(temp);//�ͷ���ʱ�ձ�ͷ���
	return front;
}

void Attach(int c, int e, Polynomial* pRear) {
	Polynomial P;
	P = (Polynomial)malloc(sizeof(struct PolyNode));
	P->coef = c;//���½�㸳ֵ
	P->expon = e;
	P->link = NULL;
	(*pRear)->link = P;
	*pRear = P;//�޸�pRearֵ
}