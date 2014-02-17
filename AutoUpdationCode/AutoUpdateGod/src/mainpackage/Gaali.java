package mainpackage;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gaali database table.
 * 
 */

public class Gaali implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int id;

	private String description1;

	private String description2;

	private String description3;

	private String description4;

	private String extra;

	private String gaali;

	private String language;

	private String origin;

	private String pronounciation;

	private String properties;

	private String relatedTo;

	private String uses1;

	private String uses2;

	private String uses3;

	private String uses4;

    public Gaali() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription1() {
		return this.description1;
	}

	public void setDescription1(String description1) {
		this.description1 = description1;
	}

	public String getDescription2() {
		return this.description2;
	}

	public void setDescription2(String description2) {
		this.description2 = description2;
	}

	public String getDescription3() {
		return this.description3;
	}

	public void setDescription3(String description3) {
		this.description3 = description3;
	}

	public String getDescription4() {
		return this.description4;
	}

	public void setDescription4(String description4) {
		this.description4 = description4;
	}

	public String getExtra() {
		return this.extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public String getGaali() {
		return this.gaali;
	}

	public void setGaali(String gaali) {
		this.gaali = gaali;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getPronounciation() {
		return this.pronounciation;
	}

	public void setPronounciation(String pronounciation) {
		this.pronounciation = pronounciation;
	}

	public String getProperties() {
		return this.properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getRelatedTo() {
		return this.relatedTo;
	}

	public void setRelatedTo(String relatedTo) {
		this.relatedTo = relatedTo;
	}

	public String getUses1() {
		return this.uses1;
	}

	public void setUses1(String uses1) {
		this.uses1 = uses1;
	}

	public String getUses2() {
		return this.uses2;
	}

	public void setUses2(String uses2) {
		this.uses2 = uses2;
	}

	public String getUses3() {
		return this.uses3;
	}

	public void setUses3(String uses3) {
		this.uses3 = uses3;
	}

	public String getUses4() {
		return this.uses4;
	}

	public void setUses4(String uses4) {
		this.uses4 = uses4;
	}

}