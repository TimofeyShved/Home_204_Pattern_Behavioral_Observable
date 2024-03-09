package com.company;

import java.util.ArrayList;
import java.util.List;

public class VariantOther {
    public static void main(String[] args) {
        Observer observer1 = new Observer("one");
        Observer observer2 = new Observer("two");
        Observer observer3 = new Observer("three");

        // каждый раз при вызове нового статуса запускается цикл проверки всех статусов
        observer1.setState("sleep");
        observer2.setState("run");
        observer3.setState("stop");
    }
}

// создаём вариацию паттерна (обсэрвл) - заставляет принудительно получить данные всем объектам
interface Observable{
    void upDate();
}

class Observer implements Observable{
    static List<Observer> observers = new ArrayList<>();
    String name;
    String state;

    public Observer(String name) {
        this.name = name;
        observers.add(this);
    }

    public void setState(String state) {
        this.state = state;
        //проверка всех статусов
        notifyAllOservers();
    }

    void notifyAllOservers(){
        for (Observer o: observers){
            o.upDate();
        }
    }

    @Override
    public void upDate() {
        System.out.println(name + " status: " + state);
    }
}