package Model;

import javax.swing.Icon;


public class Model_Card {
    String name;
    String values;
    String number;
    
    public Model_Card() {
    }

    public Model_Card(String name, String values, String number) {
        this.name = name;
        this.values = values;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getValues() {
        return values;
    }

    public String getNumber() {
        return number;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
}
