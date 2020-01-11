package codeGround;

import java.util.Scanner;
import java.util.ArrayList;

public class Chemical {
	static int Answer;
	static String[] tmp= {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al",
			"Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe",
			"Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr",
			"Y","Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb",
			"Te", "I", "Xe", "Cs", "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au",
			"Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Rf", "Db", "Sg",
			"Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Fl", "Lv", "La", "Ce", "Pr", "Nd",
			"Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac",
			"Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
			"No", "Lr"};
	static ArrayList<String> list=new ArrayList<String>();
	static boolean find(String s) {
		if(list.contains(s))
			return true;
		else return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(String s:tmp)
			list.add(s.toLowerCase());
		for(int test_case=0;test_case<T;test_case++) {
			String s=sc.next();
			s.toLowerCase();
			boolean[] check=new boolean[s.length()+1];
			check[0]=true;
			check[1]=find(s.charAt(0)+"");
			for(int i=2;i<=s.length();i++) {
				check[i]=(check[i-1]&&find(s.charAt(i-1)+""))||(check[i-2]&&find(s.substring(i-2,i)));
			}
			System.out.println("Case #"+(test_case+1));
			if(check[s.length()]==true)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

}
