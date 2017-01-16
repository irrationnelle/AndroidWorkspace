package net.azurewebsites.irrationnelle.ex06.vo;

/**
 * Created by irrationnelle on 1/16/17.
 */

public class ContactVO {
    private String name;
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactVO{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
