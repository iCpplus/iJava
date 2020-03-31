package hotelManager;

import java.util.Scanner;

import hotelManager.Hotel;

public class Main {

	public static void main(String[] args) {
		Hotel hotel=new Hotel();
		hotel.setName("MiniHilton");
		System.out.println("��ӭ����ס"+hotel.getName()+"�Ƶ�");
		Scanner scn=new Scanner(System.in);
		System.out.println("����������ָ�");
		String command=scn.next();	//��һ����
		String roomNo;
		while(!command.equalsIgnoreCase("quit")) {	//����quit�˳�
			if(command.equalsIgnoreCase("search")) {	//search()����
				String para=scn.next();
				if(para.equals("all")) {
					hotel.searchAll();
				}
				else
					hotel.searchByNo(para);
			}
			else if(command.equalsIgnoreCase("in")) {
				roomNo=scn.next();	//�ͷ����
				String name=scn.next();	//�ͻ�����
				int res=hotel.checkIn(roomNo, name);	//������ס����
				if(res==1) {
					System.out.println(name+"�ɹ���ס��");
				}
				else if(res==2) {
					System.out.println("�ÿͷ����п��ˣ�");
				}
				else if(res==3) {
					System.out.println("�ͷ�����������");
				}
			}
			else if(command.equalsIgnoreCase("out")) {
				roomNo=scn.next();	//�ͷ����
				int res=hotel.checkout(roomNo);	//�����˷�����
				if(res==1) {
					System.out.println(roomNo+"�ɹ��˷���");
				}
				else if(res==2) {
					System.out.println("�ÿͷ����п��ˣ�");
				}
				else if(res==3) {
					System.out.println("�ͷ�����������");
				}
			}
			else {
				System.out.println("û�и�ָ��");
			}
			System.out.println("����������ָ��");
			command=scn.next();	//��һ����	
		}//while
		System.out.println("��ӭ�´ι���"+hotel.getName());
		System.exit(0);
	}

}


