package ville;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fields {

	@SerializedName("nom_de_la_commune")
	@Expose
	private String nomDeLaCommune;
	@SerializedName("libell_d_acheminement")
	@Expose
	private String libellDAcheminement;
	@SerializedName("code_postal")
	@Expose
	private String codePostal;
	@SerializedName("coordonnees_gps")
	@Expose
	private List<Double> coordonneesGps = null;
	@SerializedName("code_commune_insee")
	@Expose
	private String codeCommuneInsee;

	public String getNomDeLaCommune() {
		return nomDeLaCommune;
	}

	public void setNomDeLaCommune(String nomDeLaCommune) {
		this.nomDeLaCommune = nomDeLaCommune;
	}

	public String getLibellDAcheminement() {
		return libellDAcheminement;
	}

	public void setLibellDAcheminement(String libellDAcheminement) {
		this.libellDAcheminement = libellDAcheminement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public List<Double> getCoordonneesGps() {
		return coordonneesGps;
	}

	public void setCoordonneesGps(List<Double> coordonneesGps) {
		this.coordonneesGps = coordonneesGps;
	}

	public String getCodeCommuneInsee() {
		return codeCommuneInsee;
	}

	public void setCodeCommuneInsee(String codeCommuneInsee) {
		this.codeCommuneInsee = codeCommuneInsee;
	}

}