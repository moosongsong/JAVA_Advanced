package ���׸�;

public class BTS_Appstart {
	public static void main(String [] args) {
		Course<RJ> rj = new Course("sksk", 20);
//		rj.add(new JIN("ekek", "ekek"));//�Ұ�....
		rj.add(new RJ("������", "�˱⿪", 30));//���� �� ����. ��涧�� ���� �� JIN���� ����.
		rj.showList();
	}
}
