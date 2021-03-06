import java.util.List;

public class BinaryNode<T extends Comparable<? super T>> {
    private T data;
    private BinaryNode<T> right;
    private BinaryNode<T> left;

    // TODO: initialisation
    // O(1)
    public BinaryNode(T data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }

    // TODO: on retourne la donnee voulue
    // O(1)
    public T getData() {
        return data;
    }

    // TODO: on ajoute une nouvelle donnee au bon endroit
    // O(log(n))
    public void insert(T item) {
        if (item.compareTo(data) <= 0)
            if (left == null)
                left = new BinaryNode<>(item);
            else
                left.insert(item);
        else if (right == null)
            right = new BinaryNode<>(item);
        else
            right.insert(item);
    }

    // TODO: est-ce que l'item fais partie du noeuds courant
    // O(log(n))
    public boolean contains(T item) {
        if (item == data)
            return true;
        if (item.compareTo(data) <= 0 && left != null)
            return left.contains(item);
        else if (right != null)
            return right.contains(item);
        return false;
    }

    // TODO: on retourne la maximale de l'arbre
    // O(n)
    public int getHeight() {
        int heightLeft = 0;
        int heightRight = 0;
        int heightIncrementation = 1;
        if (left != null) {
            heightLeft = heightIncrementation + left.getHeight();
        }
        if (right != null) {
            heightRight = heightIncrementation + right.getHeight();
        }
        return Math.max(heightLeft, heightRight); //O(1)-->math.max parce qu'on compare seul 2 valeurs
    }

    // TODO: l'ordre d'insertion dans la liste est l'ordre logique
    // de manière que le plus petit item sera le premier inseré
    // O(n)
    public void fillListInOrder(List<BinaryNode<T>> result) {
        if (left != null) {
            left.fillListInOrder(result);
        }
        result.add(this);
        if (right != null) {
            right.fillListInOrder(result);
        }
    }
}
