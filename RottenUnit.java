import java.util.LinkedList;

class OrangeQueue{
	int x,y,unit;
	OrangeQueue(int i, int j){
		x=i;
		y=j;
	}
}

public class RottenUnit {
	static final int R=4,C=4;
	public static void main(String[] Args){
		int[][] array1={{1,2,1,0},
						{1,0,1,0},
						{1,0,1,0},
						{1,1,1,0}};
		RottenUnit rot = new RottenUnit();
		System.out.println("Unit Time calculated : " + rot.findUnit(array1));
	}

	int findUnit (int[][] array1)
	{
		int num=0;
		boolean flag = false;
		LinkedList<OrangeQueue> q1 = new LinkedList<OrangeQueue>()  ;
		for (int i=0;i<R;i++){
			for (int j=0;j<C;j++){
				if (array1[i][j] == 2)
					q1.add(new OrangeQueue(i,j));
			}
		}
		q1.add(new OrangeQueue(-1,-1));

		while (q1.size()!=0){
			OrangeQueue q2= q1.poll();
			flag = false;
			while (q2.x != -1){
				if (q2.x+1 >=0 && q2.x+1 < 4 && q2.y < 4 && q2.y >=0 && array1[q2.x+1][q2.y] == 1){
					array1[q2.x+1][q2.y] = 2;
					q1.add(new OrangeQueue(q2.x+1,q2.y));
					flag = true;
				}
				if (q2.x-1 >=0 && q2.x-1 < 4 && q2.y < 4 && q2.y >=0 && array1[q2.x-1][q2.y] == 1){
					array1[q2.x-1][q2.y] = 2;
					q1.add(new OrangeQueue(q2.x-1,q2.y));
					flag = true;
				}
				if (q2.x >=0 && q2.x < 4 && q2.y-1 < 4 && q2.y-1 >=0 && array1[q2.x][q2.y-1] == 1){
					array1[q2.x][q2.y-1] = 2;
					q1.add(new OrangeQueue(q2.x,q2.y-1));
					flag = true;
				}
				if (q2.x >=0 && q2.x < 4 && q2.y+1 < 4 && q2.y+1 >=0 && array1[q2.x][q2.y+1] == 1){
					array1[q2.x][q2.y+1] = 2;
					q1.add(new OrangeQueue(q2.x,q2.y+1));
					flag = true;
				}
				q2= q1.poll();
			}
			if (q1.size()!=0) q1.add(new OrangeQueue(-1,-1));
			if (flag) num ++;
		}
		for (int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				if (array1[i][j] == 1)
					return -1;
			}
		}
		return num;
	}
}
