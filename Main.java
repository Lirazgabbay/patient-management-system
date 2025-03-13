/**
 * The Main class purpose is to run the manager methodes and check if they are
 * working correctly.
 */
public class Main {
    /**
     * The function simulateEnqueueTimesSeparation adds 5 different Patients with
     * different priorities into a Manager object it gets as input.
     * 
     * @param manager
     */
    public static void simulateEnqueueTimesSeparation(Manager<Patient> manager) {
        try {
            for (int i = 0; i < 5; i++) {
                int rnd = (int) (Math.random() * 10);
                boolean isvip;
                if (rnd > 5) {
                    isvip = true;
                } else {
                    isvip = false;
                }
                manager.add(new Patient(rnd, isvip));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * the functiona simulateOnlyByPriority that gets as input a Manager
     * object, removes all patients by priority and prints their details.
     */
    public static void simulateOnlyByPriority(Manager<Patient> manager) {
        while (!manager.isEmpty()) {
            System.out.println(manager.getByPriority());
        }

    }

    /**
     * a function simulateOnlyByCreation that gets as input a Manager
     * object, removes all patients by creation time and prints their details.
     * 
     * @param manager
     */
    public static void simulateOnlyByCreation(Manager<Patient> manager) {
        while (!manager.isEmpty()) {
            System.out.println(manager.getByCreationTime());
        }
    }

    /**
     * a main function that creates a Manager object, and calls the above functions.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Manager<Patient> manager = new Manager<Patient>();
        simulateEnqueueTimesSeparation(manager);
        simulateOnlyByPriority(manager);
        simulateEnqueueTimesSeparation(manager);
        simulateOnlyByCreation(manager);

    }
}
