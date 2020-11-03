package ua.lviv.lgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, InstantiationException {
		
		//Task 16.1
		System.out.println("Task 16.1");
		Book book = new Book("Harry Potter", 1354, "Fantasy", "J. K. Rowling");
		Class bookClass = book.getClass();
		
		String nameOfClass = bookClass.getName();
		System.out.println("Name of class = " + nameOfClass);
		
		String simpleName  = bookClass.getSimpleName();
		System.out.println("Simple name = " + simpleName);
		
		int modifier = bookClass.getModifiers();
		String modifierText = Modifier.toString(modifier);
		System.out.println("Class modifier = " + modifierText + " int = " + modifier);
		
		System.out.println("is public = " + Modifier.isInterface(modifier));
		System.out.println("is public = " + Modifier.isPublic(modifier));
		System.out.println("is public = " + Modifier.isSynchronized(modifier));
		
		Package classPackage = bookClass.getPackage();
		System.out.println("Package of current class is = " + classPackage);
		
		Class superClass = bookClass.getSuperclass();
		System.out.println("Super class = " + superClass);
		
		Class<?>[] interfaces = bookClass.getInterfaces();
		System.out.println("Interfaces = " + Arrays.toString(interfaces));
		
		Constructor<?>[] constructors = bookClass.getConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println("Constructor = " + constructor);
		}
		System.out.println("Constructors size = " + constructors.length);
		
		Constructor<Book> constructor = bookClass.getConstructors()[1];
		Class<?>[] parameterTypes = constructor.getParameterTypes();
		for (Class<?> class1 : parameterTypes) {
			System.out.println(class1);
		}
		
		Constructor<?> singleConstructor = bookClass.getConstructor(String.class, String.class);
		System.out.println("Single constructor = " + singleConstructor);	
		
		Field[] fields = bookClass.getFields();
		for (Field field : fields) {
			System.out.println(field);
		}
		
		System.out.println();
		Field[] declaredFields = bookClass.getDeclaredFields();
		for (Field field : declaredFields) {
			System.out.println(field);
		}
		
		Field privateLastNameField = declaredFields[3];
		privateLastNameField.setAccessible(true);
		System.out.println("private Value = " + privateLastNameField.get(book));
		System.out.println();
		
		//Task 16.2
		System.out.println("Task 16.2");
		constructor = bookClass.getConstructor(String.class, int.class, String.class, String.class);
		book = constructor.newInstance("White Fang", 298, "Adventure", "Jack London");
		System.out.println();
		
		Field ageField = bookClass.getField("bookName");
		ageField.set(book, "Martin Eden");
		System.out.println("Book new name = " + book);
		System.out.println();
		
		Method[] methods = bookClass.getMethods();
		int i = 0;
		for (Method method : methods) {
			System.out.println((i++) + " " + method);
		}
		
		System.out.println();
		for (Method method : methods) {
			if(method.getName().contains("setPages")) {
				System.out.println(book);
				method.invoke(book, 356);
				System.out.println(book);
			}
		}		
		System.out.println();
		
		//Task 16.3
		System.out.println("Task 16.3");
		Method method = bookClass.getMethod("myMethod", String.class, int[].class);
		method.invoke(book, new Object[]{"myMethod", new int[] {100}});		
		
		method = bookClass.getMethod("myMethod", String[].class);
		method.invoke(book, new Object[]{new String[]{"myMethod"}});

	}

}
