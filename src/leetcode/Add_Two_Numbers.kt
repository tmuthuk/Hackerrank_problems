package leetcode


/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
 **/

// LinkedList Implementation
class ListNode(var `val`: Int=0) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var partialSum: ListNode? = null
    var sumNode: ListNode? = null
    var currentNode: ListNode? = ListNode(0)

    var l1Var = l1
    var l2Var = l2

    var carry = 0
    while (l1Var != null || l2Var != null) {
        if (l1Var == null) l1Var = ListNode(0)
        if (l2Var == null) l2Var = ListNode(0)

        var sum = l1Var.`val` + l2Var.`val` + carry
        carry = sum/10
        sum = if (sum > 9) sum % 10 else sum

        sumNode = ListNode(sum)

        if (partialSum != null) {
            currentNode?.`val` = sumNode.`val`
            if ((l1Var.next !=null || l2Var.next!= null) || carry != 0) currentNode?.next = ListNode(0)
            currentNode = currentNode?.next
        }
        else {
            partialSum = sumNode // first node
            if ((l1Var.next !=null || l2Var.next!= null) || carry != 0) partialSum.next = ListNode(0)
            currentNode = partialSum.next
        }

        l1Var = l1Var.next
        l2Var = l2Var.next
    }

    if (carry != 0)
        currentNode?.`val` = carry


    return partialSum

}