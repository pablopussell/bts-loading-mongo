package com.bts.ingestion.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author mplanaguma
 *
 */
public class FileSplitter {

	public Iterator<String> split(final File file) throws IOException {
		return new Iterator<String>() {

			BufferedReader reader = new BufferedReader(new FileReader(file));

			@Override
			public boolean hasNext() {
				try {
					boolean ready = reader.ready();
					if (!ready) {
						reader.close();
					}
					return ready;
				} catch (IOException e) {
					try {
						reader.close();
					} catch (IOException e1) {
					}
					throw new RuntimeException(e);
				}
			}

			@Override
			public String next() {
				try {
					return reader.readLine();
				} catch (IOException e) {
					try {
						reader.close();
					} catch (IOException e1) {
					}
					throw new RuntimeException(e);
				}
			}
		};
	}

}
