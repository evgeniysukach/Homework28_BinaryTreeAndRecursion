package by.itstep.tree;


public class Launcher {

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(20);
        tree.add(11);
        tree.add(15);
        tree.add(14);
        tree.add(19);
        tree.add(22);
        tree.add(21);
        tree.add(100);
        tree.add(120);
        tree.add(2);
        tree.add(1);

        System.out.println(tree.getMaxValue());
        System.out.println(tree.getMinValue());
        System.out.println(tree.getSummOfEvenValues());
        System.out.println(tree.getSummOfValuesMoreTen());
        System.out.println(tree.getSumOfValuesMoreX(50));
        System.out.println(tree.getQuantityOfParentsOfTwo());
        System.out.println(tree.getQuantityOfParentsOfOnlyOne());


    }
}
