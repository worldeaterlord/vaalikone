package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the puheenjohtaja database table.
 * 
 */
@Entity
@NamedQuery(name="Puheenjohtaja.findAll", query="SELECT p FROM Puheenjohtaja p")
public class Puheenjohtaja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PJ_ID")
	private int pjId;

	private String etunimi;

	private int ika;

	private String pelipaikka;

	private String sukunimi;

	public Puheenjohtaja() {
	}

	public int getPjId() {
		return this.pjId;
	}

	public void setPjId(int pjId) {
		this.pjId = pjId;
	}

	public String getEtunimi() {
		return this.etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public int getIka() {
		return this.ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public String getPelipaikka() {
		return this.pelipaikka;
	}

	public void setPelipaikka(String pelipaikka) {
		this.pelipaikka = pelipaikka;
	}

	public String getSukunimi() {
		return this.sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

}