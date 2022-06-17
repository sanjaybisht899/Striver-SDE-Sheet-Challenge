/**
 * RemoveCurrentNode
 */
public class RemoveCurrentNode {
    public static void deleteNode(LinkedListNode<Integer> node) {
		if(node==null){
            return;
        }
        node.data=node.next.data;
        node.next=node.next.next;
	}
}