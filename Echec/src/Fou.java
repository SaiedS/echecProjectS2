public class Fou extends Piece {
	
	public Fou() {
	}
	
	public Fou(String couleur) {
		super(couleur);
		if(couleur == "noir")
		{
			this.nom = "\u265d";
		}
		if(couleur == "blanc")
		{
			this.nom = "\u2657";
		}
	}
	
	public boolean deplacementValide(Echiquier echec, Case depart, Case arrive) {
		
		Case dpt = echec.getCase(depart.getLigne(), depart.getColonne());
		Case arr = echec.getCase(arrive.getLigne(), arrive.getColonne());
		
		/*
		--> case arrivée vide ou pièce couleur opposée
		--> dpt.ligne == arr.ligne+x && dpt.colonne == arr.colonne+x avec 1<X<7
		--> dpt.ligne == arr.ligne+x && dpt.colonne == arr.colonne-x avec 1<X<7
		--> dpt.ligne == arr.ligne-x && dpt.colonne == arr.colonne+x avec 1<X<7
		--> dpt.ligne == arr.ligne-x && dpt.colonne == arr.colonne-x avec 1<X<7
		--> si meme couleur devant, peut se deplacer jusqu'avant le pion meme couleur, pas après
		--> si couleur ennemi devant, peut se deplacer jusqu'au pion ennemi (et le bouffer), pas après
		*/
		
		return false;
	}
	
	public Echiquier seDeplacer(Echiquier echec, Case depart, Case arrive) {
		return echec;
	}
}