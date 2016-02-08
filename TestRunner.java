
import java.io.*;
import java.util.*;
import java.lang.annotation.*;
import java.lang.reflect.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
	public static void main(String[] args) {
		List<Class<?>> testcases = new ArrayList<Class<?>>();
		ArrayList<String> filenames = new ArrayList<String>(Arrays.asList(new File(".").list()));
outer:	for (String file : filenames) if (file.endsWith(".class") && file.indexOf('$') == -1) {
			try {
				Class<?> cls = Class.forName(file.split("\\.")[0]);
				for (Method meth : cls.getDeclaredMethods())
					for (Annotation anno : meth.getDeclaredAnnotations())
						if (anno instanceof org.junit.Test) {
							testcases.add(cls);
							continue outer;
						}
			} catch (ClassNotFoundException e) {
				continue;
			}
		}
		Result result = JUnitCore.runClasses(testcases.toArray(new Class<?>[0]));
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.printf("Tests run: %d,  Failures: %d\n", result.getRunCount(), result.getFailureCount());

	}
}
