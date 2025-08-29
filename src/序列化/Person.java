package 序列化;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Person implements Serializable {

    private final String name;
    private final int age;

    // 建構子
    public Person(String name, int age) {
        // 驗證輸入資料，確保物件狀態正確
        if (name == null || name.isEmpty() || age < 0) {
            throw new IllegalArgumentException("Invalid data for Person object.");
        }
        this.name = name;
        this.age = age;
    }

    // 實作 writeReplace 方法
    // 在序列化時被呼叫，用來回傳一個序列化代理
    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    // 實作 readObject 方法
    // 這個方法會阻止預設的反序列化行為，並拋出例外
    // 這是序列化代理模式的關鍵部分
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required for deserialization.");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    // getter 方法
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // -------------------------------------
    // 2. 序列化代理類別 (靜態內部類別)
    // -------------------------------------
    private static class SerializationProxy implements Serializable {
        private final String proxyName;
        private final int proxyAge;

        // 代理物件的建構子
        // 它只負責從 Person 物件中複製需要序列化的資料
        SerializationProxy(Person person) {
            this.proxyName = person.getName();
            this.proxyAge = person.getAge();
        }

        // 實作 readResolve 方法
        // 在反序列化代理物件時被呼叫
        // 這裡會建立並回傳一個新的 Person 物件
        private Object readResolve() {
            // 在這裡進行最終的物件建構和資料驗證
            return new Person(proxyName, proxyAge);
        }
    }
}

