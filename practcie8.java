interface Messenger{
    public void sendMessage();
}

class Telegram implements Messenger{
    public void sendMessage(){
        System.out.println("Отправлено сообщение в Telegram.");
    }
}

class WhatsApp implements Messenger{
    public void sendMessage(){
        System.out.println("Отправлено сообщение в WhatsApp.");
    }
}

class Example{
    static void main(String[] args){

        var messenger1 = new Telegram();
        var messenger2 = new WhatsApp();

        messenger1.sendMessage();
        messenger2.sendMessage();
    }
}