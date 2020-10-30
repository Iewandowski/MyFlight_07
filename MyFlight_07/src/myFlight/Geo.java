package myFlight;

public class Geo {
	
	private double latitude;
	private double longitude;
	static int r = 6371;
	
	public Geo(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	
	//EXERCICIO 1 E 2 - LISTA 3
	public static double distancia(Geo geo01, Geo geo02) {
		
		double latUm = geo01.getLatitude();
		double latDois = geo02.getLatitude();
		
		double lonUm = geo01.getLongitude();
		double lonDois = geo02.getLongitude();
		
		double distLat = Math.toRadians(latDois-latUm);
		double distLon = Math.toRadians(lonDois-lonUm);
		
		double a = Math.sin(distLat / 2) * Math.sin(distLat / 2) + Math.cos(Math.toRadians(latUm)) * Math.cos(Math.toRadians(latDois)) * 
				Math.sin(distLon / 2) * Math.sin(distLon / 2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		double distancia = r * c;
		
		return distancia;
	}
	
	public double distancia(Geo geo01) {
		
		double latUm = geo01.getLatitude();
		double lonUm = geo01.getLongitude();
		
		double distLat = Math.toRadians(latUm);
		double distLon = Math.toRadians(lonUm);
		
		double a = Math.sin(distLat / 2) * Math.sin(distLat / 2) + Math.cos(Math.toRadians(latUm)) * Math.cos(Math.toRadians(latUm)) * 
				Math.sin(distLon / 2) * Math.sin(distLon / 2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		double distancia = r * c;
		
		return distancia;
	}
	public String toString() {
		return "(latitude: " + latitude + " longitude: " + longitude + ") ";
	}
}
