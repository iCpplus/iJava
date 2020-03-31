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
		int height=Integer.parseInt(roomNo.substring(0,2));	//去掉后两位
		int width=Integer.parseInt(roomNo.substring(2,4));	//后两位
		if(height<1||height>HEIGHT||width<1||width>WIDTH) {
			return false;
		}
		else
			return true;
	}
	//查询所有客房
	public void searchAll() {
		for(int i=0;i<rooms.length;i++) {
			//输出客房编号
			for(int j=0;j<rooms[i].length;j++) {
				System.out.print(rooms[i][j].getId()+"\t");
			}
			System.out.println();
			//输出客房状态
			for(int j=0;j<rooms[i].length;j++) {
				System.out.print(rooms[i][j].getCustomerName()==null?"\t":rooms[i][j].getCustomerName()+"\t");
			}
			System.out.println();
			for(int j=1;j<=8*WIDTH;j++)
				System.out.print("-");
			System.out.println();
		}
	}
	//查询指定客房
	public void searchByNo(String roomNo) {
		if(testRoomNo(roomNo)) {
			//分解客房编号
			int height=Integer.parseInt(roomNo.substring(0,2));
			int width=Integer.parseInt(roomNo.substring(2,4));
			System.out.println(rooms[height-1][width-1].getCustomerName()==null?"该客房没有客人":roomNo+"\t"+rooms[height-1][width-1].getCustomerName());			
		}
		else
			System.out.println("没有这个客房");
	}
	//入住
	public int checkIn(String roomNo,String name) {
		if(testRoomNo(roomNo)) {
			int height=Integer.parseInt(roomNo.substring(0,2));
			int width=Integer.parseInt(roomNo.substring(2,4));
			if(rooms[height-1][width-1].in(name)) {
				return 1;			//成功入住
			}
			else
				return 2;			//该客房已有客人入住
		}
		else
			return 3;				//没有这个客房
	}
	//退房
	public int checkout(String roomNo) {
		if(testRoomNo(roomNo)) {
			int height=Integer.parseInt(roomNo.substring(0,2));
			int width=Integer.parseInt(roomNo.substring(2,4));
			if(rooms[height-1][width-1].out()) {
				return 1;			//退房成功
			}
			else
				return 2;			//该房没有客人
		}
		else
			return 3;				//没有这个客房
	}

}
