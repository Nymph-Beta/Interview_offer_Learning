#### 剑指offer52. 两个链表第一个公共节点

```
输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）

数据范围：n≤1000
要求：空间复杂度 O(1)，时间复杂度 O(n)

示例1
输入：{1,2,3},{4,5},{6,7}
返回值：{6,7}
 
示例2
输入：{1},{2,3},{}
返回值：{}

```

#### 题解:双指针

```
两个链表长度分别为L1+C、L2+C， C为公共部分的长度
故L1+C+L2 = L2+C+L1
a指针从链表1走了L1+C步后，回到链表2起点走L2步；b指针从链表2走了L2+C步后，回到链表1起点走L1步。 a.b指针走的步数都为L1+L2+C

ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> nodesInA = new HashSet<>();
        ListNode curA = headA;
        while(curA != null){
            nodesInA.add(curA);
            curA = curA.next;
        }
  
        ListNode curB = headB;
        while(curB != null){
            if(nodesInA.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

```
