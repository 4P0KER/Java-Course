import java.util.Arrays;

class Array{
    public void main(String[] args){
        int a1[] = {1,4,5,2,6};
        int a2[] = {9,2,4,8,10};
        int a3[] = {1,2,4,5,6};

        //toString
        String s1 = Arrays.toString(a1);
        System.out.println("Массив a1: " + s1);

        //sort
        Arrays.sort(a1);
        System.out.println("Отсортированный массив: "+ a1);

        //BinarySearch
        System.out.println("Индекс элемента 6: " + Arrays.binarySearch(a1,6));

        //equals
        System.out.println("Равны ли массивы a1 и a2: " + Arrays.equals(a1,a2));
        System.out.println("Равны ли массивы a1 и a3: " + Arrays.equals(a1,a3));

        //compare
        int cmpResult1 = Arrays.compare(a1, a2);
        System.out.println("Сравнение a1 и a2: " + cmpResult1);
        int cmpResult2 = Arrays.compare(a1,a3);
        System.out.println("Сравнение a1 и a3: " + cmpResult2);
    }
}