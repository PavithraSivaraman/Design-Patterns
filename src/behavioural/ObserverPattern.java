package behavioural;

import java.util.ArrayList;
import java.util.List;

// Observer interface
interface Observer {
    void update(int temperature);
}

// Subject
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer Implementation
class DisplayDevice implements Observer {
    private String name;

    public DisplayDevice(String name) {
        this.name = name;
    }

    @Override
    public void update(int temperature) {
        System.out.println(name + " Display: Temperature updated to " + temperature + "°C");
    }
}

// Main class
public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        DisplayDevice mobile = new DisplayDevice("Mobile");
        DisplayDevice window = new DisplayDevice("Window");

        station.registerObserver(mobile);
        station.registerObserver(window);

        station.setTemperature(25);
    }
}
