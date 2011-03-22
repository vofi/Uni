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
		
		//String transformationsArt=getTranformationArt(description).toLowerCase();
		//String restString=getStringOhneTransformationsart(description).toLowerCase();

		String[] Argument;
		Argument=description.split(" ");
		
		
		
		
		String transformationsArt=Argument[0];
		
		
		
		if (transformationsArt.matches("translate"))
		{
			System.out.println("Mache Translate!");
			double x;
			double y;
			//String strX=getStringBisZumNächstenLeerzeichen(restString);
			//String strY=getStringNachNächstemLeerzeichen(restString);
			
			
			x=Double.parseDouble(Argument[1]);
			y=Double.parseDouble(Argument[2]);
			System.out.println("TRANSLATE: X= " +x + "   Y= " +y);
			
			Point2D point=new Point2D.Double(x, y);
			
			Translate translate=new Translate(point);
			
			stackTransformationen.push(translate);
			System.out.println("Der eingegebene Befehl 'translate' wurde in den Stack aufgenommen");
			
			
		}
		else if(transformationsArt.matches("rotate"))
		{
			System.out.println("Mache Rotate!");
			double x;
			String richtung;
			//String strX=getStringBisZumNächstenLeerzeichen(restString);
			
			x=Double.parseDouble(Argument[1]);
			richtung=Argument[2];
			
			System.out.println("ROTATE: X= " +x + "   RICHTUNG= " + richtung);
			
			Rotate rotate=new Rotate(x,richtung);
			
			stackTransformationen.push(rotate);
			
			System.out.println("Der eingegebene Befehl 'rotate' wurde in den Stack aufgenommen");
		}
		else if(transformationsArt.matches("scale"))
		{
			System.out.println("Mache Scale!");
			double skalierung;
		
			//String strSkalierung=getStringBisZumNächstenLeerzeichen(restString);
			
			skalierung=Double.parseDouble(Argument[1]);
			System.out.println("SCALE: sklaierung= " +skalierung);
			
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
		AffineTransform aTrans=new AffineTransform();
		while(!this.stackTransformationen.empty())
		{
			ITransformation aktuelleTransformation=this.stackTransformationen.pop();
			
			
			
			aTrans=aktuelleTransformation.transform(aTrans);
			//this.aktuellerPunkt=aktuelleTransformation.transform(this.aktuellerPunkt);
			System.out.println("Mache Transformation");
			
		}
		
		System.out.println("STACK ERFOLGREICH ABGEARBEITET!");
		
		//aTrans.transform(new Point2D.Double(0, 0), aktuellerPunkt);  //??
		return aTrans;
		
		
	}
	

	
}
