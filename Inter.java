import java.util.Scanner;


import java.util.Scanner;

public class Inter {
   static int N;
   static int xmin, ymin, xmax, ymax;
   static int Px, Py, Qx, Qy;
   static int cnt, olap;
   
   static void Twist(int x1, int y1, int x2, int y2) {
      long t1, t2, t3, t4;
      //-----------------------------------------
      t1 = CCW(x1, y1, x2, y2, Px, Py);
      t2 = CCW(x1, y1, x2, y2, Qx, Qy);
      t3 = CCW(Px,Py,Qx,Qy, x1, y1);
      t4 = CCW(Px,Py,Qx,Qy, x2, y2);
            
//System.out.println(t1+ " " + t2+ " "+t3+ " "+t4);
      if (t1*t2 <0 && t3*t4 <0) cnt +=1;
      else if (t1*t2 == 0 && t3*t4 ==0) {cnt=cnt+1; olap++;} // 꼭지점에서 만남
      else if (t1*t2 == 0 && t3*t4 < 0) cnt=cnt+1;
      else if (t1*t2 <0 &&  t3*t4==0) {cnt=cnt+1; olap++;}
   }

   public static int CheckPt() {
      int xS, yS, xL, yL;
      
      if (Px>= Qx) { xL= Px; xS = Qx;}
      else { xL= Qx; xS = Px;};
      if (Py>= Qy) { yL= Py; yS = Qy;}
      else { yL= Qy; yS = Py;};
      
      if ( ((Px == xmin) && (Qx == xmin)) || ((Px == xmax) && (Qx == xmax))) {
         if (yL < ymin) return 0;
         if (yS > ymax) return 0;
         if (yS == ymax && yL > ymax) return 1;
         if (yL == ymin && yS < ymin) return 1;
         return 4;
      }
      if ( ((Py == ymin) && (Qy == ymin)) || ((Py == ymax) && (Qy == ymax))) {
         if (xL < xmin) return 0;
         if (xS > xmax) return 0;
         if (xS == xmax && xL > xmax) return 1;
         if (xL == xmin && xS < xmin) return 1;
         return 4;
      }
      cnt = 0; olap =0;
      Twist(xmin, ymin, xmax, ymin);
//System.out.println(cnt + " " + olap);
      Twist(xmax, ymin, xmax, ymax);
//System.out.println(cnt + " " + olap);
      Twist(xmin, ymin, xmin, ymax);
//      System.out.println(cnt + " " + olap);
      Twist(xmin, ymax, xmax, ymax);
//      System.out.println(cnt + " " + olap);
      cnt = cnt - olap/2;
      return cnt;
   }

   static long CCW(int Ax, int Ay, int Bx, int By, int Cx, int Cy) {
      long sum = 0;
         
      sum += 1L*Ax* By - 1L*Ay*Bx;
      sum += 1L*Bx* Cy - 1L*By*Cx;
      sum += 1L*Cx* Ay - 1L*Cy*Ax;

      return sum;
   }

   public static void main(String[] args) {

      int i;
      Scanner key = new Scanner(System.in);
      N = key.nextInt();
      
      for (i=0; i<N; i++) {
         xmin = key.nextInt();
         ymin = key.nextInt();
         xmax = key.nextInt();
         ymax = key.nextInt();
         Px = key.nextInt();
         Py = key.nextInt();
         Qx = key.nextInt();
         Qy = key.nextInt();
         System.out.println(CheckPt());
//         System.out.println(xP+ " "+ yP + " "+ xQ + " "+yQ);
      }
      key.close();
   }
}