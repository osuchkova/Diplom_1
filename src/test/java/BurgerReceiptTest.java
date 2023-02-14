import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@RunWith(MockitoJUnitRunner.class)
public class BurgerReceiptTest {

    @Spy
    Burger burgerSpy;

    @Test
    public void getReceiptBunSauceFillingTrue() {
        burgerSpy = spy(Burger.class);
        Database database = new Database();
        List<Bun> buns = database.availableBuns();
        List<Ingredient> ingredients = database.availableIngredients();
        burgerSpy.setBuns(buns.get(0));
        burgerSpy.addIngredient(ingredients.get(1));
        burgerSpy.addIngredient(ingredients.get(4));
        doReturn(500F).when(burgerSpy).getPrice();
        String expected = "(==== black bun ====)\r\n= sauce sour cream =" + "\r\n= filling dinosaur =\r\n(==== black bun ====)\r\n\r\nPrice: 500,000000\r\n";
        String actual = burgerSpy.getReceipt();
        assertEquals("Рецепты должны совпадать", expected, actual);
    }
}