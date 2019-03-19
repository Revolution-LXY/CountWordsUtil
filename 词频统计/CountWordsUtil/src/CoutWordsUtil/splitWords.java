package CoutWordsUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class splitWords 
{
	public static void main(String[]args) throws FileNotFoundException
	{
		File file=new File("C:\\Users\\Administrator\\Desktop\\词频统计\\article.txt");
		if(!file.exists())
		{
			System.out.println("文件不存在");
			return;
		}
		Scanner scanner=new Scanner(file);
		HashMap<String,Integer>hashMap=new HashMap<String,Integer>();
		System.out.println("文章————————————————————————————————");
		while(scanner.hasNextLine())
		{
			String line=scanner.nextLine();
			System.out.println(line);
			String[] lineWords=line.split("\\W+");
			Set<String>wordSet=hashMap.keySet();
			for(int i=0;i<lineWords.length;i++)
			{
				if(wordSet.contains(lineWords[i]))
				{
					Integer number=hashMap.get(lineWords[i]);
					number++;
					hashMap.put(lineWords[i],number);
				}
				else
				{
					hashMap.put(lineWords[i],1);
				}
			}
		}
		System.out.println("统计单词：————————————");
		Iterator<String>iterator=hashMap.keySet().iterator();
		while(iterator.hasNext())
		{
			String word=iterator.next();
//			System.out.printf("单词："+word+"出现次数："+hashMap.get(word));
			System.out.printf("单词：%-12s 出现次数：%d\n",word,hashMap.get(word));
			
		}
		System.out.println("程序结束——————————————————");
	}

}
