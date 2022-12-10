import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.util.*;
import java.awt.*;
public class Histogram extends JPanel{
	HashMap<String, Integer> mapFreq1;
	HashMap<String, Integer> mapFreq2;
	int maxFreq;

	public Histogram(char[] array1, char[] array2){
		setPreferredSize (new Dimension (320*4, 240*2));
		setFocusable(true);
		maxFreq = 1;
		mapFreq1 = getFreq(array1);
		mapFreq2 = getFreq(array2);
	}

	private HashMap<String, Integer> getFreq(char[] data){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < data.length; i++){		
			String symbol = Character.toString(data[i]);
			if(!map.containsKey(symbol)){
				map.put(symbol, 1);
			} else {
				int freq = map.get(symbol) + 1;
				if(this.maxFreq < freq){
					this.maxFreq = freq;
				}
				map.put(symbol, freq);
			}
		}
		return map;
	}

	@Override
	public void paint(Graphics g) {
		int asciiStart = 97;
		int numEngChar = 26;
		int rectWidth = (getWidth()/2 - 20)/numEngChar;
		int heightData1 = 0;
		int heightData2 = 0;
		int freq1;
		int freq2;
		g.setFont(new Font("Impact", Font.PLAIN, 20));
		g.setColor(Color.BLACK);
		
		for(int i = asciiStart; i < asciiStart + numEngChar; i++){
			if(mapFreq1.containsKey(Character.toString((char) i))){
				freq1 = mapFreq1.get(Character.toString((char) i));
				heightData1 =  freq1 * (getHeight() - 50)/maxFreq;
			} else {
				freq1 = 0;
				heightData1 = 0;
			}
			if(mapFreq2.containsKey(Character.toString((char) i))){
				freq2 = mapFreq2.get(Character.toString((char) i));
				heightData2 =  freq2 * (getHeight() - 50)/maxFreq;
			} else {
				freq2 = 0;
				heightData2 = 0;
			}
			g.setColor(Color.GREEN);
			g.drawRect((i - asciiStart)*rectWidth + 20, getHeight() - heightData1 - 20, rectWidth, heightData1);
			g.drawRect((i - asciiStart)*rectWidth + 20 + getWidth()/2, getHeight() - heightData2 - 20, rectWidth, heightData2);
			g.setColor(Color.BLACK);
			g.fillRect((i - asciiStart)*rectWidth + 21, getHeight() - heightData1 - 20, rectWidth - 1, heightData1);
			g.fillRect((i - asciiStart)*rectWidth + 21 + getWidth()/2, getHeight() - heightData2 - 20, rectWidth - 1, heightData2);
			g.setColor(Color.RED);
			g.drawString(Integer.toString(freq1), (i - asciiStart)*rectWidth + 20, getHeight() - heightData1 - 20);
			g.drawString(Integer.toString(freq2),(i - asciiStart)*rectWidth + 20 + getWidth()/2, getHeight() - heightData2 - 20);
			g.drawString(Character.toString((char)i), rectWidth*(i - asciiStart) + 25, getHeight() - 5);
			g.drawString(Character.toString((char)i), rectWidth*(i - asciiStart) + 25 + getWidth()/2, getHeight() - 5);
		}
	}
}