package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private byte id;
    @OneToOne
    @JoinColumn(name = "manager_staff_id")
    private Staff staff;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date lastUpdate;

public Store () {}

    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


}
