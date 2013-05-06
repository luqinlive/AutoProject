package com.google.file;

import android.test.AndroidTestCase;
import android.util.Log;

public class Test extends AndroidTestCase {
	public void testRead() throws Exception{
		FileService service= new FileService(this.getContext());
		String result = service.read("a.txt");
		Log.i("TAG",result);
	}
}
