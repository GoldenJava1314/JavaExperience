package 序列化;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // 原始物件
        Person originalPerson = new Person("John Doe", 30);
        
        // 序列化檔案路徑
        String filename = "person.ser";

        // -------------------------------------
        // 步驟一：序列化 (writeObject)
        // -------------------------------------
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println("Original Person: " + originalPerson);
            oos.writeObject(originalPerson);
            System.out.println("Serialization successful. Object saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("-------------------------------------");

        // -------------------------------------
        // 步驟二：反序列化 (readObject)
        // -------------------------------------
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("Deserialized Person: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
