public abstract class Animal {
	protected String name;

	public Animal(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "Animal [name=" + name + "]";
//	}
	
	@Override
	public String toString() {
		return name;
	}
}
