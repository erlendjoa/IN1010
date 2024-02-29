public class BinaryTree {

    public static int sumOfAll(Node n) {
        if (n.left == null && n.right == null) {
            return n.val;
        }
        if (n.left == null) return (n.val + sumOfAll(n.right));
        if (n.right == null) return (n.val + sumOfAll(n.left));

        return (n.val + sumOfAll(n.left) + sumOfAll(n.right));
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;

        n3.left = n6;
        n3.right = n7;

        n4.left = n8;
        n4.right = n9;

        n5.left = n10;

        System.out.println(sumOfAll(n1));
    }
}
