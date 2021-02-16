package tab2mxl;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args ) throws FileNotFoundException {

		Parser p = new Parser("prototypeGuitarTab.txt");

		Attributes a = new Attributes(p);

		System.out.println(a.division);

		System.out.println(p.tabToCharMatrix(p.getTab())[0][0]);

		for (int i = 0; i < p.tabToCharMatrix(p.getTab()).length; i++ ) {
			System.out.println(p.tabToCharMatrix(p.getTab())[i]);
		}

		Parser p2 = new Parser("prototypeGuitarTab2.txt");

		Attributes a2 = new Attributes(p2);

		System.out.println(a2.division);

		for (int i = 0; i < p2.tabToCharMatrix(p2.getTab()).length; i++ ) {
			System.out.println(p2.tabToCharMatrix(p2.getTab())[i]);
		}

		/*
		 * |-----------0-----|-0---------------|
	   	   |---------0---0---|-0---------------|
           |-------1-------1-|-1---------------|
           |-----2-----------|-2---------------|
           |---2-------------|-2---------------|
           |-0---------------|-0---------------|
		 *  
		 */


		/*
		 * Stairway To Heaven tab by Led Zeppelin 
		 * 
		 * 	e|-------5-7-----7-|-8-----8-2-----2-|-0---------0-----|-----------------|
			B|-----5-----5-----|---5-------3-----|---1---1-----1---|-0-1-1-----------|
			G|---5---------5---|-----5-------2---|-----2---------2-|-0-2-2---2-------|
			D|-7-------6-------|-5-------4-------|-3---------------|-----------------|
			A|-----------------|-----------------|-----------------|-2-0-0---0--/8-7-|
			E|-----------------|-----------------|-----------------|-----------------|
		 * 
		 * 
		 */

	}
}
