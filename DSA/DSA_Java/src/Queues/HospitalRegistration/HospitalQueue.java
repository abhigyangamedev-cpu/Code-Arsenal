
package Queues.HospitalRegistration;

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


}
