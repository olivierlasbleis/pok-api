package ol.pokwebservice.objects.vues;

public class RangeVue {

	private String main;
	private Double esperance;
	private String couleur;
	
	public RangeVue(String main,Double esperance, String couleur) {
		super();
		this.main = main;
		this.esperance = 100.0 - esperance;
		this.couleur = couleur;
	}
	
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public Double getEsperance() {
		return esperance;
	}
	public void setEsperance(Double esperance) {
		this.esperance = esperance;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public RangeVue() {
		super();
	}
}
