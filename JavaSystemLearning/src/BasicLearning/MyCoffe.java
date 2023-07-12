package BasicLearning;

interface Coffe {

    public void Drink();

    public void Make();

    public void ReFill();

    public boolean isEmpty();
}

public class MyCoffe implements Coffe {
    private int coffeLeft = 100;

    @Override
    public void Drink() {
        coffeLeft -= 10;
        System.out.println("Drinked 10ml coffe, " + coffeLeft + "ml left.");
    }

    @Override
    public void ReFill() {
        coffeLeft = 100;
        System.out.println("ReFilled, " + coffeLeft + "ml left.");
    }

    @Override
    public void Make() {
        System.out.println("Making coffe...");
    }

    @Override
    public boolean isEmpty() {
        return coffeLeft <= 0;
    }
}

class WorkTask {
    public boolean isDone() {
        if (Math.random() > 0.5)
            return true;
        else
            return false;
    }
}

/**
 * I am a Software Developer~
 */
class Main {
    public static void main(String[] args) {
        MyCoffe myCoffe = new MyCoffe();
        WorkTask workTask = new WorkTask();

        while (!workTask.isDone()) {
            if (myCoffe.isEmpty()) {
                myCoffe.Make();
                myCoffe.ReFill();
            } else
                myCoffe.Drink();
        }
    }
}