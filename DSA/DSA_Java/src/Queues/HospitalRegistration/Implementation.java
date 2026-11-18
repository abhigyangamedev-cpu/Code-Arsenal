package Queues.HospitalRegistration;

public class Implementation {
    public static void main(String[] args) {

        HospitalQueue hospital = new HospitalQueue(5);

        hospital.enqueue(101);
        hospital.enqueue(102);
        hospital.enqueue(103);

        System.out.println("\n--- Current Queue ---");
        hospital.display();

        System.out.println("\n--- Next Patient ---");
        System.out.println("Next Patient ID: " + hospital.peek());

        System.out.println("\n--- Serving Patients ---");
        System.out.println("Served Patient ID: " + hospital.dequeue());
        System.out.println("Served Patient ID: " + hospital.dequeue());

        System.out.println("\n--- Updated Queue ---");
        hospital.display();

        hospital.enqueue(104);
        hospital.enqueue(105);
        hospital.enqueue(106);
        hospital.enqueue(107);

        System.out.println("\n--- Testing Overflow ---");
        hospital.enqueue(108);

        System.out.println("\n--- Final Queue ---");
        hospital.display();

        System.out.println("\n--- Serving Remaining Patients ---");
        while (!hospital.isEmpty()) {
            System.out.println("Served Patient ID: " + hospital.dequeue());
        }

        System.out.println("\n--- Testing Underflow ---");
        hospital.dequeue();
    }
}
