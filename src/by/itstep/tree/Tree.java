package by.itstep.tree;


/*


Обход бинарного дерева

) Поход влево
) Поход вправо
) Действие с тек. элементом


1) Макс и минимального значения
2) Суммы всех четных элементов
3) Сумма всех элементов больше 10
3*) Сумма всех элементов больше Х
4) Кол-во элементов с двумя дочерними элементами
5) Кол-во элементов которые имеют одного потомка




 */

public class Tree {

    Node root = null;

    public void add(int x) {
        Node newNode = new Node(x);

        if (root == null) {
            root = newNode;
            return;
        }

        add(newNode, root);
    }


    public void add(Node newNode, Node potentialParent) {
        if (potentialParent.getValue() > newNode.getValue()) {
            if (potentialParent.getLeft() == null)
                potentialParent.setLeft(newNode);
            else
                add(newNode, potentialParent.getLeft());
        } else if (potentialParent.getValue() < newNode.getValue()) {
            if (potentialParent.getRight() == null)
                potentialParent.setRight(newNode);
            else
                add(newNode, potentialParent.getRight());
        }
    }


    int maxLevelValue;

    public int getMaxLevel() {
        maxLevelValue = 0;
        getMaxLevel(root, 0);
        return maxLevelValue;
    }

    private void getMaxLevel(Node current, int level) {
        level++;

        if (maxLevelValue < level)
            maxLevelValue = level;

        if (current.getLeft() != null) {
            getMaxLevel(current.getLeft(), level);
        }

        if (current.getRight() != null) {
            getMaxLevel(current.getRight(), level);
        }
    }


    public void printByLevel(int level) {
        printByLevel(root, 0, level);
    }


    public void printByLevel(Node current, int currentLevel, int level) {
        if (currentLevel == level) {
            System.out.print(current.getValue() + " ");
            return;
        }
        if (current.getLeft() != null)
            printByLevel(current.getLeft(), currentLevel + 1, level);

        if (current.getRight() != null)
            printByLevel(current.getRight(), currentLevel + 1, level);
    }


    public void printTree() {
        printTree(root, getMaxLevel());
    }

    public void printTree(Node current, int level) {
        for (int i = 0; i < level; i++)
            System.out.print("   ");

        System.out.println(current.getValue());

        if (current.getLeft() != null)
            printTree(current.getLeft(), level + 1);

        if (current.getRight() != null)
            printTree(current.getRight(), level + 1);
    }


    public int sum() {
        return sum(root);
    }

    private int sum(Node current) {

        int l = 0;
        if (current.getLeft() != null)
            l = sum(current.getLeft());

        int r = 0;
        if (current.getRight() != null)
            r = sum(current.getRight());

        return l + r + current.getValue();
    }


    //1) Методы вывода Макс и минимального значения

    public int getMaxValue() {

        return getMaxValue(root);

    }

    private int getMaxValue(Node node) {


        int maxValue = Integer.MIN_VALUE;

        if (node.getValue() > maxValue)
            maxValue = node.getValue();

        if (node.getRight() != null)
            maxValue = getMaxValue(node.getRight());


        return maxValue;

    }

    public int getMinValue() {
        return getMinValue(root);
    }

    private int getMinValue(Node node) {
        int minValue = Integer.MAX_VALUE;

        if (node.getValue() < minValue)
            minValue = node.getValue();

        if (node.getLeft() != null)
            minValue = getMinValue(node.getLeft());

        return minValue;

    }

    //2) Метод вывода Суммы всех четных элементов

    public int getSummOfEvenValues() {
        return getSummOfEvenValues(root);
    }

    private int getSummOfEvenValues(Node node) {
        int sum = 0;
        if (node.getValue() % 2 == 0) {
            sum = node.getValue();
        }
        if (node.getLeft() != null)
            sum = sum + getSummOfEvenValues(node.getLeft());

        if (node.getRight() != null)
            sum = sum + getSummOfEvenValues(node.getRight());

        return sum;
    }

    // 3) Метод вывода Суммы всех элементов больше 10

    public int getSummOfValuesMoreTen() {
        return getSummOfValuesMoreTen(root);
    }

    private int getSummOfValuesMoreTen(Node node) {
        int sum = 0;
        if (node.getValue() > 10)
            sum = node.getValue();

        if (node.getLeft() != null)
            sum = sum + getSummOfValuesMoreTen(node.getLeft());

        if (node.getRight() != null)
            sum = sum + getSummOfValuesMoreTen(node.getRight());

        return sum;
    }

    //3*) Метод вывода Суммы всех элементов больше Х

    public int getSumOfValuesMoreX(int x) {
        return getSummOfValuesMoreX(root, x);
    }

    private int getSummOfValuesMoreX(Node node, int x) {
        int sum = 0;
        if (node.getValue() > x)
            sum = node.getValue();

        if (node.getLeft() != null)
            sum = sum + getSummOfValuesMoreX(node.getLeft(), x);

        if (node.getRight() != null)
            sum = sum + getSummOfValuesMoreX(node.getRight(), x);

        return sum;
    }

    //4) Метод, который выводит Кол-во элементов с двумя дочерними элементами

    public int getQuantityOfParentsOfTwo() {
        return getQuantityOfParentsOfTwo(root);
    }

    private int getQuantityOfParentsOfTwo(Node node) {
        int count = 0;
        if (node.getLeft() != null && node.getRight() != null)
            count = 1;

        if (node.getLeft() != null)
            count = count + getQuantityOfParentsOfTwo(node.getLeft());

        if (node.getRight() != null)
            count = count + getQuantityOfParentsOfTwo(node.getRight());

        return count;

    }

    //5) Метод,который выводит кол-во элементов которые имеют одного потомка

    public int getQuantityOfParentsOfOnlyOne() {
        return getQuantityOfParentsOfOnlyOne(root);
    }

    private int getQuantityOfParentsOfOnlyOne(Node node) {
        int count = 0;
        if ((node.getLeft() != null && node.getRight() == null) || (node.getLeft() == null && node.getRight() != null))
            count = 1;

        if (node.getLeft() != null)
            count = count + getQuantityOfParentsOfOnlyOne(node.getLeft());

        if (node.getRight() != null)
            count = count + getQuantityOfParentsOfOnlyOne(node.getRight());

        return count;

    }


}
















