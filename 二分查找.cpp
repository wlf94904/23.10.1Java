//���ֲ����㷨
int BinarySearch(List Tbl, ElementType K) {
	//�ڱ�Tbl�в��ҹؼ���ΪK������Ԫ��
	int left, right, mid, NoFound = -1;

	left = 1;//��ʼ��߽磬���������ĵ�һ��Ԫ��
	right = Tbl->Length;//��ʼ�ұ߽磬�ұ�����������һ��Ԫ��
	while (left <= right) {//�����Χ��Ԫ�ش���
		mid = (left + right) / 2;//�����м�Ԫ������
		//���KС���м��Ԫ��ֵ�����ҵĶ�������������
		if (K < Tbl->Element[mid]) right = mid - 1;//�����ұ߽�
		else if (K > Tbl->Element[mid]) left = mid + 1;//������߽�
		else return mid;//���ҳɹ�����������Ԫ�ص��±�
	}
	return NotFound;//���Ҳ��ɹ�������-1
}
//ÿ�ζ����Զ����Զ�
//���Զ��ֲ����㷨���ж�����ʱ�临�Ӷ�O��logN��