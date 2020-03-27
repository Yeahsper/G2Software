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
    private Customer customer_obj;

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

    public Customer getCustomer_obj() {
        return customer_obj;
    }

    public Staff getStaff_obj() {
        return staff_obj;
    }

    public Rental getRental_id() {
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

    public void setCustomer_id(Customer customer_obj) {
        this.customer_obj = customer_obj;
    }

    public void setStaff_obj(Staff staff_obj) {
        this.staff_obj = staff_obj;
    }

    public void setRental_obj(Rental rental_obj) {
        this.rental_obj = rental_obj;
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
//                ", customer_id=" + customer_obj.getFirst_name() +
//                ", staff_id=" + staff_obj.getStaff_id() +
//                ", rental_id=" + rental_obj.getRental_id() +
                '}';
    }

    // Getters and Setters for GUI Controller
    public int getCustomer_obj_id() { return customer_obj.getCustomer_id();}

    public void setCustomer_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getStaff_obj_id() {
        return staff_obj.getStaff_id();
    }

    public void setStaff_id(int new_id) { /* update id = new_id for THIS Object */ }

    public int getRental_obj_id() {
        return rental_obj.getRental_id();
    }

    public void setRental_id(int new_id) { /* update id = new_id for THIS Object */ }
}