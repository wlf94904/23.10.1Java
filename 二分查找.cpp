//二分查找算法
int BinarySearch(List Tbl, ElementType K) {
	//在表Tbl中查找关键字为K的数据元素
	int left, right, mid, NoFound = -1;

	left = 1;//初始左边界，左边是数组的第一个元素
	right = Tbl->Length;//初始右边界，右边是数组的最后一个元素
	while (left <= right) {//这个范围有元素存在
		mid = (left + right) / 2;//计算中间元素坐标
		//如果K小于中间的元素值，则找的对象在数组的左边
		if (K < Tbl->Element[mid]) right = mid - 1;//调整右边界
		else if (K > Tbl->Element[mid]) left = mid + 1;//调整左边界
		else return mid;//查找成功，返回数据元素的下标
	}
	return NotFound;//查找不成功，返回-1
}
//每次都除以二除以二
//所以二分查找算法具有对数的时间复杂度O（logN）