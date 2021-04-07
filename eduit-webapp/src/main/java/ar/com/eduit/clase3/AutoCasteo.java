package ar.com.eduit.clase3;

import ar.com.eduit.clase2.Auto;

public class AutoCasteo {

	public static void main(String[] args) {
		
		Vehiculo v1 = new Auto();
		Auto a1 = new Auto();
		
		Vehiculo v2 = new Avion();
		Avion av1 = new Avion();
		
		Vehiculo v3 = new Vehiculo();
				
		//CASTEO
		Vehiculo vaux = (Vehiculo)a1;//ctrl+shit+i
		//Auto av1a = (Auto)av1; Cannot cast from Avion to Auto
		
		Auto aux = (Auto)v3; //NO 
		Auto avion = (Auto)v3; //NO
	}

}
