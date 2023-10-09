Ptr Reverse(Ptr head, )
{
	new = head->next;
	old = new->next;
	while () {
		tmp = old->next;//记住位置
		old->next = new;//指向新结点
		new = old;old = tmp;//往前位移一段
	}
	head->next->next = old;
	return new;
}