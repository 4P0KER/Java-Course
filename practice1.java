class SizeExample {

    enum Size {
        S("Маленький", 48),
        M("Средний", 50),
        L("Большой", 52),
        XL("Очень большой", 54);

        private String description;
        private int euroSize;

        Size(String description, int euroSize) {
            this.description = description;
            this.euroSize = euroSize;
        }

        public String getDescription() {
            return description;
        }

        public int getEuroSize() {
            return euroSize;
        }
    }

    public static void main(String[] args) {
        Size mySize = Size.M;

        System.out.println("Мой размер: " + mySize);
        System.out.println("Описание: " + mySize.getDescription());
        System.out.println("Европейский размер: " + mySize.getEuroSize());
    }
}