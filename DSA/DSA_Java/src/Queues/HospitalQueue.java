
package Queues;

public class HospitalQueue {
    private int[] queue;
    private int front;
    private int rear;

    public HospitalQueue(int capacity) {
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == queue.length - 1;
    }

    public void enqueue(int patientID) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot register patient.");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear++;
        queue[rear] = patientID;

        System.out.println("Patient " + patientID + " registered successfully.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! No patients to serve.");
            return -1;
        }

        int patientID = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front++;
        }

        return patientID;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }

        return queue[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No patients waiting.");
            return;
        }

        System.out.println("Patients waiting:");

        for (int i = front; i <= rear; i++) {
            System.out.println("Patient ID: " + queue[i]);
        }
    }

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
