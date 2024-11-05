package lab4;

class Main extends Thread {
    public void run() {
        System.out.println("task one");
    }

    public static void main(String args[]) {
        Main t1 = new Main();  // Create first thread
        Main t2 = new Main();  // Create second thread
        Main t3 = new Main();  // Create third thread

        t1.start();  // Start the first thread
        t2.start();  // Start the second thread
        t3.start();  // Start the third thread
    }
}