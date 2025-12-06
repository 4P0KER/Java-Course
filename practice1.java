class EndlessCycle{
    public void main(String[] args){

        int inner = 0;
        while (true){
            System.out.println("Данный цикл является бесконечным");
            inner++;
            if (inner == 5){
                break;
            }
        }

        inner = 0;
        do {
            System.out.println("  Внутренний цикл: " + inner);
            inner++;
            // Внутренний цикл бесконечен из-за условия
        } while (inner > 0);  // inner всегда > 0

    }
}