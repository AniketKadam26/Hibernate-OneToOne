package Domain;

import javax.persistence.*;

@Entity
@Table(name="passport_info")
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="passport_id")
    private int paassportId;
    @Column(name="passport_no")
    private String passportNo;
    @Column(name="country")
    private String countryName;

    public int getPaassportId() {
        return paassportId;
    }

    public void setPaassportId(int paassportId) {
        this.paassportId = paassportId;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    @Override
    public String toString() {
        return paassportId+"\t"+passportNo+"\t"+countryName;
    }
}
