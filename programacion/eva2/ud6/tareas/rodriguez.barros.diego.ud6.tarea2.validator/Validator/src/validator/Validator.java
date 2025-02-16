/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package validator;

/**
 *
 * @author diego
 */

public abstract class Validator<T> {
    protected String message;
    protected T object;

    protected Validator() {
        this.message = "";
    }

    protected Validator(T object) {
        this.object = object;
        this.message = "";
    }

    public abstract boolean isValid();

    public String getMessage() {
        return message;
    }
}