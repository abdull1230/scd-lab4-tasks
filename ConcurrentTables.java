public class ConcurrentTables {

    // Sample data for roll numbers and dates of birth
    static String[] studentRollNumbers = {
        "2019-SE-092", "2020-SE-093", "2021-SE-094", "2022-SE-095", "2023-SE-096"
    };

    static String[] datesOfBirth = {
        "05-April", "15-May", "10-June", "20-July", "30-August"
    };

    // Function to print student roll numbers
    public static void printRollNumbers() {
        System.out.println("Roll Number Table:");
        for (String rollNumber : studentRollNumbers) {
            try {
                Thread.sleep(1000);  // Simulating a delay to show concurrent printing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(rollNumber);
        }
    }

    // Function to print dates of birth
    public static void printDatesOfBirth() {
        System.out.println("\nDate of Birth Table:");
        for (String dob : datesOfBirth) {
            try {
                Thread.sleep(1000);  // Simulating a delay to show concurrent printing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(dob);
        }
    }

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printRollNumbers();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printDatesOfBirth();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nTables printed concurrently!");
    }
}

