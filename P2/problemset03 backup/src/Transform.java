import java.util.*;
import java.awt.Point;
import java.awt.geom.AffineTransform; //NEW
import java.awt.geom.Point2D;

public class Transform {
	
	private Stack<ITransformation> stackTransformationen;
	private Point2D p;
	private Point2D startPunkt;
	private Point2D zielPunkt;
	private Point2D aktuellerPunkt;
	
	public Transform()
	{
		//Konstruktor
		this.stackTransformationen = new Stack<ITransformation>(); 
		aktuellerPunkt=new Point2D.Double(0, 0);	//TODO: ALS BSP (0,0)
	}
	
	public void addTransformation(String description) {			//KOMMENTAR: LUKAS KELLER: Hier werden Befehle eingelesen, auf Korrektheit geprüft und falls sie korrekt sind in Stack aufgenommen
		
		String transformationsArt=getTranformationArt(description).toLowerCase();
		String restString=getStringOhneTransformationsart(description).toLowerCase();
		
		if (transformationsArt.matches("translate"))
		{
			System.out.println("Mache Translate!");
			double x;
			double y;
			String strX=getStringBisZumNächstenLeerzeichen(restString);
			String strY=getStringNachNächstemLeerzeichen(restString);
			
			System.out.println("strX = " +strX + "   strY = " +strY);
			x=Double.parseDouble(strX);
			y=Double.parseDouble(strY);
			
			p.setLocation(x, y);
			
			Translate translate=new Translate(p);
			
			stackTransformationen.push(translate);
			System.out.println("Der eingegebene Befehl 'translate' wurde in den Stack aufgenommen");
			
			
		}
		else if(transformationsArt.matches("rotate"))
		{
			System.out.println("Mache Rotate!");
			double x;
			String richtung;
			String strX=getStringBisZumNächstenLeerzeichen(restString);
			
			x=Double.parseDouble(strX);
			richtung=getStringNachNächstemLeerzeichen(restString).toLowerCase();
			
			Rotate rotate=new Rotate(x,richtung);
			
			stackTransformationen.push(rotate);
			
			System.out.println("Der eingegebene Befehl 'rotate' wurde in den Stack aufgenommen");
		}
		else if(transformationsArt.matches("scale"))
		{
			System.out.println("Mache Scale!");
			double skalierung;
		
			String strSkalierung=getStringBisZumNächstenLeerzeichen(restString);
			
			skalierung=Double.parseDouble(strSkalierung);
			
			Scale scale=new Scale(skalierung);
			
			stackTransformationen.push(scale);
			
			System.out.println("Der eingegebene Befehl 'scale' wurde in den Stack aufgenommen");
		}
		else
		{
			System.out.println("Fehler in der Klasse Transform in der Methode addTransformation() eingetreten: Ungültiger Befehl eingeben!");
			System.out.println("Der eingegebenen Befehl war: " +transformationsArt);
			//TODO: Gib eine Exception zurück	
		}
	}

	public AffineTransform getAffineTransform(){//Point2D startPunkt, Point2D zielPunkt) {			//KOMMENTAR: LUKAS KELLER: Hier werden Befehle umgesetzt; return muss vom Typ AffineTransform sein (vielleicht mittels Interface ITransformation eine neue Klasse AffineTransform schreiben?)
		//Modify here
		
		//this.startPunkt=startPunkt;
		//this.zielPunkt=zielPunkt;
		//this.aktuellerPunkt=startPunkt;
		
		while(!this.stackTransformationen.empty())
		{
			ITransformation aktuelleTransformation=this.stackTransformationen.pop();
			
			aktuellerPunkt=aktuelleTransformation.transform(aktuellerPunkt);
			System.out.println("Mache Transformation");
			
		}
		
		System.out.println("STACK ERFOLGREICH ABGEARBEITET!");
		AffineTransform aTrans=new AffineTransform();
		
		aTrans.transform(startPunkt, aktuellerPunkt);  //??
		System.out.println("FERTIGE TRANSFORM: " +aTrans.toString());
		return aTrans;
		
		
	}
	
	private String getTranformationArt(String description)
	{
		return getStringBisZumNächstenLeerzeichen(description).toLowerCase();
	}
	
	private String getStringBisZumNächstenLeerzeichen(String input)
	{
		
		Boolean notEnd=true;
		for(int i=0; i<input.length() && notEnd==true; i++)
		{
			if (input.charAt(i)== ' ')
			{
				notEnd=false;
				return input.substring(0,i).toString();
			}
		}
		System.out.println("Fehler in der Klasse Transform in der Methode getStringBisZumNächstenLeerzeichen() eingetreten: Ungültiger Befehl eingeben!");
		System.out.println("Es wird zurückgegeben: " +input);
		return input; //Falls kein Leerzeichen drin
		
	}
	
	private String getStringNachNächstemLeerzeichen(String input)
	{
		Boolean notEnd=true;
		for(int i=0; i<input.length() && notEnd==true; i++)
		{
			if (input.charAt(i)== ' ')
			{
				notEnd=false;
				return input.substring(i+1,input.length());
			}
		}
		System.out.println("Fehler in der Klasse Transform in der Methode getStringNachNächstemLeerzeichen() eingetreten: Ungültiger Befehl eingeben!");
		return input; //Falls kein Leerzeichen drin
	}
	
	private String getStringOhneTransformationsart(String input)
	{
		return getStringNachNächstemLeerzeichen(input);
	}
}
