package ua.kovalev.prolesson3task2;

import ua.kovalev.prolesson3task2.annotations.SaveTo;
import ua.kovalev.prolesson3task2.annotations.Saver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        final Class<?> cls = TextContainer.class;
        if (!cls.isAnnotationPresent(SaveTo.class))
        {
            System.out.println("Отсутсвует аннотация SaveTo");
            return;
        }

        SaveTo annSaveTo = cls.getAnnotation(SaveTo.class);
        Method[] methods = cls.getMethods();
        TextContainer textContainer = new TextContainer();
        for(Method m : methods){
            if(m.isAnnotationPresent(Saver.class)){
                try {
                    m.invoke(textContainer, annSaveTo.path());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
