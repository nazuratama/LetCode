// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
// 
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }
impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        let mut head = Some(Box::new(ListNode::new(0)));
        let mut curr = head.as_mut().unwrap();
        let mut c = 0;
        let mut l1 = l1;
        let mut l2 = l2;

        while l1.is_some() || l2.is_some() || c > 0 {
            let v1 = match l1 {
                Some(node) => {
                    l1 = node.next;
                    node.val
                },
                None => 0,
            };
            let v2 = match l2 {
                Some(node) => {
                    l2 = node.next;
                    node.val
                },
                None => 0,
            };

            let sum = v1 + v2 + c;
            c = sum / 10;
            curr.next = Some(Box::new(ListNode::new(sum % 10)));
            curr = curr.next.as_mut().unwrap();
        }
        head.unwrap().next
    }
}