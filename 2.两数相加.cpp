/*
 * @lc app=leetcode.cn id=2 lang=cpp
 *
 * [2] 两数相加
 */
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode* head;
        ListNode* pre;
        int i=0;
        int j=0;

        if(l1==NULL) return l2;
        if(l2==NULL) return l1;
        while(l1!=NULL||l2!=NULL)
        {
            int tmp = 0;
            if(l1!=NULL)
            {
                tmp += l1->val;
                l1 = l1->next;
            }
            if(l2!=NULL)
            {
                tmp += l2->val;
                l2 = l2->next;
            }
            tmp += j;
            
            j = 0;

            if(tmp>9)
            {
                j = 1;
                tmp = tmp%10;
            }

            ListNode* cur = new ListNode(tmp);
            if(i==0)
            {
                head = cur;
                pre = head;
            }else{
                pre->next = cur;
                pre = cur;
            }
            // cur->Val = tmp;

            // l1 = l1->next;
            // l2 = l2->next;

            i++;
        }
        if(j==1)
        {
            ListNode* cur = new ListNode(j);
            pre->next = cur;
        }
        return head;
    }
};

