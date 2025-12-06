class NoBreak {
    public static void main(String[] args) {

        int i = 0;
        int value = 2;

        switch (value) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2; // Из-за отсутствия break вместо остановки произойдет переход в case 3
            case 3:
                i = 3;
                break;
        }

        // Таким образом, код выведет 3, а не 2
        System.out.println("Value = " + value);
        System.out.println("После switch i = " + i);

    }
}