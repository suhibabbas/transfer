package com.app.transfer;

import java.util.Objects;

public class Model {

    private int id;
    private int fromAcc;
    private int toAcc;
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromAcc() {
        return fromAcc;
    }

    public void setFromAcc(int fromAcc) {
        this.fromAcc = fromAcc;
    }

    public int getToAcc() {
        return toAcc;
    }

    public void setToAcc(int toAcc) {
        this.toAcc = toAcc;
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
        return id == model.id && fromAcc == model.fromAcc && toAcc == model.toAcc && amount == model.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromAcc, toAcc, amount);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", fromAcc=" + fromAcc +
                ", toAcc=" + toAcc +
                ", amount=" + amount +
                '}';
    }
}
