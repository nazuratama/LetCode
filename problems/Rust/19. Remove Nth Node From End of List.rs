#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
  }
}

impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        let mut dumm = ListNode::new(0);
        dumm.next = head;
        let mut l = &mut dumm as *mut ListNode;
        let mut r = &dumm as *const ListNode;

        unsafe {
            for _ in 0..n {
                r = (*r).next.as_ref().unwrap();
            }

            while (*r).next.is_some() {
                l = (*l).next.as_mut().unwrap();
                r = (*r).next.as_ref().unwrap();
            }
            
            let temp = (*l).next.as_mut().unwrap().next.take();
            (*l).next = temp;
        }
        dumm.next
    }
}