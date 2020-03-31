package hotelManager;

import hotelManager.Room;

public class Hotel {
	private String hotelName;
	static int HEIGHT=6;
	static int WIDTH=12;
	Room[][] rooms;
	
	public Hotel() {
		rooms=new Room[HEIGHT][WIDTH];
		for(int i=0;i<rooms.length;i++) {
			for(int j=0;j<rooms[i].length;j++) {
				rooms[i][j]=new Room();
				rooms[i][j].setId(i+1, j+1);
			}
		}
	}
	public void setName(String hotelName) {
		this.hotelName=hotelName;
	}
	public String getName() {
		return this.hotelName;
	}
	private boolean testRoomNo(String roomNo) {
		int height=Integer.parseInt(roomNo.substring(0,2));	//ȥ������λ
		int width=Integer.parseInt(roomNo.substring(2,4));	//����λ
		if(height<1||height>HEIGHT||width<1||width>WIDTH) {
			return false;
		}
		else
			return true;
	}
	//��ѯ���пͷ�
	public void searchAll() {
		for(int i=0;i<rooms.length;i++) {
			//����ͷ����
			for(int j=0;j<rooms[i].length;j++) {
				System.out.print(rooms[i][j].getId()+"\t");
			}
			System.out.println();
			//����ͷ�״̬
			for(int j=0;j<rooms[i].length;j++) {
				System.out.print(rooms[i][j].getCustomerName()==null?"\t":rooms[i][j].getCustomerName()+"\t");
			}
			System.out.println();
			for(int j=1;j<=8*WIDTH;j++)
				System.out.print("-");
			System.out.println();
		}
	}
	//��ѯָ���ͷ�
	public void searchByNo(String roomNo) {
		if(testRoomNo(roomNo)) {
			//�ֽ�ͷ����
			int height=Integer.parseInt(roomNo.substring(0,2));
			int width=Integer.parseInt(roomNo.substring(2,4));
			System.out.println(rooms[height-1][width-1].getCustomerName()==null?"�ÿͷ�û�п���":roomNo+"\t"+rooms[height-1][width-1].getCustomerName());			
		}
		else
			System.out.println("û������ͷ�");
	}
	//��ס
	public int checkIn(String roomNo,String name) {
		if(testRoomNo(roomNo)) {
			int height=Integer.parseInt(roomNo.substring(0,2));
			int width=Integer.parseInt(roomNo.substring(2,4));
			if(rooms[height-1][width-1].in(name)) {
				return 1;			//�ɹ���ס
			}
			else
				return 2;			//�ÿͷ����п�����ס
		}
		else
			return 3;				//û������ͷ�
	}
	//�˷�
	public int checkout(String roomNo) {
		if(testRoomNo(roomNo)) {
			int height=Integer.parseInt(roomNo.substring(0,2));
			int width=Integer.parseInt(roomNo.substring(2,4));
			if(rooms[height-1][width-1].out()) {
				return 1;			//�˷��ɹ�
			}
			else
				return 2;			//�÷�û�п���
		}
		else
			return 3;				//û������ͷ�
	}

}
