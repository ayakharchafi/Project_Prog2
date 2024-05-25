/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog2project;

import java.util.Objects;

/**
 *
 * @author ayakh
 */
public class PhoneNumber  {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }
    public boolean isValid(){
        if(number.length()!=10){
            return false;
        }
        if (!number.matches("\\d{10}")){
            return false;
        }
        return true;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneNumber() {
        this.number="";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.number);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhoneNumber other = (PhoneNumber) obj;
        return Objects.equals(this.number, other.number);
    }

    @Override
    public String toString() {
        return number;
    }
    
}
