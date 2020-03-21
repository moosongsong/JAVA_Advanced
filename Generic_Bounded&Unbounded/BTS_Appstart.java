public class BTS_Appstart {
	public static void main(String [] args) {
		Course<RJ> rj = new Course("sksk", 20);
//		rj.add(new JIN("ekek", "ekek"));//불가....
		rj.add(new RJ("알제이", "알기역", 30));//담을 수 있음. 담길때는 상한 값 JIN으로 담긴다.
		rj.showList();
	}
}
