import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Sort {
    public void sort(ArrayList<Integer> lst);
}

class BubbleS implements Sort{
    @Override
    public void sort(ArrayList<Integer> lst) {
        bubbleSort(lst);
    }

    static public void bubbleSort(ArrayList<Integer> lst){
        for(int cycle = 0 ;cycle < lst.size(); cycle ++) {
            for(int i = 0 ; i < lst.size() - 1 - cycle; i ++) {
                if(lst.get(i) > lst.get(i + 1)){
                    //swap
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(i + 1));
                    lst.set(i + 1, tmp);
                }
            }
        }
    }
}

class SelectionS implements Sort{
    @Override
    public void sort(ArrayList<Integer> lst) {
        selectionSort(lst);
    }

    static public void selectionSort(ArrayList<Integer> lst) {
        for(int i = 0 ; i < lst.size(); i++) {
            for(int j = i + 1 ; j < lst.size(); j ++) {
                if(lst.get(i) > lst.get(j)){
                    int tmp = lst.get(i);
                    lst.set(i, lst.get(j));
                    lst.set(j, tmp);
                }
            }
        }
    }
}

class SortPrint{
    Sort sort;

    ArrayList<Integer> numList = new ArrayList<>();

    // insert기능
    public void insert(ArrayList<Integer> lst){
        numList = lst;
    }

    // selection 기능
    // 생성자 주입
    public void selection(Sort sort){
        this.sort = sort;
    }

    public void run(){
        sort.sort(numList);
    }

    public void show(){
        System.out.println(sort.getClass().getName());
        System.out.println(Arrays.toString(numList.toArray()));
    }
}

public class Main{
    public static void main(String[] args) {
        SortPrint sp = new SortPrint();

        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(3,3,3,2,1,1,2,3,2,1,2,3,1,2,3,2,1,5,5,2,1,7));

        System.out.println("초기 init ");
        System.out.println(Arrays.toString(lst.toArray()));

        sp.insert(lst);

        sp.selection(new BubbleS());
        sp.run();
        sp.show();

        sp.selection(new SelectionS());
        sp.run();
        sp.show();
    }
}

