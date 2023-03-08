package Domain;

import javax.persistence.*;

@Entity
@Table(name="citizen_info")
public class Citizen {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="citizen_id")
    private int citizenId;
    @Column(name="citizen_name")
    private String citizeName;
    @Column(name="citizen_age")
    private int citizenAge;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="passport_ref")
    private Passport passportRef;

    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizeName() {
        return citizeName;
    }

    public void setCitizeName(String citizeName) {
        this.citizeName = citizeName;
    }

    public int getCitizenAge() {
        return citizenAge;
    }

    public void setCitizenAge(int citizenAge) {
        this.citizenAge = citizenAge;
    }

    public Passport getPassportRef() {
        return passportRef;
    }

    public void setPassportRef(Passport passportRef) {
        this.passportRef = passportRef;

    }
    @Override
    public String toString() {
        return citizenId+"\t"+citizeName+"\t"+citizenAge+"\t"+passportRef;
    }
}
