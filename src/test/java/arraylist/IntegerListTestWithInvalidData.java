package arraylist;

import org.example.arraylist.IntegerList;
import org.example.exceptions.EmptyArgumentException;
import org.example.exceptions.InvalidCellNumberException;
import org.example.exceptions.NonExistentElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IntegerListTestWithInvalidData {
    private IntegerList integerList;
    private final static Integer FIRST = 10;
    private final static Integer CASUAL = 99;

    @BeforeEach
    void setUp() {
        integerList = new IntegerList(3);
        integerList.add(FIRST);
    }

    @Test
    void validateItem() {
        try {
            Method method = IntegerList.class.getDeclaredMethod("validateItem", Integer.class);
            method.setAccessible(true);
            method.invoke(integerList, (Object) null);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(EmptyArgumentException.class, e.getCause().getClass());
        }
    }

    @Test
    void validateIndexTooBig() {
        try {
            Method method = IntegerList.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(integerList, 16);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(InvalidCellNumberException.class, e.getCause().getClass());
        }
    }

    @Test
    void validateIndexNegative() {
        try {
            Method method = IntegerList.class.getDeclaredMethod("validateIndex", int.class);
            method.setAccessible(true);
            method.invoke(integerList, -16);
        } catch (NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            assertEquals(InvalidCellNumberException.class, e.getCause().getClass());
        }
    }

    @Test
    void removeNonExistentItem() {
        assertThrows(NonExistentElementException.class, () -> integerList.remove(CASUAL));
    }

    @Test
    void testEqualsNull() {
        assertThrows(EmptyArgumentException.class, () -> integerList.equals(null));
    }
}
