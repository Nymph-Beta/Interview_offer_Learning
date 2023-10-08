#### 剑指offer25.合并两个排序的链表

```
输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
数据范围： 0≤n≤1000，−1000≤节点值≤1000
要求：空间复杂度 O(1)，时间复杂度 O(n)

如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出{1,2,3,4,5,6}

示例1
 输入：{1,3,5},{2,4,6}
 返回值：{1,2,3,4,5,6}

示例2
 输入：{},{}
 返回值：{}

示例3
 输入：{-1,2,4},{1,3,4}
 返回值：{-1,1,2,3,4,4}
```

#### 方法一: 双指针(迭代)

```
	ListNode head = new ListNode(-1);
        ListNode cur = head;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next =  l1;
                l1 = l1.next;
            }else{
                cur.next =  l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }
```

#### 方法二: 递归

```
返回 l1指向的结点和 l2 指向的结点中，值较小的结点
并将从下级函数获得的返回值，链接到当前结点尾部

当 l1 为空，或 l2 为空，函数结束
返回 l1 或 l2 中剩下的部分

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	if(l1 == null) return l2;
        if(l2 == null) return l1;

        if(l1.val <= l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
}

```
