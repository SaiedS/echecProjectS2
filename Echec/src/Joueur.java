import java.util.Scanner;

public class Joueur {
	
	public Joueur() {
		
	}
	
	public boolean choixValide(String choix) // verifie si le choix est conforme par rapport aux lettres et chiffres
	{
		choix = choix.toUpperCase(); // met la saisie de l'utilisateur en MAJUSCULE
		if(choix.length() == 2) // verifie que l'utilisateur n'a pas mis plus de 2 caractere à la saisie
		{
			return((choix.charAt(0) >= 'A' && choix.charAt(0) <= 'H') && (choix.charAt(1) >= '0' && choix.charAt(1) <= '7'));
			//verifie si la saisie est entre [A-H] (premier caractere) et [1-7] (deuxieme caractere)
		}
		else return false;		
	}
	
	public String saisieControle(Echiquier echec)
	{
		String deplac; // le choix de la case selon l'affichage sur le terminale
		Scanner choix = new Scanner(System.in);
		deplac = choix.nextLine();	
		
		while(choixValide(deplac) == false) // il resaisie jusqu'a que la saisie soit correcte
		{
			System.out.println(echec);
			System.out.println("Choix non conforme ! Veuillez choisir entre -> [A-H][1-7] : ");
			deplac = choix.nextLine();
		}
		return deplac.toUpperCase(); // en met en majuscule ici comme ça les autres fonctions reprennent à partir de là
	}
	
	public int getColonneSaisie(String choix) // retourne l'indice colonne par rapport au 1er caractere saisie de String choix
	{
		char c ='A'; // quand on increment on a la prochaine lettre
		for(int i = 0 ; i <= 7 ; i++)
		{
			if(choix.charAt(0) == c) // verifie si le premier caractere est egale à char c sinon on increment char c
			{
				return i; //retourne l'indice dans le plateau (conversion de la saisie au coordonnée)
			}
			c++; // pour regarder la prochaine lettre 'A' = 'A' + 1 = 'B' etc
		}
		return 0; // vu que la saisie est verifié avant ça ne retournera jamais 0
	}
	
	public int getLigneSaisie(String choix) // retourne l'indice ligne par rapport au 2eme caractere saisie de String choix
	{
		char l ='0'; // quand on increment on a le prochaine chiffre
		for(int j = 0 ; j <= 7 ; j++)
		{
			if(choix.charAt(1) == l) // verifie si le premier caractere est egale à char l sinon on incremente char l
			{
				return j; //retourne l'indice dans le plateau (conversion de la saisie au coordonnée)
			}
			l++; // '0' = '0' + '1' = '1' etc
		}
		return 0; // vu que la saisie est verifié avant ça ne retournera jamais null
	}
	
	public void setLigneSaisie(String choix, Echiquier echec)
	{
		int ligne;
		ligne = this.getLigneSaisie(choix);
		this.getChoix(choix, echec).setLigne(ligne); //initialise la ligne de la case par rapport à l'echiquier
	}
	
	public void setColonneSaisie(String choix, Echiquier echec)
	{
		int colonne;
		colonne = this.getColonneSaisie(choix);
		this.getChoix(choix, echec).setColonne(colonne); //initialise la colonne de la case par rapport à l'echiquier
	}
	
	public Case getChoix(String choix, Echiquier echec)// retourne la case choisie selon la saisie de l'utilisateur
	{
		int colonne = this.getColonneSaisie(choix); // lettre convertie en colonne
		int ligne = this.getLigneSaisie(choix); // chiffre converti en ligne
		return echec.getCase(ligne,colonne); // l'indice j -> les lettre (colonne) | l'indice i -> pour les chiffres (ligne)
	}
	
	public String choixPiece(Echiquier echec) // verifie si que le 1er choix est bien une piece
	{
		String depart;
		depart = this.saisieControle(echec);
		while(this.getChoix(depart, echec).caseOccupe() == false) // tant que le choix n'est pas une piece il resaisit
		{
			System.out.println("Choix non conforme ! La case choisie n'est pas une pièce : ");
			depart = this.saisieControle(echec);
		}
		return depart;
	}
	
	public String memeChoix(Echiquier echec, String depart)
	{
		String arrive;
		arrive = this.saisieControle(echec);
		while(arrive.equals(depart)) // tant que le choix est le meme que le 1er choix il resaisit
		{
			System.out.println("Choix non conforme ! Vous ne pouvez pas choisir la même case : ");
			arrive = this.saisieControle(echec);
		}
		return arrive;
	}
	
	public void choixDeplacement(Echiquier echec)
	{
		String depart;
		String arrive;
		int colonne = 0;
		int ligne = 0;
		System.out.println("Veuillez choisir la pièce que vous voulez déplacer (exemple : A6)\n"); // 1er choix une piece
		depart = choixPiece(echec); // verifie 1er choix est une piece
		//System.out.println(getChoix(depart, echec) + " -> 1er avec conversion"); // juste pour afficher la case choisie
		this.setColonneSaisie(depart, echec); //setColonne par rapport à la saisie
		this.setLigneSaisie(depart, echec); // setLigne par rapport à la saisie
		
		System.out.println("Veuillez choisir la case que vous voulez\n"); // 2eme choix n'importe quelle case (deplacementValide de chaque piece validera)
		arrive = memeChoix(echec,depart); // verifie si 2eme choix pas egale au premier choix (pas de mouvement surplace)
		this.setColonneSaisie(arrive, echec);
		this.setLigneSaisie(arrive, echec);

		//getChoix(arrive, echec).getPiece().deplacementValide(echec, getChoix(depart, echec), getChoix(arrive, echec));
		//if(getChoix(arrive, echec).getPiece().deplacementValide(echec, getChoix(depart, echec), getChoix(arrive, echec));
	}
		
		
		
		
		
}
