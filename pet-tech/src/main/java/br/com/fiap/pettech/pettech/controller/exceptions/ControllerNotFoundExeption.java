package br.com.fiap.pettech.pettech.controller.exceptions;

public class ControllerNotFoundExeption extends RuntimeException{
    public ControllerNotFoundExeption(String mesage) {
        super(mesage);
    }
}
