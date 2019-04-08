package persist;

import java.io.Serializable;

import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EHDOKKAAT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Ehdokkaat.findAll", query = "SELECT e FROM Ehdokkaat e"),
		@NamedQuery(name = "Ehdokkaat.findByEhdokasId", query = "SELECT e FROM Ehdokkaat e WHERE e.ehdokasId = :ehdokasId"),
		@NamedQuery(name = "Ehdokkaat.findBySukunimi", query = "SELECT e FROM Ehdokkaat e WHERE e.sukunimi = :sukunimi"),
		@NamedQuery(name = "Ehdokkaat.findByEtunimi", query = "SELECT e FROM Ehdokkaat e WHERE e.etunimi = :etunimi"),
		@NamedQuery(name = "Ehdokkaat.findByPuolue", query = "SELECT e FROM Ehdokkaat e WHERE e.puolue = :puolue"),
		@NamedQuery(name = "Ehdokkaat.findByKotipaikkakunta", query = "SELECT e FROM Ehdokkaat e WHERE e.kotipaikkakunta = :kotipaikkakunta"),
		@NamedQuery(name = "Ehdokkaat.findByIk\u00e4", query = "SELECT e FROM Ehdokkaat e WHERE e.ika = :ika"),
		@NamedQuery(name = "Ehdokkaat.findByMiksiEduskuntaan", query = "SELECT e FROM Ehdokkaat e WHERE e.miksiEduskuntaan = :miksiEduskuntaan"),
		@NamedQuery(name = "Ehdokkaat.findByMitaAsioitaHaluatEdistaa", query = "SELECT e FROM Ehdokkaat e WHERE e.mitaAsioitaHaluatEdistaa = :mitaAsioitaHaluatEdistaa"),
		@NamedQuery(name = "Ehdokkaat.findByAmmatti", query = "SELECT e FROM Ehdokkaat e WHERE e.ammatti = :ammatti") })

public class LisaaEhdokas implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "EHDOKAS_ID")
	private Integer ehdokasId;
	@Size(max = 25)
	@Column(name = "SUKUNIMI")
	private String sukunimi;
	@Size(max = 25)
	@Column(name = "ETUNIMI")
	private String etunimi;
	@Size(max = 50)
	@Column(name = "PUOLUE")
	private String puolue;
	@Size(max = 25)
	@Column(name = "KOTIPAIKKAKUNTA")
	private String kotipaikkakunta;
	@Column(name = "IKA")
	private Integer ika;
	@Size(max = 250)
	@Column(name = "MIKSI_EDUSKUNTAAN")
	private String miksiEduskuntaan;
	@Size(max = 2_000)
	@Column(name = "MITA_ASIOITA_HALUAT_EDISTAA")
	private String mitaAsioitaHaluatEdistaa;
	@Size(max = 50)
	@Column(name = "AMMATTI")
	private String ammatti;
	public Integer getEhdokasId() {
		return ehdokasId;
	}
	public void setEhdokasId(Integer ehdokasId) {
		this.ehdokasId = ehdokasId;
	}
	public String getSukunimi() {
		return sukunimi;
	}
	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}
	public String getEtunimi() {
		return etunimi;
	}
	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}
	public String getPuolue() {
		return puolue;
	}
	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}
	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}
	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}
	public Integer getIka() {
		return ika;
	}
	public void setIka(Integer ika) {
		this.ika = ika;
	}
	public String getMiksiEduskuntaan() {
		return miksiEduskuntaan;
	}
	public void setMiksiEduskuntaan(String miksiEduskuntaan) {
		this.miksiEduskuntaan = miksiEduskuntaan;
	}
	public String getMitaAsioitaHaluatEdistaa() {
		return mitaAsioitaHaluatEdistaa;
	}
	public void setMitaAsioitaHaluatEdistaa(String mitaAsioitaHaluatEdistaa) {
		this.mitaAsioitaHaluatEdistaa = mitaAsioitaHaluatEdistaa;
	}
	public String getAmmatti() {
		return ammatti;
	}
	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}
	
	
}

