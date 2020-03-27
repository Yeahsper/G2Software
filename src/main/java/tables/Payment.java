package tables;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", unique = true)
    private int payment_id;

    @Column(name = "amount", nullable = false)
    private String amount;

    @Column(name = "payment_date", nullable = false)
    private String payment_date;

    @Column(name = "last_update", nullable = false)
    private String last_update;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;

    @OneToOne
    @JoinColumn(name = "staff_id")
    private Staff staff_obj;

    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental_obj;

    //Constructor
    public Payment() {

    }

    //Getters
    public int getPayment_id() {
        return payment_id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public Staff getStaff_obj() {
        return staff_obj;
    }

    public Rental getRental_obj() {
        return rental_obj;
    }

    public String getAmount() {
        return amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public String getLast_update() {
        return last_update;
    }

    //Setters
    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public void setCustomer_id(Customer customer_id) {
        this.customer_id = customer_id;
    }

    public void setStaff_obj(Staff staff_id) {
        this.staff_obj = staff_id;
    }

    public void setRental_obj(Rental rental_id) {
        this.rental_obj = rental_id;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", amount='" + amount + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", last_update='" + last_update + '\'' +
                ", customer_id=" + customer_id +
                ", staff_id=" + staff_obj +
                ", rental_id=" + rental_obj +
                '}';
    }
}