public abstract class Hospital<T> implements Treatable<T> {
	protected String name;

	public Hospital(String name) {
		this.name = name;
	}
	public abstract void showList();
}
