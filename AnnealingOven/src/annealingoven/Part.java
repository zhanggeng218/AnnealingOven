package annealingoven;

/**A part in Cycle consists of starting Temperature, ending Temperature and length of time(hours)*/
public class Part {

    public double startTemprature;
    public double endTemprature;
    public double lengthOftime;
	
    public Part(String startTemprature, String endTemprature, String[] lengthOftime) {
        
	this.startTemprature = Double.parseDouble(startTemprature);
	this.endTemprature = Double.parseDouble(endTemprature);
	this.lengthOftime = Double.parseDouble(lengthOftime[0]) * 60 + Integer.parseInt(lengthOftime[1]); 
    }
    
    public Part(String startTemprature, String endTemprature, String lengthOftime) {
        
	this.startTemprature = Double.parseDouble(startTemprature);
	this.endTemprature = Double.parseDouble(endTemprature);
	this.lengthOftime = Double.parseDouble(lengthOftime); 
    }
}
