package com.hcl.coronathreat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name="coronastates")


@NamedQueries({
    @NamedQuery(
        name = "findAccountById",
        query = "from CoronalistEntity a where a.id = :id"
        ),
    @NamedQuery(
            name = "findbyStateAndCity",
            query = "from CoronalistEntity a where a.state = :state AND a.city = :city"
		),
    @NamedQuery(
            name = "findbyState",
            query = "from CoronalistEntity a where a.state = :state"
		),
})
public class CoronalistEntity {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer sno;
	 @Column(name="State")
	 private String state;
	 @Column(name="City")
	  private String city;
	 @Column(name="Male")
	  private String male;
	 @Column(name="Female")
		private String female;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	  public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getFemale() {
		return female;
	}

	public void setFemale(String female) {
		this.female = female;
	}

	
	  

}
