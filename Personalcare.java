class Personalcare extends Product{
	private String desc;
	// wrewr
	Personalcare(){};
	Personalcare(String a, String b, double c, int d, String desc){
		super(a,b,c,d); this.desc=desc;
	}
	//adadwr
	public String display(){
		return ""+ gcode()+"\t"+ gname()+"\t" + gprice()+"\t"+ gquantity()+"\t"+ desc;
		//3r3r3
	}
	//erhwr
}
