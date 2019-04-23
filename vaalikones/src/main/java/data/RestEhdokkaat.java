package data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class RestEhdokkaat {
	
	public RestEhdokkaat(){
		
	}

	@Id
	private String sukunimi;
	private Integer ehdokasId;
	private String etunimi;
	private String puolue;
	private String kotipaikkakunta;
	private Integer ika;
	private String miksiEduskuntaan;
	private String mitaAsioitaHaluatEdistaa;
	private String ammatti;
	

	public RestEhdokkaat(Integer ehdokasId) {
		this.ehdokasId = ehdokasId;
	}


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
