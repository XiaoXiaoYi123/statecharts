package org.yakindu.sct.examples.wizard.search;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

import com.google.common.base.Predicate;

public class FileUtil {

	public static void deleteDirectory(File folder) throws IOException {
		Files.walkFileTree(folder.toPath(), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}
		});
	}
	
	public static File findFirst(File folder, Predicate<File> predicate) {
		for (File file : folder.listFiles()) {
			if (file.isHidden() || !file.exists() || !file.canRead()) {
				continue;
			}
			if (predicate.apply(file)) {
				return file;
			}
			if (file.isDirectory()) {
				File foundRecursive = findFirst(file, predicate);
				if (foundRecursive != null) {
					return foundRecursive;
				}
			}
		}
		return null;
	}
}
