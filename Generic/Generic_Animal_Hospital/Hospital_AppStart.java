public class Hospital_AppStart {

	public static void main(String[] args) {
		AnimalHospital<Animal> ah = new AnimalHospital<Animal>(10);
		ah.treat(new Cat());
		ah.treat(new Cat());
		ah.treat(new Dog());
		ah.treat(new Cat());
		ah.treat(new Dog());
		ah.showList();
	}

}
