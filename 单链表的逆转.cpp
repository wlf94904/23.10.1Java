Ptr Reverse(Ptr head, )
{
	new = head->next;
	old = new->next;
	while () {
		tmp = old->next;//��סλ��
		old->next = new;//ָ���½��
		new = old;old = tmp;//��ǰλ��һ��
	}
	head->next->next = old;
	return new;
}