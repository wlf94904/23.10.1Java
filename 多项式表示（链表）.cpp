#include<stdio.h>
//�����������ɸ���㹹�ɵ�
#include <malloc.h>
typedef struct PolyNode* Polynomial;//�ṹָ��
struct PolyNode {
	int coef;//ϵ��
	int expon;//ָ��
	//������һ����ָ��ָ����һ�����
	Polynomial link;//ָ��

};

int main() {
	Polynomial P1, P2, PP, PS;//P1��P2��������ṹ��ָ��
	P1 = ReadPoly();//�������ʽ
	P2 = ReadPoly();
	PP = Mult(P1, P2);//�˷�����
	PrintPoly(PP);
	PS = Add(P1, P2);
	PrintPoly(PS);//��ӡ���͵Ķ���ʽ
	return 0;
}

//��ζ������ʽ
Polynomial ReadPoly(){
	Polynomial P, Rear,t;
	int c, e, N;
	scanf_s("%d", &N);//�ȶ����ܵĶ���N
	P = (Polynomial)malloc(sizeof(struct PolyNode));//����ͷ�սڵ�
	P->link = NULL;
	Rear = P;
	while (N--) {
		scanf_s("%d %d", &c, &e);//����ϵ����ָ��
		//Rear�ǵ�ǰ������ʽ�е�β��ָ��
		//����ǰ��������ʽβ��
		Attach(c, e, &Rear);//����һ����㣬��������嵽�������ʽ��

	}
	t = P; P = P->link; free(t);//ɾ����ʱ���ɵ�ͷ���

	return P;

}

void Attach(int c, int e, Polynomial* pRear) {
	Polynomial P;

	P = (Polynomial)malloc(sizeof(struct PolyNode));
	//���½�㸳ֵ
	P->coef = c;
	P->expon = e;
	P->link = NULL;
	(*pRear)->link = P;
	//*pRear��ʾ��ǰ������ʽβ��ָ��
	*pRear = P;//�޸�pRearֵ,pRearʵ������ָ���ָ��
}

//��ν���������ʽ���
Polynomial Add(Polynomial P1, Polynomial P2) {

	t1 = P1; t2 = P2;
	//�ȹ��������ս��
	P = (Polynomial)malloc(sizeof(struct PolyNode));
	P->link = NULL;//����һ���ս��
	Rear = P;//��Rearָ������ս��
	while (t1 && t2) {//��t1��t2�����յ�ʱ�򣬱Ƚ����ǵ�ָ��
		//�����ϵ�����
		if (t1->expon == t2->expon) {

		}
		else if (t1->expon > t2->expon) {

		}
		else {

		}
	}
	//������һ�����治Ϊ�յĽӵ��������ʽ�ĺ��棬�ֱ���t1���յ������t2���յ����
	while (t1) {

	}
	while (t2) {

	}

	return P;//���ؽ������ʽ
}

//��������ʽ���
Polynomial Mult(PolyNode P1, PolyNode P2) {
	
	Polynomial P, Rear, t1, t2, t;
	int c, e;
	if (!P1 || !P2) return NULL;



	t1 = P1; t2 = P2;

	P = (Polynomial)malloc(sizeof(struct PolyNode)); P->link = NULL;//������һ���ս��P
	Rear = P;//��Rearָ������ս��P

	//�����ʼ�Ķ���ʽ
	while (t2) {//����P1�ĵ�һ�����P2���õ�P
		Attach(t1->coef * t2->coef, t1->expon + t2->expon, &Rear);
		t2 = t2->link;//t2����Ų

	}
	t1 = t1 ->link;
	while (t1) {//��t1��ÿһ�����ѭ��
		t2 = P2; Rear = P;
		while (t2) {//��t2��ÿһ�����ѭ��
			e = t1->expon + t2->expon;//ָ�����
			c = t1->coef * t2->coef;//ϵ�����
			while (Rear->link && Rear->link->expon > e)
				Rear = Rear->link;
			if (Rear->link && Rear->link->expon == e) {//ָ����ȣ���ϵ�����
				//����Ҫ����һ���µĽ�㣬ֻҪ��ϵ����Ӽ���
				if(Rear->link->coef+c)//�жϼ����Ժ�ϵ���Ƿ����0
					Rear->link->coef + c;
				else {//�����Ժ�ϵ������0���Ͱ���ɾ������Rearָ�����һ�����ɾ��
					t = Rear->link;
					Rear ->link = t->link;
					free(t);
				}
			}
			else {//С�ڵ����
				//����һ���µĽ��
				t = (Polynomial)malloc(sizeof(struct PolyNode));
				//��c��e�����������Ӧ��ϵ����ָ���ķ�����
				t->coef = c; t->expon = e;
				//������½����ȥ�����������������
				t->link = Rear->link;
				Rear->link = t; Rear = Rear->link;
			}
			t2 = t2->link;//t2ָ������
		}
		t1 = t1->link;//t1ָ������
	}
	//��ô����
	t2 = P; P = P->link; free(t2);

	return P;

}

//����ʽ���
void PrintPoly(Polynomial P) {
	//�������ʽ
	int flag = 0;//�������������ʽ��

	//���б����P����ʽ�ղ��գ��������0 0�����գ����������ѭ��
	if (!P) { printf("0 0\n"); return; }

	while (P) {
		if (!flag)
			flag = 1;//���ɵ�һ��ǰ��û�пո񣬺���ÿһ��ǰ�涼�пո�
		else
			printf(" ");
		printf("%d %d", P->coef, P->expon);
		P = P->link;

		P = P->link;
	}
}