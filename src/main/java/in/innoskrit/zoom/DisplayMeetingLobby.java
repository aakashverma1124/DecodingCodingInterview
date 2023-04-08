package in.innoskrit.zoom;

class Node {
    public String participantName;
    public Node left;
    public Node right;

    public Node(String participantName) {
        this.participantName = participantName;
        this.left = null;
        this.right = null;
    }

    public void insert(String participantName) {

    }
}

class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(String participantName) {
        if(root == null) {
            this.root = new Node(participantName);
        } else {
            this.root.insert(participantName);
        }
    }
}

public class DisplayMeetingLobby {
}
