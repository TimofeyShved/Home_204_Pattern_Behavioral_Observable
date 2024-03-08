package com.company;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // Паттерн (обсэрвл) заствляет слушать что происходит на стороне и делать свои действия

        System.out.println("Введите текст: ");

        // создаем класс который мы будем слушать
        EventSource eventSource = new EventSource();

        // добовляем слушателя
        eventSource.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("Текст ввели: "+arg);
            }
        });

        // включаем его поток
        new Thread(eventSource).start();
    }
}

// класс в котором мы вводим значения, причём постоянно в потоке
class EventSource extends Observable implements Runnable{
    @Override
    public void run() {
        while (true){
            String repons = new Scanner(System.in).next();
            setChanged();
            notifyObservers(repons);
        }
    }
}
