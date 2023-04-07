package org.suh.account;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "transfer")
public class Transfer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="from_acc")
    private int fromAcc;

    @Column(name="to_acc")
    private int toAcc;

    @Column(name="amount")
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
        Transfer transfer = (Transfer) o;
        return id == transfer.id && fromAcc == transfer.fromAcc && toAcc == transfer.toAcc && amount == transfer.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromAcc, toAcc, amount);
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", fromAcc=" + fromAcc +
                ", toAcc=" + toAcc +
                ", amount=" + amount +
                '}';
    }
}
