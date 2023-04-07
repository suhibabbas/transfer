package org.suh.account;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="acc_Num")
    private int accNum;

    @Column(name="acc_Name")
    private String accName;

    @Column(name="amount")
    private int amount;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return id == model.id && accNum == model.accNum && amount == model.amount && Objects.equals(accName, model.accName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accNum, accName, amount);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", accNum=" + accNum +
                ", accName='" + accName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
