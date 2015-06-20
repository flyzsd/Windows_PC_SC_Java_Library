package org.zsd.win32.pcsc.test;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.zsd.win32.pcsc.PCSCException;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException, PCSCException {
		ExecutorService excutors = Executors.newCachedThreadPool();
		excutors.submit(new ReaderHandler(excutors));
	}
}
