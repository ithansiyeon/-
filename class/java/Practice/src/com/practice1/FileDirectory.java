package com.practice1;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class FileDirectory {
	private static Scanner scan;
	private static int countFile;
	private static int countDir;
	private static 	ArrayList<File> list;
	static {
		scan = new Scanner(System.in);
		countFile=0;
		countDir=0;
		list = new ArrayList<File>();
	}

	public static void main(String[] args) {

		 m1();
		// m2();
		//m3();
		//m4();
		//m5();
		//m6();
		//m7();
		//m8();
		//m9();
		//m10();

	}

	private static void m10() {
		String path = "\\C:\\파일_디렉토리_문제\\직원";
		File dir = new File(path);
		//File[] list = dir.listFiles();
		//String[] name;
		boolean loop = false;
		if(dir.exists()) {
		for(File file:dir.listFiles()) {
			String[] name = file.getName().split("_");
			String mpath = path+"\\"+name[0]+"\\"+name[1];
			File mdir = new File(mpath);
			mdir.mkdirs();
			File moveFile = new File(mdir.getAbsolutePath()+"\\"+file.getName());
			loop = file.renameTo(moveFile);
			
			}
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
		if(loop) {
			System.out.println("분류가 완료되었습니다.");
		} else {
			System.out.println("분류 실패");
		}
		
	}

	private static void m9() {
		File dir = new File("C:\\파일_디렉토리_문제\\크기 정렬");
		countFile(dir);
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<list.size()-1-i;j++) {
				if(list.get(j+1).length()>list.get(j).length()) {
					File temp = list.get(j);
					list.set(j,list.get(j+1));
					list.set(j+1, temp);
				}
			}
		}
		System.out.println("[파일명]\t\t\t    [크기]\t[파일이 들어있는 폴더]");
		
		for(File temp:list) {
			System.out.printf("%-30s\t%10s\t%s\n", temp.getName(),length((double)temp.length()),temp.getParentFile().getName());
		}
		
	}
	
	private static void countFile(File dir) {
		
		for(File sub:dir.listFiles()) {
			if(sub.isFile()) {
				list.add(sub);
			}
		}
		
		for(File sub:dir.listFiles()) {
			if(sub.isDirectory()) {
				countFile(sub);
			}
		}
		
	}

	private static void m8() {
		
		File dir = new File("C:\\파일_디렉토리_문제\\폴더 삭제\\delete");
		deleteDirectory(dir);
		System.out.println("폴더를 삭제했습니다.");
		System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다.\n",countDir,countFile);
		
	}

	private static void deleteDirectory(File dir) {
		
		//File[] list = dir.listFiles();
		
		for(File sub:dir.listFiles()) {
			if(sub.isFile()) {
				countFile++;
				sub.delete();
			}
			
		}
		
		for(File sub:dir.listFiles()) {
			if(sub.isDirectory()) {
				deleteDirectory(sub);
				}
			}
		
		countDir++;
		dir.delete();
		
		
		
	}
		
	

	private static void m7() {
		
		File dirA = new File("C:\\파일_디렉토리_문제\\동일 파일\\MusicA");
		File dirB = new File("C:\\파일_디렉토리_문제\\동일 파일\\MusicB");
		int count = 0;
		if(dirA.exists() && dirB.exists()) {
			for(File listA : dirA.listFiles()) {
				for(File listB : dirB.listFiles()) {
					if(listA.getName().equals(listB.getName()) && listA.isFile() && listB.isFile()) {
						System.out.println(listA.getName());
						count++;
					}
				}
			}
			System.out.printf("%d개 파일이 중복됩니다.\n",count);
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
		
	}

	private static void m6() {
		int count=0;
		File dir = new File("C:\\파일_디렉토리_문제\\파일 제거");
		if(dir.exists()) {
			for(File list:dir.listFiles()) {
					if(list.length()==0 && list.isFile()) {
						list.delete();
						count++;
				}
			}
			System.out.printf("총 %d개의 파일을 삭제했습니다.",count);
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
		
	}

	private static void m5() {
		
		File dir = new File("C:\\파일_디렉토리_문제\\확장자별 카운트");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		int count=1;
		if(dir.exists()) {
			for(File list:dir.listFiles()) {
				String key = list.getName().substring(list.getName().indexOf("."),list.getName().length());
				if(map.containsKey(key)) {
					map.put(key, map.get(key)+1);
				} else {
					map.put(key,1);
				}
			}
			
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
		Set <String> name = map.keySet();
		for(String list:name) {
			System.out.printf("*%s:%d개\n",list,map.get(list));
		}
		
	}

	private static void m4() {
		String path = "C:\\파일_디렉토리_문제\\음악 파일\\Music";
		File dir = new File(path);
		int count=1;
		if(dir.exists()) {
			for(File list: dir.listFiles()) {
				if(list.isFile()) {
				//System.out.println(list.getName());
				String name = String.format("[%03d]%s",count,list.getName());
				File file = new File(path+"\\"+name);
				list.renameTo(file);
				count++;
				}
			}
			
			for(File list: dir.listFiles()) {
				if(list.isFile()) {
				System.out.println(list.getName());
				}
			}
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
		
		
	}

	private static void m3() {
		File file = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\java\\file\\AAA\\test.txt");

		System.out.println("파일 이동을 실행합니다.");

		if (file.exists()) {
			File file1 = new File("C:\\Users\\PC\\OneDrive\\바탕 화면\\java\\file\\BBB\\test.txt");
			boolean loop = file.renameTo(file1);
			if (!loop) {
				System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n)");
				String ans = scan.nextLine();
				if (ans.equals("y")) {
					file1.delete();
					file.renameTo(file1);
					System.out.println("y.파일을 덮어섰습니다.");
				} else {
					System.out.println("n.작업을 취소합니다.");
				}

			}
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}

	}

	private static void m2() {

		System.out.print("폴더 선택:");
		String path = scan.nextLine();
		System.out.print("파일 확장자:");
		String extension = scan.nextLine();

		File dir = new File(path);

		if (dir.exists()) {
			for (File list : dir.listFiles()) {
				String name = list.getName().toUpperCase();
				if (name.substring(name.indexOf(".") + 1, name.length()).equals(extension.toUpperCase())) {
					System.out.printf("%s\n", name);
				}

			}
		} else {
			System.out.println("폴더가 존재하지 않습니다.");
		}
	}

	private static void m1() {
		System.out.print("파일 경로:");
		String path = scan.nextLine();
		File file = new File(path);
		double c = file.length();
		if (file.exists()) {
			String len = length(c);
			String name = file.getName();
			System.out.println(name);
			String[] list = name.split("\\.");
			System.out.println(Arrays.toString(list));
			System.out.println(list.length);
			System.out.printf("파일명:%s\n", name);
			 System.out.printf("종류:%s\n",name.substring(name.indexOf(".")+1,name.length()));
			System.out.printf("종류:%s\n", list[1]);
			System.out.printf("파일 크기:%s\n", len);
		}

		else {
			System.out.println("파일이 존재하지 않습니다.");
		}

	}

	private static String length(double c) {
		String len="";
		if (c < 1024) {
			len = String.format("%.1fB", c);
		} else if (c >= 1024 && c < 1024 * 1024) {
			len = String.format("%.1fKB", c / 1024);
		} else if (c >= 1024 * 1024 && c < 1024 * 1024 * 1024) {
			len = String.format("%.1fMB", c / (1024 * 1024));
		} else if (c >= 1024 * 1024 * 1024 && c < 1024 * 1024 * 1024 * 1024) {
			len = String.format("%.1fGB", c / (1024 * 1024 * 1024));
		} else if (c >= 1024 * 1024 * 1024 * 1024 && c < 1024 * 1024 * 1024 * 1024) {
			len = String.format("%.1fTB", c / (1024 * 1024 * 1024 * 1024));
		}
		return len;
	}

}
